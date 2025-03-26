

public class Agenda {
	//atributos
	private String nome;
	private String telefone;
	private long rg;
	
	//m�todo especial - ele inicia os atributos
	//construtor
	public Agenda() {
		this.nome = "";
		this.telefone = "";
		this.rg = 0;
	}
	public Agenda(String nome, String tel, long rg) {
		this.nome = nome;
		this.telefone = tel;
		this.rg = rg;
	}
	//get = fun��o que pega/ler o conte�do do atributo
	public String getNome() {
		return this.nome;
	}
	public String getTelefone() {
		return this.telefone;
	}
	public long getRg() {
		return this.rg;
	}
	//set = procedimento que alterar o conte�do do atributo
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}
	//fun��o que mostra todo o conte�do do objeto
	public String toString() {
		return this.nome+ " "+this.telefone+" "+this.rg;
	}
	
	
	
	
	
}
