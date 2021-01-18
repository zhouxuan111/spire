package com.zx.spire.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;

/**
 * @author xuanzhou
 * @date 2021/1/15 2:09 下午
 */
public class TestWordUtil {

    public static void main(String[] args) throws IOException {

        Map<String,Object> map = new HashMap<>();
        map.put("${text_name}","周旋");
        map.put("${checkbox_one}",true);
        map.put("${checkbox_two}",false);
        map.put("${checkbox_three}",false);

        map.put("${img_sign}","/Users/zhouxuan/Desktop/itext_text/WechatIMG17.jpeg");
        WordUtil.createPdfToStream(map,1);


    }

}
