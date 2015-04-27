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
 
System.out.println("EXIF版本：" + directory.getString(ExifDirectory.TAG_EXIF_VERSION)); 
System.out.println("相机品牌：" + directory.getString(ExifDirectory.TAG_MAKE)); 
System.out.println("相机型号：" + directory.getString(ExifDirectory.TAG_MODEL)); 
System.out.println("光 圈 值：" + directory.getString(ExifDirectory.TAG_FNUMBER)); 
System.out.println("快 門：" + directory.getString(ExifDirectory.TAG_EXPOSURE_TIME)); 
System.out.println("感 光 度：" + directory.getString(ExifDirectory.TAG_ISO_EQUIVALENT));
System.out.println("软 件：" + directory.getString(ExifDirectory.TAG_SOFTWARE)); 
System.out.println("原始拍摄时间：" + directory.getString(ExifDirectory.TAG_DATETIME_ORIGINAL));
System.out.println("数字化时间：" + directory.getString(ExifDirectory.TAG_DATETIME_DIGITIZED));
System.out.println("方 向：" + directory.getString(ExifDirectory.TAG_ORIENTATION));
System.out.println("图片宽度：" + directory.getString(ExifDirectory.TAG_EXIF_IMAGE_WIDTH));
System.out.println("图片高度：" + directory.getString(ExifDirectory.TAG_EXIF_IMAGE_HEIGHT));
System.out.println("水平分辨率：" + directory.getString(ExifDirectory.TAG_X_RESOLUTION));
System.out.println("垂直分辨率：" + directory.getString(ExifDirectory.TAG_Y_RESOLUTION));
System.out.println("垂直分辨率：" + directory.getString(ExifDirectory.TAG_EXPOSURE_BIAS));
break;
 
//获得全部metadata 
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
