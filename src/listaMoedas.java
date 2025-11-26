package CofrinhoJv;

import java.util.ArrayList;
import java.util.List;

// Classe que gerencia uma lista de moedas no cofrinho
public class listaMoedas {

    private List<Moeda> minhaLista = new ArrayList<>();

    // Adiciona uma moeda à lista
    public void adicionarMoeda(Moeda moeda) {
        minhaLista.add(moeda);
    }

    // Remove uma moeda específica
    public boolean removerMoeda(Moeda moeda) {
        return minhaLista.remove(moeda);
    }
 
    // Remove uma moeda pelo índice
    public void removerMoeda(int indice) {
        if (indice >= 0 && indice < minhaLista.size()) {
            minhaLista.remove(indice);
        }
    }

    //Lista todas as moedas com informações
    public void listagemMoedas() {
        if (minhaLista.isEmpty()) {
            System.out.println("O cofrinho está vazio!");
            return;
        }

        System.out.println("=== Moedas no cofrinho ===");
        for (int i = 0; i < minhaLista.size(); i++) {
            System.out.print((i + 1) + "ª moeda: ");
            minhaLista.get(i).info();
        }
    }

    // Calcula o total dos valores originais
    public double calcularTotal() {
        double total = 0;
        for (Moeda m : minhaLista) {
            total += m.getValor();
        }
        return total;
    }

    // Calcula o total convertido para Real
    public double calcularTotalConvertido() {
        double total = 0;
        for (Moeda m : minhaLista) {
            total += m.converter();
        }
        return total;
    }
}