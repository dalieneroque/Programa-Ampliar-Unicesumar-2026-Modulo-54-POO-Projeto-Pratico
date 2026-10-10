import java.lang.classfile.ClassElement;

public class Main {

    public static void main(String[] args) {
 
        Carro carroMazda = new Carro("Mazda rx-7", "Vermelho");

        carroMazda.acelerar();
        carroMazda.setVelocidade(400);
        carroMazda.mover();

        System.out.println(" Velocidade do Carro Mazda rx-7 = " + carroMazda.getVelocidade() + " A posição é " + carroMazda.getPosicao());
        System.out.println(" O nome do carro é " + carroMazda.getNome());                
    }

}