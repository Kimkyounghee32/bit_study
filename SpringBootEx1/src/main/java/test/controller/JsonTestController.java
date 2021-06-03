package test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonTestController {

	@GetMapping("/shop/list")
	public List<ShopDto> list()
	{
		List<ShopDto> list=new ArrayList<ShopDto>();
		ShopDto s1=new ShopDto();
		s1.setSang("사과");
		s1.setSu(3);
		s1.setDan(1000);
		
		list.add(s1);
		
		ShopDto s2=new ShopDto();
		s2.setSang("복숭아");
		s2.setSu(5);
		s2.setDan(1200);
		
		list.add(s2);
		return list;
	}
}
