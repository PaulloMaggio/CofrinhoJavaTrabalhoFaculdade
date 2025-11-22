package CofrinhoJv;

import java.util.ArrayList;
import java.util.List;

public class listaMoedas {

    private List<Moeda> minhaLista = new ArrayList<>();

    public void adicionarMoeda(Moeda moeda) {
        minhaLista.add(moeda);
    }

    public boolean removerMoeda(Moeda moeda) {
        return minhaLista.remove(moeda);
    }

    public void removerMoeda(int indice) {
        if (indice >= 0 && indice < minhaLista.size()) {
            minhaLista.remove(indice);
        }
    }

    public void listagemMoedas() {
        if (minhaLista.isEmpty()) {
            System.out.println("O cofrinho está vazio!");
            return;
        }

        System.out.println("=== Moedas no cofrinho ===");
        for (int i = 0; i < minhaLista.size(); i++) {
            Moeda m = minhaLista.get(i);
            System.out.println((i + 1) + "ª moeda: R$ " + m.getValor());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Moeda m : minhaLista) {
            total += m.getValor();
        }
        return total;
    }
}
