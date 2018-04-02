/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookper.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import br.com.bookper.coneccoes.DAO.DAO;
import br.com.bookper.coneccoes.DAO.FuncionarioDAO;
import br.com.bookper.coneccoes.DAO.GerenteDAO;
import br.com.bookper.coneccoes.modelo.Cliente;
import br.com.bookper.coneccoes.modelo.Gerente;
import br.com.bookper.coneccoes.modelo.Livro;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.recomendacoes.GeradorDePersonalidades;
import br.com.bookper.recomendacoes.RecomendacoesDeLivros;
import br.com.bookper.segurancaedados.PermisoesESeguranca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author LABINFO
 */
public class ControladorFinal implements Initializable {

	private final EntityManager em = new JPAUtil().getEntityManager();
	private final DAO dao = new DAO(this.em);

	private final ControlaTelas tela = new ControlaTelas();

	@FXML
	private JFXRadioButton rbdGostou1;

	@FXML
	private JFXRadioButton rbdGostou2;

	@FXML
	private JFXRadioButton rbdGostou3;

	@FXML
	private JFXRadioButton rbdNaoGostou1;

	@FXML
	private JFXRadioButton rbdNaoGostou2;

	@FXML
	private JFXRadioButton rbdNaoGostou3;

	@FXML
	private Label lblNomeLivro1;

	@FXML
	private Label lblNomeLivro2;

	@FXML
	private Label lblNomeLivro3;

	@FXML
	private ImageView imgCapa1;

	@FXML
	private ImageView imgCapa2;

	@FXML
	private ImageView imgCapa3;

	@FXML
	private JFXTextField txtEmail;

	private final RecomendacoesDeLivros recomendacoesDeLivros = new RecomendacoesDeLivros();

	private final Livro l1 = this.recomendacoesDeLivros.getRecomendacao1();

	private final Livro l2 = this.recomendacoesDeLivros.getRecomendacao2();

	private final Livro l3 = this.recomendacoesDeLivros.getRecomendacao3();

	@FXML
	private void clickRecomecar(final ActionEvent event) {
		this.dao.abrirCadastro();
		this.salvarRecomendacao();
		this.salvarUsuario();
		this.dao.commit();
		this.tela.iniciarPadrao("Perguntas.fxml");
		this.tela.fechar(this.rbdGostou1);

	}

	private void salvarUsuario() {
		final String email = PermisoesESeguranca.getEMAIL();
		Gerente gerente;
		try {
			gerente = new FuncionarioDAO(this.em).buscarGerente(email);
		} catch (final Exception e) {
			gerente = new GerenteDAO(this.em).buscaEmail(email);
		}

		final Cliente cliente = new Cliente(gerente, this.txtEmail.getText(),
				GeradorDePersonalidades.getPersonalidade());

		this.dao.cadastrarEntidade(cliente);

	}

	private void salvarRecomendacao() {
		final String personalidade = GeradorDePersonalidades.getPersonalidade();

		if (this.rbdGostou1.isSelected())
			this.l1.getRank().forEach(rank -> {
				if (personalidade.equals(rank.getPersonalidade())) {
					rank.somaUm();
					this.dao.reSubir(rank);
				}
			});
		else if (this.rbdNaoGostou1.isSelected())
			this.l1.getRank().forEach(rank -> {
				if (personalidade.equals(rank.getPersonalidade())) {
					rank.subtraiUm();
					this.dao.reSubir(rank);
				}
			});

		if (this.rbdGostou2.isSelected())
			this.l2.getRank().forEach(rank -> {
				if (personalidade.equals(rank.getPersonalidade())) {
					rank.somaUm();
					this.dao.reSubir(rank);
				}
			});
		else if (this.rbdNaoGostou2.isSelected())
			this.l2.getRank().forEach(rank -> {
				if (personalidade.equals(rank.getPersonalidade())) {
					rank.subtraiUm();
					this.dao.reSubir(rank);
				}
			});

		if (this.rbdGostou3.isSelected())
			this.l3.getRank().forEach(rank -> {
				if (personalidade.equals(rank.getPersonalidade())) {
					rank.somaUm();
					this.dao.reSubir(rank);
				}
			});
		else if (this.rbdNaoGostou3.isSelected())
			this.l3.getRank().forEach(rank -> {
				if (personalidade.equals(rank.getPersonalidade())) {
					rank.subtraiUm();
					this.dao.reSubir(rank);
				}
			});

	}

	@Override
	public void initialize(final URL url, final ResourceBundle rb) {
		this.lblNomeLivro1.setText(this.l1.getNome());
		this.lblNomeLivro2.setText(this.l2.getNome());
		this.lblNomeLivro3.setText(this.l3.getNome());
		try {
			this.imgCapa1.setImage(new Image(this.l1.getUrlDaImagem()));
			this.imgCapa2.setImage(new Image(this.l2.getUrlDaImagem()));
			this.imgCapa3.setImage(new Image(this.l3.getUrlDaImagem()));
		} catch (final Exception e) {
			e.getStackTrace();
		}
	}

}
