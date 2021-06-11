package react.spring.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import person.data.MysqlPersonMapper;
import person.data.PersonDto;

@CrossOrigin  //spring5 부터 가능 - 다른 도메인과의 통신
@RestController
public class PersonReactController {
	
	@Autowired
	MysqlPersonMapper mapper;
	
	String uploadName;//photo 폴더에 업로드되는 실제 사진 파일명

	
	@GetMapping("/person/list")
	public List<PersonDto> getAllDatas()
	{
		return mapper.getAllDatas();
	}
	
	
	//******spirng에서 사진 먼저 업로드하는 부분
	
	@PostMapping(value ="/person/upload",
			consumes = {"multipart/form-data"})
	//업로드될 이름을 json으로 보낼건데 한개만 보낼거임
	//그럼 저쪽에서는 멀티파트 업로드파일이라는 걸로 받을거고
	//받기 위해서는 리퀘스트가 필요하겠죠
	public Map<String, String> fileUpload(
			@RequestParam MultipartFile uploadFile,
			HttpServletRequest request
			)
	{
		//저장경로
		String path=request.getSession().getServletContext().getRealPath("/photo");
		System.out.println(path);
		
		//파일명 앞에 날짜붙여서 업로드
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		uploadName="d"+sdf.format(date)+"_"+uploadFile.getOriginalFilename();
		
		try {
		uploadFile.transferTo(new File(path+"\\"+uploadName));
		}catch(Exception e) {
			System.out.println("파일 업로드 오류:"+e.getMessage());
		} 
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("sajin", uploadName);
		return map;
	}
	
	@PostMapping("/person/insert")
	public Map<String, String> insert(@RequestBody PersonDto dto)
	{
		//사진은 따로 dto 에 저장
		dto.setSajin(this.uploadName);
		//db insert
		mapper.insertPerson(dto);
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("mes",dto.getName()+" 님의 데이타 DB 에 추가 성공!!");
		return map;
	}
	
	@GetMapping("/person/select")
	public PersonDto select(@RequestParam String num)
	{
		return mapper.getData(num); //메퍼로 겟데이터에다가 넘을 보내서 리턴
	}
	
	@DeleteMapping("/person/delete")
	public void delete(@RequestParam String num)
	{
		mapper.deleteData(num);
	}


}
