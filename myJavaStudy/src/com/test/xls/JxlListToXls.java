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
		biaotou.add("����");
		biaotou.add("�ֺ�");
		biaotou.add("��������");
		biaotou.add("�յ�����");
		biaotou.add("����ʱ��");
		biaotou.add("������");
		resultList.add(biaotou);
		List neirong = new ArrayList();
		neirong.add("2271");
		neirong.add("2271");
		neirong.add("��������");
		neirong.add("��ɽά������52�ֲ�����");
		neirong.add("2014-03-27/09:06:52");
		neirong.add("������ ");
		resultList.add(neirong);
		neirong = new ArrayList();// ��ʼ��һ�£�����֮ǰ��ֵ�Ͳ������
		neirong.add("3651");
		neirong.add("3651");
		neirong.add("���߹���");
		neirong.add("��������֧�ֲ��ް�");
		neirong.add("2014-03-26/14:57:00");
		neirong.add("������");
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
		// ��ÿ�ʼʱ��   
        long start = System.currentTimeMillis();
		// �����excel��·��
		String filePath = "d:\\test1.xls";
		// ����Excel������
		WritableWorkbook wwb;
		// �½���һ��jxl�ļ�,����C��������test.xls
		OutputStream os=new FileOutputStream(filePath);
		wwb = Workbook.createWorkbook(os);
		// ��ӵ�һ�����������õ�һ��Sheet������   
        WritableSheet sheet = wwb.createSheet("��Ʒ�嵥", 0); 
        Label label; 
        for (int i = 0; i < resultList.size(); i++) {
        	List rowList=(List)resultList.get(i);
        	for (int j = 0; j < rowList.size(); j++) {
        		CellView cellView = new CellView();  
        		// Label(x,y,z)����x����Ԫ��ĵ�x+1�У���y+1��, ��Ԫ���������y   
                // ��Label������Ӷ�����ָ����Ԫ���λ�ú�����   
        		String fillCell=(String)rowList.get(j);
        		 label = new Label(j,i,fillCell);
        		 sheet.addCell(label);   
			}
		}
        // д������   
        wwb.write();   
        // �ر��ļ�   
        wwb.close();   
        long end = System.currentTimeMillis();   
        System.out.println("----��ɸò������õ�ʱ����:"+(end-start)/1000);  
	}

}
