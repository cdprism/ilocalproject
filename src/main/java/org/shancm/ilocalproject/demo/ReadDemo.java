package org.shancm.ilocalproject.demo;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @author shancm
 * @package org.shancm.ilocalproject.demo
 * @description:
 * @date 2018/11/1
 */
public class ReadDemo {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("C:\\Users\\shancm\\Desktop\\用户数据(1).csv");

		InputStreamReader isr = new InputStreamReader(is, "GBK");

		BufferedReader reader = new BufferedReader(isr);

		reader.readLine();

		String string = "";
		while (StringUtils.isNotBlank(string = reader.readLine())){
			String[] split = string.split(",");
			for (String s : split) {
				System.out.println(s);
			}

		}
	}
}
