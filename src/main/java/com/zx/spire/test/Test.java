package com.zx.spire.test;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;

/**
 * @author xuanzhou
 * @date 2021/1/15 2:09 下午
 */
public class Test {

    public static void main(String[] args) {
        Document document = new Document();
        document.loadFromFile("/Users/zhouxuan/Desktop/itext_text/test_result.docx");
        document.setReplaceFirst(true);
        //调用方法用新文本替换原文本内容
        document.replace("${name}", "周旋", false, true);
        document.saveToFile("/Users/zhouxuan/Desktop/itext_text/1.docx", FileFormat.Docx_2013);
        document.dispose();
    }

}
