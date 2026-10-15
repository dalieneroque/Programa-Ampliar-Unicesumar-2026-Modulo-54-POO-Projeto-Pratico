public class Carro extends Veiculo {

    public Carro(String nome, String cor) {
        super(nome, cor);
    }

    @Override 
    public void acelerar() {
        setVelocidade(getVelocidade() + 2);
    }

}
