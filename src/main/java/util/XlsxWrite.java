package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.vo.TreeVO;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
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


	public String chartExcel(List<HashMap<String, String>> List,String filePath ) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(); // sheet 생성
		//head
		sheet.createRow(0);
		sheet.createRow(1);
		sheet.createRow(2);

		CellStyle header = getCellStyle(workbook, "header");

		setMergeValue(sheet ,header, "번호                            ".trim() , 0,0,2,0,6.9);
		setMergeValue(sheet ,header, "호기                            ".trim() , 0,1,2,0,4.3);
		setMergeValue(sheet ,header, "건물명                         ".trim() , 0,2,2,0,6.4);
		setMergeValue(sheet ,header, "관리번호                      ".trim() , 0,3,2,0,18.2);
		setMergeValue(sheet ,header, "기존관통부\r\n번호      ".trim() , 0,4,2,0,9.7);
		setMergeValue(sheet ,header, "관리구역\r\n여부         ".trim() , 0,5,2,0,8.3);
		setMergeValue(sheet ,header, "ELEVATION        ".trim() , 0,6,2,0,9.5);
		setMergeValue(sheet ,header, "방화벽지역\r\n번호       ".trim() , 0,7,2,0,10.8);
		setMergeValue(sheet ,header, "점검방\r\n번호             ".trim() , 0,8,2,0,11);
		setMergeValue(sheet ,header, "이면방\r\n번호             ".trim() , 0,9,2,0,11);
		setMergeValue(sheet ,header, "관통부 형태                    ".trim() , 0,10,2,0,12);
		setMergeValue(sheet ,header, "벽바닥 번호                    ".trim() , 0,11,2,0,12);
		setMergeValue(sheet ,header, "벽  재질                        ".trim() , 0,12,2,0,8.3);
		setMergeValue(sheet ,header, "벽  두께                        ".trim() , 0,13,2,0,8.3);
		setMergeValue(sheet ,header, "정면사진\r\n  번호     ".trim() , 0,14,2,0,12);
		setMergeValue(sheet ,header, "이면사진\r\n  번호     ".trim() , 0,15,2,0,12);
		setMergeValue(sheet ,header, "관통부 참조도면 번호        ".trim() , 0,16,2,0,13.7);
		setMergeValue(sheet ,header, "관통부 위치도면 번호         ".trim() , 0,17,2,0,11);
		setMergeValue(sheet ,header, "관통부 SEAL DETAIL DWG".trim() , 0,18,2,0,8.3);
		setMergeValue(sheet ,header, "관통부\r\nEL.       ".trim() , 0,19,2,0,8.7);
		setMergeValue(sheet ,header, "관통부\r\n직경              ".trim() , 0,20,2,0,12);
		setMergeValue(sheet ,header, "관통부\r\n가로              ".trim() , 0,21,2,0,12);
		setMergeValue(sheet ,header, "관통부\r\n세로              ".trim() , 0,22,2,0,12);
		setMergeValue(sheet ,header, "관통부\r\nTYPE      ".trim() , 0,23,2,0,8.3);
		setMergeValue(sheet ,header, "PROJECTION        ".trim() , 0,24,2,0,11);
		setMergeValue(sheet ,header, "최대자유면적                   ".trim() , 0,25,2,0,8.3);
		setMergeValue(sheet ,header, "최대환영거리                   ".trim() , 0,26,2,0,8.3);
		setMergeValue(sheet ,header, "밀폐재\r\n재질              ".trim() , 0,27,2,0,8.7);
		setMergeValue(sheet ,header, "밀폐재\r\n두께              ".trim() , 0,28,2,0,8.7);
		setMergeValue(sheet ,header, "밀폐재\r\nDETAIL DWG".trim() , 0,29,2,0,17.9);
		setMergeValue(sheet ,header, "SEAL\r\nQUALITY\r\nCLASS".trim() , 0,30,2,0,8.7);
		setMergeValue(sheet ,header, "댐판 재질                        ".trim() , 0,31,2,0,8.7);
		setMergeValue(sheet ,header, "댐판 두께                        ".trim() , 0,32,2,0,8.7);
		setMergeValue(sheet ,header, "시공상태                         ".trim() , 0,33,2,5,0);
		setMergeValue(sheet ,header, "특이사항                         ".trim() , 0,39,2,0,50.9);
		setMergeValue(sheet ,header, "관통재 정보                     ".trim() , 0,40,2,0,53.7);
		setMergeValue(sheet ,header, "관통물질명 (규격X수량)  ".trim() , 0,41,0,8,0);
		setMergeValue(sheet ,header, "배관                               ".trim() , 1,41,1,0,7.5);
		setMergeValue(sheet ,header, "덕트                               ".trim() , 1,42,1,0,7.5);
		setMergeValue(sheet ,header, "계장튜브                          ".trim() , 1,43,1,0,7.5);
		setMergeValue(sheet ,header, "전선관                             ".trim() , 1,44,1,0,7.5);
		setMergeValue(sheet ,header, "케이블                             ".trim() , 1,45,1,0,7.5);
		setMergeValue(sheet ,header, "트레이                             ".trim() , 1,46,1,0,7.5);
		setMergeValue(sheet ,header, "커버트레이                        ".trim() , 1,47,1,0,9.5);
		setMergeValue(sheet ,header, "기타                                ".trim() , 1,48,1,0,7.5);
		setMergeValue(sheet ,header, "CAP미설치 수량                 ".trim() , 1,49,1,0,15);
		setMergeValue(sheet ,header, "이전 설계 정보                   ".trim() , 0,50,0,3,0);
		setMergeValue(sheet ,header, "SAFETY\r\nCATEGORY ".trim() , 1,50,1,0,12.2);
		setMergeValue(sheet ,header, "ANCHOR\r\nTYPE      ".trim() , 1,51,1,0,12.2);
		setMergeValue(sheet ,header, "LATERAL\r\nMOVEMENT ".trim() , 1,52,1,0,12.2);
		setMergeValue(sheet ,header, "LINE\r\nTEMPERATURE ".trim() , 1,53,1,0,12.2);
		setMergeValue(sheet ,header, "성능기준                            ".trim() , 0,54,0,23,0);
		setMergeValue(sheet ,header, "VENTILATION         ".trim() , 1,54,0,4,0);
		setMergeValue(sheet ,header, "FIRE                ".trim() , 1,59,0,4,0);
		setMergeValue(sheet ,header, "RADIATION           ".trim() , 1,64,0,4,0);
		setMergeValue(sheet ,header, "FLOOD               ".trim() , 1,69,0,4,0);
		setMergeValue(sheet ,header, "PRESSURE            ".trim() , 1,74,0,3,0);
		setMergeValue(sheet ,header, "적용                                  ".trim() , 2,54,0,0,8.3);
		setMergeValue(sheet ,header, "허용치                               ".trim() , 2,55,0,0,8.3);
		setMergeValue(sheet ,header, "성능인증번호                       ".trim() , 2,56,0,0,11.5);
		setMergeValue(sheet ,header, "판정                                  ".trim() , 2,57,0,0,8.3);
		setMergeValue(sheet ,header, "사유                                  ".trim() , 2,58,0,0,8.3);
		setMergeValue(sheet ,header, "적용                                  ".trim() , 2,59,0,0,8.3);
		setMergeValue(sheet ,header, "허용치                               ".trim() , 2,60,0,0,8.3);
		setMergeValue(sheet ,header, "성능인증번호                       ".trim() , 2,61,0,0,11.5);
		setMergeValue(sheet ,header, "판정                                  ".trim() , 2,62,0,0,8.3);
		setMergeValue(sheet ,header, "사유                                  ".trim() , 2,63,0,0,8.3);
		setMergeValue(sheet ,header, "적용                                  ".trim() , 2,64,0,0,8.3);
		setMergeValue(sheet ,header, "허용치                               ".trim() , 2,65,0,0,8.3);
		setMergeValue(sheet ,header, "성능인증번호                       ".trim() , 2,66,0,0,11.5);
		setMergeValue(sheet ,header, "판정                                  ".trim() , 2,67,0,0,8.3);
		setMergeValue(sheet ,header, "사유                                  ".trim() , 2,68,0,0,8.3);
		setMergeValue(sheet ,header, "적용                                  ".trim() , 2,69,0,0,8.3);
		setMergeValue(sheet ,header, "허용치                               ".trim() , 2,70,0,0,8.3);
		setMergeValue(sheet ,header, "성능인증번호                       ".trim() , 2,71,0,0,11.5);
		setMergeValue(sheet ,header, "판정                                  ".trim() , 2,72,0,0,8.3);
		setMergeValue(sheet ,header, "사유                                  ".trim() , 2,73,0,0,8.3);
		setMergeValue(sheet ,header, "적용                                  ".trim() , 2,74,0,0,8.3);
		setMergeValue(sheet ,header, "허용치                               ".trim() , 2,75,0,0,8.3);
		setMergeValue(sheet ,header, "성능인증번호                       ".trim() , 2,76,0,0,11.5);
		setMergeValue(sheet ,header, "판정                                  ".trim() , 2,77,0,0,8.3);
		setMergeValue(sheet ,header, "판정사유                             ".trim() , 0,78,2,0,39);
		setMergeValue(sheet ,header, "현장사진\r\n(정면)      ".trim() , 0,79,2,0,8.3);
		setMergeValue(sheet ,header, "현장사진\r\n(이면)      ".trim() , 0,80,2,0,8.3);
		setMergeValue(sheet ,header, "책임자  검토                        ".trim() , 0,81,0,9,0);
		setMergeValue(sheet ,header, "점검자                                ".trim() , 1,81,0,1,0);
		setMergeValue(sheet ,header, "작성자                                ".trim() , 1,83,0,1,0);
		setMergeValue(sheet ,header, "대리인                                ".trim() , 1,85,0,1,0);
		setMergeValue(sheet ,header, "책임기술자                          ".trim() , 1,87,0,1,0);
		setMergeValue(sheet ,header, "담당감독                             ".trim() , 1,89,0,1,0);
		setMergeValue(sheet ,header, "성명                                  ".trim() , 2,81,0,0,8.3);
		setMergeValue(sheet ,header, "일자                                  ".trim() , 2,82,0,0,8.3);
		setMergeValue(sheet ,header, "성명                                  ".trim() , 2,83,0,0,8.3);
		setMergeValue(sheet ,header, "일자                                  ".trim() , 2,84,0,0,8.3);
		setMergeValue(sheet ,header, "성명                                  ".trim() , 2,85,0,0,8.3);
		setMergeValue(sheet ,header, "일자                                  ".trim() , 2,86,0,0,8.3);
		setMergeValue(sheet ,header, "성명                                  ".trim() , 2,87,0,0,8.3);
		setMergeValue(sheet ,header, "일자                                  ".trim() , 2,88,0,0,8.3);
		setMergeValue(sheet ,header, "성명                                  ".trim() , 2,89,0,0,8.3);
		setMergeValue(sheet ,header, "일자                                  ".trim() , 2,90,0,0,8.3);
		setMergeValue(sheet ,header, "확인유무                            ".trim() , 0,91,2,0,8.3);
		setMergeValue(sheet ,header, "회사명                               ".trim() , 0,92,2,0,8.3);
		setMergeValue(sheet ,header, "관리대상                            ".trim() , 0,93,2,0,8.3);
		setMergeValue(sheet ,header, "신규여부                            ".trim() , 0,94,2,0,8.3);
		setMergeValue(sheet ,header, "점검회차                            ".trim() , 0,95,2,0,8.3);
		setMergeValue(sheet ,header, "보수내용                            ".trim() , 0,96,2,0,39.9);
		setMergeValue(sheet ,header, "시공상태                            ".trim() , 0,97,2,0,18.9);
		setMergeValue(sheet ,header, "계산용\r\nELEVATION   ".trim() , 0,98,2,0,8.3);
		setMergeValue(sheet ,header, "계산용 관통부\r\nEL.    ".trim() , 0,99,2,0,8.7);
		setMergeValue(sheet ,header, "계산용 관통부\r\n직경        ".trim() , 0,100,2,0,12);
		setMergeValue(sheet ,header, "계산용 관통부\r\n가로        ".trim() , 0,101,2,0,12);
		setMergeValue(sheet ,header, "계산용 관통부\r\n세로        ".trim() , 0,102,2,0,12);
		setMergeValue(sheet ,header, "체크시트                            ".trim() , 0,103,2,0,27.9);
		setMergeValue(sheet ,header, "위치도                               ".trim() , 0,104,2,0,27.9);
		setMergeValue(sheet ,header, "평면도                               ".trim() , 0,105,2,0,27.9);
		
		for(int i=0 ; i < List.size(); i ++){
			sheet.createRow(i+3);
            String EquipNo = "0";

            if (List.get(i).get("EquipNo").equals("A0101"))
            {
                EquipNo = "5"; //5호기 
            }
            else if (List.get(i).get("EquipNo").equals("A0102"))
            {
                EquipNo = "6"; //5호기 
            }
			
			setValue(sheet ,null,i+3,0,0,List.get(i).get("InspectSeq"));
			setValue(sheet ,null,i+3,1,0,EquipNo);
			setValue(sheet ,null,i+3,2,0,List.get(i).get("LocNo_name"));
			setValue(sheet ,null,i+3,3,0,List.get(i).get("ManagementNo"));
			setValue(sheet ,null,i+3,4,0,List.get(i).get("PenetrationNo"));
			setValue(sheet ,null,i+3,5,0,List.get(i).get("ManagementAreaYN"));
			setValue(sheet ,null,i+3,6,0,List.get(i).get("Elevation"));
			setValue(sheet ,null,i+3,7,0,List.get(i).get("FirePreventionAreaNo"));
			setValue(sheet ,null,i+3,8,0,List.get(i).get("InspectionRoomNo"));
			setValue(sheet ,null,i+3,9,0,List.get(i).get("BackRoomNo"));
			setValue(sheet ,null,i+3,10,0,List.get(i).get("PenetrationForm_name"));
			setValue(sheet ,null,i+3,11,0,List.get(i).get("Wall_FloorNo"));
//			setValue(sheet ,null,i+3,12,0,List.get(i).get("FirewallYN_name"));
			setValue(sheet ,null,i+3,12,0,List.get(i).get("WallMeterial_name"));
			setValue(sheet ,null,i+3,13,0,List.get(i).get("WallThickness"));
			setValue(sheet ,null,i+3,14,0,List.get(i).get("FrontPicNo"));
			setValue(sheet ,null,i+3,15,0,List.get(i).get("BackPicNo"));
			setValue(sheet ,null,i+3,16,0,List.get(i).get("ReferenceFloorPlanNo"));
			setValue(sheet ,null,i+3,17,0,List.get(i).get("LocationFloorPlanNo"));
			setValue(sheet ,null,i+3,18,0,List.get(i).get("SealDetailDWG"));
			setValue(sheet ,null,i+3,19,0,List.get(i).get("EL"));
			setValue(sheet ,null,i+3,20,0,List.get(i).get("Diameter"));
			setValue(sheet ,null,i+3,21,0,List.get(i).get("Height"));
			setValue(sheet ,null,i+3,22,0,List.get(i).get("Length"));
			
            if (List.get(i).get("PenetrationType").split("|").length >= 2)
            {
            	setValue(sheet ,null,i+3,23,0,List.get(i).get("PenetrationType").split("|")[0]);
            	setValue(sheet ,null,i+3,24,0,List.get(i).get("PenetrationType").split("|")[1]);
            }
            else
            {
            	setValue(sheet ,null,i+3,23,0,List.get(i).get("PenetrationType"));
            	setValue(sheet ,null,i+3,24,0,"");
            }
        	setValue(sheet ,null,i+3,25,0,List.get(i).get("MaximumFreeArea"));
        	setValue(sheet ,null,i+3,26,0,List.get(i).get("MaximumFreeDistance"));
        	setValue(sheet ,null,i+3,27,0,List.get(i).get("SealMeterial_name"));
        	setValue(sheet ,null,i+3,28,0,List.get(i).get("SealThickness"));
        	setValue(sheet ,null,i+3,29,0,List.get(i).get("SealSealDetailDWG"));
        	setValue(sheet ,null,i+3,30,0,List.get(i).get("SealQualityClass"));
        	setValue(sheet ,null,i+3,31,0,List.get(i).get("PressingBoardMeterial"));
        	setValue(sheet ,null,i+3,32,0,List.get(i).get("PressingBoardThickness"));
        	String ConstructionState_name = List.get(i).get("ConstructionState_name");
        	

            if (ConstructionState_name.contains("양호"))
            {
            	setValue(sheet ,null,i+3,33,0,"■ 양호");
            }
            else
            {
            	setValue(sheet ,null,i+3,33,0,"□ 양호");
            }


            if (ConstructionState_name.contains("미시공"))
            {
            	setValue(sheet ,null,i+3,34,0,"■ 미시공");
            }
            else
            {
            	setValue(sheet ,null,i+3,34,0,"□ 미시공");
            }

            if (ConstructionState_name.contains("파손"))
            {
            	setValue(sheet ,null,i+3,35,0,"■ 파손");
            }
            else
            {
            	setValue(sheet ,null,i+3,35,0,"□ 파손");
            }

            if (ConstructionState_name.contains("댐재미제거"))
            {
            	setValue(sheet ,null,i+3,36,0,"■ 댐재미제거");
            }
            else
            {
            	setValue(sheet ,null,i+3,36,0,"□ 댐재미제거");
            }

            if (ConstructionState_name.contains("전선관내미시공"))
            {
            	setValue(sheet ,null,i+3,37,0,"■ 전선관내미시공");
            }
            else
            {
            	setValue(sheet ,null,i+3,37,0,"□ 전선관내미시공");
            }

            if (ConstructionState_name.contains("CAP 미설치"))
            {
            	setValue(sheet ,null,i+3,38,0,"■ CAP 미설치");
            }
            else
            {
            	setValue(sheet ,null,i+3,38,0,"□ CAP 미설치");
            }

            setValue(sheet ,null,i+3,39,0,List.get(i).get("SpecialNote"));

            String SealantConditionState = "";
            if (!List.get(i).get("Pipe").equals(""))
            {
                SealantConditionState += " ■ 배관";
            }
            else
            {
                SealantConditionState += " □ 배관";
            }


            if (!List.get(i).get("Duct").equals(""))
            {
                SealantConditionState += " ■ 덕트";
            }
            else
            {
                SealantConditionState += " □ 덕트";
            }


            if (!List.get(i).get("SectionTube").equals(""))
            {
                SealantConditionState += " ■ 계장";
            }
            else
            {
                SealantConditionState += " □ 계장";
            }


            if (!List.get(i).get("Conduit").equals(""))
            {
                SealantConditionState += " ■ 전선관";
            }
            else
            {
                SealantConditionState += " □ 전선관";
            }


            if (!List.get(i).get("Cable").equals(""))
            {
                SealantConditionState += " ■ 케이블";
            }
            else
            {
                SealantConditionState += " □ 케이블";
            }


            if (!List.get(i).get("Tray").equals("") || !List.get(i).get("CoverTray").equals("") )
            {
                SealantConditionState += " ■ 트레이";
            }
            else
            {
                SealantConditionState += " □ 트레이";
            }


            if (!List.get(i).get("Etc").equals(""))
            {
                SealantConditionState += " ■ 기타";
            }
            else
            {
                SealantConditionState += " □ 기타";
            }

            setValue(sheet ,null,i+3,40,0,SealantConditionState);
            setValue(sheet ,null,i+3,41,0,List.get(i).get("Pipe"));
            setValue(sheet ,null,i+3,42,0,List.get(i).get("Duct"));
            setValue(sheet ,null,i+3,43,0,List.get(i).get("SectionTube"));
            setValue(sheet ,null,i+3,44,0,List.get(i).get("Conduit"));
            setValue(sheet ,null,i+3,45,0,List.get(i).get("Cable"));
            setValue(sheet ,null,i+3,46,0,List.get(i).get("Tray"));
            setValue(sheet ,null,i+3,47,0,List.get(i).get("CoverTray"));
            setValue(sheet ,null,i+3,48,0,List.get(i).get("Etc"));
            setValue(sheet ,null,i+3,49,0,List.get(i).get("CAP_Not_Num"));
            setValue(sheet ,null,i+3,50,0,List.get(i).get("SAFETY_CATEGORY"));
            setValue(sheet ,null,i+3,51,0,List.get(i).get("ANCHORTYPE"));
            setValue(sheet ,null,i+3,52,0,List.get(i).get("LATERALMOVEMENT"));
            setValue(sheet ,null,i+3,53,0,List.get(i).get("LINETEMPERATURE"));
            setValue(sheet ,null,i+3,54,0,List.get(i).get("VENTILATION_VALUE"));
            setValue(sheet ,null,i+3,55,0,List.get(i).get("VENTILATION_VALUE_RANGE"));
            setValue(sheet ,null,i+3,56,0,List.get(i).get("VENTILATION_VAL_NO"));
            setValue(sheet ,null,i+3,57,0,List.get(i).get("VENTILATION_JUDGMENT"));
            setValue(sheet ,null,i+3,58,0,List.get(i).get("VENTILATION_REASON"));
            setValue(sheet ,null,i+3,59,0,List.get(i).get("FIRE_VALUE"));
            setValue(sheet ,null,i+3,60,0,List.get(i).get("FIRE_VALUE_RANGE"));
            setValue(sheet ,null,i+3,61,0,List.get(i).get("FIRE_VAL_NO"));
            setValue(sheet ,null,i+3,62,0,List.get(i).get("FIRE_JUDGMENT"));
            setValue(sheet ,null,i+3,63,0,List.get(i).get("FIRE_REASON"));
            setValue(sheet ,null,i+3,64,0,List.get(i).get("RADIATION_VALUE"));
            setValue(sheet ,null,i+3,65,0,List.get(i).get("RADIATION_VALUE_RANGE"));
            setValue(sheet ,null,i+3,66,0,List.get(i).get("RADIATION_VAL_NO"));
            setValue(sheet ,null,i+3,67,0,List.get(i).get("RADIATION_JUDGMENT"));
            setValue(sheet ,null,i+3,68,0,List.get(i).get("RADIATION_REASON"));
            setValue(sheet ,null,i+3,69,0,List.get(i).get("FLOOD_VALUE"));
            setValue(sheet ,null,i+3,70,0,List.get(i).get("FLOOD_VALUE_RANGE"));
            setValue(sheet ,null,i+3,71,0,List.get(i).get("FLOOD_VAL_NO"));
            setValue(sheet ,null,i+3,72,0,List.get(i).get("FLOOD_JUDGMENT"));
            setValue(sheet ,null,i+3,73,0,List.get(i).get("FLOOD_REASON"));
            setValue(sheet ,null,i+3,74,0,List.get(i).get("PRESSURE_VALUE"));
            setValue(sheet ,null,i+3,75,0,List.get(i).get("PRESSURE_VALUE_RANGE"));
            setValue(sheet ,null,i+3,76,0,List.get(i).get("PRESSURE_VAL_NO"));
            setValue(sheet ,null,i+3,77,0,List.get(i).get("PRESSURE_JUDGMENT"));
            setValue(sheet ,null,i+3,78,0,List.get(i).get("PRESSURE_REASON"));
            setValue(sheet ,null,i+3,81,0,List.get(i).get("Reviewer"));
            setValue(sheet ,null,i+3,82,0,List.get(i).get("Reviewer_date"));
            setValue(sheet ,null,i+3,83,0,List.get(i).get("Register"));
            setValue(sheet ,null,i+3,84,0,List.get(i).get("Register_date"));
            setValue(sheet ,null,i+3,85,0,List.get(i).get("Supporter"));
            setValue(sheet ,null,i+3,86,0,List.get(i).get("Supporter_date"));
            setValue(sheet ,null,i+3,87,0,List.get(i).get("Technicker"));
            setValue(sheet ,null,i+3,88,0,List.get(i).get("Technicker_date"));
            setValue(sheet ,null,i+3,89,0,List.get(i).get("Checker"));
            setValue(sheet ,null,i+3,90,0,List.get(i).get("Checker_date"));
            setValue(sheet ,null,i+3,91,0,List.get(i).get("CertificationYN"));
            setValue(sheet ,null,i+3,92,0,List.get(i).get("Com_name"));
            setValue(sheet ,null,i+3,93,0,List.get(i).get("ManagementObjYN"));
            setValue(sheet ,null,i+3,94,0,List.get(i).get("NewYN"));
            setValue(sheet ,null,i+3,95,0,List.get(i).get("Wall_Fire_time"));
            setValue(sheet ,null,i+3,96,0,List.get(i).get("ImproveNote"));
            setValue(sheet ,null,i+3,103,0,List.get(i).get("FileLocation_1"));
            setValue(sheet ,null,i+3,104,0,List.get(i).get("FileLocation_2"));
            setValue(sheet ,null,i+3,105,0,List.get(i).get("FileLocation_3"));
//            worksheet.Cells[row_ + i, 104] = outputData[i]["FileLocation_1"];
//            worksheet.Cells[row_ + i, 105] = outputData[i]["FileLocation_2"];
//            worksheet.Cells[row_ + i, 106] = outputData[i]["FileLocation_3"];
//
//            writeIndex++;
		}
		
		
		String fileName = "excel_" + System.currentTimeMillis()+".xlsx";

		FileOutputStream outFile = new FileOutputStream(filePath + fileName);
		workbook.write(outFile);
		outFile.close();
		workbook.close();

		return fileName;
	}
	private void setValue(XSSFSheet sheet,CellStyle cellStyle,int rowNum ,int colNum ,int colWidth,String value){
		sheet.getRow(rowNum).createCell(colNum).setCellValue(value);
		if(cellStyle!=null)
			sheet.getRow(rowNum).getCell(colNum).setCellStyle(cellStyle);
		if(colWidth > 0)
			sheet.setColumnWidth(colNum, colWidth*280);
	}

	private void setMergeValue(XSSFSheet sheet,CellStyle cellStyle,String value, int rowNum ,int colNum ,int rowMerge, int colMerge , double colWidth){
		sheet.getRow(rowNum).createCell(colNum).setCellValue(value);

		if(cellStyle!=null){
			sheet.getRow(rowNum).getCell(colNum).setCellStyle(cellStyle);
			for(int i = 0 ; i <= rowMerge ; i ++){
				for(int j = 0 ; j <= colMerge ; j ++){
					try{
						sheet.getRow(rowNum+i).getCell(colNum+j).setCellStyle(cellStyle);
					}catch(Exception e){
						sheet.getRow(rowNum+i).createCell(colNum+j).setCellStyle(cellStyle);
					}
				}
			}
		}
		sheet.addMergedRegion(new CellRangeAddress(rowNum, rowNum+rowMerge, colNum, colNum + colMerge));
		if(colMerge >= 0  &&  colWidth > 0)
			sheet.setColumnWidth(colNum, (int)(colWidth*275));
	}
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
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			style.setFillForegroundColor(IndexedColors.WHITE.index);
			style.setWrapText(true);
		} else if( str.equals("subHeader")){
			byte[] rgb = new byte[3];
			rgb[0] = (byte) 242;
			rgb[1] = (byte) 242;
			rgb[2] = (byte) 242;
			XSSFColor mycolor = new XSSFColor(rgb);
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			style.setFillForegroundColor(mycolor);
		} else if (str.equals("oddCell")) {
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		} else if (str.equals("evenCell")) {
			byte[] rgb = new byte[3];
			rgb[0] = (byte) 246;
			rgb[1] = (byte) 247;
			rgb[2] = (byte) 251;
			XSSFColor mycolor = new XSSFColor(rgb);
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			style.setFillForegroundColor(mycolor);
		}
		return style;
	}
}