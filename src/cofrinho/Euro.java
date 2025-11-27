
package cofrinho;

public class Euro extends Moeda {        // HERANÇA de Moeda

    private static final double TAXA_CONVERSAO = 6.20; // atualizado em 26/11/2025

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.printf("Euro - € %.2f (taxa: R$ %.2f)%n", valor, TAXA_CONVERSAO);
    }

    @Override
    public double converter() {
        return valor * TAXA_CONVERSAO;   // converte Euro → Real
    }
}