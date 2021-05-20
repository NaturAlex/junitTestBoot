package com.ad61v1.test.logger.tool;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;

/**
 * @Author: eaazhel
 * @Date: 2020/9/21 17:04
 */
public class LoggerTool {

	public static void main(String[] args) throws Exception {
		String fileName = "test.log";
		String content = readFileFromClassPath(fileName);
		String[] lineContents = content.split("\n");
//		Map<Integer, String> logMap = new HashMap<>();
		int lineIndex = 1;
		for (String line : lineContents) {
			System.out.println("lineIndex = " + lineIndex);
			String[] words = line.split(",");
			int i = 1;
			for (String s1 : words) {
				System.out.println(i+" , " + s1);
				i++;
			}
			System.out.println("");
			System.out.println("--------------------------------------------");
			System.out.println("");
			lineIndex++;
		}
	}

	private static String readFileFromClassPath(String fileName) throws Exception{
		File file = ResourceUtils.getFile("classpath:./"+fileName);
		FileReader reader = new FileReader(file);
		char[] chars = new char[1024];
		int index ;
		StringBuilder sb = new StringBuilder(1000);
		while ((index = reader.read(chars)) != -1){
			sb.append(new String(chars,0,index));
		}
		String result = sb.toString();
		return result;
	}
}
