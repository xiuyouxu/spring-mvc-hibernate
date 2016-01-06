package com.dc.test.util;

import java.security.CodeSource;

public class CodeSourceResolver {
	public static void main(String[] args) throws ClassNotFoundException {
		String className = "org.springframework.web.multipart.commons.CommonsMultipartResolver";
		if (className == null) {
			System.out.println("Please the className argument.");
			return;
		}
		Class<?> cls = Class.forName(className);
		if (cls == null) {
			System.out.println("Class [" + className + "] not found!");
		} else {
			CodeSource cs = cls.getProtectionDomain().getCodeSource();
			if (cs == null) {
				System.out.println(className + " location not available!");
			} else {
				String location = cs.getLocation().getPath();
				System.out.println(className + " location: " + location);
			}
		}
	}
}