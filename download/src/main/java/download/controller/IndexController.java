package download.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping("")
    public ModelAndView welcome(Map<String, Object> model) {
        return new ModelAndView("welcome");
    }
}
