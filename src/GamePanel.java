import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer t;
	GameObject go;
public GamePanel() {
	t = new Timer(1000/60, this);
	go = new GameObject(10,10,10,10);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	repaint();
	go.update();
	repaint();
}
public void startGame() {
	t.start();
}
public void paintComponent(Graphics g) {
	g.fillRect(10, 10, 100, 100);
	go.draw(g);
}
@Override
public void keyTyped(KeyEvent e) {
	System.out.println("hi");
}
@Override
public void keyPressed(KeyEvent e) {
	System.out.println("hello");
}
@Override
public void keyReleased(KeyEvent e) {
	System.out.println("aloha");
}
}
