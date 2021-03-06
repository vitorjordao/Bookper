package br.com.bookper.classesdastabelas;

import java.util.List;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.coneccoes.modelo.RankDaBusca;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TabelaLivro extends RecursiveTreeObject<TabelaLivro> {
	private final StringProperty id;
	private final StringProperty nome;
	private final StringProperty urlDaImagem;
	private final StringProperty gerente;
	private final StringProperty rank;
	private final StringProperty sinopse;
	private final StringProperty nomeAutor;

	public TabelaLivro(final Integer id, final String nome, final String urlDaImagem, final Gerente gerente,
			final List<RankDaBusca> ranks, final String sinopse, final String nomeAutor) {
		super();
		this.sinopse = new SimpleStringProperty(sinopse);
		this.nomeAutor = new SimpleStringProperty(nomeAutor);
		this.id = new SimpleStringProperty(Integer.toString(id));
		this.nome = new SimpleStringProperty(nome);
		this.urlDaImagem = new SimpleStringProperty(urlDaImagem);
		this.gerente = new SimpleStringProperty(gerente.getNome());
		long pontuacao = 0;
		for (final RankDaBusca rank : ranks) {
			pontuacao += rank.getAvaliacao();
		}
		this.rank = new SimpleStringProperty(pontuacao + "");
	}

	public StringProperty getSinopseProperty() {
		return this.sinopse;
	}

	public StringProperty getNomeAutorProperty() {
		return this.nomeAutor;
	}

	public StringProperty getUrlDaImagemProperty() {
		return this.urlDaImagem;
	}

	public StringProperty getGerenteProperty() {
		return this.gerente;
	}

	public StringProperty getRankProperty() {
		return this.rank;
	}

	public StringProperty getIdProperty() {
		return this.id;
	}

	public String getId() {
		return this.id.get();
	}

	public StringProperty getNomeProperty() {
		return this.nome;
	}

	public String getNome() {
		return this.nome.get();
	}

	public String getUrlDaImagem() {
		return this.urlDaImagem.get();
	}

	public String getGerente() {
		return this.gerente.get();
	}

	public String getRank() {
		return this.rank.get();
	}

	public String getSinopse() {
		return this.sinopse.get();
	}

	public String getNomeAutor() {
		return this.nomeAutor.get();
	}

}
