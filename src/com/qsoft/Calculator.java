package com.qsoft;

import java.util.regex.Pattern;

public class Calculator {

	public static int add(String str) {

		if (str == null) {
			return 1;
		}
		if (str.isEmpty()) {
			return 1;
		}
		if (str.contains("//[")) {
			do {
				str = str.replace("//", "");
				str = str.replace("\n", "");
				String delimiter1 = str.substring(str.indexOf("[") + 1,
						str.indexOf("]"));
				String rep = str.substring(str.indexOf("["),
						str.indexOf("]") + 1);
				str = str.replaceAll(Pattern.quote(rep), ",");
				str = str.replaceAll(Pattern.quote(delimiter1), ",");
			} while (str.contains("["));
			String[] strTemp = str.split(",");
			return sum(strTemp);
		} else if (str.contains("//")) {
			str = str.replace("//", "");
			str = str.replace("\n", "");
			String[] strTemp = str.split(";");
			return sum(strTemp);
		} else {
			str = str.replace("\n", "");
			String[] strTemp = str.split(",");
			return sum(strTemp);
		}

	}

	public static int sum(String[] str) {
		int sum = 0;
		int strTempSize = str.length;
		for (int i = 0; i < strTempSize; i++) {
			String str1 = str[i];
			if (str1.isEmpty()) {
				continue;
			}
			if(Integer.parseInt(str1)<0){
				throw new RuntimeException("negatives not allowed");
			}
			sum += Integer.parseInt(str1);
		}
		return sum;
	}
}
