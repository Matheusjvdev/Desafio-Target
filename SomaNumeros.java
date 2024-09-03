public class SomaNumeros {
    public static void main(String[] args) {
        int indice = 13;
        int soma = 0;
        int k = 0;

        while (k < indice) {
            k = k + 1;
            soma = soma + k;
        }

        System.out.println("A soma dos números de 1 a " + indice + " é: " + soma);
    }
}