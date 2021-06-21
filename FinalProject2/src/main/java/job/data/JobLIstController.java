package job.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import job.data.JobMapper;

@Controller
public class JobLIstController {
	  @Autowired
	   JobMapper mapper;
	   @GetMapping({"/","/index"})
	   public ModelAndView index() {
	      ModelAndView mview =new ModelAndView();
	      //총 개수
	      int totalCount=mapper.getTotalCount();
	      mview.addObject("totalCount",totalCount);
	      mview.setViewName("index");
	      return mview;
	   }

}
