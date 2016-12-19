/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author sai
 */
public class RServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private static final long serialVersionUID = 1L;
    private final String UPLOAD_DIRECTORY = "/home/sai/NetBeansProjects/mail/web/profile/";
    db.NewClass ns = new db.NewClass();
    boolean j = false;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          HttpSession session=request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
            session.setAttribute("profileimage", UPLOAD_DIRECTORY+"/"+img);
            String register = "You are Successfully registered";
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
