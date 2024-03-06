package multiplos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int limite = scanner.nextInt();       

        int soma = 0;
        StringBuilder numerosMultiplos = new StringBuilder();

        for (int i = 1; i < limite; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                numerosMultiplos.append(i).append(", ");
                soma += i;
            }
        }

        System.out.println("Lista de todos os múltiplos de 3 ou 5 até " + limite + ": " + numerosMultiplos.toString());
        System.out.println("A soma é: " + soma);
	}

}
