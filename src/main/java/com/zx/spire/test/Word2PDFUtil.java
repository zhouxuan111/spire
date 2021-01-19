package com.zx.spire.test;

/**
 * @author qhwang
 * @date 2017-11-02 下午7:19
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.samples.AbstractSample;

/**
 * Word转PDF工具类，利用docx4j-export-fo工具提供的功能实现 比poi的实现方式简洁很多
 */
public class Word2PDFUtil extends AbstractSample {

    public static void convert(String outputStream, String pdfOutputFilePath) throws Exception{
        Long startTime = System.currentTimeMillis();
        try (OutputStream os = new java.io.FileOutputStream(pdfOutputFilePath);){

            //ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(outputStream));

            Mapper fontMapper = new IdentityPlusMapper();

            fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
            fontMapper.put("宋体",PhysicalFonts.get("SimSun"));
            fontMapper.put("微软雅黑",PhysicalFonts.get("Microsoft Yahei"));
            fontMapper.put("黑体-简",PhysicalFonts.get("SimHei"));
            fontMapper.put("楷体",PhysicalFonts.get("KaiTi"));
            fontMapper.put("新宋体",PhysicalFonts.get("NSimSun"));
            fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
            fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
            fontMapper.put("宋体扩展",PhysicalFonts.get("simsun-extB"));
            fontMapper.put("仿宋",PhysicalFonts.get("FangSong"));
            fontMapper.put("仿宋_GB2312",PhysicalFonts.get("FangSong_GB2312"));
            fontMapper.put("幼圆",PhysicalFonts.get("YouYuan"));
            fontMapper.put("华文宋体",PhysicalFonts.get("STSong"));
            fontMapper.put("华文中宋",PhysicalFonts.get("STZhongsong"));


            wordMLPackage.setFontMapper(fontMapper);

            FOSettings foSettings = Docx4J.createFOSettings();

            foSettings.setWmlPackage(wordMLPackage);


            Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);

            if (wordMLPackage.getMainDocumentPart().getFontTablePart() != null) {
                wordMLPackage.getMainDocumentPart().getFontTablePart().deleteEmbeddedFontTempFiles();
            }
        }
    }
}
