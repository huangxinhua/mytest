package com.compare;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ObejectCompare {

	public static void main(String args[]) {
		List<StudentVO> obj1List=getGrade1Student();
		List<StudentVO> obj2List=getGrade2Student();
		List<StudentVO> editList=compareListVO(obj1List, obj2List);
		System.out.println(editList);
	}
	//比较两个vo集合的属性
	private static <T> List<T> compareListVO(List<T> obj1List,List<T> obj2List){
		List<T> editList=new ArrayList<T>();
		for (T obj1 : obj1List) {
			boolean flag=false;
			for (T obj2 : obj2List) {
				if (((StudentVO)obj1).getName().equals(((StudentVO)obj2).getName())) {
					try {
						flag=compareToEachOther(obj1,obj2);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				if(flag){
					editList.add(obj1);
					editList.add(obj2);
				}
			}
		}
		return editList;
	}
	//比较两个vo对象的属性值是否不同
	private static <T> boolean compareToEachOther(T obj1,T obj2) throws IllegalArgumentException, IllegalAccessException{
		Map<String, String> result=new HashMap<String,String>();
		Field[] fs=obj1.getClass().getDeclaredFields();
		for (Field f : fs) {
			f.setAccessible(true);
			if (f.getName().equals("score")) {
				continue;
			}
			Object v1=f.get(obj1);
			Object v2=f.get(obj2);
			if (v1==null&&v2==null) {
				 continue;
			}
			if ((v1==null&&v2!=null)||(v2==null&&v1!=null)) {
				return true;
			}
			if (v1!=null&&!v1.equals(v2)) {
				result.put(f.getName(), String.valueOf(v1.equals(v2)));
				return true;
			}
		}
		return false;
	}
	
	private static List<StudentVO> getGrade1Student(){
		List<StudentVO> studentVOs=new ArrayList<StudentVO>();
		StudentVO s1=new StudentVO();
		s1.setName("晓明");
		s1.setAge(45);
		s1.setScore(89.6);
		StudentVO s2=new StudentVO();
		s2.setName("黄生");
		s2.setAge(25);
		s2.setScore(98.6);
		StudentVO s3=new StudentVO();
		s3.setName("张生");
		s3.setAge(48);
		s3.setScore(60.6);
		studentVOs.add(s1);
		studentVOs.add(s2);
		studentVOs.add(s3);
		return studentVOs;
	}
	
	private static List<StudentVO> getGrade2Student(){
		List<StudentVO> studentVOs=new ArrayList<StudentVO>();
		StudentVO s1=new StudentVO();
		s1.setName("晓明");
		s1.setAge(45);
		s1.setScore(89.6);
		StudentVO s2=new StudentVO();
		s2.setName("黄生");
		s2.setAge(48);
		s2.setScore(98.6);
		StudentVO s3=new StudentVO();
		s3.setName("张生");
		s3.setAge(48);
		s3.setScore(60.6);
		studentVOs.add(s1);
		studentVOs.add(s2);
		studentVOs.add(s3);
		return studentVOs;
	}
}
