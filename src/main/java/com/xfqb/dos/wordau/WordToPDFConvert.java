package com.xfqb.dos.wordau;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.fonts.Mapper;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import com.xfqb.dos.wordau.config.FontConfig;

/**
 * This converts Docx file to PDF
 * Author: Naveen - Javadomain.in
 */
public class WordToPDFConvert {
	public static void main(String[] args) {
		
		String inputWordPath = "E:\\文档\\test\\测试数据.docx";  
		String outputPDFPath = "E:\\文档\\test\\我是结果.pdf"; 
		
		
		convertDocxToPDF(inputWordPath, outputPDFPath);
	}
	
	/**
	 * docx文档转换为PDF
	 *
	 * @param pdfPath PDF文档存储路径
	 * @throws Exception 可能为Docx4JException, FileNotFoundException, IOException等
	 */
	public static void convertDocxToPDF(String docxPath, String pdfPath){
	    OutputStream os = null;
	    try {
	        InputStream is = new FileInputStream(new File(docxPath));
	        WordprocessingMLPackage mlPackage = WordprocessingMLPackage.load(is);
	        Mapper fontMapper = FontConfig.getFontMapp();
	        mlPackage.setFontMapper(fontMapper);
	        os = new java.io.FileOutputStream(pdfPath);
	        FOSettings foSettings = Docx4J.createFOSettings();
	        foSettings.setWmlPackage(mlPackage);
	        Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
	    }catch(Exception ex){
	        ex.printStackTrace();
	    }finally {
	        IOUtils.closeQuietly(os);
	    }
	}

}
