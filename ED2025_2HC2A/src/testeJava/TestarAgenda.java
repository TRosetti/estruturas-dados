package testeJava;

public class TestarAgenda {

	public static void main(String[] args) {
		//criar um objeto da classe Agenda
		
		Agenda agenda = new Agenda();
		agenda.setNome("maria");
		agenda.setTelefone("9393-9933");
		agenda.setRg(12342222);
		
		Agenda agenda2 = new Agenda();
		agenda2.setNome("jo�o");
		agenda2.setTelefone("77777-77777");
		agenda2.setRg(88888888);
		
		Agenda agenda3 = new Agenda("ana","333333",9876);
		
		
		System.out.println("nome: "+agenda.toString());
		System.out.println();
		System.out.println("nome: "+agenda2.toString());
		System.out.println();
		System.out.println("nome: "+agenda3.toString());
		
		
		

	}

}
