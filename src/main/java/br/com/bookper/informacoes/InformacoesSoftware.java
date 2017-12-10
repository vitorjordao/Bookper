package br.com.bookper.informacoes;

import java.time.LocalDate;

public class InformacoesSoftware {
	private static String nomeEmpresa;
	private static String versao;
	private static String criadores;
	private static LocalDate dataDaVersao;
	private static String nomeProjeto;

	public final String pegarDados() {
		return "@"+getNomeEmpresa()+" "+getDataDaVersao()+" - "+getNomeProjeto()+" "+getVersao()+"\n Feito por: "+criadores;
	}

	public final String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public final String getVersao() {
		return versao;
	}
	public final String getCriadores() {
		return criadores;
	}
	public final LocalDate getDataDaVersao() {
		return dataDaVersao;
	}
	public final String getNomeProjeto() {
		return nomeProjeto;
	}

	public void carregarDados() {
		nomeEmpresa = "Bookper";
		versao = "B1.1";
		criadores = "Vitor Jordão | Luca";
		dataDaVersao = LocalDate.of(2017, 11, 29);
		nomeProjeto = "Bookper";
	}

}
