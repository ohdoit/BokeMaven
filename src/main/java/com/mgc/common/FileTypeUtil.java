package com.mgc.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;

public class FileTypeUtil {
	public static void main(String[] args) throws IOException {
		Path source = Paths.get("E:/file/123.png");
		System.out.println(Files.probeContentType(source)+"    "+new MimetypesFileTypeMap().getContentType(new File("E:/file/123.png")));
		source = Paths.get("E:/file/123.exe");
		System.out.println(Files.probeContentType(source)+"    "+new MimetypesFileTypeMap().getContentType(new File("E:/file/123.doc")));
		source = Paths.get("E:/file/123.js");
		System.out.println(Files.probeContentType(source)+"    "+new MimetypesFileTypeMap().getContentType(new File("E:/file/123.docx")));
		source = Paths.get("E:/file/123.jsp");
		System.out.println(Files.probeContentType(source)+"    "+new MimetypesFileTypeMap().getContentType(new File("E:/file/123.xlsx")));
		source = Paths.get("E:/file/123.rar");
		System.out.println(Files.probeContentType(source)+"    "+new MimetypesFileTypeMap().getContentType(new File("E:/file/123.xls")));
		source = Paths.get("E:/file/123.zip");
		System.out.println(Files.probeContentType(source)+"    "+new MimetypesFileTypeMap().getContentType(new File("E:/file/123.zip")));
		source = Paths.get("E:/file/123.gif");
		System.out.println(Files.probeContentType(source)+"    "+new MimetypesFileTypeMap().getContentType(new File("E:/file/123.gif")));
		
		String fileType = getFileType("E:/file/123.png");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.gif");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.rar");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.zip");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.jsp");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.doc");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.docx");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.xls");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.xlsx");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.wmv");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.bmp");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.pdf");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.mp3");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.mp4");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.wmv");
		System.out.println(fileType);
		fileType = getFileType("E:/file/123.mkv");
		System.out.println(fileType);
	}
	
	public static final HashMap<String, String> mFileTypes = new HashMap<String, String>();  
    static {  
        // images  
        mFileTypes.put("FFD8FF", "jpg"); 
        mFileTypes.put("FFD8FFE0", "jpeg");  
        mFileTypes.put("FFD8FFE1", "jpeg");  
        mFileTypes.put("89504E47", "png");  
        mFileTypes.put("47494638", "gif");  
        mFileTypes.put("49492A00", "tif");  
        mFileTypes.put("424D", "bmp");   
        mFileTypes.put("424D0672", "bmp");  
        //  
        mFileTypes.put("41433130", "dwg"); // CAD  
        mFileTypes.put("38425053", "psd");  
        mFileTypes.put("7B5C727466", "rtf"); // 日记本  
        mFileTypes.put("3C3F786D6C", "xml");  
        mFileTypes.put("68746D6C3E", "html");  
        mFileTypes.put("44656C69766572792D646174653A", "eml"); // 邮件  
        mFileTypes.put("D0CF11E0", "doc");  
        mFileTypes.put("D0CF11E0", "xls");//excel2003版本文件  
        mFileTypes.put("5374616E64617264204A", "mdb");  
        mFileTypes.put("252150532D41646F6265", "ps");  
        mFileTypes.put("255044462D312E", "pdf");    
        mFileTypes.put("25504446", "pdf");  
        mFileTypes.put("504B0304", "docx");  
        mFileTypes.put("504B0304", "xlsx");//excel2007以上版本文件  
        mFileTypes.put("52617221", "rar");  
        mFileTypes.put("57415645", "wav");  
        mFileTypes.put("3026B275", "wmv");
        mFileTypes.put("41564920", "avi");  
        mFileTypes.put("2E524D46", "rm");  
        mFileTypes.put("000001BA", "mpg");  
        mFileTypes.put("000001B3", "mpg");  
        mFileTypes.put("6D6F6F76", "mov");  
        mFileTypes.put("3026B2758E66CF11", "asf");  
        mFileTypes.put("4D546864", "mid");  
        mFileTypes.put("1F8B08", "gz");  
        mFileTypes.put("49443303", "mp3");
        mFileTypes.put("00000020", "mp4");
        mFileTypes.put("1A45DFA3", "mkv");
    }  

    /**
     * <p>Title:getFileType </p>
     * <p>Description: 根据文件路径获取文件头信息</p>
     * @param filePath  文件路径 
     * @return 文件头信息 
     * @author 鲁东顺
     * @date 2016-11-23上午10:06:40
     */
    public static String getFileType(String filePath) {  
//        System.out.println(getFileHeader(filePath));  //返回十六进制  如：504B0304
        //System.out.println(mFileTypes.get(getFileHeader(filePath)));  //xlsx
    	String type = getFileHeader(filePath);
    	System.out.println("----------"+type);
        return mFileTypes.get(type);  
    }  
    /**
     * <p>Title:getFileTypeByFileInputStream </p>
     * <p>Description: 根据文件流获取文件头信息</p>
     * @param is   文件流
     * @return  文件头信息
     * @author 鲁东顺
     * @date 2016-11-23上午10:23:10
     */
    public static String getFileTypeByFileInputStream(FileInputStream is) {  
        return mFileTypes.get(getFileHeaderByFileInputStream(is));  
    }  

    /**
     * <p>Title:getFileHeader </p>
     * <p>Description: 根据文件路径获取文件头信息 </p>
     * @param filePath 文件路径 
     * @return 十六进制文件头信息 
     * @author 鲁东顺
     * @date 2016-11-23上午10:08:16
     */
    public static String getFileHeader(String filePath) {  
        FileInputStream is = null;  
        String value = null;  
        try {  
            is = new FileInputStream(filePath);  
            byte[] b = new byte[4];  
            /* 
             * int read() 从此输入流中读取一个数据字节。int read(byte[] b) 从此输入流中将最多 b.length 
             * 个字节的数据读入一个 byte 数组中。 int read(byte[] b, int off, int len) 
             * 从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。 
             */  
            is.read(b, 0, b.length);  
            value = bytesToHexString(b);  
        } catch (Exception e) {  
        } finally {  
            if (null != is) {  
                try {  
                    is.close();  
                } catch (IOException e) {  
                }  
            }  
        }  
        return value;  
    }  
    /**
     * <p>Title:getFileHeaderByFileInputStream </p>
     * <p>Description: 根据文件流获取文件头信息</p>
     * @param is  文件流
     * @return  十六进制文件头信息 
     * @author 鲁东顺
     * @date 2016-11-23上午10:20:27
     */
    public static String getFileHeaderByFileInputStream(FileInputStream is) {  
        String value = null;  
        try {  
            byte[] b = new byte[4];  
            /* 
             * int read() 从此输入流中读取一个数据字节。int read(byte[] b) 从此输入流中将最多 b.length 
             * 个字节的数据读入一个 byte 数组中。 int read(byte[] b, int off, int len) 
             * 从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。 
             */  
            is.read(b, 0, b.length);  
            value = bytesToHexString(b);  
        } catch (Exception e) {  
        } finally {  
            if (null != is) {  
                try {  
                    is.close();  
                } catch (IOException e) {  
                }  
            }  
        }  
        return value;  
    }  

    /**
     * <p>Title:bytesToHexString </p>
     * <p>Description: 将要读取文件头信息的文件的byte数组转换成string类型表示 </p>
     * @param src 要读取文件头信息的文件的byte数组 
     * @return  文件头信息 
     * @author 鲁东顺
     * @date 2016-11-23上午10:09:56
     */
    private static String bytesToHexString(byte[] src) {  
        StringBuilder builder = new StringBuilder();  
        if (src == null || src.length <= 0) {  
            return null;  
        }  
        String hv;  
        for (int i = 0; i < src.length; i++) {  
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写  
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();  
            if (hv.length() < 2) {  
                builder.append(0);  
            }  
            builder.append(hv);  
        }  
        //System.out.println(builder.toString());  
        return builder.toString();  
    }  
	
}
