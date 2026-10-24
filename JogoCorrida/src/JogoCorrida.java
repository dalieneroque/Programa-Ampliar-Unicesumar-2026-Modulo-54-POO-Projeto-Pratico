import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;

public class JogoCorrida extends JPanel implements ActionListener {
    private ArrayList<Veiculo> veiculo = new ArrayList<>();
    private Timer timer;
    private boolean corridaAtiva = false;
    private Veiculo vencedor = null;
    private final int META = 750;


    public JogoCorrida() { 
        setPreferredSize(new Dimension(900, 500)); 
        setBackgroud(new Color(30, 30, 30)); 
        setFocusable(true); 

        veiculo.add(new Carro("Camaro", "#FDD835"));
        veiculo.add(new Moto("Ninja", "#0ef51a"));
        veiculo.add(new Caminhao("Peterbilt", "#090cb8"));
        veiculo.add(new Carro("Ferrari", "#f00d09"));

        //Timer
        timer = new Timer(50, this);

        //Criar um código que permite o jogador iniciar a corrida ao pressionar a tecla ENTER
        addKeyListener(new KeyAdapter() {
            @Override 
            public void KeyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciarCorrida();
                }
            }
        });       

    }

    //Método de iniciarCorrida 
        public void iniciarCorrida() {
            for (Veiculo v : veiculo) v.resetar();
            vencedor = null;
            corridaAtiva = true;
            timer.start();
            repaint();
        }

}






