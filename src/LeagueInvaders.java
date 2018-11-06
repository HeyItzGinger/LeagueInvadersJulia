import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final int width = 500;
	final int height = 800;
public LeagueInvaders() {
	frame = new JFrame();
}
public static void main(String[] args) {
	LeagueInvaders li = new LeagueInvaders();
	li.setup();
}
public void setup() {
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
