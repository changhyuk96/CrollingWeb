package com.my.crolling;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class ListExcelDownload extends AbstractXlsxView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			String today = new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(new Date());
			
			@SuppressWarnings("unchecked")
			List<CityInfo> list = (List<CityInfo>) model.get("list");
			
			Sheet sheet = workbook.createSheet();
			
			sheet.setDefaultRowHeight((short) 500);
			sheet.setDefaultColumnWidth(15);
			
			Row header = sheet.createRow(1);
			header.createCell(1).setCellValue("도시 명");
			header.createCell(2).setCellValue("합계");
			header.createCell(3).setCellValue("국내 발생");
			header.createCell(4).setCellValue("해외 유입");
			header.createCell(5).setCellValue("격리중");
			header.createCell(6).setCellValue("격리해제");
			header.createCell(7).setCellValue("총 확진자");
			header.createCell(8).setCellValue("완치율");
			
			int rowCount = 2;
			for(CityInfo city : list) {
				Row row = sheet.createRow(rowCount++);
				int cellCount = 1;
				row.createCell(cellCount++).setCellValue(city.getCityName());
				row.createCell(cellCount++).setCellValue(city.getTodayTotal());
				row.createCell(cellCount++).setCellValue(city.getDomestic());
				row.createCell(cellCount++).setCellValue(city.getForeign());
				row.createCell(cellCount++).setCellValue(city.getConfirmedPatient());
				row.createCell(cellCount++).setCellValue(city.getRecoveredPatient());
				row.createCell(cellCount++).setCellValue(city.getTotalPatient());
				row.createCell(cellCount++).setCellValue(city.getRecoveredRate());
			}
			try {
				response.setHeader("Content-Disposition", "attachement; filename=\""
			+ java.net.URLEncoder.encode(today+"_코로나.xlsx", "UTF-8") + "\";charset=\"UTF-8\""); }
			catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

	}

}
