package fila;

import dados.Item;
import dados.ItemChar;
import pilha.PilhaContigChar;

public class FilaCircular {
    private Item[] info;
    private int frente;
    private int tras;
    private int tamanho;

    public FilaCircular(int qte) {
        this.frente = 0;
        this.tras = 0;
        this.tamanho = 0;
        this.info = new Item[qte];
    }

    public Item getInfo() {
        return this.info[this.frente];
    }

    public int getFrente() {
        return this.frente;
    }

    public int getTras() {
        return this.tras;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean eVazia() {
        return (this.tamanho == 0);
    }

    public boolean eCheia() {
        return (this.tamanho == this.info.length);
    }

    public boolean enfileirar(Item elem) {
        if (this.eCheia())
            return false;
        else {
            this.info[this.tras] = elem;
            this.tras = (++this.tras % this.info.length);
            this.tamanho++;
            return true;
        }
    }

    public Item desenfileirar() {
        Item no;
        if (this.eVazia())
            return null;
        else {
            no = this.info[this.frente];
            this.frente = (++this.frente % this.info.length);
            this.tamanho--;
            return no;
        }
    }

    public String toString() { // imprimir o conteúdo da fila
        String msg = "";
        int aux = this.frente;
        for (int i = 1; i <= this.tamanho; i++) {
            msg += this.info[aux].getChave() + " ";
            aux = (++aux % this.info.length);
        }
        return msg;
    }


    // ex2

    public int somaFilaCircular() {
        int soma = 0;
        
        // Enquanto a fila não estiver vazia
        while (!this.eVazia()) {
            // Desenfileira o elemento da frente
            Item item = this.desenfileirar();
            
            // Adiciona o valor à soma
            soma += (int) item.getChave(); // Assume que o Item é do tipo inteiro
        }
        
        return soma; // Retorna a soma dos elementos
    }


    // ex3

    public FilaCircular transferirPilhaParaFila(PilhaContigChar pilha) {
        FilaCircular fila = new FilaCircular(pilha.getTopo()); // Criamos uma nova fila com capacidade suficiente para os elementos da pilha
        
        // Enquanto a pilha não estiver vazia
        while (!pilha.eVazia()) {
            // Desempilha o elemento da pilha
            ItemChar itemPilha = pilha.desempilhar();
            
            // Enfileira o item na fila
            fila.enfileirar(new Item(itemPilha.getChave())); // Enfileira o inteiro correspondente
        }
        
        return fila; // Retorna a fila preenchida com os elementos da pilha
    }


    // ex6

    public boolean inserirAcimaDeDez(int valor) {
        if (this.eCheia()) {
            // Não há espaço para inserção
            return false;
        }
        
        // Variáveis para controle do loop
        int auxFrente = this.getFrente();
        int auxTamanho = this.getTamanho();
        
        // Percorre os elementos da fila
        for (int i = 0; i < auxTamanho; i++) {
            // Verifica se o valor atual é 10
            if (this.info[auxFrente].getChave() == 10) {
                // Verifica se há espaço na fila
                if (this.eCheia()) {
                    return false; // Não há espaço para mais elementos
                }
                
                // Enfileira o novo valor após o 10
                int posicaoNova = (this.getTras() + 1) % this.info.length;
                this.info[posicaoNova] = new Item(valor);
                this.tras = posicaoNova;
                this.tamanho++;
            }
            
            // Move para o próximo elemento da fila circular
            auxFrente = (++auxFrente % this.info.length);
        }
        
        return true; // Inserção bem-sucedida
    }
    
}