
import java.util.Scanner;

public class Cofrinho {

    public static void main(String[] args) {
        listaMoedas cofrinho = new listaMoedas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Loop do menu para interagir com o cofrinho
        do {
            System.out.println("\n=== Menu Cofrinho ===");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Calcular total");
            System.out.println("5. Calcular total convertido para Real");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor: ");
                    String inputValor = scanner.nextLine().replace(',', '.');
                    double valor = Double.parseDouble(inputValor);
                    System.out.print("Digite o tipo (Dolar/Euro/Real): ");
                    String tipo = scanner.nextLine().trim().toLowerCase();
                    Moeda moeda;
                    // Cria a moeda com base no tipo escolhido

if (tipo.equals("dolar")) {
                        moeda = new Dolar(valor);
                    } else if (tipo.equals("euro")) {
                        moeda = new Euro(valor);
                    } else if (tipo.equals("real")) {
                        moeda = new Real(valor);
                    } else {
                        System.out.println("Tipo inválido!");
                        continue;
                    }
                    cofrinho.adicionarMoeda(moeda);
                    System.out.println("Moeda adicionada!");
                    break;
                case 2:
                    System.out.print("Digite o índice da moeda a remover (começando de 1): ");
                    int indice = scanner.nextInt() - 1;
                    scanner.nextLine();
                    cofrinho.removerMoeda(indice);
                    System.out.println("Moeda removida!");
                    break;
                case 3:
                    cofrinho.listagemMoedas();
                    break;
                case 4:
                    System.out.println("Total: R$ " + cofrinho.calcularTotal());
                    break;
                case 5:
                    System.out.println("Total convertido: R$ " + cofrinho.calcularTotalConvertido());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}