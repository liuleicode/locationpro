package com.ll.location.controller;

import com.ll.location.dao.LocaldtlMapper;
import com.ll.location.dao.UserMapper;
import com.ll.location.model.Localdtl;
import com.ll.location.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liulei on 2017/7/16.
 */
@Controller
@RequestMapping("qrcode")
public class LocationController {
    @Autowired
    LocaldtlMapper localdtlMapper;
    @Autowired
    UserMapper userMapper;

    /**
     *
     * @param localid
     * @param user
     * @param source
     * source为来源，0-二维码 1或null-网页访问
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("findlocation")
    public ModelAndView findLocation(String localid, User user, String source,HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("index");
        Localdtl localdtl = localdtlMapper.selectByPrimaryKey(localid);
        modelAndView.addObject("localdtl",localdtl);

            return modelAndView;

    }
}
