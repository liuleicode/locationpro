package com.ll.location.controller;

import com.alibaba.fastjson.JSONObject;
import com.ll.location.dao.LocaldtlMapper;
import com.ll.location.dao.UserMapper;
import com.ll.location.model.Localdtl;
import com.ll.location.model.User;
import com.ll.location.service.FindLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(LocationController.class);
    @Autowired
    FindLocationService findLocationService;

    /**
     * @param localid
     * @param user
     * @param source   source为来源，0-二维码 1或null-网页访问
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("findlocation")
    public ModelAndView findLocation(String localid, User user, String source, HttpServletRequest request, HttpServletResponse response) {

        logger.info("进入findlocation接口");
        logger.info("localid:" + localid);
        logger.info("user" + JSONObject.toJSONString(user));
        logger.info("source" + source);
        ModelAndView modelAndView = new ModelAndView("index");
        Localdtl localdtl = findLocationService.findLocal(localid, user, source);
        modelAndView.addObject("localdtl", localdtl);
        return modelAndView;
    }
}
