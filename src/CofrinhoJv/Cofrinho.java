package CofrinhoJv;

import java.util.Scanner;

public class Cofrinho {

	public static void main(String[] args) {
		listaMoedas cofrinho = new listaMoedas();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o valor: ");
		
		String moeda = scanner.nextLine().replace(',', '.');
		double valor = Double.parseDouble(moeda);

		System.out.println("Valor convertido: " + valor);

		cofrinho.adicionarMoeda(new Moeda(valor));
		       

		cofrinho.listagemMoedas();
		System.out.println("Total: R$ " + cofrinho.calcularTotal());
		    }
}
