package com.imageread;

import com.drew.metadata.*;
import com.drew.metadata.exif.*;
import com.drew.imaging.jpeg.JpegProcessingException;
import java.io.*;
import java.util.Iterator;
 
public class EXIFReader {
 
public static void main(String args[]) throws FileNotFoundException {
File f = new File("d://7.jpg");
try {
ExifReader er = new ExifReader(f);
Metadata exif = er.extract();
Iterator itr = exif.getDirectoryIterator();
while (itr.hasNext()) {
Directory directory = (Directory) itr.next();
 
System.out.println("EXIF�汾��" + directory.getString(ExifDirectory.TAG_EXIF_VERSION)); 
System.out.println("���Ʒ�ƣ�" + directory.getString(ExifDirectory.TAG_MAKE)); 
System.out.println("����ͺţ�" + directory.getString(ExifDirectory.TAG_MODEL)); 
System.out.println("�� Ȧ ֵ��" + directory.getString(ExifDirectory.TAG_FNUMBER)); 
System.out.println("�� �T��" + directory.getString(ExifDirectory.TAG_EXPOSURE_TIME)); 
System.out.println("�� �� �ȣ�" + directory.getString(ExifDirectory.TAG_ISO_EQUIVALENT));
System.out.println("�� ����" + directory.getString(ExifDirectory.TAG_SOFTWARE)); 
System.out.println("ԭʼ����ʱ�䣺" + directory.getString(ExifDirectory.TAG_DATETIME_ORIGINAL));
System.out.println("���ֻ�ʱ�䣺" + directory.getString(ExifDirectory.TAG_DATETIME_DIGITIZED));
System.out.println("�� ��" + directory.getString(ExifDirectory.TAG_ORIENTATION));
System.out.println("ͼƬ��ȣ�" + directory.getString(ExifDirectory.TAG_EXIF_IMAGE_WIDTH));
System.out.println("ͼƬ�߶ȣ�" + directory.getString(ExifDirectory.TAG_EXIF_IMAGE_HEIGHT));
System.out.println("ˮƽ�ֱ��ʣ�" + directory.getString(ExifDirectory.TAG_X_RESOLUTION));
System.out.println("��ֱ�ֱ��ʣ�" + directory.getString(ExifDirectory.TAG_Y_RESOLUTION));
System.out.println("��ֱ�ֱ��ʣ�" + directory.getString(ExifDirectory.TAG_EXPOSURE_BIAS));
break;
 
//���ȫ��metadata 
/*Iterator tags = directory.getTagIterator();
while (tags.hasNext()) {
Tag tag = (Tag) tags.next();
System.out.println(tag);
}
if (directory.hasErrors()) {
Iterator errors = directory.getErrors();
while (errors.hasNext()) {
System.out.println("ERROR: " + errors.next());
}
}*/
}
} catch (JpegProcessingException e) {
System.err.println("not jpeg file");
}
 
}
 
}
