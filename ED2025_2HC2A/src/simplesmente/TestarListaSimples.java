

import dados.Item;

public class TestarListaSimples {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		
		lista.inserirUltimo(new Item(1));
		lista.inserirUltimo(new Item(2));
		lista.inserirUltimo(new Item(3));
		lista.inserirUltimo(new Item(4));
	
		
		
		System.out.println("Lista:\n"+lista.toString());

	

		// System.out.println(lista.primeiroTeste());

		// System.out.println("Lista:\n"+lista.toString());
		
		System.out.println(lista.primeiroTeste());
		
		
		System.out.println("Lista:\n"+lista.toString());
		
		// // soma
		// System.out.println(lista.somarValores());

		// //Media
		// System.out.println(lista.mediaValores());

		// // Valores Pares
		// System.out.println(lista.valoresPares());





	}


}




