
package cofrinho;

import java.util.Scanner;

/**
 * Classe principal do programa - contém o menu interativo e o método main
 * Responsável por coordenar toda a interação com o usuário
 */
public class Main {

    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();  // Objeto que representa o cofrinho físico
        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.println("Bem-vindo ao Cofrinho Digital!");

        // Loop principal do programa - roda até o usuário escolher sair
        do {
            exibirMenu();
            opcao = lerOpcao(sc);

            switch (opcao) {
                case 1 -> adicionarMoeda(cofrinho, sc);                    // Adiciona nova moeda
                case 2 -> removerMoeda(cofrinho, sc);                      // Remove moeda por índice
                case 3 -> cofrinho.listarMoedas();                         // Mostra todas as moedas
                case 4 -> exibirTotalConvertido(cofrinho);                 // Mostra valor total em reais
                case 0 -> System.out.println("Obrigado por usar o Cofrinho! Até logo!");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        sc.close(); // Boa prática: sempre fechar o Scanner
    }

    // Exibe o menu de opções formatado
    private static void exibirMenu() {
        System.out.println("\n" + "=".repeat(30));
        System.out.println("     COFRINHO DE MOEDAS");
        System.out.println("=".repeat(30));
        System.out.println("1. Adicionar moeda");
        System.out.println("2. Remover moeda");
        System.out.println("3. Listar moedas");
        System.out.println("4. Calcular total em Real");
        System.out.println("0. Sair");
        System.out.println("=".repeat(30));
        System.out.print("Escolha uma opção: ");
    }

    // Lê e valida a opção do menu
    private static int lerOpcao(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Por favor, digite um número válido: ");
            sc.next(); // descarta entrada inválida
        }
        return sc.nextInt();
    }

    // Método responsável por adicionar uma moeda com validação completa
    private static void adicionarMoeda(Cofrinho cofrinho, Scanner sc) {
        sc.nextLine(); // limpa o buffer após o nextInt()

        System.out.print("Digite o valor da moeda: ");
        double valor = lerDoubleValido(sc);

        System.out.print("Tipo da moeda (real / dolar / euro): ");
        String tipo = sc.nextLine().trim().toLowerCase();

        Moeda moeda = switch (tipo) {
            case "real"  -> new Real(valor);
            case "dolar" -> new Dolar(valor);
            case "euro"  -> new Euro(valor);
            default -> {
                System.out.println("Tipo de moeda inválido! Use: real, dolar ou euro.");
                yield null;
            }
        };

        if (moeda != null) {
            cofrinho.adicionar(moeda);
            System.out.println("Moeda adicionada com sucesso!");
        }
    }

    // Método auxiliar para garantir que o valor digitado seja um número válido
    private static double lerDoubleValido(Scanner sc) {
        while (true) {
            String entrada = sc.nextLine().replace(',', '.');
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido! Digite um número (ex: 10.50): ");
            }
        }
    }

    // Remove uma moeda com segurança (verifica índice)
    private static void removerMoeda(Cofrinho cofrinho, Scanner sc) {
        if (cofrinho.isVazio()) {
            System.out.println("O cofrinho está vazio! Nada para remover.");
            return;
        }

        cofrinho.listarMoedas();
        System.out.print("Digite o número da moeda a remover: ");
        int indice = sc.nextInt() - 1; // usuário vê de 1 em diante
        sc.nextLine(); // limpa buffer

        if (cofrinho.remover(indice)) {
            System.out.println("Moeda removida com sucesso!");
        } else {
            System.out.println("Número inválido! Nenhuma moeda foi removida.");
        }
    }

    // Exibe o total convertido com formatação bonita
    private static void exibirTotalConvertido(Cofrinho cofrinho) {
        double total = cofrinho.calcularTotalConvertido();
        System.out.printf("TOTAL CONVERTIDO EM REAIS: R$ %.2f%n", total);
    }
}