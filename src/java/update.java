/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author sai
 */
@MultipartConfig          // indicates that request MIME type is �multipart/form-data�
//@WebServlet("/profile")
public class update extends HttpServlet {
 private static final long serialVersionUID = 1L;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             String arr[]=new String[255];
              db.NewClass ns=new db.NewClass();
             boolean i=false;
		String email=request.getParameter("email");
		String oldpwd=request.getParameter("oldpwd");
                String newpwd=request.getParameter("newpwd");
		String name=request.getParameter("name");
		String id=request.getParameter("hiddenid");
		
		String num=request.getParameter("mobileno");
		
		String country=request.getParameter("country");
                arr=name.split(" ");
                String fname=arr[0];
                 String mname=arr[1];
                  String lname=arr[2];
                 
                 
                  if(oldpwd==null && newpwd==null){
                  i=ns.updateData("update users set email='"+email+"',name='"+fname+"',middlename='"+mname+"',lastname='"+lname+"',contactno='"+num+"',country='"+country+"' where id='"+id+"'");
                  }else{
                   i=ns.updateData("update users set email='"+email+"',password='"+newpwd+"',name='"+fname+"',middlename='"+mname+"',lastname='"+lname+"',contactno='"+num+"',country='"+country+"' where id='"+id+"'");
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