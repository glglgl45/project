package system;


public class Pickax {
	
	private static String pickName = "stone";
	private static int dmg = 3;
	private static int level = 0;
	private static double mul = 1;
	private static int money;
	private static int pickLevel = 1;
	private static int dura = 100;
	
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
		pickName = "stone";
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
		pickName = "stone";
		dmg = 3;
		pickLevel = 1;
	}
	public void copperPick() {
		pickName = "copper";
		dmg = 10;
		pickLevel = 2;
	}
	public void ironPick() {
		pickName = "iron";
		dmg = 30;
		pickLevel = 3;
	}
	public void titaniumPick() {
		pickName = "titanium";
		dmg = 50;
		pickLevel = 4;
	}
	public void diamondPick() {
		pickName = "diamond";
		dmg = 80;
		pickLevel = 5;
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
		double atk = dmg * mul;
		return (int) atk;
	}
}
