package com.zx.spire.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;

/**
 * @author xuanzhou
 * @date 2021/1/15 10:34 上午
 */
public class TestWordToPdf {

    public static void main(String[] args) throws Exception {
       Word2PDFUtil.convert("/Users/zhouxuan/Desktop/itext_text/12.docx","/Users/zhouxuan/Desktop/itext_text/2.pdf");
        /*File inputWord = new File("/Users/zhouxuan/Desktop/itext_text/1.docx");
        File outputFile = new File("/Users/zhouxuan/Desktop/itext_text/2.pdf");
        try  {
            InputStream docxInputStream = new FileInputStream(inputWord);
            OutputStream outputStream = new FileOutputStream(outputFile);
            IConverter converter = LocalConverter.builder().build();
            converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
            outputStream.close();
            17：17:25


            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }
}
