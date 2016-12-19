
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String UPLOAD_DIRECTORY = "/home/sai/NetBeansProjects/mail/web/profile/";
    db.NewClass ns = new db.NewClass();
    boolean j = false;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String arr[] = new String[255];
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");

        String num = request.getParameter("mname");

        String country = request.getParameter("country");
        arr = name.split("");
        String fname = arr[0];
        String mname = arr[1];
        String lname = arr[2];

        String img = null;

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        try {
            // process only if its multipart content
            if (isMultipart) {
                // Create a factory for disk-based file items
                FileItemFactory factory = new DiskFileItemFactory();

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                try {
                    // Parse the request
                    List<FileItem> multiparts = upload.parseRequest(request);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
                    String date = sdf.format(new Date());
                    String arr1[] = new String[255];

                    boolean j = false;
                    arr = date.split("/");
                    String num1 = arr[0] + arr1[1] + arr1[2];
                    Random rd = new Random();
                    int i;
                    i = rd.nextInt(Integer.parseInt(num1));
                    for (FileItem item : multiparts) {
                        if (!item.isFormField()) {
                            String nameofimg = new File(item.getName()).getName();

                            String namearr[] = new String[255];
                            namearr = (nameofimg.split("\\."));

                            img = i + "." + namearr[1];
                            item.write(new File(UPLOAD_DIRECTORY + File.separator + img));
                        }
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("File upload failed");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        j = ns.insertData("insert into users(`email`,`password`,`name`,`middlename`,`lastname`,`gender`,`contactno`,`country`,`profile`)values('" + email + "','" + password + "','" + fname + "','" + mname + "','" + lname + "','" + gender + "','" + num + "','" + country + "','" + "profile/" + img + "')");

        if (j == true) {
            String register = "You are Successfully registered";
            session.setAttribute("profileimage", UPLOAD_DIRECTORY+"/"+img);
            request.setAttribute("register", register);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        } else {
            String registererror = "Sorry,Registration failed. please try later";
            request.setAttribute("registererror", registererror);
            RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
            rd.include(request, response);
        }

    }
}
