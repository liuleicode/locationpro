package com.ll.location.service;

import com.alibaba.fastjson.JSONObject;
import com.ll.location.dao.LocaldtlMapper;
import com.ll.location.dao.UserMapper;
import com.ll.location.dao.UsersigninMapper;
import com.ll.location.dao.UsersignindtlMapper;
import com.ll.location.model.Localdtl;
import com.ll.location.model.User;
import com.ll.location.model.Usersignin;
import com.ll.location.model.Usersignindtl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by liulei on 2017/7/16.
 */
@Service
public class FindLocationServiceImpl implements FindLocationService {
    private static Logger logger = LoggerFactory.getLogger(FindLocationServiceImpl.class);
    @Autowired
    LocaldtlMapper localdtlMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UsersigninMapper usersigninMapper;
    @Autowired
    UsersignindtlMapper usersignindtlMapper;

    @Override
    public Localdtl findLocal(String localid, User user, String source) {
        logger.info("进入查询地址程序");
        Localdtl localdtl = localdtlMapper.selectByPrimaryKey(localid);

        logger.info(JSONObject.toJSONString(localdtl));

        if (user != null) {
            try {
                this.updateUserInfo(localid, user, source);
            } catch (Exception e) {
                logger.error("更新数据库异常：：：" + e.getMessage());
            }
        }

        return localdtl;
    }

    private void updateUserInfo(String localid, User user, String source) {

        //如果来源不是扫码 就不需要处理
        if (!source.equals(0))
            return;
        Date date = new Date();
        //TODO 这个地方与微信账号有关，不知道具体接口是什么，暂时这么写
        User u = userMapper.selectByPrimaryKey(user.getUserid());
        if (u != null) {
            //todo 更新数据信息
            u.setLastsignintime(date);
            userMapper.updateByPrimaryKey(u);
        } else {
            u.setLastsignintime(date);
            u.setCreatetime(date);
            userMapper.insert(u);
        }
        //更新用户登录数据
        Usersignin usersignin = usersigninMapper.selectByLocalidAndUserid(localid, user.getUserid());

        Usersignin usersignin1 = new Usersignin();

        if (usersignin != null) {
            usersignin.setSignincount(usersignin.getSignincount() + 1);
            usersignin.setUpdatetime(date);
        } else {
            usersignin1.setUpdatetime(date);
            usersignin1.setSignincount(1L);
            usersignin1.setCreatetime(date);
            usersignin1.setLocaldtlid(localid);
            usersignin1.setUserid(user.getUserid());
            usersignin1.setUsersigninid(UUID.randomUUID().toString());
            usersigninMapper.insert(usersignin1);

        }

        Usersignindtl usersignindtl = new Usersignindtl();
        usersignindtl.setCreatetime(date);
        usersignindtl.setLocaldtlid(localid);
        usersignindtl.setUpdatetime(date);
        usersignindtl.setUserid(user.getUserid());
        usersignindtl.setUsersignid(usersignin == null ? usersignin1.getUsersigninid() : usersignin.getUsersigninid());
        usersignindtlMapper.insert(usersignindtl);


    }

}
