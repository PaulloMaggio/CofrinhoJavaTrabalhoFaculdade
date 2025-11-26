// Classe que representa a moeda Real, extendendo Moeda
public class Real extends Moeda {

    // Construtor
    public Real(double valor) {
        super(valor);
    }

    @Override
    void info() {
        System.out.println("Real - Valor: " + getValor());
    }

    @Override
    double converter() {
        return getValor(); // Já em Real, sem conversão
    }
}