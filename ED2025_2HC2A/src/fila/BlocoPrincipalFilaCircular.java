package fila;

import java.util.Scanner;
import dados.Item;

public class BlocoPrincipalFilaCircular {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("digite o tamanho máximo da fila");
        int tam = scan.nextInt();
        FilaCircular fila = new FilaCircular(tam);
        int valor;
        Item item;
        char opcao;
        do {
            System.out.println("Escolha uma Opção:\n" +
                    "1. enfileirar\n" +
                    "2. desenfileirar\n" +
                    "3. Imprimir Fila\n" +
                    "4. Sair");
            opcao = scan.next().charAt(0);
            switch (opcao) {
                case '1':
                    System.out.println("Inserir um Valor no final da fila\n" + "Digite um valor");
                    valor = scan.nextInt();
                    if (!fila.enfileirar(new Item(valor))) {
                        System.out.println("fila está cheia");
                    }
                    break;
                case '2':
                    
                    item = fila.desenfileirar();
                    if (item == null) {
                        System.out.println("A fila está vazia");
                    } else {
                        System.out.println("o " + item.getChave() +
                                " foi removido da fila");
                    }
                    break;
                case '3':
                 
                    if (!fila.eVazia()) {
                        System.out.println("A fila: " + fila.toString());
                    } else {
                        System.out.println("A fila está vazia");
                    }
                    break;
                case '4':
                    System.out.println("fim do programa");
                    break;
                default:
                    System.out.println("opção invalida, tente novamente");
            }
        } while (opcao != '4');
        System.exit(0);
    }
}

