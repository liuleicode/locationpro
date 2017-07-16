package com.ll.location.service;

import com.ll.location.dao.UsersigninMapper;
import com.ll.location.model.User;
import com.ll.location.model.Usersignin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liulei on 2017/7/16.
 */
@Service
public class UsersignindtlServiceImpl implements UsersignindtlService {

    @Autowired
    UsersigninMapper usersigninMapper;

    /**
     * @param user
     * @param pagesize
     * @param pageno
     * @return
     */
    @Override
    public List<Usersignin> listUsersignindtl(User user, Integer pagesize, Integer pageno) {

        return usersigninMapper.selectByUseridByPage(user.getUserid(), pagesize * pageno - 1, pagesize);

    }
}
