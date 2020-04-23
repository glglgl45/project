package system;


public class Pickax {
	
	private static String pickName = "돌 곡괭이";
	private static int dmg = 3;
	private static int level = 0;
	private static double mul = 1;
	private static int money;
	private static int pickLevel = 1;
	private static int dura = 100;
	private static int score = 99999;
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		Pickax.score = score;
	}

	public String getPickName() {
		return pickName;
	}

	public void setPickName(String pickName) {
		Pickax.pickName = pickName;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		Pickax.dmg = dmg;
	}

	public int getDura() {
		return dura;
	}

	public void setDura(int dura) {
		Pickax.dura = dura;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		Pickax.level = level;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPickLevel() {
		return pickLevel;
	}

	public void setPickLevel(int pickLevel) {
		Pickax.pickLevel = pickLevel;
	}

	public void initPick() {
		pickName = "돌 곡괭이";
		dmg = 3;
		level = 0;
		mul = 1;
		money = 0;
	}
	
	public void infoPick() {
		System.out.println(pickName +"+"+ level +" : "+ dmg + "x"+ mul + " 소지금 : " +money);
	}
	
	// 종류 별 정보
	public void stonePick() {
		pickName = "돌 곡괭이";
		dmg = 3;
		pickLevel = 1;
		dura = 100;
	}
	public void copperPick() {
		pickName = "구리 곡괭이";
		dmg = 15;
		pickLevel = 2;
		dura = 100;
	}
	public void ironPick() {
		pickName = "철 곡괭이";
		dmg = 150;
		pickLevel = 3;
		dura = 100;
	}
	public void titaniumPick() {
		pickName = "티타늄 곡괭이";
		dmg = 500;
		pickLevel = 4;
		dura = 100;
	}
	public void diamondPick() {
		pickName = "다이아 곡괭이";
		dmg = 2500;
		pickLevel = 5;
		dura = 100;
	}
	
	public double multi () {
		if(level==0) {
			mul = 1;
		}else if(level==1) {
			mul = 1.2;
		} else if(level==2) {
			mul = 1.4;
		} else if(level==3) {
			mul = 1.6;
		} else if(level==4) {
			mul = 1.8;
		} else if(level==5) {
			mul = 2;
		} 
		return mul;
	}
	
	public int atk() {
		if(getDura() > 0) {
			double atk = dmg * mul;
			setDura(getDura()-1);
			setScore(getScore()-1);
			return (int) atk;
		} else {
			double atk = 0;
			System.out.println("내구도가 부족합니다.");
			setScore(getScore()-1);
			return (int) atk;
		}
	}
	
	public int atkWood() {
		if(getDura() > 0) {
			double atk = dmg * mul;
			setDura(getDura()-1);
			setScore(getScore()-1);
			return (int) atk;
		} else {
			double atkWood = dmg/3;
			setScore(getScore()-1);
			return (int) atkWood;			
		}
	}
}
