package cc.tt.springdemo.controller;

import cc.tt.springdemo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author tong
 * @Date 2019/6/25 19:17
 * @Version 1.0
 **/
@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "HelloController World!";
    }

    @Autowired
    private Person person;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ResponseBody
    public Person person() {
        return person;
    }
}
