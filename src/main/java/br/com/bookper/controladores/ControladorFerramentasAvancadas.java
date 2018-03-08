package br.com.bookper.controladores;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.Normalizer;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import br.com.bookper.coneccoes.DAO.ClienteDAO;
import br.com.bookper.coneccoes.modelo.Cliente;
import br.com.bookper.coneccoes.util.JPAUtil;
import br.com.bookper.controladores.telas.ControlaTelas;
import br.com.bookper.personalidades.TodasPersonalidades;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ControladorFerramentasAvancadas implements Initializable {
	private final ControlaTelas tela = new ControlaTelas();
	private final TodasPersonalidades personalidades = new TodasPersonalidades();

	@FXML
	private AnchorPane panPrincipal;

	@FXML
	private Label lblNome;

	@FXML
	private PieChart estatisticasQuantidadesDePersonalidades;

	@FXML
	private void clickVoltar(final ActionEvent event) throws IOException {
		this.tela.iniciarPadrao("TelaIntermediaria.fxml");
		this.tela.fechar(this.panPrincipal);
	}

	@FXML
	private void clickFechar(final ActionEvent event) {
		this.tela.fechar(this.panPrincipal);
		System.exit(0);
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		this.geraGraficoDaQunatidadeDePessoasComAquelaPersonalidadeQueFiseraoOTeste();
	}

	private void geraGraficoDaQunatidadeDePessoasComAquelaPersonalidadeQueFiseraoOTeste() {

		final EntityManager em = new JPAUtil().getEntityManager();
		final ClienteDAO clienteDAO = new ClienteDAO(em);
		final List<Cliente> clientes = clienteDAO.pegarTodosOsLvrosDesteGerente();
		for (final Cliente cliente : clientes) {
			String personalidade = cliente.getPersonalidade();
			// personalidade = personalidade.toLowerCase();
			personalidade = Normalizer.normalize(personalidade, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			getAtributos(personalidade, this.personalidades);

		}
		System.out.println("Arquiteto " + this.personalidades.getArquiteto());
		System.out.println("Comandante " + this.personalidades.getComandante());
		final ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Advogado", this.personalidades.getAdvogado()),
				new PieChart.Data("Animador", this.personalidades.getAnimador()),
				new PieChart.Data("Arquiteto", this.personalidades.getArquiteto()),
				new PieChart.Data("Ativista", this.personalidades.getAtivista()),
				new PieChart.Data("Aventureiro", this.personalidades.getAventureiro()),
				new PieChart.Data("Comandante", this.personalidades.getComandante()),
				new PieChart.Data("Cônsul", this.personalidades.getConsul()),
				new PieChart.Data("Defensor", this.personalidades.getDefensor()),
				new PieChart.Data("Empresário", this.personalidades.getEmpresario()),
				new PieChart.Data("Executivo", this.personalidades.getExecutivo()),
				new PieChart.Data("Inovador", this.personalidades.getInovador()),
				new PieChart.Data("Lógico", this.personalidades.getLogico()),
				new PieChart.Data("Logístico", this.personalidades.getLogistico()),
				new PieChart.Data("Mediador", this.personalidades.getMediador()),
				new PieChart.Data("Protagonista", this.personalidades.getProtagonista()),
				new PieChart.Data("Virtuoso", this.personalidades.getVirtuoso()));
		this.estatisticasQuantidadesDePersonalidades.setData(pieChartData);
	}

	public static void getAtributos(final String personalidade, final Object o) {

		try {
			final Class<?> c = o.getClass();

			long value = 0;
			for (final Method f : c.getMethods()) {
				if (f.getName().equals("get" + personalidade)) {
					final Object invoke = f.invoke(o);
					value = (long) invoke;
				}
			}
			for (final Method f : c.getMethods()) {
				if (f.getName().equals("set" + personalidade)) {
					f.invoke(o, value + 1);
				}
				System.out.println("Nomes " + f.getName() + " valor " + value);
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

}
