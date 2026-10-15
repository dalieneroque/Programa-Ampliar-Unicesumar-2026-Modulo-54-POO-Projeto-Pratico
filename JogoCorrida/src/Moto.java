public class Moto extends Veiculo{
    
    public Moto(String nome, String cor) {
        super(nome, cor);
    }

   @Override 
    public void acelerar() {
        setVelocidade(getVelocidade() + 3);
    }
}
