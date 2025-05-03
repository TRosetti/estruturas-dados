package pilha;

public class TestarPilha {
    public static void main(String[] args) {
        PilhaContigChar pilha = new PilhaContigChar(1000);
        String palavra = "dado";
        String invertida;
        invertida = pilha.inverterPalavra(palavra);
        System.out.println("Palavra Invertida = " + invertida);

        
    }
    
}
