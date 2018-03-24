package br.com.bookper.segurancaedados;

public final class PermisoesESeguranca {

	private static String EMAIL;
	private static String SENHA;
	private static boolean CADASTROLIVRO;
	private static boolean CADASTROFUNCIONARIO;
	private static boolean FERRAMENTASAVANCADAS;

	public PermisoesESeguranca(final String email, final String senha, final boolean cadastroLivro,
			final boolean cadastroFuncionario, final boolean ferramentasAvancadas) {
		PermisoesESeguranca.EMAIL = email;
		PermisoesESeguranca.SENHA = senha;
		PermisoesESeguranca.CADASTROLIVRO = cadastroLivro;
		PermisoesESeguranca.CADASTROFUNCIONARIO = cadastroFuncionario;
		PermisoesESeguranca.FERRAMENTASAVANCADAS = ferramentasAvancadas;

	}

	public static String getEMAIL() {
		return EMAIL;
	}

	public static String getSENHA() {
		return SENHA;
	}

	public static boolean isCADASTROLIVRO() {
		return CADASTROLIVRO;
	}

	public static boolean isCADASTROFUNCIONARIO() {
		return CADASTROFUNCIONARIO;
	}

	public static boolean isFERRAMENTASAVANCADAS() {
		return FERRAMENTASAVANCADAS;
	}

}
