import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final int width = 500;
	final int height = 800;
	GamePanel gp;
public LeagueInvaders() {
	frame = new JFrame();
	gp = new GamePanel();
}
public static void main(String[] args) {
	LeagueInvaders li = new LeagueInvaders();
	li.setup();
}
public void setup() {
	frame.add(gp);
	frame.addKeyListener(gp);
	frame.setVisible(true);
	frame.getContentPane().setPreferredSize(new Dimension(width, height));
    frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gp.startGame();
}
}
