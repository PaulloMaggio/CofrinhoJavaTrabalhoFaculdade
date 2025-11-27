
package cofrinho;

public class Real extends Moeda {        // HERANÇA de Moeda

    public Real(double valor) {
        super(valor);                    // chama construtor da classe pai
    }

    @Override
    public void info() {
        System.out.printf("Moeda Brasileira - R$ %.2f%n", valor);
    }

    @Override
    public double converter() {
        return valor;                    // já está em Real → sem conversão
    }
}