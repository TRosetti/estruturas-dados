package pilha;

import java.util.Scanner;
import dados.*;

public class MenuPrincipal {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("digite o tamanho máximo da pilha");
        int quant = scan.nextInt();
        // instancia uma nova pilha.
        PilhaContigChar pilha = new PilhaContigChar(quant);
        char valor;
        ItemChar item;
        char opcao;

        do {
            opcao = menu();
            switch (opcao) {
                case '1':
                    System.out.println("Digite um valor para inserir na " + "pilha");
                    valor = scan.next().charAt(0);
                    if (!pilha.empilhar(new ItemChar(valor)))
                        System.out.println("Pilha está cheia");
                    break;

                case '2':
                    item = pilha.desempilhar();

                    if (item == null)
                        System.out.println("A pilha está vazia");
                    else
                        System.out.println(item.getChave());
                    break;

                case '3':
                    break;
                default:
                    System.out.println("fim do programa");
                    System.out.println("opção inválida, tente novamente");
            }

        } while (opcao != '3');
        System.exit(0);
    }

    public static char menu() {
        System.out.println("Escolha uma Opção:\n" +
                "1. empilhar\n" +
                "2. desempilhar\n" +
                "3. Sair");
        return scan.next().charAt(0);
    }
}