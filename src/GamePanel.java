import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer t;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font subFont;
	

	public GamePanel() {
		t = new Timer(1000 / 60, this);
		titleFont = new Font("Papyrus", Font.PLAIN, 55);
		subFont = new Font("PingFang HK", Font.PLAIN, 28);
	}

	public void startGame() {
		t.start();
	}

	public void updateMenuState() {

	}

	public void updateGameState() {

	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height); 
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("League Invaders", 60, 60);
		g.setFont(subFont);
		g.setColor(Color.white);
		g.drawString("Press ENTER to start", 110, 300);
		g.drawString("Press SPACE for instructions", 72, 500);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0,  0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 90, 60);
		g.setFont(subFont);
		g.setColor(Color.black);
		g.drawString("You killed 0 enemies", 120, 300);
		g.drawString("Press ENTER to restart", 100, 500);
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		}
		else if (currentState == GAME_STATE) {
			drawGameState(g);
		}
		else if (currentState == END_STATE) {
			drawEndState(g);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState == MENU_STATE) {
				currentState = GAME_STATE;
			}
			else if(currentState == GAME_STATE) {
				currentState = END_STATE;
			}
			else if(currentState == END_STATE) {
				currentState = MENU_STATE;
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
