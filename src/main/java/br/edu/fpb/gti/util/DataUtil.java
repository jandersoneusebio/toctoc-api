package br.edu.fpb.gti.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DataUtil {
	
	public static final String DATA_HORA_DB = "yyyy-MM-dd hh:mm:ss.SSS";
	
	public static Timestamp retornarTimestampAtual() {
		return new Timestamp(new Date().getTime());
	}
	
	public static Date converterLocalDateTimeParaDate(LocalDateTime localDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATA_HORA_DB);
		
		return sdf.parse(localDate.toString().replace("T", " "));
	}
}
