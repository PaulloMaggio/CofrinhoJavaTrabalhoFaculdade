
package cofrinho;

/**
 * Classe abstrata Moeda - define o contrato que toda moeda deve seguir
 * HERANÇA: todas as moedas específicas herdam desta classe
 * Não pode ser instanciada diretamente (abstract)
 */
public abstract class Moeda {
    protected double valor; // protegido para as subclasses acessarem diretamente

    // Construtor protegido - só subclasses podem chamar
    protected Moeda(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    // Toda moeda deve saber se apresentar
    public abstract void info();

    // Toda moeda deve saber se converter para Real
    public abstract double converter();
}