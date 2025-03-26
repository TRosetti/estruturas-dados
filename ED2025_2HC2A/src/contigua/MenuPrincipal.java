package contigua;

import java.util.Scanner;
import dados.Item;

public class MenuPrincipal {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("digite o tamanho máximo da lista");
        int tam = scan.nextInt();
        ListaContig lista = new ListaContig(tam);
        int valor;
        char opcao;
        do {
            System.out.println("Escolha uma Opção:\n" +
                    "1. Inserir Nó no final\n" +
                    "2. Localizar Nó\n" +
                    "3. Excluir Nó\n" +
                    "4. Exibir lista\n" +
                    "5. Sair");
            opcao = scan.next().charAt(0);
            switch (opcao) {
                case '1':
                    System.out.println("Inserir um Valor no final da lista\n"
                            + "Digite um valor");
                    valor = scan.nextInt();
                    if (!lista.inserirUltimo(new Item(valor))) {
                        System.out.println("Lista está cheia");
                    }
                case '2':

                    if (lista.eVazia()) {
                        System.out.println("A lista está vazia");
                    } else {

                        System.out.println("Digite o valor para localizar");
                        valor = scan.nextInt();
                        int pesqNo = lista.pesquisarNo(valor);

                        if (pesqNo == lista.getFim()) {
                            System.out.println("Não encontrado\n");
                        } else {
                            System.out.println("Está na posição " + pesqNo);
                        }
                    }

                    break;

                case '3':

                    if (lista.eVazia()) {
                    } else {
                        System.out.println("A lista está vazia");
                        System.out.println("Digite um valor para excluí-lo:");
                        valor = scan.nextInt();
                        if (lista.removerNo(valor)) {
                            System.out.println("remoção efetuada");
                        } else {
                            System.out.println("remoção não efetuada," +
                                    " valor não encontrado");
                        }
                    }
                case '4':
                  
                    if (lista.eVazia()) {
                        System.out.println("A lista está vazia");
                    } else {
                        System.out.println("Exibir a lista" + lista.toString());
                    }

                    break;
                case '5':

                    System.out.println("fim do programa");
                default:
                    System.out.println("opção invalida, tente novamente");
            }
        } while (opcao != '5');
        System.exit(0);
    }
}