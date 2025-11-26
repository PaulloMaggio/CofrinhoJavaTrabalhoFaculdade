// Classe que representa a moeda Dolar, extendendo Moeda
public class Dolar extends Moeda {
    private static final double TAXA_CONVERSAO = 5.4; // Taxa aproximada USD para BRL

    // Construtor
    public Dolar(double valor) {
        super(valor);
    }

    @Override
    void info() {
        System.out.println("Dolar - Valor: " + getValor());
    }

    @Override
    double converter() {
        return getValor() * TAXA_CONVERSAO;
    }
}