package com.zx.spire.test;

import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.SdtCheckBox;
import com.spire.doc.documents.SdtType;
import com.spire.doc.documents.StructureDocumentTagInline;
import com.spire.doc.documents.TextSelection;
import com.spire.doc.fields.CheckBoxFormField;
import com.spire.doc.fields.DocPicture;
import com.spire.doc.fields.TextRange;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xuanzhou
 * @date 2021/1/19 2:17 下午
 */
public class CheckBox {

    public static void main(String[] args) {

        /*Document document = new Document();
        document.loadFromFile("/Users/zhouxuan/Desktop/itext_text/3.docx");

        TextSelection textSelection = document.findString("${one}",false,true);
//创建Word文档
        TextRange textRange = textSelection.getAsOneRange();
        Paragraph paragraph =  textRange.getOwnerParagraph();
        int index = textRange.getOwnerParagraph().getChildObjects().indexOf(textRange);
        //添加复选框内容控件
        StructureDocumentTagInline sd = new StructureDocumentTagInline(document);
        paragraph.getChildObjects().insert(index,sd);
        sd.getSDTProperties().setSDTType(SdtType.Check_Box);
        SdtCheckBox scb = new SdtCheckBox();
        sd.getSDTProperties().setControlProperties(scb);
        sd.getSDTProperties().setAlias("复选框");
        sd.getSDTProperties().setTag("复选框");
        sd.getChildObjects().insert(index,textRange);
        scb.setCheckedStateCharacterCode(9745);
        scb.setChecked(true);
        PrivateFontPath fontPath = new PrivateFontPath("宋体","src/main/resources/宋体_常规.ttc");
        ToPdfParameterList toPdfParameterList = new ToPdfParameterList();
        List pathList = new LinkedList<>();
        pathList.add(fontPath);
        toPdfParameterList.setPrivateFontPaths(pathList);
        //pdf的保存路径
        //Word2PDFUtil.convert(outputStream,"/Users/zhouxuan/Desktop/itext_text/ReplaceTextWithImage.pdf");


        //将Word文档保存为PDF
        document.saveToFile("/Users/zhouxuan/Desktop/itext_text/4.pdf",toPdfParameterList);



        //document.saveToFile("/Users/zhouxuan/Desktop/itext_text/4.pdf",FileFormat.PDF);
        document.dispose();*/



        //创建Word文档
        Document document = new Document();
        Section section = document.addSection();
        Paragraph paragraph = section.addParagraph();
        section.addParagraph();



        //添加复选框内容控件
        StructureDocumentTagInline  sd = new StructureDocumentTagInline(document);
        paragraph.getChildObjects().add(sd);
        sd.getSDTProperties().setSDTType(SdtType.Check_Box);
        sd.getSDTProperties().setAlias("复选框");
        sd.getSDTProperties().setTag("复选框");
        SdtCheckBox scb = new SdtCheckBox();
        sd.getSDTProperties().setControlProperties(scb);
        TextRange rt = new TextRange(document);
        sd.getChildObjects().add(rt);
        scb.setChecked(true);


        //保存结果文档
        document.saveToFile("/Users/zhouxuan/Desktop/itext_text/4.pdf", FileFormat.PDF);


    }

}
