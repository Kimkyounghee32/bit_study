package board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//카페에서 코드 복사하여 매핑주소와 실제 파일있는 경로만 수정

@Controller
public class DownloadController {

 //외부서버의 파일을 내 컴퓨터로 다운로드하는소스
 @GetMapping("/board/download")
 public void download(HttpServletRequest request,
   HttpServletResponse response,
   @RequestParam String clip)//타입명을 클립으로 다운 받음
	 {
		  String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		  File file=new File(path+"\\"+clip);
		  System.out.println("파일 경로:"+file);
		  setHeaderType(response, request, file);
	  
		  try {
		   transport(new FileInputStream(file),
		     response.getOutputStream(), file);
		  } catch (FileNotFoundException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }  
	 }
 
 //다운로드 받기 위한 코드
 private void setHeaderType(HttpServletResponse response,
   HttpServletRequest request,
   File file)
	 {
		  String mime = request.getSession().getServletContext().getMimeType(file.toString());
		  if(mime != null)
		   mime = "application/octet-stream";
		  response.setContentType(mime);
		  response.setHeader("Content-Disposition",
		    "attachment;filename=" + toEng(file.getName()));
		  response.setHeader("Content-Length", "" + file.length());
	
	 }

 private void transport(InputStream in, OutputStream out, File file)
   throws IOException
	 {
		  BufferedInputStream bin = null;
		  BufferedOutputStream bos = null;
		
		  try{
		   bin = new BufferedInputStream(in);
		   bos = new BufferedOutputStream(out);
		
		   byte[] buf=new byte[(int)file.length()];
		   int read=0;
		   while((read = bin.read(buf)) != -1)
		   {
		    bos.write(buf, 0, read);   //객체, 시작(offset), 길이
		   }
		  }catch(Exception e){
		   System.out.println("transport error : " + e);
		  }finally{
		   bos.close();
		   bin.close();
		  }
	 }
 
 //한글변환
 public String toEng(String str)
	 {
		  String tmp=null;
		  try{
		   tmp = new String(str.getBytes("utf-8"), "8859_1");
		  }catch(Exception e){}
		  return tmp;
		 }         

	}
