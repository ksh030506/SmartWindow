package com.example.SmartWindow;

        import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    private XmlParse xmlParse;
    @RequestMapping(value = "/")
    public ModelAndView  Hello(){
        ModelAndView view = new ModelAndView("index");
        return  view;
    }
}
