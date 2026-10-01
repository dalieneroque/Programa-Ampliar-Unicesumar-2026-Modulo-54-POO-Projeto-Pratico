public class Main {

    public static void main(String[] args) {

        Veiculo carroCivic = new Veiculo();

        carroCivic.nome = "Civic";
        carroCivic.cor = "Prata";
        

        Veiculo carroUno = new Veiculo();

        carroUno.nome = "Uno";
        carroUno.cor = "Branco";
              

        System.out.println(carroCivic.nome);
        System.out.println(carroUno.cor);
        
    }

}