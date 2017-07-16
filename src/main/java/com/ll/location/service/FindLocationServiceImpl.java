package com.ll.location.service;

import com.ll.location.dao.LocaldtlMapper;
import com.ll.location.dao.UserMapper;
import com.ll.location.dao.UsersigninMapper;
import com.ll.location.dao.UsersignindtlMapper;
import com.ll.location.model.Localdtl;
import com.ll.location.model.User;
import com.ll.location.model.Usersignin;
import com.ll.location.model.Usersignindtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by liulei on 2017/7/16.
 */
@Service
public class FindLocationServiceImpl implements FindLocationService {
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
        Localdtl localdtl = localdtlMapper.selectByPrimaryKey(localid);

        if (user != null) {
            this.updateUserInfo(localid, user);
        }

        return localdtl;
    }

    private void updateUserInfo(String localid, User user) {

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
