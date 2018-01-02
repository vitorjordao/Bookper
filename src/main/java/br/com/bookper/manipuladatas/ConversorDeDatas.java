package br.com.bookper.manipuladatas;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ConversorDeDatas {

	public Calendar converterLocalDataParaJodaTime(LocalDate data) {
		Calendar calendar = new GregorianCalendar();
		calendar.set(data.getYear(), data.getMonthValue(), data.getDayOfMonth());
		return calendar;
	}

}
