package testeJava;
import java.util.Scanner;

public class PrimeiroProgramaJava {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1;
		int num2;
		System.out.println("Digite o valor do num1:");
		num1 = scan.nextInt();
		System.out.println("Digite o valor do num2:");
		num2 = scan.nextInt();
		System.out.println("a soma � "+ (num1+num2));
		//comando de decis�o
		if (num1 > 10) {
			System.out.println("o valor de num1 � maior que 10");
		} else {
			if (num1 == 10) {
				System.out.println("o valor de num1 � igual a 10");
			} else {
				System.out.println("o valor de num1 � menor que 10");
			}
		}
		//comandos de repeti��o
		int i = 0;
		System.out.println("while");
		while (i < 5) {
			System.out.println("i = " + i);
			i++;
		}
		System.out.println("for");
		for ( i=0; i < 5; i++) {
			System.out.println("i = " + i);
			
		}
		System.out.println("do while");
		i = 0;
		do {
			System.out.println("i = " + i);
			i++;
		}while (i< 5);
		
	}
}
