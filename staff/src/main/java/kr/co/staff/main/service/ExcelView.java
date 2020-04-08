package kr.co.staff.main.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kr.co.staff.repository.vo.Staff;

public class ExcelView extends AbstractExcelView {
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		

			List<Staff> excelList =(List<Staff>) model.get("excelList");
			Sheet sheet = workbook.createSheet("sheet");
			Row row = null;
			int rowCount = 0;
			int cellCount = 0;
			System.out.println("엑셀뷰"+ excelList);
			row = sheet.createRow(rowCount++);
			row.createCell(cellCount++).setCellValue("직원번호");
			row.createCell(cellCount++).setCellValue("성명");
			row.createCell(cellCount++).setCellValue("직급");
			row.createCell(cellCount++).setCellValue("이메일주소");
			row.createCell(cellCount++).setCellValue("전화번호");
			
			for(Staff staff : excelList) {
				row = sheet.createRow(rowCount++);
				cellCount = 0;
				row.createCell(cellCount++).setCellValue(staff.getStaffNo());
				row.createCell(cellCount++).setCellValue(staff.getStaffName());
				row.createCell(cellCount++).setCellValue(staff.getStaffRank());
				row.createCell(cellCount++).setCellValue(staff.getStaffEmail());
				row.createCell(cellCount++).setCellValue(staff.getStaffPh());
			}
			
		
		
	}
	

	@Override
	protected Workbook createWorkbook() {
		// TODO Auto-generated method stub
		return new XSSFWorkbook();
	}

}
