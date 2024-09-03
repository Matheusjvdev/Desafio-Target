import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

         if
 (pertenceFibonacci(numero)) {
            System.out.println(numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(numero + " não pertence à sequência de Fibonacci.");
        }

        scanner.close(); 

    }

    public static boolean pertenceFibonacci(int numero) {
        int a = 0, b = 1, c;

        
        if (numero == a || numero == b) {
            return true;
        }

        
        while (b < numero) {
            c = a + b;
            a = b;
            b = c;
        }

        return b == numero; 
    }
}