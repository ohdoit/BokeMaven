package com.mgc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.mgc.common.PropertiesUtil;

@Controller
@RequestMapping("/file")
public class FileController extends BaseController {
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(){
		return "file_manage";
	}
	
	@RequestMapping(value="/upload1", method=RequestMethod.POST)
	public String fileUpload(@RequestParam("file")CommonsMultipartFile file) throws IOException{
		System.out.println("start upload..."+System.currentTimeMillis());
		System.out.println(file.getOriginalFilename());
		InputStream is = file.getInputStream();
		FileOutputStream fos = new FileOutputStream(PropertiesUtil.getUploadDirectory()+file.getOriginalFilename());
		int read = -1;
		while((read=is.read())!=-1){
			fos.write(read);
		}
		fos.flush();
		fos.close();
		is.close();
		System.out.println("start upload..."+System.currentTimeMillis());
		return "success";
	}
	
	@RequestMapping(value="/upload2", method=RequestMethod.POST)
	public String fileUpload2(MultipartFile file) throws IOException{
		System.out.println("start upload..."+System.currentTimeMillis());
		System.out.println(file.getOriginalFilename());
		File fos = new File(PropertiesUtil.getUploadDirectory()+file.getOriginalFilename());
		file.transferTo(fos);
		System.out.println("start upload..."+System.currentTimeMillis());
		return "success";
	}
	
	@RequestMapping(value="/upload3", method=RequestMethod.POST)
	public String fileUpload3() throws IOException{
		System.out.println("start upload..."+System.currentTimeMillis());
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(session.getServletContext());
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest multiReq = (MultipartHttpServletRequest)request;
			Iterator<String> iterator = multiReq.getFileNames();
			while(iterator.hasNext()){
				MultipartFile file = multiReq.getFile(iterator.next());
				if(file!=null){
					file.transferTo(new File(PropertiesUtil.getUploadDirectory()+file.getOriginalFilename()));
				}
			}
		}
		System.out.println("start upload..."+System.currentTimeMillis());
		return "success";
	}
	

	@RequestMapping(value="/download", method=RequestMethod.GET)
	public ResponseEntity<byte[]> download(Model model) throws IOException{
		String filePath = PropertiesUtil.getUploadDirectory()+"1.png";
		File file = new File(filePath);
		HttpHeaders headers = new HttpHeaders();
		// 解决中文乱码
		String fileName = new String("1.png".getBytes("UTF-8"), "iso-8859-1");
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
