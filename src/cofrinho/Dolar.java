// src/cofrinho/Dolar.java
package cofrinho;

public class Dolar extends Moeda {       // HERANÇA de Moeda

    private static final double TAXA_CONVERSAO = 5.70; // atualizado em 26/11/2025

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.printf("Dólar Americano - $ %.2f (taxa: R$ %.2f)%n", valor, TAXA_CONVERSAO);
    }

    @Override
    public double converter() {
        return valor * TAXA_CONVERSAO;   // converte Dólar → Real
    }
}