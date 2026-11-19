//Importação das bibliotecas necessárias para listas, eventos de teclado/ timer e interface gráfica.
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;

//A classe herda JPanel(é um painel visual) e implementa ActionListener (para escutar as atualizações do Timer)
public class JogoCorrida extends JPanel implements ActionListener {
    //Atributos da Classe 
    private ArrayList<Veiculo> veiculo = new ArrayList<>(); //Lista que guarda os veículos da corrida
    private Timer timer; //Temporizador que controla o loop de animação
    private boolean corridaAtiva = false; //Flag (booleano) para saber se a corrida está ativa
    private Veiculo vencedor = null; //Guarda o veículo que vence a corrisa
    private final int META = 750; //Linha de chegada (posição X fica em 750 pixels)

    //Construtor
    public JogoCorrida() { 
        setPreferredSize(new Dimension(900, 500)); //Define a largura (900px) e altura (500px) da janela
        setBackground(new Color(30, 30, 30)); //Define a cor de fundo(cinza bem escuro)
        setFocusable(true); //Permite que o painel receba o foco dos eventos de teclado

        //Objetos que adiciona os competidores a lista (usando polimorfismo: Carro, Moto e Caminhão herdam de Veículo)
        veiculo.add(new Carro("Camaro", "#FDD835")); 
        veiculo.add(new Moto("Ninja", "#0ef51a"));
        veiculo.add(new Caminhao("Peterbilt", "#090cb8"));
        veiculo.add(new Carro("Ferrari", "#f00d09"));

        //Configura o Timer para disparar um evento a cada 50 milisegundos (20 atualizações por segundo)
        timer = new Timer(50, this);

        //Adiciona um leitor de teclas no painel
        addKeyListener(new KeyAdapter() {
            @Override 
            public void keyPressed(KeyEvent e) {
                //Se a tecla pressionada for ENTER, chama o método para começar a corrida
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciarCorrida();
                }
            }
        });       

    }

    //Método responsável por preparar e dar a largada da corrida
        public void iniciarCorrida() {
            for (Veiculo v : veiculo) v.resetar(); //Percorre a lista e volta todos os veículos para a posição inicial
            vencedor = null; //Limpa o registro do vencedor da corrida anterior
            corridaAtiva = true; //Marca que a corrida começou
            timer.start(); //Inicia a contagem do Timer (começa a rodar o loop do jogo)
            repaint(); //Solicita a redesenha a tela no Java Swing
        }

        
        @Override //Indica que estamos sobrescrevendo um método da interface ActionListener
        public void actionPerformed(ActionEvent e) { //Método executado quando o Timer disparar o evento
            if (!corridaAtiva) return; //Se a corrida não estiver ativa, imterrompe a execução 

            for (Veiculo v : veiculo) { //Percorre todos os veiculos da lista.
                //Polimorfismo: cada veiculo executa sua própria versão de método
                v.acelerar(); //Aumenta a velocidade do veículo 
                v.mover(); //Atualiza a posição do veículo

                if (v.getPosicao() >= META) { //Verifica se o veiculo alcançou a linha de chegada
                    vencedor = v; //Define o veículo como vencedor
                    corridaAtiva = false; //Finaliza o estado da corrida
                    timer.stop(); // Imterromper o Timer
                }              
            }
             repaint(); //Atualiza o desenho dos veículos na tela.
        }

       @Override //Indica que estamos sobrescrevendo um método da classe JPanel
       protected void paintComponent(Graphics g) { //Método responsável por desenhar os elementos da tela.
            super.paintComponent(g); //Limpa e prepara o painel para um novo desenho
            Graphics2D g2 = (Graphics2D) g; //Converte Graphics para Graphics2D, permitindo recursos avançados de desenho.

            //Configuração da qualidade visual dos desenhos(veiculos)
            g2.setRenderingHint( //Define a configuração de renderização
                RenderingHints.KEY_ANTIALIASING, //Seleciona a configuração de suavização das bordas
                RenderingHints.VALUE_ANTIALIAS_ON); //Ativa a suavização das bordas

            //Desenhando a linha de chegada    
            g2.setColor(Color.WHITE); //Define a cor branca para os desenhos seguintes

            for (int y = 40; y < 360; y += 20) { //Repete o desenho em diferentes posições verticais.
                g2.fillRect(META + 60, y, 15, 10); //Desenha um retângulo branco na primeira posição
                g2.fillRect(META + 75, y + 10, 15, 10); //Desenha outro retângulo, alternando a posição
            }

            //Desenhando os veículos 
            int y = 80; //Define a posição vertical inicial dos veículos
            for (Veiculo v : veiculo) { //Percorre todos os veiculos da lista.
                desenharVeiculo(g2, v, 50 + v.getPosicao(), y); //Desenha o veículo na posição correspondente

                g2.setColor(Color.WHITE); //Define a cor branca para os textos
                g2.setFont(new Font("Arial", Font.BOLD, 14)); //Define a fonte Arial, em negrito e tamanho 14
                g2.drawString( //Desenha o nome e a velocidade do veículo
                    v.getNome() + "Velocidade: " + v.getVelocidade(), //Concatena o nome e a velocidade
                    50 + v.getPosicao(), y - 15); //Define as coordenadas do texto
                    y += 90; //Aumenta a posição do veículo para desenhar o próximo veículo.

                }

            //Mensagens    
            g2.setFont(new Font("Arial", Font.BOLD, 26)); //Define a fonte das mensagens principais
            if (!corridaAtiva && vencedor == null) { //Verifica se a corrida não começou e ainda não existe vencedor.
                g2.setColor(Color.YELLOW); //Define a cor amarela para a mensagem
                g2.drawString("Pressione a tecla ENTER para iniciar a corrida", 250, 30); //Exibe a instrução para iniciar a corrida
          } else if (vencedor != null) { //Verifica se existe um vencedor
            g2.setColor(Color.GREEN); //Define a cor verde para a mensagem
            g2.drawString("🏆 Vencedor: " + vencedor.getNome() + "!", 300, 30); //Exibe o nome do vencedor
          }
       }
    
    //Método responsável por desenhar cada veículo na tela
    private void desenharVeiculo(Graphics2D g2, Veiculo v, int x, int y) { 
        Color cor = Color.decode(v.getcor()); //Obtém a cor do veículo e converte o código hexadecimal em Color
        g2.setColor(cor); //Define a cor do veículo para os próximos desenhos

        if (v instanceof Caminhao) { //Verifica se o veículo é um objeto da classe caminhão
            g2.fillRoundRect(x, y, 40, 35, 8, 8); //Desenha a cabine do caminhão
            g2.fillRect(x + 40, y + 5, 60, 30); //Desenha a carroceria do caminhão
            g2.setColor(Color.BLACK); //Define a cor preta para as rodas
            g2.fillOval(x + 8, y + 28, 16, 16); //Desenha a primeira roda
            g2.fillOval(x + 45, y + 28, 16, 16); //Desenha a segunda roda
            g2.fillOval(x + 75, y + 28, 16, 16); //Desenha a terceira roda
        } else if (v instanceof Carro) { //Verifica se o veículo é um objeto da classe carro
            g2.fillRoundRect(x, y, 70, 35, 10, 10); //Desenha a carroceria do carro com cantos arrendodados
            g2.setColor(Color.BLACK); //Define a cor preta para as rodas
            g2.fillOval(x + 10, y + 28, 15, 15); //Desenha a primeira roda
            g2.fillOval(x + 45, y + 28, 15, 15); //Desenha a segunda roda
        } else {
            //Moto
            g2.fillRoundRect(x, y, 55, 25, 10, 10); //Desenha a moto
            g2.setColor(Color.BLACK); //Define a cor preta para as rodas
            g2.fillOval(x + 5, y + 20, 14, 14); //Desenha a primeira roda
            g2.fillOval(x + 35, y + 20, 14, 14); //Desenha a segunda roda
        }
       }
    
       public static void main(String[] args) { //Método principal, repsonsável por iniciar a execução do programa(JogoCorrida)
        JFrame frame = new JFrame("Jogo de Corrida POO"); //Cria a janela do jogo com o título informado
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerra o programa quando a janela é fechada
        frame.add(new JogoCorrida()); //Cria o objeto JogoCorrida e adiciona à janela
        frame.pack(); //Ajusta o tamanho da janela connforme os componentes adicionados
        frame.setLocationRelativeTo(null); //Centraliza a janela na tela
        frame.setVisible(true); //Torna a janela visível para o usuário
       }
       
}







