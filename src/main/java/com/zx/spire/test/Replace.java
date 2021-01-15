package com.zx.spire.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.ToPdfParameterList;
import com.spire.doc.documents.TextSelection;
import com.spire.doc.fields.DocPicture;
import com.spire.doc.fields.TextRange;

/**
 * @author xuanzhou
 * @date 2021/1/14 5:49 下午
 */
public class Replace {

    public static void main(String[] args) throws Exception {
        Document document = new Document();
        document.loadFromFile("/Users/zhouxuan/Desktop/itext_text/个人税收居民身份声明文件.docx");
        document.setReplaceFirst(true);
        //调用方法用新文本替换原文本内容
        document.replace("${name}", "周旋", false, true);

        //查找需要替换的字符串
        TextSelection[] textSelection = document.findAllString("${img}",true,false);
        int index ;

        //加载图片替换文本字符串
        for (Object obj : textSelection) {
            TextSelection Selection = (TextSelection)obj;
            DocPicture pic = new DocPicture(document);
            pic.loadImage("/Users/zhouxuan/Desktop/itext_text/WechatIMG17.jpeg");
            pic.setHeight(100);
            pic.setWidth(100);
            TextRange range = Selection.getAsOneRange();
            index = range.getOwnerParagraph().getChildObjects().indexOf(range);
            range.getOwnerParagraph().getChildObjects().insert(index,pic);
            range.getOwnerParagraph().getChildObjects().remove(range);
        }

        //复选框打钩

        TextSelection selection1 = document.findString("${one}",true,false);
        TextRange tr1 = selection1.getAsOneRange();
        tr1.getCharacterFormat().setFontName("Wingdings 2");
        //除了16进制，也可以用10进制来表示这个符号，复选框打勾是82
        document.replace(selection1.getSelectedText(),String.valueOf(((char)82)), true, false);

        TextSelection selection2 = document.findString("${two}",true,false);
        TextRange tr2 = selection2.getAsOneRange();
        tr2.getCharacterFormat().setFontName("Wingdings 2");
        //除了16进制，也可以用10进制来表示这个符号，复选框打勾是82
        document.replace(selection2.getSelectedText(),String.valueOf(((char)163)), true, false);

        TextSelection selection3 = document.findString("${three}",true,false);
        TextRange tr3 = selection3.getAsOneRange();
        tr3.getCharacterFormat().setFontName("Wingdings 2");
        //除了16进制，也可以用10进制来表示这个符号，复选框打勾是82
        document.replace(selection3.getSelectedText(),String.valueOf(((char)163)), true, false);


        //
        document.saveToFile("/Users/zhouxuan/Desktop/itext_text/ReplaceTextWithImage.pdf",FileFormat.PDF);
        document.dispose();
        //保存文档
        /*ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.saveToStream(outputStream, FileFormat.Docx_2013);
        document.dispose();

        Word2PDFUtil.convert(outputStream,"/Users/zhouxuan/Desktop/itext_text/ReplaceTextWithImage.pdf");*/

        ToPdfParameterList list = new ToPdfParameterList();
    }

}
