package com.cosy.sun.test;

import com.cosy.sun.trigger.TriggerTree;
import com.cosy.sun.trigger.TriggerUtils;
import org.junit.jupiter.api.Test;

public class TestTriggerUtils {

	@Test
	public void testTriggerTree() {
		TriggerTree parseJsonToMap = TriggerUtils.parseJsonToTree(
				"{\r\n" +
				"    \"condition\": \"OR\",\r\n" +
				"    \"rules\" : [\r\n" +
				"        {\r\n" +
				"            \"condition\": \"OR\",\r\n" +
				"            \"rules\" : [\r\n" +
				"                {\r\n" +
				"                    \"condition\": \"OR\",\r\n" +
				"                    \"rules\" : [\r\n" +
				"                        \r\n" +
				"                        {\r\n" +
				"                            \"left\":\"a\",\r\n" +
				"                            \"right\" : \"A1\",\r\n" +
				"                            \"operator\": \"=\"\r\n" +
				"                        },\r\n" +
				"                        \r\n" +
				"                        {\r\n" +
				"                            \"left\":\"a\",\r\n" +
				"                            \"right\" : \"A2\",\r\n" +
				"                            \"operator\": \"=\"\r\n" +
				"                        }\r\n" +
				"                        \r\n" +
				"                \r\n" +
				"                    ]\r\n" +
				"                },\r\n" +
				"                {\r\n" +
				"                    \"left\":\"a\",\r\n" +
				"                    \"right\" : \"A1\",\r\n" +
				"                    \"operator\": \"=\"\r\n" +
				"                },\r\n" +
				"                \r\n" +
				"                {\r\n" +
				"                    \"left\":\"a\",\r\n" +
				"                    \"right\" : \"A2\",\r\n" +
				"                    \"operator\": \"=\"\r\n" +
				"                }\r\n" +
				"                \r\n" +
				"        \r\n" +
				"            ]\r\n" +
				"        },\r\n" +
				"        {\r\n" +
				"            \"left\":\"a\",\r\n" +
				"            \"right\" : \"A1\",\r\n" +
				"            \"operator\": \"=\"\r\n" +
				"        },\r\n" +
				"        {\r\n" +
				"            \"condition\": \"OR\",\r\n" +
				"            \"rules\" : [\r\n" +
				"                {\r\n" +
				"                    \"left\":\"a\",\r\n" +
				"                    \"right\" : \"A1\",\r\n" +
				"                    \"operator\": \"=\"\r\n" +
				"                },\r\n" +
				"                \r\n" +
				"                {\r\n" +
				"                    \"left\":\"a\",\r\n" +
				"                    \"right\" : \"A2\",\r\n" +
				"                    \"operator\": \"=\"\r\n" +
				"                }\r\n" +
				"                \r\n" +
				"        \r\n" +
				"            ]\r\n" +
				"        },\r\n" +
				"        {\r\n" +
				"            \"left\":\"a\",\r\n" +
				"            \"right\" : \"A2\",\r\n" +
				"            \"operator\": \"=\"\r\n" +
				"        }\r\n" +
				"        \r\n" +
				"\r\n" +
				"    ]\r\n" +
				"}");
		String mapToExpression = TriggerUtils.treeToExpression(parseJsonToMap);
		System.out.println(mapToExpression);
	}

//	@Test
//	public void test() {
//		Map<String, Object> parseJsonToMap = TriggerUtils.parseJsonToMap("{\r\n" + "    \"condition\": \"OR\",\r\n"
//				+ "    \"rules\" : [\r\n" + "        {\r\n" + "            \"left\":\"conditiona1\",\r\n"
//				+ "            \"right\" : \"A1\",\r\n" + "            \"operator\": \"equal\"\r\n" + "        },\r\n"
//				+ "        {\r\n" + "            \"condition\": \"AND\",\r\n" + "            \"rules\" : [{\r\n"
//				+ "                \"left\":\"conditiona1\",\r\n" + "                \"right\" : \"A1\",\r\n"
//				+ "                \"operator\": \"equal\"\r\n" + "            },\r\n" + "            {\r\n"
//				+ "                \"condition\": \"AND\",\r\n" + "                \"rules\" : [\r\n"
//				+ "                    {\r\n" + "                        \"left\":\"conditionab1\",\r\n"
//				+ "                        \"right\" : \"B1\",\r\n"
//				+ "                        \"operator\": \"equal\"\r\n" + "                    },\r\n"
//				+ "                    {\r\n" + "                        \"left\":\"conditionab2\",\r\n"
//				+ "                        \"right\" : \"B2\",\r\n"
//				+ "                        \"operator\": \"equal\"\r\n" + "                    },\r\n"
//				+ "                    {\r\n" + "                        \"left\":\"conditionab2\",\r\n"
//				+ "                        \"right\" : \"B2\",\r\n"
//				+ "                        \"operator\": \"equal\"\r\n" + "                    }\r\n"
//				+ "            \r\n" + "                ]\r\n" + "            },\r\n" + "            {\r\n"
//				+ "                \"condition\": \"AND\",\r\n" + "                \"rules\" : [\r\n"
//				+ "                    {\r\n" + "                        \"left\":\"conditionab1\",\r\n"
//				+ "                        \"right\" : \"B1\",\r\n"
//				+ "                        \"operator\": \"equal\"\r\n" + "                    },\r\n"
//				+ "                    {\r\n" + "                        \"left\":\"conditionab2\",\r\n"
//				+ "                        \"right\" : \"B2\",\r\n"
//				+ "                        \"operator\": \"equal\"\r\n" + "                    },\r\n"
//				+ "                    {\r\n" + "                        \"left\":\"conditionab2\",\r\n"
//				+ "                        \"right\" : \"B2\",\r\n"
//				+ "                        \"operator\": \"equal\"\r\n" + "                    }\r\n"
//				+ "            \r\n" + "                ]\r\n" + "            },\r\n" + "            {\r\n"
//				+ "                \"left\":\"conditiona2\",\r\n" + "                \"right\" : \"A2\",\r\n"
//				+ "                \"operator\": \"equal\"\r\n" + "            }\r\n" + "            \r\n" + "    \r\n"
//				+ "        ]\r\n" + "        },\r\n" + "        {\r\n" + "            \"condition\": \"AND\",\r\n"
//				+ "            \"rules\" : [\r\n" + "                {\r\n"
//				+ "                    \"left\":\"conditionab1\",\r\n" + "                    \"right\" : \"B1\",\r\n"
//				+ "                    \"operator\": \"equal\"\r\n" + "                },\r\n" + "                {\r\n"
//				+ "                    \"left\":\"conditionab2\",\r\n" + "                    \"right\" : \"B2\",\r\n"
//				+ "                    \"operator\": \"equal\"\r\n" + "                },\r\n" + "                {\r\n"
//				+ "                    \"left\":\"conditionab2\",\r\n" + "                    \"right\" : \"B2\",\r\n"
//				+ "                    \"operator\": \"equal\"\r\n" + "                }\r\n" + "        \r\n"
//				+ "            ]\r\n" + "        },\r\n" + "        {\r\n" + "            \"left\":\"conditiona2\",\r\n"
//				+ "            \"right\" : \"A2\",\r\n" + "            \"operator\": \"equal\"\r\n" + "        }\r\n"
//				+ "        \r\n" + "\r\n" + "    ]\r\n" + "}\r\n" + "\r\n" + "");
//		parseJsonToMap.forEach((key, value) -> {
//			if (value instanceof Map) {
//				((Map) value).forEach((key1, value1) -> {
//					System.out.println(key1 + "-" + value1);
//				});
//			}
//			System.out.println(key + "-" + value);
//		});
//
//		String mapToExpression = TriggerUtils.mapToExpression(parseJsonToMap);
//		System.out.println(mapToExpression);
//	}

}
