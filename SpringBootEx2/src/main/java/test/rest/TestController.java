package test.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

   @GetMapping("/stu/info")
   public Map<String,String> hello()
   {
      Map<String,String> map=new HashMap<String, String>();
      map.put("message", "배 안고파");
      return map;
      
   }
   
  
}
