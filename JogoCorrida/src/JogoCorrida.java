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
    private boolean corridaAtiva = false; //Flag (booleano) para saber se a corrida está rodando
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
            for (Veiculo v : veiculo) v.resetar(); //Percorrer a lista e volta a posição de todos os veículos ao inicio
            vencedor = null; //Resetar o vencedor da corrida anterior
            corridaAtiva = true; //Marca que a corrida começou
            timer.start(); //Inicia a contagem do Timer (começa a rodar o loop do jogo)
            repaint(); //Solicita a redesenha a tela no Java Swing
        }

        
        @Override 
        public void actionPerformed(ActionEvent e) {
            if (!corridaAtiva) return;

            for (Veiculo v : veiculo) {
                //Polimorfismo
                v.acelerar();
                v.mover();

                if (v.getPosicao() >= META) {
                    vencedor = v;
                    corridaAtiva = false;
                    timer.stop();
                }              
            }
             repaint();
        }

       @Override 
       protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            //Configuração da qualidade visual dos desenhos(veiculos)
            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);

            //Desenhando a linha de chegada    
            g2.setColor(Color.WHITE);

            for (int y = 40; y < 360; y += 20) {
                g2.fillRect(META + 60, y, 15, 10);
                g2.fillRect(META + 75, y + 10, 15, 10);
            }

            //Desenhando os veículos 
            int y = 80;
            for (Veiculo v : veiculo) {
                desenharVeiculo(g2, v, 50 + v.getPosicao(), y);

                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Arial", Font.BOLD, 14));
                g2.drawString(
                    v.getNome() + "Velocidade: " + v.getVelocidade(),
                    50 + v.getPosicao(), y - 15);
                    y += 90;

                }

            //Mensagens    
            g2.setFont(new Font("Arial", Font.BOLD, 26));
            if (!corridaAtiva && vencedor == null) {
                g2.setColor(Color.YELLOW);  
                g2.drawString("Pressione a tecla ENTER para iniciar a corrida", 250, 30);
          } else if (vencedor != null) {
            g2.setColor(Color.GREEN);
            g2.drawString("🏆 Vencedor: " + vencedor.getNome() + "!", 300, 30);
          }
       }
    

    private void desenharVeiculo(Graphics2D g2, Veiculo v, int x, int y) {
        Color cor = Color.decode(v.getcor()); 
        g2.setColor(cor);

        if (v instanceof Caminhao) {
            g2.fillRoundRect(x, y, 40, 35, 8, 8); //cabine
            g2.fillRect(x + 40, y + 5, 60, 30); //carroceria
            g2.setColor(Color.BLACK);
            g2.fillOval(x + 8, y + 28, 16, 16);
            g2.fillOval(x + 45, y + 28, 16, 16);
            g2.fillOval(x + 75, y + 28, 16, 16);
        } else if (v instanceof Carro) {
            g2.fillRoundRect(x, y, 70, 35, 10, 10); 
            g2.setColor(Color.BLACK);
            g2.fillOval(x + 10, y + 28, 15, 15);
            g2.fillOval(x + 45, y + 28, 15, 15);
        } else {
            //Moto
            g2.fillRoundRect(x, y, 55, 25, 10, 10); 
            g2.setColor(Color.BLACK);
            g2.fillOval(x + 5, y + 20, 14, 14);
            g2.fillOval(x + 35, y + 20, 14, 14);
        }
       }
    
       public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo de Corrida POO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JogoCorrida());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
       }
       
}







