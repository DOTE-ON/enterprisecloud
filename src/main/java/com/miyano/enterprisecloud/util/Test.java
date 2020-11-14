package com.miyano.enterprisecloud.util;

import java.util.Date;

/**
 * @ClassName: test
 * @description: 
 * @author: mengxue
 * @Date: 2020-8-30 19:48:13
 */
public class Test {

	public static void main(String[] args) {

		Date[] dates = AgeConvertBirth.AgeToBirth (22);
		for (Date date : dates) {
			System.out.println (date);
		}
	}
}