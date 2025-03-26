

import dados.Item;

public class TestarListaSimples {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(new Item(10));
		lista.inserirUltimo(new Item(15));
		lista.inserirUltimo(new Item(5));
		lista.inserirUltimo(new Item(8));
		lista.inserirUltimo(new Item(24));

		System.out.println("Lista:\n"+lista.toString());

		// Inseri após o primeiro
		lista.inserirAposPrimeiro(new Item(12));
		System.out.println("Lista:\n"+lista.toString());
		
		// soma
		System.out.println(lista.somarValores());

		//Media
		System.out.println(lista.mediaValores());

		// Valores Pares
		System.out.println(lista.valoresPares());
	}

}
