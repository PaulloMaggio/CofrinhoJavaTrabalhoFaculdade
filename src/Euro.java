// Classe que representa a moeda Euro, extendendo Moeda
public class Euro extends Moeda {
    private static final double TAXA_CONVERSAO = 6.2; // Taxa aproximada EUR para BRL

    // Construtor
    public Euro(double valor) {
        super(valor);
    }

    @Override
    void info() {
        System.out.println("Euro - Valor: " + getValor());
    }

    @Override
    double converter() {
        return getValor() * TAXA_CONVERSAO;
    }
}