// Classe abstrata que representa uma moeda genérica
public abstract class Moeda {
    private double valor; 

    // Construtor que inicializa o valor da moeda
    public Moeda(double valor) {
        this.valor = valor;
    }

    // Retorna o valor da moeda
    public double getValor() {
        return valor;
    }

    // Método abstrato para exibir informações da moeda
    abstract void info();
    
    // Método abstrato para converter o valor (para Real)
    abstract double converter();
}