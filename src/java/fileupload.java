

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
public class fileupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "/home/sai/NetBeansProjects/mail/web/image/";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	// process only if its multipart content
	if (isMultipart) {
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// Parse the request
                    String imgname = null;
			List<FileItem> multiparts = upload.parseRequest(request);
                                        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
                                        String date = sdf.format(new Date());
                                        String arr[]=new String[255];
                                        arr=date.split("/");
                                        String num=arr[0]+arr[1]+arr[2];
                                        Random rd=new Random();
                                        int i;
                                        i = rd.nextInt(Integer.parseInt(num));
			for (FileItem item : multiparts) {
				if (!item.isFormField()) {
					String name = new File(item.getName()).getName();
                                        
                                        String namearr[]=new String[255];
                                        namearr=(name.split("//."));
                                       
                                     imgname=i+"."+namearr[1];
					item.write(new File(UPLOAD_DIRECTORY + File.separator +imgname));
				}
			}
                        String uname=request.getParameter("id");
                        db.NewClass ns=new db.NewClass();
                        ns.updateData("update users set profile='"+"image/"+imgname+"' where email='"+uname+"'");
                         System.out.println("File upload ");
		} 
		catch (Exception e) 
		{ 
                    System.out.println(e.getMessage());
		  System.out.println("File upload failed");
		}
	}
}
}