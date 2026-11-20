
public abstract class Veiculo { // Declara a classe abstrata Veiculo, que servirá como modelo para os demais veículos.

    private String nome; // Atributo privado que armazena o nome do veículo.
    private String cor; // Atributo privado que armazena a cor do veículo.
    private int velocidade; // Atributo privado que armazena a velocidade atual do veículo.
    private int posicao; // Atributo privado que armazena a posição atual do veículo.

    public Veiculo (String nome, String cor) { // Construtor responsável por receber o nome e a cor do veículo.
        this.nome = nome; // Atribui o nome recebido ao atributo nome do próprio objeto.
        this.cor = cor; // Atribui a cor recebida ao atributo cor do próprio objeto.
        this.velocidade = 0; // Inicializa a velocidade do veículo em zero.
        this.posicao = 0; // Inicializa a posição do veículo em zero.
    }

    public abstract void acelerar(); // Método abstrato que deverá ser implementado pelas classes filhas, cada uma com sua própria aceleração.

    public void mover() { // Método responsável por movimentar o veículo durante a corrida.
        posicao += velocidade; // Atualiza a posição somando a velocidade atual do veículo.
    }

    public String getNome() { return nome;} // Getter que retorna o nome do veículo.
    public String getcor() { return cor;} // Getter que retorna a cor do veículo.
    public int getVelocidade() { return velocidade; } // Getter que retorna a velocidade atual do veículo.
    public int getPosicao() { return posicao; } // Getter que retorna a posição atual do veículo.

    public void setVelocidade(int velocidade) { // Setter que permite atualizar a velocidade do veículo.
        if (velocidade < 0) { // Verifica se a velocidade informada é menor que zero.
            velocidade = 0; // Se for negativa, define a velocidade como zero.
        }
        if (velocidade > 10) { // Verifica se a velocidade informada ultrapassa o limite máximo.
            velocidade = 10; // Se ultrapassar, limita a velocidade ao valor máximo de 10.
        }

        this.velocidade = velocidade; // Atualiza o atributo velocidade com o valor validado.
    }

    public void resetar() { // Método responsável por reiniciar os valores do veículo.
        this.posicao=0; // Retorna a posição do veículo ao ponto inicial.
        this.velocidade=0; // Zera a velocidade do veículo.
    }

}
