package pilha;
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

    // ex6 

    public String inverterPalavra(String palavra){
        String resposta = "";
        for(int i=0; i<palavra.length(); i++){
            this.empilhar(new ItemChar(palavra.charAt(i)));
        }
        while(!this.eVazia()){
            resposta += this.desempilhar().getChave();
        }

        return resposta;
    }
}