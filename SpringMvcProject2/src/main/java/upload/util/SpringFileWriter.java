package upload.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class SpringFileWriter {
	FileOutputStream fos;
	
	public String writeFile(MultipartFile file,String path)
	{
		//저장할 파일명을 구하는데 예를 들어 a.jpg
		//file123456_a.jpg 이런식으로 저장되도록 해보자
		long time=new Date().getTime();//시간을 초로 환산해서 숫자로 반환
		//저장할 파일명 : (시분)초가 붙기 때문에 절대로 같은 파일명이 나올 수없음
		String fileName="file"+time+"_"+file.getOriginalFilename();
		
		//path폴더에 저장하기
		try {
			byte[] fileData;
			fileData = file.getBytes();
			//byte[] fileData= file.getBytes(); 과 같음
			fos=new FileOutputStream(path+"\\"+fileName);
			fos.write(fileData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();			
				}
		}
		
		return fileName; //업로드된 파일명을 컨트롤러로 보낸다
		
	}
}
