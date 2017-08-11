package com.example.demo.web.controller;

import com.example.demo.web.model.LoginInputViewModel;
import com.example.demo.web.model.TestViewModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping(value = "/go", method = RequestMethod.POST)
    public String setDepartureTime(@RequestBody TestViewModel testViewModel) {
        return testViewModel.getLiuyang();
    }
}
