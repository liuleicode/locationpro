package com.ll.location.service;

import com.ll.location.model.Localdtl;
import com.ll.location.model.User;

/**
 * Created by liulei on 2017/7/16.
 */
public interface FindLocationService {
    /**
     *
     * @param localid
     * @param user
     * @param source
     * source 为来源 0-二维码 1或者null-其他渠道
     * @return
     */
    Localdtl findLocal(String localid, User user,String source);

}
