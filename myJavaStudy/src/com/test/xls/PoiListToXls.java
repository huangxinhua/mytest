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
		neirong=new ArrayList();//初始化一下，这样之前的值就不会加入
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
		//创建一个EXCEL
		Workbook wb = new HSSFWorkbook();
		//创建一个SHEET
		Sheet sheet1 = wb.createSheet("报表1");
		for (int i = 0; i < resultList.size(); i++) {
			//创建一行
		    Row row = sheet1.createRow(i);
		    List rowList=(List)resultList.get(i);
		    for (int j = 0; j < rowList.size(); j++) {
		    	//第i行，创建第j列
		    	Cell cell = row.createCell(j);
		    	String cellList=(String)rowList.get(j);
		    	// 将定义好的单元格添加到工作表中   
				cell.setCellValue(cellList );
			}
		}
		FileOutputStream fileOut = new FileOutputStream("d:\\testa.xls");
	    wb.write(fileOut);
	    fileOut.close();
	}
}
