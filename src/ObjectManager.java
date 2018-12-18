import java.awt.Graphics;

public class ObjectManager {
	Rocketship rocketship;
	public ObjectManager(Rocketship r) {
		rocketship = r;
	}
	public void update() {
		rocketship.update();
	}
	public void draw(Graphics g) {
		rocketship.draw(g);
	}
}
