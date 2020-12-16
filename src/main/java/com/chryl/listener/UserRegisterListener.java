package com.chryl.listener;

import com.chryl.listener.event.UserRegisterEvent;
import com.chryl.listener.order.UserRegisterOrder;
import com.chryl.po.User;
import com.chryl.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 模拟用户注册成功的监听事件
 * Created by Chr.yl on 2020/12/16.
 *
 * @author Chr.yl
 */
@Component("defaultUserListener")
@AllArgsConstructor
public class UserRegisterListener {

    @Autowired
    private UserService userService;


    @EventListener(UserRegisterEvent.class)
    @Order(UserRegisterOrder.DEFAULT)
    public void userEvent(UserRegisterEvent userRegisterEvent) {

        User user = userRegisterEvent.getUser();

        userService.save(user);
    }

}
