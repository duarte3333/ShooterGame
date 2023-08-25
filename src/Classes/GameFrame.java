package Classes;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

    //Chama o construtor do JFrame?
    GameFrame(){

        this.add(new GamePanel());
        this.setTitle("Dudu shoot's you");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();  //O que isto faz?
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}