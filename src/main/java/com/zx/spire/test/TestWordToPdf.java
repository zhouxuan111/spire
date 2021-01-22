package com.zx.spire.test;

/**
 * @author xuanzhou
 * @date 2021/1/15 10:34 上午
 */
public class TestWordToPdf {

    public static void main(String[] args) throws Exception {
       Word2PDFUtil.convert("/Users/zhouxuan/Desktop/itext_text/5.docx","/Users/zhouxuan/Desktop/itext_text/2.pdf");
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
