package com.chryl.controller;

import com.chryl.listener.event.UserRegisterEvent;
import com.chryl.po.User;
import com.chryl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Chr.yl on 2020/12/10.
 *
 * @author Chr.yl
 */
@RestController
@RequestMapping("/listener")
public class UserController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/save")
    @Transactional//放在事务中
    public Object show() {

        //模拟入参
        User userEntity = new User();
        userEntity.setId(UUID.randomUUID().toString().replace("-", "").substring(4, 15));
        userEntity.setUserName("nancy");
        userEntity.setUserPassowrd("999999999999");
        boolean regOk = true;
        String regType = "1";

        // 通过事务提交订单
        eventPublisher.publishEvent(new UserRegisterEvent(regOk, regType, userEntity));

        return "请前往数据库查看是否插入数据";

    }
}
