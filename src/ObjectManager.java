import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<Projectile> projectList = new ArrayList<Projectile>();
	Rocketship rocketship;
	ArrayList<Alien> alienList = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 2000;
	int score = 0;

	public ObjectManager(Rocketship r) {
		rocketship = r;
	}

	public void update() {
		rocketship.update();
		for (Projectile p : projectList) {
			p.update();
		}
		for (Alien a : alienList) {
			a.update();
		}
		purgeObject();
	}

	public void draw(Graphics g) {
		rocketship.draw(g);
		for (Projectile p : projectList) {
			p.draw(g);
		}
		for (Alien a : alienList) {
			a.draw(g);
		}
	}

	public void addProjectile(Projectile p) {
		projectList.add(p);
	}

	public void addAlien(Alien a) {
		alienList.add(a);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
			
			enemyTimer = System.currentTimeMillis();
		}
	}
	public void purgeObject() {
		for(int i = 0; i < alienList.size(); i++) {
			if (!alienList.get(i).isAlive) {
				alienList.remove(i);
			}
		}
	}
	public void checkCollision() {
		for(Alien a : alienList){
	        if(rocketship.collisionBox.intersects(a.collisionBox)){
	                rocketship.isAlive = false;
	        }
	    for(Projectile p : projectList) {
	    		if(p.collisionBox.intersects(a.collisionBox)) {
	    			a.isAlive = false;
	    			score++;
	    		}
	    }
	}


	}
	public int getScore() {
		return score;
	}

}
