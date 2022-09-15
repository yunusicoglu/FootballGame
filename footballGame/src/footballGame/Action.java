package footballGame;

import java.util.Random;


public class Action {
	
	Random random = new Random();
	int requiredScore;
	
	public boolean Pass(int passScore) {
		requiredScore = random.nextInt(50,100);
		if (passScore>=requiredScore) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean Shot(int shotScore) {
		requiredScore = random.nextInt(70,100);
		if (shotScore>=requiredScore) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean Dribbling(int dribblingScore) {
		requiredScore = random.nextInt(70,100);
		if (dribblingScore>=requiredScore) {
			return true;
		}else {
			return false;
		}
	}
	

}
