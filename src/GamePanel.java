import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager om = new ObjectManager(rocket);
	

	public GamePanel() {
		t = new Timer(1000 / 60, this);
		titleFont = new Font("Papyrus", Font.PLAIN, 55);
		subFont = new Font("PingFang HK", Font.PLAIN, 28);
		try {
            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
    } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

    }


	}

	public void startGame() {
		t.start();
	}

	public void updateMenuState() {
		
	}

	public void updateGameState() {
		om.manageEnemies();
		om.checkCollision();
		om.purgeObject();
		om.update();
		if(rocket.isAlive == false) {
			currentState = END_STATE;
		}
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
		 g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.width, LeagueInvaders.height, null);
		om.draw(g);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0,  0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 90, 60);
		g.setFont(subFont);
		g.setColor(Color.black);
		g.drawString("You killed " + om.getScore() + " enemies", 120, 300);
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
				rocket = new Rocketship(250, 700, 50, 50);
				om = new ObjectManager(rocket);
				currentState = MENU_STATE;
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.y-=rocket.speed;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.y+=rocket.speed;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.x-=rocket.speed;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.x+=rocket.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			om.addProjectile(new Projectile(rocket.x+20, rocket.y, 10, 10));
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
