package com.xfqb.dos.wordau.config;

import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFonts;

/**
 * 进行word 字符集处理
 * @ClassName: FontConfig 
 * @date 2018年11月23日
 * @author tang wang
 */
public class FontConfig {
	public static Mapper getFontMapp() {

		Mapper fontMapper = new IdentityPlusMapper();
		//中文字体转换
		fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));  
		fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
		fontMapper.put("宋体",PhysicalFonts.get("SimSun"));
		fontMapper.put("微软雅黑",PhysicalFonts.get("Microsoft Yahei"));
		fontMapper.put("黑体",PhysicalFonts.get("SimHei"));
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
		return fontMapper;
	}
}
