package com.dingel.bilibili.api;


import com.dingel.bilibili.service.DemoService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoApi {


    @Autowired
    private DemoService demoService;


    @GetMapping("/query")
    public Long query(Long id){
        return demoService.query(id);
    }


}
