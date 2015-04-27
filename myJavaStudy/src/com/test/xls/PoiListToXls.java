package com.test.xls;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class PoiListToXls {

	public static void main(String[] args) {
			List workbookList=createlist();
			//System.out.println(workbookList);
			try {
				writeToPoiXls(workbookList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static List createlist(){
		List biaotou=new ArrayList();		
		List resultList=new ArrayList();
		biaotou.add("name");
		biaotou.add("id");
		resultList.add(biaotou);
		List neirong=new ArrayList();
		neirong.add("A");
		neirong.add("AA");
		resultList.add(neirong);
		neirong=new ArrayList();//��ʼ��һ�£�����֮ǰ��ֵ�Ͳ������
		neirong.add("b");
		neirong.add("bb");
		resultList.add(neirong);
		neirong=new ArrayList();
		neirong.add("C");
		neirong.add("CC");
		resultList.add(neirong);	
		System.out.print(resultList);
		return resultList;
	}
	public static void writeToPoiXls(List resultList )throws Exception{
		//����һ��EXCEL
		Workbook wb = new HSSFWorkbook();
		//����һ��SHEET
		Sheet sheet1 = wb.createSheet("����1");
		for (int i = 0; i < resultList.size(); i++) {
			//����һ��
		    Row row = sheet1.createRow(i);
		    List rowList=(List)resultList.get(i);
		    for (int j = 0; j < rowList.size(); j++) {
		    	//��i�У�������j��
		    	Cell cell = row.createCell(j);
		    	String cellList=(String)rowList.get(j);
		    	// ������õĵ�Ԫ����ӵ���������   
				cell.setCellValue(cellList );
			}
		}
		FileOutputStream fileOut = new FileOutputStream("d:\\testa.xls");
	    wb.write(fileOut);
	    fileOut.close();
	}
}
