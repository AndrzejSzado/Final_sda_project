package sda.pl.com.chat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by RENT on 2016-12-17.
 */
@RestController
@RequestMapping("/hello")
public class Controller {

    @RequestMapping(method = RequestMethod.GET, value = "/say")
    public String hello(){
        return "  Andrzej";
    }
}
