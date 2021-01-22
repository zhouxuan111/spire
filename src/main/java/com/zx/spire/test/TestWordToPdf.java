package com.zx.spire.test;

/**
 * @author xuanzhou
 * @date 2021/1/15 10:34 上午
 */
public class TestWordToPdf {

    public static void main(String[] args) throws Exception {

        /**
         * 使用docx4j将word转换为pdf 不会出现复选框丢失
         */
        Word2PDFUtil.convert("/Users/zhouxuan/Desktop/itext_text/5.docx","/Users/zhouxuan/Desktop/itext_text/2.pdf");
    }
}
