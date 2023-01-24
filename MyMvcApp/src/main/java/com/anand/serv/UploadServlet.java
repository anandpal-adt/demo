package com.anand.serv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.anand.service.CarService;
import com.anand.service.CarServiceImple;

@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String s=request.getParameter("carId");
    int carId=Integer.parseInt(s);
    
    Part part=request.getPart("image");
    
    String fileName=part.getSubmittedFileName();
    fileName =fileName.substring(fileName.lastIndexOf('.'));
    fileName=s+fileName;
    
    String filePath=request.getServletContext().getRealPath("/");
    
    Path path=Paths.get(filePath);
    path=path.resolve(path+"/"+fileName);
    Files.copy(part.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
    
    CarService carService=new CarServiceImple();
    carService.addImage(carId,fileName);
    
    response.sendRedirect("car_list.jsp");
	}

}
