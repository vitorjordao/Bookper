package br.com.bookper.personalidades;

public interface Personalidades{
	public String getDescricaoPersonalidade();
	public String getImagemPersonalidade();
	public Personalidades verificaPersonalidade(String personalidade);
	public void setProximo(Personalidades outraPersonalidade);
}
