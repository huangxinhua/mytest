package com.test.xls;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.CellView;
import jxl.Workbook;
import jxl.write.WritableWorkbook;
//import jxl.format.Alignment;
//import jxl.format.Border;
//import jxl.format.BorderLineStyle;
//import jxl.format.CellFormat;
import jxl.write.Label;
//import jxl.write.WritableCellFormat;
//import jxl.write.WritableFont;
import jxl.write.WritableSheet;
public class JxlListToXls {
	public static void main(String[] args) {
		List workbookList = createlist();
		//System.out.println(workbookList);
		try {
			writeToJxlXls(workbookList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List createlist() {
		List biaotou = new ArrayList();
		List resultList = new ArrayList();
		biaotou.add("局向");
		biaotou.add("局号");
		biaotou.add("工单类型");
		biaotou.add("收单部门");
		biaotou.add("创建时间");
		biaotou.add("创建人");
		resultList.add(biaotou);
		List neirong = new ArrayList();
		neirong.add("2271");
		neirong.add("2271");
		neirong.add("测量工单");
		neirong.add("立山维护中心52局测量班");
		neirong.add("2014-03-27/09:06:52");
		neirong.add("胡海军 ");
		resultList.add(neirong);
		neirong = new ArrayList();// 初始化一下，这样之前的值就不会加入
		neirong.add("3651");
		neirong.add("3651");
		neirong.add("外线工单");
		neirong.add("海城温香支局查修班");
		neirong.add("2014-03-26/14:57:00");
		neirong.add("胡海军");
		resultList.add(neirong);
		/*neirong = new ArrayList();
		neirong.add("3651");
		neirong.add("3651");
		resultList.add(neirong);*/
		System.out.print(resultList);
		System.out.println("tostring"+resultList.toString());
		return resultList;		
	}

	public static void writeToJxlXls(List resultList) throws Exception {
		// 获得开始时间   
        long start = System.currentTimeMillis();
		// 输出的excel的路径
		String filePath = "d:\\test1.xls";
		// 创建Excel工作薄
		WritableWorkbook wwb;
		// 新建立一个jxl文件,即在C盘下生成test.xls
		OutputStream os=new FileOutputStream(filePath);
		wwb = Workbook.createWorkbook(os);
		// 添加第一个工作表并设置第一个Sheet的名字   
        WritableSheet sheet = wwb.createSheet("产品清单", 0); 
        Label label; 
        for (int i = 0; i < resultList.size(); i++) {
        	List rowList=(List)resultList.get(i);
        	for (int j = 0; j < rowList.size(); j++) {
        		CellView cellView = new CellView();  
        		// Label(x,y,z)其中x代表单元格的第x+1列，第y+1行, 单元格的内容是y   
                // 在Label对象的子对象中指明单元格的位置和内容   
        		String fillCell=(String)rowList.get(j);
        		 label = new Label(j,i,fillCell);
        		 sheet.addCell(label);   
			}
		}
        // 写入数据   
        wwb.write();   
        // 关闭文件   
        wwb.close();   
        long end = System.currentTimeMillis();   
        System.out.println("----完成该操作共用的时间是:"+(end-start)/1000);  
	}

}
