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
     * 用于用户扫描二维码查询地址信息,通过链接也是通过这个controller查询，只是source来源为非零
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

    @RequestMapping("locationintroduce")
    public ModelAndView locationIntroduce(String localid, User user, String source, HttpServletRequest request, HttpServletResponse response) {

        logger.info("进入findlocation接口");
        logger.info("localid:" + localid);
        logger.info("user" + JSONObject.toJSONString(user));
        logger.info("source" + source);
        ModelAndView modelAndView = new ModelAndView("/jsp/localtion");
        Localdtl localdtl=new Localdtl();
        //Localdtl localdtl = findLocationService.findLocal(localid, user, source);
        localdtl.setName("广武明长城");

        //来历
        localdtl.setMainoriginofname("该地名来源于古代战事防御工事。");
        //含义
        localdtl.setMainmeanofname("现存长城是明朝所筑，位于山阴县张家庄乡旧广武村附近，故而得名。");
        //地名的历史沿革
        localdtl.setMainhistoryevolution("2014年山阴县文物局对现有长城遗迹进行编号拍照。名称沿用至今。");
        //资料来源
        localdtl.setInfosource("山阴县史志馆、一普资料（1988年版）、地名资料补充与更新（1992年版）、遥感影像图、《中华人民共和国政区大典》（朔州部分2013年版）、区划地名数据库、《山阴县志》（1999年版）、《山阴史迹图志》（2014年版）、实地勘探、调查");
        //地理实体概况
        localdtl.setMainlocalinfo("【位置信息】位于山阴县张家庄乡旧广武村附近。" +
                "    【遗址详简】修筑长城一般都就地取材，城砖和石灰石就地烧制，高山峻岭地段开采石料，用石头堆砌。" +
                "    【长宽、结构信息】在沙漠地段用红柳枝条和芦苇与砂石一层层铺砌。黄土地区，大都采取土垒筑。在重要地段的城墙一般用砖和石头砌。城墙高低宽窄不一，平均高在7米，墙基一般宽在6米，顶宽5米。" +
                "    【其它信息】2001年，广武明长城被国务院批准列入第五批全国重点文物保护单位。 ");
        modelAndView.addObject("localdtl", localdtl);
        return modelAndView;
    }

    @RequestMapping("evalution")
    public ModelAndView evalution(String localid, User user, String source, HttpServletRequest request, HttpServletResponse response) {

        logger.info("进入findlocation接口");
        logger.info("localid:" + localid);
        logger.info("user" + JSONObject.toJSONString(user));
        logger.info("source" + source);
        ModelAndView modelAndView = new ModelAndView("/jsp/Evalution");
        //Localdtl localdtl = findLocationService.findLocal(localid, user, source);
        //  modelAndView.addObject("localdtl", localdtl);
        return modelAndView;
    }
}
