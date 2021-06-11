package spring.test.study;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
		public String menu() {
		//jsp로 접근하려면 아까만든 폴더명으로 접근한다
		 return "day0527/menu";
		}
	
	@GetMapping("/shop/{path}")
	public String pathEx(Model model,//모델을 파라미터로 선언
			@PathVariable("path") String p) //p라는 변수로 읽어온다
	{
		String msg="";
		if(p.equals("addcart"))
			msg="장바구니에 선택한 상품을 추가했어요!!";
		else if(p.equals("listcart"))
			msg="장바구니에 담긴 상품을 출력했어요!!";
		else if(p.equals("delcart"))
			msg="장바구니에 선택한 상품을 삭제했어요!!";
		else
			msg="경로가 잘못되었습니다!!";
			
		//모델 따로 받았을 때는 모델어트리뷰트 사용
		model.addAttribute("msg", msg);
		return "day0527/cartresult";
	}
	
}
