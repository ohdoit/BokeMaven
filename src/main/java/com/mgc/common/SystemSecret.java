package com.mgc.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SystemSecret {
	private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
			"a", "b", "c", "d", "e", "f"};
	
	/**
	 * 转换字节数组为16进制字符串
	 */
	public static String toHexString(byte[] b){
		String str = "";
		for(int i=0; i<b.length; i++){
			str += toHexString(b[i]);
		}
		return str;
	}
	
	private static String toHexString(byte b){
		int n = b;
		if(n<0) n += 256;
		int d1 = n/16;
		int d2 = n%16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	public static String md5Encode(String content){
		String result = content;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = toHexString(md.digest(result.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static String md5Encode2(String inputStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = inputStr.getBytes("UTF-8");
			byte[] md5Bytes = md5.digest(bytes);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				/*
				 * 在32位的电脑中数字都是以32格式存放的，如果是要求一个byte(8位)类型的数字，对于int这种32位的整形，
				 * 高24位具有随机性(从所有的数字形式来看，前面的24位取值并不确定，我把它视为具有一定的随机性，比如int型的整数，高24位的取值都是不确定的。)，
				 * 低8位才是实际的数据。java.lang.Integer.toHexString() 方法的参数是int(32位)类型，如果输入一个byte(8位)类型的数字，这个
				 * 方法会把这个数字的高24为也看作有效位，这就必然导致错误，使用& 0XFF操作，可以把高24位置0以避免这样错误的发生。
				 */
				int value = md5Bytes[i] & 0xff;
				
				if (value < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(value));
				
			}
			return hexValue.toString();
			
		} catch (Exception e) {
			return "";
		}
	}
}
