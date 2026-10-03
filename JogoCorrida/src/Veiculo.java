public class Veiculo {
    String nome;
    String cor; 
    int velocidade;
    int posicao;

    public Veiculo (String Nome, String cor) {
        this.nome = Nome;
        this.cor = cor;
        this.velocidade = 0;
        this.posicao = 0;
    }

    public void acelerar() {
        velocidade++;
    }

    public void mover() {
        posicao += velocidade;       
    }
}
