package com.zx.spire.test;


/**
 * @author xuanzhou
 * @date 2021/1/15 10:34 上午
 */
public class TestWordToPdf {

    /*public static void main(String[] args) throws IOException, Docx4JException {


        WordprocessingMLPackage pkg = Docx4J.load(new File("/Users/zhouxuan/Desktop/itext_text/ReplaceTextWithImage.docx"));

        File output = new File("/Users/zhouxuan/Desktop/itext_text/ReplaceTextWithImage.pdf");
        FileOutputStream fos = new FileOutputStream(output);

        Documents4jLocalServices exporter = new Documents4jLocalServices();
        exporter.export(pkg, fos);

        // or equivalently,
        // Docx4J.toPDF(pkg, fos);

        fos.close();

    }*/

    public static void main(String[] args) throws Exception {
        Word2PDFUtil.convert("/Users/zhouxuan/Desktop/itext_text/1.docx","/Users/zhouxuan/Desktop/itext_text/ReplaceTextWithImage.pdf");
    }
}
