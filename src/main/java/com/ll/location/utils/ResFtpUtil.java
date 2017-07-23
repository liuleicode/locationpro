package com.ll.location.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.ll.location.prop.ConfigProp;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;


public class ResFtpUtil {

    private static Logger logger = Logger.getLogger(ResFtpUtil.class);

    private static FTPClient ftpClient = new FTPClient();

    /**
     * 将文件流上传至资源服务器
     * 
     * @param fis
     * @param fileName
     * @return
     */
    synchronized public static boolean transFileStreamAsFile(InputStream fis, String fileName, String pathname) {

        boolean result = false;

        try {
            String ip = ConfigProp.getProperty(ConfigProp.RES_FTP_IP);
            int port = Integer.parseInt(ConfigProp.getProperty(ConfigProp.RES_FTP_PORT));
            String username = ConfigProp.getProperty(ConfigProp.RES_FTP_USERNAME);
            String password = ConfigProp.getProperty(ConfigProp.RES_FTP_PASSWORD);

            ftpClient.connect(ip, port);
            boolean loginResult = ftpClient.login(username, password);
            if (!loginResult) {
                logger.error("ftp login error");
                return false;
            }

            // 设置上传目录
            // ftpClient.changeWorkingDirectory(directory);
            ftpClient.setBufferSize(1024);
            ftpClient.setControlEncoding("UTF-8");

            // 设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            logger.info("ftp upload as " + fileName);

            if (pathname != null) {
                // int mkdResult = ftpClient.mkd(path);
                // int rmdResult = ftpClient.rmd(path);
                // int deleResult = ftpClient.dele(pathname);
                ftpClient.mkd(pathname);
                ftpClient.changeWorkingDirectory(pathname);
            }

            ftpClient.storeFile(fileName, fis);

            ftpClient.logout();

            result = true;
        } catch (IOException e) {
            logger.error("ftp translate error." + e.getMessage());
            result = false;
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                    ;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {

        File srcFile = new File("D:\\2.jpg");
        FileInputStream fis = new FileInputStream(srcFile);
        boolean result = transFileStreamAsFile(fis, "zzzzzzzz.jpg", "testPathName/sub1/sub2");
        fis.close();

        System.out.println(result);
    }
}
