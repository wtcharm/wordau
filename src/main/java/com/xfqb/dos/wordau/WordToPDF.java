package com.xfqb.dos.wordau;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.xfqb.dos.wordau.config.FontConfig;

public class WordToPDF {

	/**
	 *  PdfConverter 转PDF
	 * @param sfileName
	 * @param toFileName
	 * @return
	 */
	public static boolean wordToPDF(String sfileName, String toFileName){
		OutputStream out = null;
		try {
			XWPFDocument document=new XWPFDocument(new FileInputStream(new File(sfileName)));
			//
			File outFile = new File(toFileName);
			outFile.getParentFile().mkdirs();
			out = new FileOutputStream(outFile);
			
			
			
			//gb2312
			PdfOptions options= PdfOptions.create().fontEncoding(FontConfig.getFontMapp().toString());
			PdfConverter.getInstance().convert(document,out,options);
		}catch (FileNotFoundException e){
			return false;
		} catch (IOException e) {
			return false;
		} finally {
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String filepath = "E:\\文档\\test\\测试数据.docx";  
		String outpath = "E:\\文档\\test\\我是结果11.pdf";   
		wordToPDF(filepath, outpath);


	}
}
