package br.com.bookper.validacoes;

import java.time.LocalDate;

public class Data implements Validacoes {

	@Override
	public TiposValidacoes isValido(Object data) {
		LocalDate dataOk = (LocalDate) data;
		try {
			dataOk.getDayOfMonth();
			dataOk.getMonthValue();
			dataOk.getYear();
		}
		catch (Exception e) {
			return TiposValidacoes.NOTOK;
		}
		return TiposValidacoes.OK;
	}

}
