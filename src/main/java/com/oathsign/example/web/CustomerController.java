package com.oathsign.example.web;

import com.oathsign.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    @Transactional(readOnly = true)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "Hello World");
        return "create";
    }

    @RequestMapping(value = "store/{name}/{address}")
    public String store(@PathVariable("name") String name, @PathVariable("address") String address) {
        customerService.add(name, address);
        return "ok";
    }
}
