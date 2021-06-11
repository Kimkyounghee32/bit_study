package spring.study.bit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨트롤러 어노테이션해야 자동으로 빈으로 등록

//공통 매핑은 밖에 써도됨 그렇지 않으면 클래스 안에 매핑주소 써주기
public class TestController {
	
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	//기본형식은 위의 형식이나
	//겟 방식이기 때문에 메서드 방식 기본을 생략할수있다.
	//생략한 방식↓
	//@RequestMapping("/shop/detail")
	//public String hello1(Model model)
	//리퀘스트에 저장할 때는 모델이 필요
	//{	
		//Request에 mes 저장
	//	model.addAttribute("mes", "오늘은 즐거운 수요일입니다!!");
	//	return "result1"; //     /WEB-INF/views/result1.jsp 로 포워드
	//}
	
	//방법2
		@GetMapping("/shop/detail") //스프링5부터 가능
		public ModelAndView hello2()
		{
			ModelAndView mview=new ModelAndView();
			//request 에 저장
			mview.addObject("mes", "여러분 스프링 어렵죠???");
			//포워드할 파일명 지정
			mview.setViewName("result1");
			return mview;
		}

	
}
