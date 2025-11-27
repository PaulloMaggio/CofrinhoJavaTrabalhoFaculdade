
package cofrinho;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Cofrinho - representa o cofrinho físico
 * Responsável por armazenar, listar, adicionar e remover moedas
 * Usa List<Moeda> → aceita qualquer moeda graças ao POLIMORFISMO
 */
public class Cofrinho {
    // Encapsulamento: lista privada, só acessível pelos métodos da classe
    private final List<Moeda> moedas = new ArrayList<>();

    /**
     * Adiciona uma moeda ao cofrinho
     * @param m - qualquer objeto que seja do tipo Moeda (ou suas subclasses)
     */
    public void adicionar(Moeda m) {
        if (m != null && m.getValor() > 0) {
            moedas.add(m);
        }
    }

    /**
     * Remove moeda pelo índice (índice começa em 0 internamente)
     * @param indice - posição da moeda na lista
     * @return true se removeu, false se índice inválido
     */
    public boolean remover(int indice) {
        if (indice >= 0 && indice < moedas.size()) {
            moedas.remove(indice);
            return true;
        }
        return false;
    }

    /**
     * Lista todas as moedas com número e informações específicas
     * Usa POLIMORFISMO: chama info() de cada moeda (comportamento diferente)
     */
    public void listarMoedas() {
        if (moedas.isEmpty()) {
            System.out.println("O cofrinho está vazio!");
            return;
        }

        System.out.println("\nMoedas no cofrinho:");
        System.out.println("-".repeat(40));
        for (int i = 0; i < moedas.size(); i++) {
            System.out.printf("%d - ", i + 1);
            moedas.get(i).info();  // POLIMORFISMO: cada moeda imprime do seu jeito
        }
        System.out.println("-".repeat(40));
    }

    /**
     * Calcula o valor total convertido para Real
     * Usa POLIMORFISMO: cada moeda sabe como se converter
     */
    public double calcularTotalConvertido() {
        double total = 0.0;
        for (Moeda m : moedas) {
            total += m.converter();  // Comportamento diferente para Real, Dólar e Euro
        }
        return total;
    }

    /** Verifica se o cofrinho está vazio */
    public boolean isVazio() {
        return moedas.isEmpty();
    }
}