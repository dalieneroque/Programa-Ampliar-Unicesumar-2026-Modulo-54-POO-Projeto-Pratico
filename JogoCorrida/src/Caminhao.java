public class Caminhao extends Veiculo {
    
    public Caminhao(String nome, String cor) {
        super(nome, cor);
    }

    @Override 
    public void acelerar() {
        setVelocidade(getVelocidade() + 1);
    }
}
