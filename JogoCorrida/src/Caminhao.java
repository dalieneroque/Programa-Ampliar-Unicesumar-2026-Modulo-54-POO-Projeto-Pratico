// A classe Caminhao herda os atributos e métodos da classe Veiculo.
public class Caminhao extends Veiculo {

    // Construtor da classe Caminhao e recebe o nome e a cor do caminhão como parâmetros.
    public Caminhao(String nome, String cor) {
        super(nome, cor); // Chama o construtor da classe pai (Veiculo), enviando o nome e a cor recebidos.

    }

    // Indica que estamos sobrescrevendo um método que já existe na classe Veiculo.
    @Override
    public void acelerar() {
        setVelocidade(getVelocidade() + 1); // Obtém a velocidade atual do caminhão, adiciona 1 e atualiza sua velocidade.

    }
}
