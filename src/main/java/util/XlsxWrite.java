package util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.vo.TreeVO;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
   Allowable column range for EXCEL2007 is (0..16383)
   row number (1048576) outside allowable range (0..1048575)
   cell style limit :: 64000
 */
public class XlsxWrite {

	public String rt_create_chartExcel(ArrayList<ArrayList<String>> mids, ArrayList<List<TreeVO>> treeGridListAll, ArrayList<ArrayList<HashMap<String, Object>>> list, String filePath, int screenNum) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();
		for(int i=0;i<screenNum;i++){
			int rowIdx = 0;
			int colIdx = 4;

			XSSFSheet sheet = workbook.createSheet("실시간 " + (i+1)); // sheet 생성

			sheet.setColumnWidth(0, 15 * 256);
			sheet.setColumnWidth(1, 15 * 256);
			sheet.setColumnWidth(2, 30 * 256);
			sheet.setColumnWidth(3, 15 * 256);

			XSSFRow row = sheet.createRow(rowIdx++);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue("장치명");
			cell = row.createCell(4);
			cell.setCellValue("내용");

			HashMap<String, Integer> rowNums = new HashMap<String, Integer>();
			for (TreeVO vo : treeGridListAll.get(i)) {
				row = sheet.createRow(rowIdx++);
				cell = row.createCell(Integer.parseInt(vo.getLevel().trim()));
				cell.setCellValue(vo.getName());
				if (vo.getIsleaf().trim().equals("true")) {
					String mid = vo.getMid();
					for (int j = 0; j < mids.get(i).size(); j++) {
						if (mid.equals(mids.get(i).get(j))) { rowNums.put("value" + (j + 1), rowIdx - 1); break; }
					}
				}
			}

			row = sheet.createRow(rowIdx);
			cell = row.createCell(3);
			cell.setCellValue("시간");

			for (HashMap<String, Object> map : list.get(i)) {
				for (int j = 0; j < rowNums.size(); j++) {
					String target = "value" + (j + 1);
					row = sheet.getRow(rowNums.get(target));
					cell = row.createCell(colIdx);
					String val = String.valueOf(map.get(target));
					if (val == "null") cell.setCellValue("");
					else cell.setCellValue(Double.parseDouble(val));
				}
				row = sheet.getRow(rowIdx);
				cell = row.createCell(colIdx);
				cell.setCellValue((String) map.get("arg"));
				colIdx++;
			}

			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3)); //rowStart, rowLast, colStart, colLast
			if((colIdx -1) >= 4){
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, colIdx -1)); //rowStart, rowLast, colStart, colLast
			}
			else{
				sheet.getRow(0).getCell(4).setCellValue("");
			}

			// CellStyle
			CellStyle header = getCellStyle(workbook, "header");
			CellStyle evenCell = getCellStyle(workbook, "evenCell");
			CellStyle oddCell = getCellStyle(workbook, "oddCell");

			for (int j = 0; j < colIdx; j++) {
				try { sheet.getRow(0).getCell(j).setCellStyle(header); }
				catch (Exception ex) { sheet.getRow(0).createCell(j).setCellStyle(header); }
				if (j >= 4) sheet.setColumnWidth(j, 22 * 256); 
			}

			for (int j = 0; j < colIdx; j++) {
				for (int k = 1; k < rowIdx + 1; k++) {

					if (k % 2 == 0) {
						try { sheet.getRow(k).getCell(j).setCellStyle(evenCell); }
						catch (Exception ex) { sheet.getRow(k).createCell(j).setCellStyle(evenCell); }
					} else {
						try { sheet.getRow(k).getCell(j).setCellStyle(oddCell); }
						catch (Exception ex) { sheet.getRow(k).createCell(j).setCellStyle(oddCell); }
					}
				}
			}

			sheet.getRow(rowIdx).getCell(3).setCellStyle(header);
		}

		File dir = new File(filePath);
		if (!dir.exists()) dir.mkdirs();
		String fileName = "record_" + System.currentTimeMillis()+".xlsx";

		FileOutputStream outFile = new FileOutputStream(filePath + fileName);
		workbook.write(outFile);
		outFile.close();
		workbook.close();

		return fileName;
	}

	public String rc_create_chartExcel(ArrayList<ArrayList<String>> mids, ArrayList<List<TreeVO>> treeGridListAll, ArrayList<ArrayList<HashMap<String, Object>>> list, String filePath) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();
		for(int i=0;i<mids.size();i++){
			int rowIdx = 0;
			int colIdx = 4;

			XSSFSheet sheet = workbook.createSheet("이력조회 " + (i+1)); // sheet 생성

			sheet.setColumnWidth(0, 15 * 256);
			sheet.setColumnWidth(1, 15 * 256);
			sheet.setColumnWidth(2, 30 * 256);
			sheet.setColumnWidth(3, 15 * 256);

			XSSFRow row = sheet.createRow(rowIdx++);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue("장치명");
			cell = row.createCell(4);
			cell.setCellValue("내용");

			HashMap<String, Integer> rowNums = new HashMap<String, Integer>();
			for (TreeVO vo : treeGridListAll.get(i)) {
				row = sheet.createRow(rowIdx++);
				cell = row.createCell(Integer.parseInt(vo.getLevel().trim()));
				cell.setCellValue(vo.getName());
				if (vo.getIsleaf().trim().equals("true")) {
					String mid = vo.getMid();
					for (int j = 0; j < mids.get(i).size(); j++) {
						if (mid.equals(mids.get(i).get(j))) { rowNums.put("value" + (j + 1), rowIdx - 1); break; }
					}
				}
			}

			row = sheet.createRow(rowIdx);
			cell = row.createCell(3);
			cell.setCellValue("시간");

			for (HashMap<String, Object> map : list.get(i)) {
				for (int j = 0; j < rowNums.size(); j++) {
					String target = "value" + (j + 1);
					row = sheet.getRow(rowNums.get(target));
					cell = row.createCell(colIdx);
					String val = String.valueOf(map.get(target));
					if (val == "null") cell.setCellValue("");
					else cell.setCellValue(Double.parseDouble(val));
				}
				row = sheet.getRow(rowIdx);
				cell = row.createCell(colIdx);
				cell.setCellValue((String) map.get("arg"));
				colIdx++;
			}

			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3)); //rowStart, rowLast, colStart, colLast
			if((colIdx -1) >= 4){
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, colIdx -1)); //rowStart, rowLast, colStart, colLast
			}
			else{
				sheet.getRow(0).getCell(4).setCellValue("");
			}

			// CellStyle
			CellStyle header = getCellStyle(workbook, "header");
			CellStyle evenCell = getCellStyle(workbook, "evenCell");
			CellStyle oddCell = getCellStyle(workbook, "oddCell");

			for (int j = 0; j < colIdx; j++) {
				try { sheet.getRow(0).getCell(j).setCellStyle(header); }
				catch (Exception ex) { sheet.getRow(0).createCell(j).setCellStyle(header); }
				if (j >= 4) sheet.setColumnWidth(j, 22 * 256); 
			}

			for (int j = 0; j < colIdx; j++) {
				for (int k = 1; k < rowIdx + 1; k++) {

					if (k % 2 == 0) {
						try { sheet.getRow(k).getCell(j).setCellStyle(evenCell); }
						catch (Exception ex) { sheet.getRow(k).createCell(j).setCellStyle(evenCell); }
					} else {
						try { sheet.getRow(k).getCell(j).setCellStyle(oddCell); }
						catch (Exception ex) { sheet.getRow(k).createCell(j).setCellStyle(oddCell); }
					}
				}
			}

			sheet.getRow(rowIdx).getCell(3).setCellStyle(header);
		}

		File dir = new File(filePath);
		if (!dir.exists()) dir.mkdirs();
		String fileName = "record_" + System.currentTimeMillis()+".xlsx";

		FileOutputStream outFile = new FileOutputStream(filePath + fileName);
		workbook.write(outFile);
		outFile.close();
		workbook.close();

		return fileName;
	}


	@SuppressWarnings("unchecked")
	public String rc_create_gridExcel(String[] mids, List<TreeVO> treeGridList, List<HashMap<String, Object>> list, String filePath) throws Exception {
		int rowIdx = 4;
		int colIdx = 0;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("이력조회"); // sheet 생성

		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("시간");

		cell = row.createCell(1);
		cell.setCellValue("장치명");


		// tree 세로구조로 집어넣는 header 부분
		int rowCount = 0;
		ArrayList<Integer> parentIdList = new ArrayList<Integer>();
		ArrayList<String> valueList = new ArrayList<String>();
		valueList.add("arg");
		for(int i=3;i>=0;i--){
			row = sheet.createRow(rowIdx--);
			if(i==3){
				for (TreeVO vo : treeGridList) {
					if(Integer.parseInt(vo.getLevel().trim())==3){
						cell = row.createCell(++colIdx);
						cell.setCellValue(vo.getName());
						parentIdList.add(vo.getParentid());

						String mid = vo.getMid();
						for (int j = 0; j < mids.length; j++) {
							if (mid.equals(mids[j])) { valueList.add("value" + (j + 1)); break; }
						}
					}
				}
				rowCount = parentIdList.size();
			}
			else{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp = (ArrayList<Integer>) parentIdList.clone();
				parentIdList.clear();
				for(int j=0;j<temp.size();j++){
					for (TreeVO vo : treeGridList) {
						if(vo.getId()==temp.get(j)){
							cell = row.createCell(++colIdx);
							cell.setCellValue(vo.getName());
							parentIdList.add(vo.getParentid());
						}
					}
				}
			}
			colIdx = 0;
		}

		// header에 관해 parent체크 및 병합 부분
		sheet.addMergedRegion(new CellRangeAddress(0, 4, 0, 0)); //rowStart, rowLast, colStart, colLast
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, rowCount)); //rowStart, rowLast, colStart, colLast
		for(int i=1;i<4;i++){
			int endMergeIndex = 0;
			int duplicateCount = 0;
			row = sheet.getRow(i);
			for(int j=1;j<=rowCount;j++){
				if(j>endMergeIndex){
					for(int k=j+1;k<=rowCount;k++){
						if(row.getCell(j).getStringCellValue().equals(row.getCell(k).getStringCellValue())){
							endMergeIndex=k;
							duplicateCount++;
						}
						else break;
					}
					sheet.addMergedRegion(new CellRangeAddress(i, i, j, j+duplicateCount)); //rowStart, rowLast, colStart, colLast
					duplicateCount=0;
				}
			}
		}

		// list 데이터 입력부분
		rowIdx = 5;
		for(int i=0;i<list.size();i++){
			if((rowIdx+1)*(rowCount+1)>1500000) break;

			row = sheet.createRow(rowIdx++);
			for(int j=0;j<=rowCount;j++){
				cell = row.createCell(colIdx++);
				if(list.get(i).get(valueList.get(j)) != null) cell.setCellValue(list.get(i).get(valueList.get(j)).toString());
				else cell.setCellValue("");
			}
			colIdx=0;
		}

		// cell 스타일 
		for(int i=0;i<=rowCount;i++){
			sheet.setColumnWidth(i, 22 * 256);
		}

		CellStyle header = getCellStyle(workbook, "header");
		CellStyle subHeader = getCellStyle(workbook, "subHeader");
		CellStyle evenCell = getCellStyle(workbook, "evenCell");
		CellStyle oddCell = getCellStyle(workbook, "oddCell");

		sheet.getRow(0).getCell(0).setCellStyle(header);
		sheet.getRow(0).getCell(1).setCellStyle(header);

		for (int i=1;i<=4;i++) {
			for(int j=1;j<=rowCount;j++)
				try { sheet.getRow(i).getCell(j).setCellStyle(subHeader); }
			catch (Exception ex) { sheet.getRow(i).getCell(j).setCellStyle(subHeader); }
		}

		for (int i=5;i<rowIdx;i++) {
			for (int j=0;j<=rowCount;j++) {
				if (i%2 == 0) {
					try { sheet.getRow(i).getCell(j).setCellStyle(evenCell); }
					catch (Exception ex) { sheet.getRow(i).createCell(j).setCellStyle(evenCell); }
				} else {
					try { sheet.getRow(i).getCell(j).setCellStyle(oddCell); }
					catch (Exception ex) { sheet.getRow(i).createCell(j).setCellStyle(oddCell); }
				}
			}
		}

		File dir = new File(filePath);
		if (!dir.exists()) dir.mkdirs();
		String fileName = "record_" + System.currentTimeMillis()+".xlsx";

		FileOutputStream outFile = new FileOutputStream(filePath + fileName);
		workbook.write(outFile);
		outFile.close();
		workbook.close();

		return fileName;
	}

	public String lv_create_excel(List<HashMap<String, Object>> list, String filePath) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("로그뷰어"); // sheet 생성

		sheet.setColumnWidth(0, 22 * 256);
		sheet.setColumnWidth(1, 15 * 256);
		sheet.setColumnWidth(2, 15 * 256);
		sheet.setColumnWidth(3, 15 * 256);
		sheet.setColumnWidth(4, 32 * 256);
		sheet.setColumnWidth(5, 13 * 256);
		sheet.setColumnWidth(6, 13 * 256);
		sheet.setColumnWidth(7, 13 * 256);
		sheet.setColumnWidth(8, 15 * 256);

		XSSFRow row = sheet.createRow(0);

		XSSFCell cell = row.createCell(0);
		cell.setCellValue("시간"); cell.setCellStyle(getCellStyle(workbook, "header"));
		cell = row.createCell(1);
		cell.setCellValue("생산부서"); cell.setCellStyle(getCellStyle(workbook, "header"));
		cell = row.createCell(2);
		cell.setCellValue("설비그룹"); cell.setCellStyle(getCellStyle(workbook, "header"));
		cell = row.createCell(3);
		cell.setCellValue("파라미터"); cell.setCellStyle(getCellStyle(workbook, "header"));
		cell = row.createCell(4);
		cell.setCellValue("장비명"); cell.setCellStyle(getCellStyle(workbook, "header"));
		cell = row.createCell(5);
		cell.setCellValue("상한제한"); cell.setCellStyle(getCellStyle(workbook, "header"));
		cell = row.createCell(6);
		cell.setCellValue("하한제한"); cell.setCellStyle(getCellStyle(workbook, "header"));
		cell = row.createCell(7);
		cell.setCellValue("값"); cell.setCellStyle(getCellStyle(workbook, "header"));
		cell = row.createCell(8);
		cell.setCellValue("내용"); cell.setCellStyle(getCellStyle(workbook, "header"));

		for (int i = 0; i < list.size(); i++) {

			HashMap<String, Object> map = list.get(i);
			XSSFCellStyle cs;

			if ((i + 1) % 2 == 0) cs = getCellStyle(workbook, "evenCell");
			else cs = getCellStyle(workbook, "oddCell");

			row = sheet.createRow(i + 1);
			XSSFCell cells = row.createCell(0);
			cells.setCellValue((String) map.get("dbtime")); cells.setCellStyle(cs);
			cells = row.createCell(1);
			cells.setCellValue((String) map.get("deptname")); cells.setCellStyle(cs);
			cells = row.createCell(2);
			cells.setCellValue((String) map.get("eqgname")); cells.setCellStyle(cs);
			cells = row.createCell(3);
			cells.setCellValue((String) map.get("sensor")); cells.setCellStyle(cs);
			cells = row.createCell(4);
			cells.setCellValue((String) map.get("eqname")); cells.setCellStyle(cs);
			cells = row.createCell(5);
			cells.setCellValue(Double.parseDouble(String.valueOf(map.get("upperlimit")))); cells.setCellStyle(cs);
			cells = row.createCell(6);
			cells.setCellValue(Double.parseDouble(String.valueOf(map.get("lowerlimit")))); cells.setCellStyle(cs);
			cells = row.createCell(7);
			cells.setCellValue(Double.parseDouble(String.valueOf(map.get("value")))); cells.setCellStyle(cs);
			cells = row.createCell(8);
			cells.setCellValue((String) map.get("log")); cells.setCellStyle(cs);
		}

		File dir = new File(filePath);
		if (!dir.exists()) dir.mkdirs();
		String fileName = "log_" + System.currentTimeMillis()+".xlsx";

		FileOutputStream outFile = new FileOutputStream(filePath + fileName);
		workbook.write(outFile);
		outFile.close();
		workbook.close();

		return fileName;
	}

	private XSSFCellStyle getCellStyle(XSSFWorkbook workbook, String str) {
		XSSFCellStyle style = workbook.createCellStyle();

		if (str.equals("header")) {
			style.setAlignment(CellStyle.ALIGN_CENTER);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		} else if( str.equals("subHeader")){
			byte[] rgb = new byte[3];
			rgb[0] = (byte) 242;
			rgb[1] = (byte) 242;
			rgb[2] = (byte) 242;
			XSSFColor mycolor = new XSSFColor(rgb);
			style.setAlignment(CellStyle.ALIGN_CENTER);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setFillForegroundColor(mycolor);
		} else if (str.equals("oddCell")) {
			style.setAlignment(CellStyle.ALIGN_CENTER);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderRight(CellStyle.BORDER_THIN);
		} else if (str.equals("evenCell")) {
			byte[] rgb = new byte[3];
			rgb[0] = (byte) 246;
			rgb[1] = (byte) 247;
			rgb[2] = (byte) 251;
			XSSFColor mycolor = new XSSFColor(rgb);
			style.setAlignment(CellStyle.ALIGN_CENTER);
			style.setBorderTop(CellStyle.BORDER_THIN);
			style.setBorderBottom(CellStyle.BORDER_THIN);
			style.setBorderLeft(CellStyle.BORDER_THIN);
			style.setBorderRight(CellStyle.BORDER_THIN);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setFillForegroundColor(mycolor);
		}
		return style;
	}
}