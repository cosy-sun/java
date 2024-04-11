package com.cosy.sun.jdk.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.UUID;

public class FileTest {

	public static void main(String[] args) throws IOException, ParseException {

		File file = new File("E:\\data-续约贷款信息-zyd-20190228_20190320.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line = null;
		File outFile = new File("E:\\sql.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		String linee = bufferedReader.readLine();
		String[] split = linee.split(",", -1);
		StringBuilder builder = new StringBuilder();
		builder.append("insert into prms_conext_loan_info(");
		builder.append("ID,");
		for (int j = 0; j < split.length; j++) {
			StringBuilder tuofeng = new StringBuilder();
			String strings = split[j];
			char[] charArray = strings.toCharArray();
			if (split[j].contains("threeSumOvertTimePer")) {
				tuofeng.append("three_sum_over_time");
			} else if (split[j].contains("nineAmountPer")) {
				tuofeng.append("nine_amountper");
			} else {
				for (int i = 0; i < charArray.length; i++) {
					String a = charArray[i] + "";
					if (a.matches("[A-Z]")) {
						tuofeng.append("_");
					}
					tuofeng.append(charArray[i]);
				}

			}
			builder.append(tuofeng);
			if (j == 49) {
				builder.append(") values (");
			} else {
				builder.append(",");
			}
		}
		System.out.println(builder);
		while ((line = bufferedReader.readLine()) != null) {
			StringBuilder s = new StringBuilder();
			s.append(builder);
			String[] split2 = line.split(",", -1);
			s.append("'" + UUID.randomUUID() + "',");
			for (int j = 0; j < split2.length; j++) {
				if (split2[j].contains("/")) {
					System.out.println(split2[j]);
//					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
//					Date parse = simpleDateFormat.parse(split2[j]);
//					SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
//					String format = simpleDateFormat2.format(parse);
					s.append("to_date('" + split2[j] + "', 'yyyy/mm/dd'),");
				} else {

					s.append("'");
					if (split[j].contains(".")) {
						BigDecimal bigDecimal = new BigDecimal(split2[j]);
						BigDecimal setScale = bigDecimal.setScale(2, RoundingMode.DOWN);
						s.append(setScale);
					} else {
						s.append(split2[j]);
					}
					if (j != 49) {
						s.append("',");
					} else {
						s.append("'");
					}
				}
			}

			s.append(");");
			writer.write(new String(s));
			writer.newLine();
		}
		writer.flush();
		writer.close();
		bufferedReader.close();
	}

}
