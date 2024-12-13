package kopo.poly.util;

public class CmmUtil {

	public static String nvl(String str, String chgStr) {
		return (str == null || str.isEmpty()) ?chgStr : str;
	}

	public static String nvl(String str){
		return nvl(str, "");
	}


	public static <T extends Number> T nvl(T number, T defaultValue) {
		return (number == null) ? defaultValue : number;
	}



}
