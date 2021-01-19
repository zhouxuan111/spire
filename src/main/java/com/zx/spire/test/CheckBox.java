package com.zx.spire.test;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.SdtCheckBox;
import com.spire.doc.documents.SdtType;
import com.spire.doc.documents.StructureDocumentTagInline;
import com.spire.doc.documents.TextSelection;
import com.spire.doc.fields.CheckBoxFormField;
import com.spire.doc.fields.DocPicture;
import com.spire.doc.fields.TextRange;

/**
 * @author xuanzhou
 * @date 2021/1/19 2:17 下午
 */
public class CheckBox {

    public static void main(String[] args) {

        Document document = new Document();
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
        sd.getChildObjects().add(textRange);
        scb.setCheckedStateCharacterCode(9745);
        scb.setChecked(true);





        document.saveToFile("/Users/zhouxuan/Desktop/itext_text/4.docx",FileFormat.Docx_2013);
        document.dispose();

    }

}
