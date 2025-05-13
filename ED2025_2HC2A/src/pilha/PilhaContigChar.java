package pilha;
import java.util.Scanner;

import dados.*;

public class PilhaContigChar {
    private ItemChar[] info;
    private int topo;

    public PilhaContigChar(int tamanho) {
        this.info = new ItemChar[tamanho];
        this.topo = 0;
    }

    public ItemChar getInfo() {
        return this.info[this.topo - 1];
    }

    public void setInfo(int i, ItemChar novo){
        this.info[i] = novo;
    }

    public int getTopo() {
        return this.topo;
    }
    
    public void setTopo(int i){
        this.topo = i;
    }

    public boolean eVazia() {
        return (this.topo == 0);
    }

    public boolean eCheia() {
        return (this.topo == this.info.length);
    }

    // inserir um novo dado no topo da pilha.
    public boolean empilhar(ItemChar elem) {
        if (this.eCheia())
            return false;
        else {
            this.info[this.topo] = elem;
            this.topo++;
            return true;
        }
    }

    // remove o dado que está no topo da pilha (somente um dado).
    public ItemChar desempilhar() {
        if (this.eVazia())
            return null;
        else {
            this.topo--;
            return this.info[this.topo];
        }
    }

    // ex1

    public String inverterFrase(String frase) {
        // Esvazia a pilha, se estiver com algo (por segurança)
        this.topo = 0;
    
        // Empilha cada caractere da frase
        for (int i = 0; i < frase.length(); i++) {
            this.empilhar(new ItemChar(frase.charAt(i)));
        }
    
        // Desempilha tudo em ordem reversa
        String resultado = "";
        while (!this.eVazia()) {
            resultado += this.desempilhar().getChave();
        }
    
        return resultado;
    }

    // ex6 

    public void removerAlunosChaveMaiorQue500(PilhaContigChar pilhaOriginal) {
        PilhaContigChar pilhaAux = new PilhaContigChar(pilhaOriginal.info.length); // Criando pilha auxiliar com mesma capacidade
    
        // Remove todos os elementos da pilha original
        while (!pilhaOriginal.eVazia()) {
            ItemChar aluno = pilhaOriginal.desempilhar(); // Desempilha um aluno (ItemChar)
            
            // Verifica se o aluno tem chave <= 500
            if (aluno.getChave() <= 500) {
                pilhaAux.empilhar(aluno); // Empilha alunos válidos na pilha auxiliar
            }
            // Se a chave for maior que 500, o aluno é descartado
        }
    
        // Devolve os elementos para a pilha original, mantendo a ordem
        while (!pilhaAux.eVazia()) {
            pilhaOriginal.empilhar(pilhaAux.desempilhar()); // Empilha os alunos restantes de volta na pilha original
        }
    }
    

    public boolean verificarSimetria(String X) {
        // Verifica se a string contém apenas 'A' e 'B'
        if (!X.matches("[AB]+")) {
            return false; // Não contém apenas 'A' e 'B'
        }
    
        int tamanho = X.length();
    
        // Se a string tiver comprimento ímpar, não pode ser simétrica dessa forma
        if (tamanho % 2 != 0) {
            return false;
        }
    
        PilhaContigChar pilha = new PilhaContigChar(tamanho / 2);
    
        // Empilha a primeira metade da string
        for (int i = 0; i < tamanho / 2; i++) {
            pilha.empilhar(new ItemChar(X.charAt(i)));
        }
    
        // Compara a segunda metade com o topo da pilha
        for (int i = tamanho / 2; i < tamanho; i++) {
            if (pilha.desempilhar().getChave() != X.charAt(i)) {
                return false; // Se não for igual, a string não é simétrica
            }
        }
    
        return true; // Se tudo foi validado, a string é simétrica
    }



    // ex fila circular

    int[] fila;         // array que armazena os elementos
    int inicio;         // índice do primeiro elemento
    int fim;            // índice onde o próximo será inserido
    int tamanho;        // quantidade atual de elementos na fila
    int capacidade;
    public boolean enfileirar(int elemento) {
        if (tamanho == capacidade) {
            // Fila cheia, não é possível inserir
            return false;
        }
    
        fila[fim] = elemento;
        fim = (fim + 1) % capacidade;  // avança circularmente
        tamanho++;
        return true;
    }

}