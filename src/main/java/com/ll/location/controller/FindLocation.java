package com.ll.location.controller;

import com.alibaba.fastjson.JSONObject;
//import com.ll.location.dao.LocalMapper;
//import com.ll.location.model.Local;
import jdk.nashorn.internal.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liulei on 2017/7/2.
 */
@Controller
@RequestMapping("/location")
public class FindLocation {

    private Logger logger = LoggerFactory.getLogger(FindLocation.class);
//    @Autowired

////    @RequestMapping("/findlocation")
////    @ResponseBody
//    public String findLocation(Model model){
//        model.addAttribute("liulei","liulei1");
//
//        return "index";
//    }

//    @RequestMapping("/fandlocation/{localno}")
//    @ResponseBody
//    public Local findLocation(@PathVariable(value="localno") String localno){
//        Local local = localMapper.selectByLocalno(localno);
//        logger.info(JSONObject.toJSONString(local));
//        return local;
//    }
//
//    @RequestMapping("/fandlocation1/{localno}")
////    @ResponseBody
//    public ModelAndView findLocation1(@PathVariable(value="localno") String localno){
//        Local local = localMapper.selectByLocalno(localno);
//        logger.info(JSONObject.toJSONString(local));
//        ModelAndView modelAndView = new ModelAndView("index");
//
//        modelAndView.addObject("local",local);
//        return modelAndView;
//    }
}
