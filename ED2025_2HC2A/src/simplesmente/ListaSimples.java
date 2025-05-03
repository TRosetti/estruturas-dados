
package simplesmente;
import dados.Item;

public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;
	//construtor da classe
	public ListaSimples(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public No getPrim(){
		return this.prim;
	}
	public No getUlt(){
		return this.ult;
	}
	public void setQuantNos(int novoValor){
		this.quantNos = novoValor;
	}
	public void setPrim(No novoNo){
		this.prim = novoNo;
	}
	public void setUlt(No novoNo){
		this.ult = novoNo;
	}
	public boolean eVazia (){
		return (this.prim == null);
	}
	//insere um novo n� no final da lista ou se a lista estiver vazia, insere o primeiro n� na lista
	public void inserirUltimo (Item elem){
		No novoNo = new No (elem);
		if (this.eVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	//retorna o endere�o do n� que est� contendo o valor a ser procurado.
	public No pesquisarNo (int chave){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)){
			atual = atual.getProx();
		}	
		return atual;
	}
	public boolean removerNo(int x){
		if (this.eVazia()){
			return false;
		}else{
			if (this.prim.getInfo().getChave()==x){
				if (this.prim.getProx()==null){  //se for �nico n� da lista
					this.ult = null;
				}
				//remover o primeiro n� da lista
				this.prim = this.prim.getProx();
			}else{
				No atual = this.prim;
				while ((atual.getProx()!=null)&&
						(atual.getProx().getInfo().getChave()!=x)){
					atual = atual.getProx();
				}
				if (atual.getProx()==null){//n�o achou o valor na lista
					return false;
				}else{
					if (atual.getProx()==this.ult){  //se for o �ltimo n�
						atual.setProx(null);
						this.ult = atual;
					}else{	//remove o n� no meio da lista
						atual.setProx(atual.getProx().getProx());
					}
				}
			}
			this.quantNos--;
			return true;
		}
	}
	//mostra todo o conte�do da lista
	public String toString(){
		String msg = "";
		No atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}
	//inserir ap�s o primeiro n� da lista
	public void inserirAposPrimeiro(Item elem) {
		if (!this.eVazia()) {
			No novoNo = new No(elem);
			novoNo.setProx(this.prim.getProx());
			this.prim.setProx(novoNo);
			this.quantNos++;
		}
	}



	// Atividade 02 - Questão 07

	public int somarValores(){

		int soma = 0;
		No atual = this.prim;
		
		while(atual != null){
			soma += atual.getInfo().getChave();
			atual = atual.getProx();
		}
		return soma;
	}

	// Atividade 02 - Questão 08

	public double mediaValores(){

		int soma = 0;
		double  media = 0;
	
		soma = somarValores(); // chama a função somar Valores

		media = soma/this.quantNos;

		return media;
	}

	// Atividade 02 - Questão 09

	public String valoresPares(){
		String resposta = "";

		if(!this.eVazia()){
			No atual = this.prim;

			for(int i = 1; i <= this.quantNos; i++){
				if(atual.getInfo().getChave() % 2 == 0){
					resposta +=  atual.getInfo().getChave() + " ";
					
				}
				atual = atual.getProx();
				
			}
			return resposta;
		}else{
		
			return "Lista Vazia";
		}
		
	}

		// Atividade 02 - Questão 10

		public String primeiroTeste() {
			No atual = this.prim.getProx();

			prim = atual.getProx();
			atual.setProx(null);
			

			return "atual: " +  atual.getInfo().getChave();
		}

		public String segundoTeste() {
			No atual = this.prim.getProx();

			atual.setProx(null);
			

			return "atual: " +  atual.getInfo().getChave();
		}

		
		
		// primeiro = atual.getProx();
		// atual.setProx(null);


		// atual.setProx(null);
		
}
