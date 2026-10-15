public abstract class Veiculo {
    private String nome;
    private String cor; 
    private int velocidade;
    private int posicao;

    public Veiculo (String Nome, String cor) {
        this.nome = Nome;
        this.cor = cor;
        this.velocidade = 0;
        this.posicao = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getcor() {
        return cor;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setVelocidade(int velocidade) {
        if (velocidade < 0) {
            velocidade = 0;
        }
        if (velocidade > 10) {
            velocidade = 10;
        }

        this.velocidade = velocidade;
    }

    public abstract void acelerar(); {
        
    }


    public void mover() {
        posicao += velocidade;       
    }
}








// Abstração: focamos no que o objeto faz, sem precisar definir todos os detalhes na classe base.

// A classe Veiculo define o que deve existir, mas não como será feito.