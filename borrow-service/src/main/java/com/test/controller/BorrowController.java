package com.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    //@HystrixCommand(fallbackMethod = "onError")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid){
        //System.out.println("开始向其他服务获取信息");
        return service.getUserBorrowDetailByUid(uid);
    }
/*
    //Hystrix备选方法
    UserBorrowDetail onError(int uid){
        System.out.println("服务错误，进入备选方法！");
        return new UserBorrowDetail(null, Collections.emptyList());
    }*/
}