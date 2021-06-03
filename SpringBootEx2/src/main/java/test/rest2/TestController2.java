package test.rest2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
	
	@GetMapping("/shop/info")
	public Map<String, String> hello()
	{
		Map<String, String> map=new HashMap<String, String>();
		map.put("message", "오늘 점심은 한정식입니다");
		return map;
	}


}
