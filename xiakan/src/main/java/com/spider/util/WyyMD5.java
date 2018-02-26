//package com.spider.util;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
//
//public class WyyMD5 {
//
//	public static void main(String[] args) throws NoSuchAlgorithmException {
//		// TODO Auto-generated method stub
//        String id="473571905";  
//		String url="http://m10.music.126.net/20170421190802/1b12a3bb2a4e84abded0469b5661eeab/ymusic/cb48/1b1e/3b0e/c00d8ea454195bbb0605cdc741b534b3.mp3";
//	
//		String input = "473571905";
//        String key = "3go8&$8*3*3h0k(2)2";
//        byte[] keyBytes = key.getBytes();
//        byte[] searchBytes = input.getBytes();
//
//        for (int i = 0; i < searchBytes.length; ++i) {
//            searchBytes[i] ^= keyBytes[i % keyBytes.length];
//        }
//
//        MessageDigest mdInst = MessageDigest.getInstance("MD5");
//        mdInst.update(searchBytes);
//   //     byte[] result = Base64.getEncoder().encode(mdInst.digest());
//        String params = new String(result);
//        params = params.replace("+", "-");
//        params = params.replace("/", "_");
//
//        System.out.println("http://m2.music.126.net/" + params + "/" + input + ".mp3");
//	
//	
//	}
//	
//	
//
//}
