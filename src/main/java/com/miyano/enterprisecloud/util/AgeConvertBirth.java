package com.miyano.enterprisecloud.util;
/**
*	@author 	TeacherXue@isoftstone.com
*	@date		2018年9月29日 上午11:08:46
*	@file		com.issCollege.util AgeConvertAge.java
*	@version	V1.0
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgeConvertBirth {
	/**
	 * 获得指定年龄的生日范围
	 * @param age 年龄数值大于等于0
	 * @return 日期数组，【0】 为生日范围的开始日期 【1】为生日范围的结束日期
	 */
	public static Date[] AgeToBirth(int age) {
		Date[] birthRange=new Date[2];
		if(age>0) {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR,c.get(Calendar.YEAR)-age-1);
			birthRange[0]=c.getTime();
			c.set(Calendar.YEAR,c.get(Calendar.YEAR)+1);
			birthRange[1]=c.getTime();			
		}	
		return birthRange;
	}
	
	/**
	 * 根据生日算年龄，截止到当前时间的月和日
	 * @param birth 生日时间对象
	 * @return 年龄数值，如果生日大于当前时间返回-1
	 */
	public static int birthToAge(Date birth) {
		int age=-1;
		Date current=new Date();
		if(birth.after(current)) {
			return age;
		}
		Calendar currCald = Calendar.getInstance();
		currCald.setTime(current);
		Calendar birthCald = Calendar.getInstance();
		birthCald.setTime(birth);
		age=currCald.get(Calendar.YEAR)-birthCald.get(Calendar.YEAR);
		if(currCald.get(Calendar.MONTH)<birthCald.get(Calendar.MONTH)) {
			age-=1;
		}else if(currCald.get(Calendar.MONTH)==birthCald.get(Calendar.MONTH) && currCald.get(Calendar.DATE)<birthCald.get(Calendar.DATE)) {
			age-=1;
		}
		return age;
	}
	
	
	public static void main(String[] args) {
	/*	Date[] dates = AgeToBirth(20);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		for (Date date : dates) {
			System.out.println(fmt.format(date));
		}*/
		Date birth;
		try {
			birth = new SimpleDateFormat("yyyyMMdd").parse("19800930");
			System.out.println(birthToAge(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
