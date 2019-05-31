package com.xfqb.dos.wordau.util;

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

public class WordPdfUtil {

	/**
	 * 将word转化为PDf
	 * @param inputWordPath 要转换的文档路径
	 * @param outputPDFPath 转化之后的文档路径
	 * @auth tao wang
	 * @date 2018年11月23日
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
