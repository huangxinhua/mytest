package com.imageread;

/**
 * 
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class HashMapTest {
	public static void main(String[] args) {
		Map map=new HashMap();
		for(int i=0;i<100000;i++){
			map.put(String.valueOf(i), "hello world!");
		}
		long start=System.currentTimeMillis(); 
		Iterator it=map.keySet().iterator();
		while(it.hasNext()){
			String key=(String) it.next();
			map.get(key);
		}
		long end=System.currentTimeMillis();
		System.out.println("keyset运行时间:"+(end-start)+"ms");
		
		start=System.currentTimeMillis(); 
		it=map.entrySet().iterator();
		while(it.hasNext()){
			 java.util.Map.Entry entry = (java.util.Map.Entry) it.next(); 
			 entry.getValue();
			// System.out.println("值是"+entry.getKey());
			// System.out.println("值是"+entry.getValue());
		}
		end=System.currentTimeMillis();
		System.out.println("entrySet运行时间:"+(end-start)+"ms");	
	}
}