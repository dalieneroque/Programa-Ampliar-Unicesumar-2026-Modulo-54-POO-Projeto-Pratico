public class Main {

    public static void main(String[] args) {

        
        Veiculo carroUno = new Veiculo("Uno", "Branco");

        carroUno.acelerar();
        carroUno.mover();


        System.out.println("Carro" + carroUno.nome );
        System.out.println("Velocidade" + carroUno.velocidade );
        System.out.println("Posição" + carroUno.posicao );
        
    }

}