package com.zx.spire.test;


import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.SdtCheckBox;
import com.spire.doc.documents.SdtType;
import com.spire.doc.documents.StructureDocumentTagInline;
import com.spire.doc.documents.TextSelection;
import com.spire.doc.fields.DocPicture;
import com.spire.doc.fields.TextRange;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xuanzhou
 * @date 2021/1/14 5:49 下午
 */
public class ReplaceDemo {

    public static void main(String[] args) throws Exception {
        Document document = new Document();
        document.loadFromFile("/Users/zhouxuan/Desktop/itext_text/个人税收居民身份声明文件.docx");
        document.setReplaceFirst(true);
        //调用方法用新文本替换原文本内容 不区分大小写，匹配整个词
        document.replace("${text_name}", "周旋", true, true);

        //查找需要替换的字符串
        TextSelection textSelection = document.findString("${img_sign}",true,true);

        //加载图片替换文本字符串
        DocPicture pic = new DocPicture(document);
        pic.loadImage("/Users/zhouxuan/Desktop/itext_text/WechatIMG17.jpeg");
        pic.setHeight(100);
        pic.setWidth(100);
        TextRange range = textSelection.getAsOneRange();
        int index = range.getOwnerParagraph().getChildObjects().indexOf(range);
        range.getOwnerParagraph().getChildObjects().insert(index,pic);
        range.getOwnerParagraph().getChildObjects().remove(range);

        //复选框打钩
        TextSelection selection1 = document.findString("${checkbox_one}",true,false);
        //创建Word文档
        TextRange textRange1 = selection1.getAsOneRange();
        Paragraph paragraph1 =  textRange1.getOwnerParagraph();
         index = textRange1.getOwnerParagraph().getChildObjects().indexOf(textRange1);

        //添加复选框内容控件
        //
        StructureDocumentTagInline sd1 = new StructureDocumentTagInline(document);
        paragraph1.getChildObjects().insert(index,sd1);
        sd1.getSDTProperties().setSDTType(SdtType.Check_Box);
        SdtCheckBox scb1 = new SdtCheckBox();
        sd1.getSDTProperties().setControlProperties(scb1);
        sd1.getChildObjects().add(textRange1);
        sd1.getSDTProperties().setAlias("复选框");
        sd1.getSDTProperties().setTag("复选框");
        //顺序不能更换 复选框打对勾
        scb1.setCheckedStateCharacterCode(9745);
        scb1.setChecked(true);


        TextSelection selection2 = document.findString("${checkbox_two}",true,false);
        //创建Word文档
        TextRange textRange2 = selection2.getAsOneRange();
        index = textRange2.getOwnerParagraph().getChildObjects().indexOf(textRange2);

        Paragraph paragraph2 =  textRange2.getOwnerParagraph();
        //添加复选框内容控件
        StructureDocumentTagInline sd2 = new StructureDocumentTagInline(document);
        paragraph2.getChildObjects().insert(index,sd2);
        sd2.getSDTProperties().setSDTType(SdtType.Check_Box);
        SdtCheckBox scb2 = new SdtCheckBox();
        sd2.getSDTProperties().setControlProperties(scb2);
        sd2.getChildObjects().add(textRange2);
        scb2.setChecked(false);


        TextSelection selection3 = document.findString("${checkbox_three}",true,false);
        //创建Word文档
        TextRange textRange3 = selection3.getAsOneRange();
        Paragraph paragraph3 =  textRange3.getOwnerParagraph();
        index = textRange3.getOwnerParagraph().getChildObjects().indexOf(textRange3);

        //添加复选框内容控件
        StructureDocumentTagInline sd3 = new StructureDocumentTagInline(document);
        paragraph3.getChildObjects().insert(index,sd3);
        sd3.getSDTProperties().setSDTType(SdtType.Check_Box);
        SdtCheckBox scb3 = new SdtCheckBox();
        sd3.getSDTProperties().setControlProperties(scb3);
        sd3.getChildObjects().add(textRange3);
        scb3.setChecked(false);


        //使用宋体转换为PDF - 添加未安装字体
        PrivateFontPath fontPath = new PrivateFontPath("宋体","src/main/resources/宋体_常规.ttc");
        PrivateFontPath fontPath1 = new PrivateFontPath("MS Gothic","src/main/resources/MS Gothic.ttc");
        ToPdfParameterList toPdfParameterList = new ToPdfParameterList();
        List pathList = new LinkedList<>();
        pathList.add(fontPath);
        pathList.add(fontPath);
        toPdfParameterList.setPrivateFontPaths(pathList);
        //pdf的保存路径
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.saveToFile("/Users/zhouxuan/Desktop/itext_text/ReplaceTextWithImage.pdf",toPdfParameterList);
    }

}
