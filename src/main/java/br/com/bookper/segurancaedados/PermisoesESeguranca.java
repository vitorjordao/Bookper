package br.com.bookper.segurancaedados;

public final class PermisoesESeguranca {

	private static String EMAIL;
	private static String SENHA;
	private static boolean CADASTROLIVRO;
	private static boolean CADASTROFUNCIONARIO;

	public PermisoesESeguranca(final String email, final String senha, final boolean cadastroLivro,
			final boolean cadastroFuncionario) {
		PermisoesESeguranca.EMAIL = email;
		PermisoesESeguranca.SENHA = senha;
		PermisoesESeguranca.CADASTROLIVRO = cadastroLivro;
		PermisoesESeguranca.CADASTROFUNCIONARIO = cadastroFuncionario;

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

}
