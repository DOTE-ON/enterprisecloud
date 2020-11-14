package com.miyano.enterprisecloud.util;

import java.io.File;

/**
*	@author 	TeacherXue@isoftstone.com
*	@date		2018年9月28日 下午5:59:49
*	@file		com.issCollege.util RenameFiles.java
*	@version	V1.0
*/
public class RenameFiles {
	/**
	 * 批量重命名文件
	 * @param sourceForder 扫描文件夹
	 * @param newNameFomat 批量文件名格式前缀+### 符号#的数量新文件名的数字位 例如img001.jpg
	 * @param startNum 计数开始于多少，如传null，则从0开始计数
	 * @throws Exception 
	 */
	public static void renameFiles(String sourceForder,String newNameFomat,Integer startNum) throws Exception {
		File path = new File(sourceForder);
		String firstName=newNameFomat.substring(0, newNameFomat.indexOf("#"));
		String lastName=newNameFomat.substring(newNameFomat.indexOf("#"));
		int nameNumber=lastName.length();
		System.out.println("数字位数："+lastName.length());
		int i=0;
		if(startNum!=null) {
			i=startNum;
		}
		if(path.exists() && path.isDirectory()) {
			File[] files = path.listFiles();
			for (File f : files) {
				i++;
				String tgName=firstName+String.format("%0"+nameNumber+"d", i)+f.getName().substring(f.getName().lastIndexOf("."));
				f.renameTo(new File(sourceForder,tgName));
			}
		}else {
			throw new Exception("原文件夹错误或不存在");
		}
	}
	
	public static void main(String[] args) {
		try {
			renameFiles("D:\\img", "img####", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
