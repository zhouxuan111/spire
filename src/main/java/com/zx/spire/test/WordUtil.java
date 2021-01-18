package com.zx.spire.test;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.spire.doc.Document;
import com.spire.doc.PrivateFontPath;
import com.spire.doc.ToPdfParameterList;
import com.spire.doc.documents.TextSelection;
import com.spire.doc.fields.DocPicture;
import com.spire.doc.fields.TextRange;

/**
 * word文档工具类
 * @author xuanzhou
 * @date 2021/1/18 10:26 上午
 */
public class WordUtil {
    /**
     * 使用说明：本工具类只支持小于3页的pdf使用
     * 模板的占位符和替换值要求：
     *  文本:key = ${text_xxx} ，value = 要替换的文本
     *  图片:key = ${img_xxx}，value = 图片路径
     *  复选框:key = ${checkbox_xxx}，value = true(打钩) or false(不打勾)
     *
     * 示例：
     *    Map<String,Object> map = new HashMap<>();
     *    map.put("${text_name}","周旋");
     *    map.put("${checkbox_one}",true);
     *    map.put("${checkbox_two}",false);
     *    map.put("${checkbox_three}",false);
     *    map.put("${img_sign}","/Users/zhouxuan/Desktop/itext_text/WechatIMG17.jpeg");
     *    WordUtil.createPdf(map,1);
     */

    /**
     * 生成PDF（保存到小文件系统） - 暂不使用
     * @param data
     * @param templateNo
     * @return
     */
    public static String createPdf(Map<String,Object> data,Integer templateNo){
        String templateUrl = getUrlByTemplateNo(templateNo);
        Document document = convert(data,templateUrl);
        //设置PDF的格式
        PrivateFontPath fontPath = new PrivateFontPath("宋体","src/main/resources/宋体_常规.ttc");
        ToPdfParameterList toPdfParameterList = new ToPdfParameterList();
        List pathList = new LinkedList<>();
        pathList.add(fontPath);
        toPdfParameterList.setPrivateFontPaths(pathList);

        //获取pdf的路径 --
        StringBuilder pdfUrl = new StringBuilder(templateUrl.split("\\.")[0]).append(".pdf");

        //需要上传到小文件系统
        document.saveToFile(pdfUrl.toString(),toPdfParameterList);
        return pdfUrl.toString();
    }

    /**
     * 将pdf保存到流中
     * @param data
     * @param templateNo
     * @return
     */
    public static OutputStream createPdfToStream(Map<String,Object> data,Integer templateNo) throws IOException {
        String templateUrl = getUrlByTemplateNo(templateNo);
        Document document = convert(data,templateUrl);
        //设置PDF的格式
        PrivateFontPath fontPath = new PrivateFontPath("宋体","src/main/resources/宋体_常规.ttc");
        ToPdfParameterList toPdfParameterList = new ToPdfParameterList();
        List pathList = new LinkedList<>();
        pathList.add(fontPath);
        toPdfParameterList.setPrivateFontPaths(pathList);

        //返回流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.saveToStream(outputStream,toPdfParameterList);
        return outputStream;
    }


    /**
     * word数据填充
     */
    public static Document convert(Map<String,Object> data,String templateUrl){
        //加载模板文件
        Document document = new Document();
        document.loadFromFile(templateUrl);

        for (Map.Entry<String,Object> entry: data.entrySet()) {
            //替换文本
            if(entry.getKey().startsWith("${text_")){
                document.replace(entry.getKey(),entry.getValue().toString(),false,true);
            }
            //替换图片
            else if (entry.getKey().startsWith("${img_")){
                TextSelection textSelection = document.findString(entry.getKey(),true,false);
                int index ;

                //加载图片替换文本字符串
                DocPicture pic = new DocPicture(document);
                pic.loadImage(entry.getValue().toString());
                pic.setHeight(100);
                pic.setWidth(100);
                TextRange range = textSelection.getAsOneRange();
                index = range.getOwnerParagraph().getChildObjects().indexOf(range);
                range.getOwnerParagraph().getChildObjects().insert(index,pic);
                range.getOwnerParagraph().getChildObjects().remove(range);
            }
            //替换复选框
            else if(entry.getKey().startsWith("${checkbox_")){
                TextSelection selection = document.findString(entry.getKey(),true,false);
                TextRange textRange = selection.getAsOneRange();
                textRange.getCharacterFormat().setFontName("Wingdings 2");
                //82代表打钩 163代表不打勾
                String value = (boolean)entry.getValue() == true?String.valueOf(((char)82)):String.valueOf(((char)163));
                document.replace(selection.getSelectedText(),value, true, false);
            }
        }

        return document;
    }

    /**
     * 根据模板号获取模板Url
     * @return
     */
    private static String getUrlByTemplateNo(Integer templateNo) {
        String url = null;
        if(templateNo == 1){
            url = "/Users/zhouxuan/Desktop/itext_text/个人税收居民身份声明文件.docx";
        }

        return url;
    }

}
