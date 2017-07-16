package com.ll.location.service;

import com.ll.location.model.Localdtl;
import com.ll.location.model.User;
import com.ll.location.model.Usersignin;

import java.util.List;

/**
 * Created by liulei on 2017/7/16.
 */
public interface UsersignindtlService {
    /**
     *
     * @param user
     * @param pagesize
     * @param pageno
     * source 为来源 0-二维码 1或者null-其他渠道
     * @return
     */
    List<Usersignin> listUsersignindtl( User user, Integer pagesize,Integer pageno);

}
