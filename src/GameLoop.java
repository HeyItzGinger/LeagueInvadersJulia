import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameLoop extends JPanel implements ActionListener{
	Timer t;
public GameLoop(1000/60, this) {
	t = new Timer();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	System.out.println("hi");
}
}
