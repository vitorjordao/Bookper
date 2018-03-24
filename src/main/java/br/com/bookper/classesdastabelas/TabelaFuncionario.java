package br.com.bookper.classesdastabelas;

import java.util.Calendar;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TabelaFuncionario extends RecursiveTreeObject<TabelaFuncionario> {
	private final StringProperty id;
	private final StringProperty nome;
	private final StringProperty email;
	private final StringProperty senha;
	private final StringProperty cargo;
	private final StringProperty dataDeContratacao;
	private final StringProperty manipulaLivros;
	private final StringProperty manipulaFuncionarios;
	private final StringProperty manipulaFerramentasAvancadas;
	private final int dia;
	private final int mes;
	private final int ano;

	public TabelaFuncionario(final Integer id, final String nome, final String email, final String senha,
			final String cargo, final Calendar dataDeContratacao, final Boolean manipulaLivros,
			final Boolean manipulaFuncionarios, final Boolean manipulaFerramentasAvancadas) {
		super();
		// jfxButton.getValue().setText("Teste");

		this.id = new SimpleStringProperty(Integer.toString(id));
		this.nome = new SimpleStringProperty(nome);
		this.email = new SimpleStringProperty(email);
		this.senha = new SimpleStringProperty(senha);
		this.cargo = new SimpleStringProperty(cargo);
		this.dataDeContratacao = new SimpleStringProperty(dataDeContratacao.getTime().toString());
		this.manipulaLivros = new SimpleStringProperty(manipulaLivros.toString());
		this.manipulaFuncionarios = new SimpleStringProperty(manipulaFuncionarios.toString());
		this.manipulaFerramentasAvancadas = new SimpleStringProperty(manipulaFerramentasAvancadas.toString());
		this.dia = dataDeContratacao.get(Calendar.DAY_OF_WEEK);
		this.mes = dataDeContratacao.get(Calendar.MONTH);
		this.ano = dataDeContratacao.get(Calendar.YEAR);
	}

	public int getDia() {
		return this.dia;
	}

	public int getMes() {
		return this.mes;
	}

	public int getAno() {
		return this.ano;
	}

	public StringProperty getIdProperty() {
		return this.id;
	}

	public String getId() {
		return this.id.get();
	}

	public StringProperty getManipulaFerramentasAvancadasProperty() {
		return this.manipulaFerramentasAvancadas;
	}

	public String getManipulaFerramentasAvancadas() {
		return this.manipulaFerramentasAvancadas.get();
	}

	public StringProperty getNomeProperty() {
		return this.nome;
	}

	public String getNome() {
		return this.nome.get();
	}

	public StringProperty getEmailProperty() {
		return this.email;
	}

	public String getEmail() {
		return this.email.get();
	}

	public StringProperty getSenhaProperty() {
		return this.senha;
	}

	public String getSenha() {
		return this.senha.get();
	}

	public StringProperty getCargoProperty() {
		return this.cargo;
	}

	public String getCargo() {
		return this.cargo.get();
	}

	public StringProperty getDataProperty() {
		return this.dataDeContratacao;
	}

	public String getDataDeContratacao() {
		return this.dataDeContratacao.get();
	}

	public StringProperty getManipulaLivrosProperty() {
		return this.manipulaLivros;
	}

	public String getManipulaLivros() {
		return this.manipulaLivros.get();
	}

	public StringProperty getManipulaFuncionariosProperty() {
		return this.manipulaFuncionarios;
	}

	public String getManipulaFuncionarios() {
		return this.manipulaFuncionarios.get();
	}

}
