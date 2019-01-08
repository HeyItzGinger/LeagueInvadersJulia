import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<Projectile> projectList = new ArrayList<Projectile>();
	Rocketship rocketship;
	public ObjectManager(Rocketship r) {
		rocketship = r;
	}
	public void update() {
		rocketship.update();
		for(Projectile p : projectList) {
			p.update();
		}
	}
	public void draw(Graphics g) {
		rocketship.draw(g);
		for(Projectile p :projectList) {
			p.draw(g);
		}
	}
	public void addProjectile(Projectile p) {
		projectList.add(p);
	}
}
