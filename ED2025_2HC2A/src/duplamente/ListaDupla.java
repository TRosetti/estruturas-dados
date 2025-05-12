package duplamente;

import dados.Item;

public class ListaDupla {
    private NoDupla prim;
    private NoDupla ult;
    private int quantNos;

    public ListaDupla() {
        this.prim = null;
        this.ult = null;
        this.quantNos = 0;
    }

    public int getQuantNos() {
        return this.quantNos;
    }

    public NoDupla getPrim() {
        return this.prim;
    }

    public NoDupla getUlt() {
        return this.ult;
    }

    public void setQuantNos(int valorNovo) {
        this.quantNos = valorNovo;
    }

    public void setPrim(NoDupla novoNo) {
        this.prim = novoNo;
    }

    public void setUlt(NoDupla novoNo) {
        this.ult = novoNo;
    }

    public boolean eVazia() {
        return (this.prim == null);
    }

    // insere um novo nó no final da lista ou se a lista estiver vazia, insere
    // o primeiro nó na lista
    public void inserirUltimo(Item elem) {
        NoDupla novoNo = new NoDupla(elem);
        if (this.eVazia())
            this.prim = novoNo;
        else {
            novoNo.setAnt(this.ult);
            this.ult.setProx(novoNo);
        }
        this.ult = novoNo;
        this.quantNos++;
    }

    // retorna o endereço do nó que está contendo o valor a ser procurado.
    public NoDupla pesquisarNo(int chave) {
        NoDupla atual = this.prim;
        while ((atual != null) && (atual.getInfo().getChave() != chave))
            atual = atual.getProx();
        return atual;
    }

    // remove um determinado nó em qualquer posição na lista.
    public boolean removerNo(int chave) {
        NoDupla atual = this.prim;
        while ((atual != null) && (atual.getInfo().getChave() != chave)) {
            atual = atual.getProx();
        }
        if (atual == null)
            return false;
        else if (atual == this.prim) {
            this.prim = prim.getProx();
            if (this.prim == null) // se a lista tem somente um nó
                this.ult = null;
            else
                this.prim.setAnt(null);
        } else if (atual == this.ult) {
            this.ult = this.ult.getAnt();
            this.ult.setProx(null);
        } else {
            atual.getProx().setAnt(atual.getAnt());
            atual.getAnt().setProx(atual.getProx());
        }
        this.quantNos--;
        return true;
    }

    public String toString() {
        String msg = "";
        NoDupla atual = this.prim;
        while (atual != null) {
            msg += atual.getInfo().getChave() + "\n";
            atual = atual.getProx();
        }
        return msg;
    }


    // Lista 5 
    
    // Ex1 
    public void concatenarDuasListas(ListaDupla lista1, ListaDupla lista2){
        if(lista2.eVazia()){
            System.out.println("Lista 2 vazia");
            return; // finaliza o programa
        }

        if(lista1.eVazia()){
            // caso não tenha item na lista 1 
            this.prim = lista2.getPrim();
            this.ult = lista2.getUlt();
        }else{
            lista1.getUlt().setProx(lista2.getPrim());
            lista2.getPrim().setAnt(lista1.getUlt());
            lista1.setUlt(lista2.getUlt());
            lista1.quantNos += lista2.getQuantNos();
        }
        // limpa a lista 2
        lista2.setPrim(null);
        lista2.setUlt(null);
        lista2.setQuantNos(0);

        
    }

    // Ex2

    public void partirListaMeio(ListaDupla lista1){
        if(lista1.eVazia()){
            System.out.println("Lista 1 vazia");
            return; // finaliza o programa
        }
        if(lista1.getQuantNos() == 1){
            System.out.println("Lista 1 tem apenas um nó");
            return; // finaliza o programa
        }
        NoDupla atual = lista1.getPrim();
        int meio = lista1.getQuantNos()/2;

        for(int i = 1; i < meio; i++){ // adicionando 1 para não entrar no meio (fica no anterior ao meio)
            atual = atual.getProx();
        }
        // atual está no meio da lista 

        ListaDupla novaLista = new ListaDupla();
        novaLista.setPrim(atual.getProx());
        novaLista.setUlt(lista1.getUlt());
        this.ult = atual;
        this.ult.setProx(null);
        novaLista.getPrim().setAnt(null);
        
        novaLista.setQuantNos(lista1.getQuantNos() - meio);
        this.setQuantNos(meio);
       
        

        System.out.println("Lista 1: \n" + lista1.toString());
        System.out.println("");
        System.out.println("Lista1 quantNos: " + lista1.getQuantNos());
        System.out.println("Lista1 prim: " +lista1.getPrim().getInfo().getChave());
        System.out.println("Lista1 ult: " +lista1.getUlt().getInfo().getChave());
        System.out.println("");
        System.out.println("NovaLista: \n"+ novaLista.toString());
        System.out.println("");
        System.out.println("NovaLista quantNos: " + novaLista.getQuantNos());
        System.out.println("NovaLista prim: " +novaLista.getPrim().getInfo().getChave());
        System.out.println("NovaLista ult: " +novaLista.getUlt().getInfo().getChave());
        System.out.println("");
        
    }

    // Ex3

    public void mostrarMaiorValor(ListaDupla lista1){
        if(lista1.eVazia()){
            System.out.println("Lista 1 vazia");
            return; // finaliza o programa
        }else{
            NoDupla atual = lista1.getPrim();
            Item maior = atual.getInfo();

            while(atual != null){
                if(atual.getInfo().getChave() > maior.getChave()){
                    maior = atual.getInfo();
                }
                atual = atual.getProx();
            }
            System.out.println("Maior valor: " + maior.getChave());
        }
        
    }


    // Ex4
    
    public double calcularMedia(ListaDupla lista){
        NoDupla atual = lista.getPrim();
        int tamanho = lista.getQuantNos();
        double soma = 0; // estava com int, mas o calculo da média dava erro, não mostrava a casa decimal por causa disso
        double resultado = 0;
        

        if(lista.eVazia()){
            return -1; 
        }else{

            for(int i = 0; i < tamanho; i++){
                soma += atual.getInfo().getChave();
                atual = atual.getProx();
            }

            resultado = soma/tamanho; // se um item for int, pode dar erro se tiver casa decimal 
           // resultado = (double) soma/tamanho; // assim, se a somar for int, vai forçar a mostrar um double


            return resultado;
        }
        
    }

    // Ex5
    
    public boolean retirarZero(ListaDupla lista){
        NoDupla atual = lista.getPrim();
        int tamanho = lista.getQuantNos();
        // precisa alterar o quantNos depois 

        if(eVazia()){
            return false;
        }            
            
        while (atual != null) {
            if (atual.getInfo().getChave() == 0) {
                NoDupla proximo = atual.getProx();
    
                // Caso seja o primeiro nó
                if (atual == lista.getPrim()) {
                    lista.setPrim(proximo);
                    if (proximo != null) {
                        proximo.setAnt(null);
                    }
                }
                // Caso seja o último nó
                else if (atual == lista.getUlt()) {
                    NoDupla anterior = atual.getAnt();
                    lista.setUlt(anterior);
                    if (anterior != null) {
                        anterior.setProx(null);
                    }
                }
                // Caso esteja no meio
                else {
                    NoDupla anterior = atual.getAnt();
                    anterior.setProx(proximo);
                    proximo.setAnt(anterior);
                }
    
                atual = proximo; // avança para o próximo
            } else {
                atual = atual.getProx(); // avança normalmente
            }
        }
        

       return true;

        
    }

    // Ex6
    public void retirarRepetidos() {
        NoDupla atual = this.prim;
        NoDupla comparador, proximo;
        
    
        while (atual != null) { 
            comparador = atual.getProx();
    
            while (comparador != null) {
                proximo = comparador.getProx();
    
                if (comparador.getInfo().getChave() == atual.getInfo().getChave()) {
                    // Remover o nó comparador
                    if (comparador == this.ult) {
                        this.ult = comparador.getAnt();
                        if (this.ult != null) {
                            this.ult.setProx(null);
                        }
                    } else {
                        comparador.getAnt().setProx(comparador.getProx());
                        comparador.getProx().setAnt(comparador.getAnt());
                    }
                    this.quantNos--; // Atualiza o contador
                }
    
                comparador = proximo;
            }
    
            atual = atual.getProx();
        }
    }
    
}
