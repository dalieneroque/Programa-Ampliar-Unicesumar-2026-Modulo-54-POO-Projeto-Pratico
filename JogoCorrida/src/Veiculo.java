public abstract class Veiculo {
    //Encapsulamento: atributos privados
    private String nome;    
    private String cor; 
    private int velocidade;
    private int posicao;

    //Construtur da classe Veiculo 
    public Veiculo (String Nome, String cor) {
        this.nome = Nome;
        this.cor = cor;
        this.velocidade = 0;
        this.posicao = 0;
    }

    //Método abstrato: cada veículo acelera do seu jeito
    public abstract void acelerar(); {
        
    }

    // Atualiza a posição do veículo somando o valor da velocidade
    public void mover() {
        posicao += velocidade;       
    }

    // Getters e Setters 
    public String getNome() { return nome;}
    public String getcor() { return cor;}
    public int getVelocidade() { return velocidade; }
    public int getPosicao() { return posicao; }

    public void setVelocidade(int velocidade) {
        if (velocidade < 0) {
            velocidade = 0;
        }
        if (velocidade > 10) {
            velocidade = 10;
        }

        this.velocidade = velocidade;
    }   


}