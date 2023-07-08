package com.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InputOutputStreamDemoController {
   
	
	@RequestMapping(value ="/savedata"  ,method = RequestMethod.POST)
	public ResponseEntity<?> saveDataIntoFile(@RequestParam(value = "name",required = false) String name,
			                                  @RequestParam(value = "file",required = false) MultipartFile multipartFile){
		
		
		//creating refrence of input and output stream...
		OutputStream os=null;
		InputStream is=null;
		try {
			
			  //saving name in the info.txt file inside employeeinfo folder...
		      os=new FileOutputStream("F:\\AllJavaDemo\\SpringBootJava\\Research\\employeeinfo\\info.txt",true);
		      //writing name varibale inf file..
		      byte[] nameInBytes = name.getBytes();
		      os.write(nameInBytes);
		      os.flush();
		      //writing new line in file
		      byte[] bytesNewLine = "\n".getBytes();
		      os.write(bytesNewLine);
		      os.flush();
		      
		      //saving file inside images folder...
		      String originalFilename = multipartFile.getOriginalFilename();
		      os=new FileOutputStream("F:\\AllJavaDemo\\SpringBootJava\\Research\\images"+File.separator+originalFilename);
		      //getting inputstream from file and converting it into byte array..
		      is = multipartFile.getInputStream();
		      byte fileBytes[]=new byte[is.available()];
		      is.read(fileBytes);
		      //writing byte array into file...
		      os.write(fileBytes);
		      os.flush();
		      
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				is.close();
				os.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		return new ResponseEntity<>("FileSaved Successfully..",HttpStatus.OK);
	}
}
