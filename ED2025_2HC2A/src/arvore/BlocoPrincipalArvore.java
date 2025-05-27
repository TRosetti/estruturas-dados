package arvore;

import java.util.Scanner;
import dados.Item;

public class BlocoPrincipalArvore {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        int valor;
        Item[] vetor = new Item[10];
        char opcao;

        do {
            System.out.println("Escolha uma Opção:\n" +
                    "1. Inserir Nó na árvore\n" +
                    "2. Localizar Nó na árvore\n" +
                    "3. Excluir Nó da árvore\n" +
                    "4. Exibir árvore ordenada\n" +
                    "5. Sair");
            opcao = scan.next().charAt(0);
            switch (opcao) {
                case '1':
                    System.out.println("Digite um valor para inserir na árvore");
                    valor = scan.nextInt();

                    if (arvore.inserir(new Item(valor))) {
                        System.out.println("inserção efetuada com sucesso");
                    } else {
                        System.out.println("valor já existe na árvore");
                    }
                    break;
                case '2':

                    if (arvore.eVazia()) {
                        System.out.println("Árvore está vazia");
                    } else {
                        System.out.println("Digite o valor para pesquisar");
                        valor = scan.nextInt();
                        if (arvore.pesquisar(valor)) {
                            System.out.println(valor + "foi encontrado");
                        } else {
                            System.out.println(valor + "não encontrado");
                        }
                    }
                    break;
                case '3':

                    if (arvore.eVazia()) {
                        System.out.println("Arvore está vazia");
                    } else {
                        System.out.println("Digite um valor para excluir");
                        valor = scan.nextInt();
                        if (arvore.remover(valor)) {
                            System.out.println("remoção efetuada");
                        } else {
                            System.out.println("valor não encontrado");
                        }
                    }
                    break;
                case '4':

                    if (arvore.eVazia()) {
                        System.out.println("A árvore está vazia");
                    } else {
                        vetor = arvore.CamCentral();
                        String msg = " ";
                        for (int i = 0; i < arvore.getQuantNos(); i++) {
                            msg += vetor[i].getChave() + " ";
                        }
                        System.out.println("Exibir a árvore: " + msg);
                    }
                    break;
                case '5':

                    System.out.println("fim do programa");
                    break;
                default:
                    System.out.println("opção inválida, tente novamente");
            }
        } while (opcao != '5');
        System.exit(0);
    }
}