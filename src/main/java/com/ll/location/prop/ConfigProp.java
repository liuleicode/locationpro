package com.ll.location.prop;

import java.util.Properties;

import org.apache.log4j.Logger;


public class ConfigProp {

    // 资源分布网络前缀
    // 上传内容，网络访问地址
    // public static final String UPLOAD_HEAD_PRE = "upload.head.pre";
    public static final String RES_FTP_IP = "res.ftp.ip";
    public static final String RES_FTP_PORT = "res.ftp.port";
    public static final String RES_FTP_USERNAME = "res.ftp.username";
    public static final String RES_FTP_PASSWORD = "res.ftp.pasword";
    public static final String RES_FTP_USERPHOTOS = "res.ftp.userphotos";
    public static final String RES_FTP_ACTIVITY_STAR = "res.ftp.activity.star";
    
    //下载升级包，网络访问地址
    public static final String DOWNLOAD_SERVER = "download.server.pre";

    // 用户资源
    public static final String USER_PHOTO_PRE = "user.photo.pre";
    
    //资源包，网络访问地址
    public static final String COMMON_IMG = "common.img.pre";
    public static final String COMMON_CSS_SERVER = "common.css.pre";
    public static final String COMMON_JS = "common.js.pre";

    // 明星啪网络资源前缀
    public static final String ACTIVITY_STAR_PRE = "activity.star.pre";

    // 兑吧参数
    public static final String DUI_BA_APPKEY = "duiba.appkey";
    public static final String DUI_BA_APPSECRET = "duiba.appsecret";
    public static final String DUI_BA_AOTOLOGIN = "duiba.aotologin";
    public static final String DUI_BA_REDIRECT = "duiba.redirect";
    public static final String DUI_BA_EXCHANGEFAIL = "duiba.exchangefail";
    public static final String DUI_BA_NOTIFYOK = "duiba.notifyok";


    // 运通讯参数
    public static final String YTX_REST_URL = "ytx.rest.url";
    public static final String YTX_REST_PORT = "ytx.rest.port";
    public static final String YTX_ACCOUNT_SID = "ytx.account.sid";
    public static final String YTX_AUTH_TOKEN = "ytx.auth.token";
    public static final String YTX_APPID = "ytx.appid";
    public static final String YTX_TEMPLETEID = "ytx.templeteid";


    // 支付宝参数
    public static final String BATCH_ALIPAY_URL = "batch.alipay.url";
    public static final String BATCH_TOKEN = "batch.token";

    // 系统常量数据
    public static final String SYSTEM_USER_ID = "system.user.id";

    private static Logger logger = Logger.getLogger(ConfigProp.class);

    private static String name = "constants.properties";

    private static Properties prop;

    public static void initialize() {

        // 读取加载配置文件
        prop = PropLoader.load(name);

        if (prop == null)
            logger.error("properties(" + name + ") initialize error");
        else
            logger.info("properties(" + name + ") initialize success");
    }

    public static void reset() {
        prop = null;
    }

    public static String getProperty(String key) {
        if (prop == null)
            initialize();

        return prop.getProperty(key);
    }
}
