// A classe Moto herda os atributos e métodos da classe Veiculo.
public class Moto extends Veiculo{
    
    // Construtor da classe Moto e recebe o nome e a cor da moto como parâmetros.
    public Moto(String nome, String cor) {
        super(nome, cor); // Chama o construtor da classe pai (Veiculo), enviando o nome e a cor recebidos.
    }

    // Indica que estamos sobrescrevendo um método que já existe na classe Veiculo.
   @Override 
    public void acelerar() {
        setVelocidade(getVelocidade() + 3); // Obtém a velocidade atual da moto, adiciona 3 e atualiza sua velocidade.
    }
}
