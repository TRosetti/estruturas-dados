
package simplesmente;
import dados.Item;

public class No {
	private Item info; // a declara��o do tipo Item est� no capitulo 1
	private No prox;

	public No (Item elem){  // a vari�vel elem cont�m os dados que ser�o armazenados
		this.info = elem;
		this.prox = null; // esta linha � opcional, pois o prox � automaticamente 
           //definido como null
	}
	public Item getInfo (){
		return this.info;
	}
	public void setInfo(Item elem){
		this.info = elem;
	}
	public No getProx(){
		return this.prox;
	}
	public void setProx(No novoNo){
		this.prox = novoNo;
	}

}
