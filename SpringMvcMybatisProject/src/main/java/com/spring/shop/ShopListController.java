package com.spring.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.data.ShopDao;
import shop.data.ShopDto;

@Controller
public class ShopListController {
	@Autowired //�ڵ�����(Ŭ���� 1���϶��� ���, �������̽��� ������ Ŭ������ �������϶� ���x)
	ShopDao dao;
	
	@GetMapping({"/","/list"}) //���� �ΰ��� ����
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		//db ���� ��ü ���� ��������
		int totalCount=dao.getTotalCount();
		
		List<ShopDto> list=dao.getAllDatas();	
		
		//model �� ����
		mview.addObject("list",list);
		mview.addObject("totalCount",totalCount);
		
		mview.setViewName("shop/list");
		return mview;

	}
	
	@GetMapping({"/content"}) //���� �ΰ��� ����
	public ModelAndView detail(@RequestParam String num) //@RequestParam ���� num�� ����
	{
		ModelAndView mview=new ModelAndView();
		ShopDto dto=dao.getData(num);
		mview.addObject("dto",dto);
		mview.setViewName("shop/content");
		return mview;
	}
}