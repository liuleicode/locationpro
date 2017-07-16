package com.ll.location.controller;

import com.ll.location.model.User;
import com.ll.location.model.Usersignin;
import com.ll.location.service.UsersignindtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by liulei on 2017/7/16.
 */
@Controller
@RequestMapping("usersign")
public class UserSignController {

    @Autowired
    UsersignindtlService usersignindtlService;


    /**
     * 用户查询登录信息 通过
     * @param u
     * @param pagesize
     * @param pageno
     * @return
     */
    @RequestMapping("listusersign")
    public ModelAndView listUserSigns(User u, Integer pagesize, Integer pageno) {
        List<Usersignin> usersignindtls = usersignindtlService.listUsersignindtl(u, pagesize, pageno);

        ModelAndView modelAndView = new ModelAndView("findlist");
        modelAndView.addObject("usersignindtls", usersignindtls);
        return modelAndView;

    }
}
