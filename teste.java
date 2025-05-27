import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
    }

    public int recursividade1(int a, int b){
        if(b == 0){
            return a;
        }else{
            return recursividade1(b, a % b);
        }
        
    }
}
