package com.chryl.listener.event;

import com.chryl.po.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Chr.yl on 2020/12/16.
 *
 * @author Chr.yl
 */
@Data
@AllArgsConstructor
public class UserRegisterEvent {

    private boolean regOk;

    /**
     * 1:手机,2网页
     */
    private String regType;

    private User user;

}
