package com.ll.location.utilmain;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;

import java.io.File;
import java.io.IOException;

/**
 * POI 读取 word 2003 和 word 2007 中文字内容的<a href="http://lib.csdn.net/base/softwaretest" class='replace_word' title="软件测试知识库" target='_blank' style='color:#df3434; font-weight:bold;'>测试</a>类<br />
 *
 * @author Carl He
 * @createDate 2009-07-25
 */
public class Poi {
    public static void main(String[] args) throws OpenXML4JException, XmlException, IOException {

        String path = "C:\\files\\files\\files\\"; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory())
                ;
            else
                docToString(path, fs.getName());
        }

//        try
//
//        {
        //word 2003： 图片不会被读取
//            InputStream is = new FileInputStream(new File("c://files//2003.doc"));
//            WordExtractor ex = new WordExtractor(is);
//            String text2003 = ex.getText();
//            System.out.println(text2003);
//            String text20032 = text2003.replace("\u0007", " ").replace("：", " ");
//            String[] array1 = text20032.split("\\s+");
//            System.out.println(array1.length);
//            for (String array : array1)
//                System.out.println(array);

        //word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
//            OPCPackage opcPackage = POIXMLDocument.openPackage("c://files//2007.docx");
//            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
//            String text2007 = extractor.getText();
//            System.out.println(text2007);
//
//        } catch (
//                Exception e)
//
//        {
//            e.printStackTrace();
//        }
    }

    private static void docToString(String forderpath, String filename) throws IOException, OpenXML4JException, XmlException {
        OPCPackage opcPackage = POIXMLDocument.openPackage(forderpath + filename);
        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
        String text2007 = extractor.getText();
//        System.out.println(text2007);
        String text20072 = text2007.replace(" 类别: ","\u0007类别: ").replace(" ", "\u0008").replace("\t\t","\taaaa\t").replace("\t\n","\taaaa\t").replace("\u0007", " ").replace(":",": ");
        String[] array1 = text20072.split("\\s+");
        System.out.println(array1.length);
        int i = 0;
        for (String array : array1) {
            if (!array.trim().equals("登记表")&& i==0)
                continue;
            System.out.println(++i + array.replace("\u0008", " ").trim().replace("aaaa",""));
        }
        /**
         * 3-区域
         * 5-类别
         * 7-名称
         * 9-简称
         * 11-曾用名
         * 13-类别
         * 17-使用时间
         * 19-地名的来历
         *
         *
         */
//        System.out.println(text2007);
    }
}
