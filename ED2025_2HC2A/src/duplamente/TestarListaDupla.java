package duplamente;
import dados.Item;

public class TestarListaDupla {
    public static void main(String[] args) {
        ListaDupla lista1 = new ListaDupla();
        ListaDupla lista2 = new ListaDupla();

        lista1.inserirUltimo(new Item(1));
        lista1.inserirUltimo(new Item(2));
        lista1.inserirUltimo(new Item(3));
        lista1.inserirUltimo(new Item(4));
        lista1.inserirUltimo(new Item(15));
        lista1.inserirUltimo(new Item(6));
        lista1.inserirUltimo(new Item(7));
        lista1.inserirUltimo(new Item(8));
        // lista1.inserirUltimo(new Item(9));

        lista2.inserirUltimo(new Item(0));
        lista2.inserirUltimo(new Item(11));    
        lista2.inserirUltimo(new Item(0));
        
        lista2.inserirUltimo(new Item(12));
        lista2.inserirUltimo(new Item(13));
        lista2.inserirUltimo(new Item(0));
        lista2.inserirUltimo(new Item(14));
        lista2.inserirUltimo(new Item(0));

        // System.out.println("Lista1:\n" + lista1.toString());
        // System.out.println("Lista2:\n" + lista2.toString());

        // lista1.concatenarDuasListas(lista1, lista2);

        // System.out.println("Lista1:\n" + lista1.toString());
        // System.out.println("Lista2:\n" + lista2.toString());

        // lista1.partirListaMeio(lista1);

        // lista1.mostrarMaiorValor(lista1);

        System.out.println(lista2.toString());
        // System.out.println(lista2.calcularMedia(lista2));
        System.out.println(lista2.retirarZero(lista2));
        
        System.out.println(lista2.toString());
       
    }
}
