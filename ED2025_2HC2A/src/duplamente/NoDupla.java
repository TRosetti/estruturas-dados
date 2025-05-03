package duplamente;

import dados.Item;

public class NoDupla {
    private Item info; private NoDupla prox;
    private NoDupla ant;
        
    public NoDupla (Item elem){
        this.info = elem;
        this.prox = null;
        this.ant = null;
    }
    public Item getInfo (){
        return this.info;
    }
    public NoDupla getProx(){
        return this.prox;
    }
    public NoDupla getAnt(){
        return this.ant;
    }
    public void setProx(NoDupla novoNo){
        this.prox = novoNo;
    }
    public void setAnt(NoDupla novoNo){
        this.ant = novoNo;
    }
}