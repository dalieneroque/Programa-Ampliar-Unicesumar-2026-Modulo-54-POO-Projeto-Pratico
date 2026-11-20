// A classe Carro herda os atributos e métodos da classe Veiculo.
public class Carro extends Veiculo {
    
    // Construtor da classe Carro e recebe o nome e a cor do carro como parâmetros.
    public Carro(String nome, String cor) {
        super(nome, cor); // Chama o construtor da classe pai (Veiculo), enviando o nome e a cor recebidos.
    }

    // Indica que estamos sobrescrevendo um método que já existe na classe Veiculo.
    @Override 
    public void acelerar() {
        setVelocidade(getVelocidade() + 2); // Obtém a velocidade atual do carro, adiciona 2 e atualiza sua velocidade.
    }

}
