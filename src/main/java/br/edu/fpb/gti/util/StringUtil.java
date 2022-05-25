package br.edu.fpb.gti.util;

import java.util.List;
import java.util.Objects;

public class StringUtil {

	public static boolean isNullOrEmpty(String str) {
		return Objects.isNull(str) || str.isEmpty();
	}
	
	public static boolean isNullOrEmpty(List<?> list) {
		return Objects.isNull(list) || list.isEmpty();
	}
	
	
}
