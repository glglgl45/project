package ore;

public class Pickax {
	private String str;
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	// 종류 별 정보
	public int stonePick() {
		int dmg = 3;
		return dmg;
	}
	public int copperPick() {
		int dmg = 10;
		return dmg;
	}
	public int ironPick() {
		int dmg = 30;
		return dmg;
	}
	public int titaniumPick() {
		int dmg = 50;
		return dmg;
	}
	public int diamondPick() {
		int dmg = 80;
		return dmg;
	}
	
	// 곡괭이 정보
	public int choicePick(int level) {
		int dmg = 3;
		if(getStr().equals("stone")) {
			dmg = stonePick();
		} else if(getStr().equals("copper")) {
			dmg = copperPick();
		} else if(getStr().equals("iron")) {
			dmg = ironPick();
		} else if(getStr().equals("titanium")) {
			dmg = titaniumPick();
		} else if(getStr().equals("diamond")) {
			dmg = diamondPick();
		}
		return (int) (dmg * multi(level));
	}
	
	// 곡괭이 단계
	public String stagePick() {
		if(getStr().equals("stone")) {
			return "copper";
		} else if(getStr().equals("copper")) {
			return "iron";
		} else if(getStr().equals("iron")) {
			return "titanium";
		} else if(getStr().equals("titanium")) {
			return "diamond";
		} else {
			return "diamond";
		}
	}
	
	// 강화 수치 당 공격력 배율
	public double multi (int level) {
		double mul = 1;
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
}
