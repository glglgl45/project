package system;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

public class Pickax {
	
	private static String pickName = "돌 곡괭이"; // 곡괭이 이름
	private static int dmg = 3; // 기준 공격력
	private static int level = 0; // 강화 레벨
	private static double mul = 1; // 강화에 따른 배수
	private static int money=0; // 소지금
	private static int pickLevel = 1; // 곡괭이 진화 단계
	private static int dura = 100; // 내구도
	private static int score = 99999; // 점수
	private static String userId; // 아이디
	private String pathCursor;
	private String pathClick;
	
	// DB에 있는 데이터를 곡괭이에 세팅하는 메소드
	public void pickSet(String userID, int gold, int dmg, int durability, 
						int enhance, int multiple, String pickName, int score, int pickLevel) {
		userId = userID; // pick.setUserId(vo.getId());	
		money = gold; // pick.setMoney(vo.getGold());
		this.dmg = dmg; // pick.setDmg(vo.getDamage());
		dura = durability; // pick.setDura(vo.getDurability());
		level = enhance; // pick.setMul(vo.getMul());
		this.pickName = pickName; // pick.setPickName(vo.getPickName());
		this.score = score; // pick.setScore(vo.getScore());
		this.pickLevel = pickLevel; // pick.setPickLevel(vo.getPickLevel());
	}
	
	// 현재 곡괭이의 레벨을 이미지로 출력
	public String pickImg() {
		if(pickLevel==1) {
			return "/img/pickax/pickax-stone.png";
		} else if(pickLevel==2) {
			return "/img/pickax/pickax-copper.png";
		} else if(pickLevel==3) {
			return "/img/pickax/pickax-iron.png";
		} else if(pickLevel==4) {
			return "/img/pickax/pickax-titanium.png";
		} else if(pickLevel==5) {
			return "/img/pickax/pickax-diamond.png";
		} else {
			System.out.println("에러 : 곡괭이 레벨이 이미지로 출력이 안됨");
			return "error";
		}
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		Pickax.userId = userId;
	}

	
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
	
	public double getMul() {
		return mul;
	}

	public void setMul(double mul) {
		Pickax.mul = mul;
	}

	public void initPick() {
		pickName = "돌 곡괭이";
		dmg = 3;
		level = 0;
		mul = 1;
		money = 0;
	}
	
	public void infoPick() {
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
	
	public int crit() {
		int ran = (int) (Math.random()*100);
		if(ran > 90) {
			return 1;
		} else if(ran < 10) {
			return 1;
		} else {
			return 0;
		}
	}
	
	// 채광 메소드
	public int atk() {
		if(getDura() > 0) { // 내구도가 0 보다 크면 채광
			if(crit()==1) {
				double atk = dmg * mul * mul;
				setDura(getDura()-1);
				setScore(getScore()-1);
				return (int) atk;
			} else {
				double atk = dmg * mul;
				setDura(getDura()-1);
				setScore(getScore()-1);
				return (int) atk;
			}
		} else { // 내구도가 0이면 채광 불가
			double atk = 0;
			setScore(getScore()-1);
			return (int) atk;
		}
	}
	
	// 나무 캐기
	public int atkWood() {
		if(getDura() > 0) {
			double atk = dmg * mul;
			setDura(getDura()-1);
			setScore(getScore()-1);
			return (int) atk;
		} else {
			double atkWood = 1;
			setScore(getScore()-1);
			return (int) atkWood;			
		}
	}
    //곡괭이 정보를 불러올때 필요한 메소드
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	// 커서
	public Cursor cursor(){ 
		// 경로 지정
		if(pickLevel==1) {
			pathCursor = "/img/pickax/pickax-stone.png";
		} else if(pickLevel==2) {
			pathCursor = "/img/pickax/pickax-copper.png";
		} else if(pickLevel==3) {
			pathCursor = "/img/pickax/pickax-iron.png";
		} else if(pickLevel==4) {
			pathCursor = "/img/pickax/pickax-titanium.png";
		} else if(pickLevel==5) {
			pathCursor = "/img/pickax/pickax-diamond.png";
		} else {
			System.out.println("에러 : 곡괭이 커서 이미지 경로 문제");
		}
		// 커서 이미지 변경
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		Image cursorimage=tk.getImage(Pickax.class.getResource(pathCursor));
		Point point=new Point(20,20); 
		Cursor cursor=tk.createCustomCursor(cursorimage, point, "cursor");
		return cursor;
	}
	
	public Cursor click() {
		// 경로 지정
		if(pickLevel==1) {
			pathClick = "/img/pickax/pickaxStoneClick.png";
		} else if(pickLevel==2) {
			pathClick = "/img/pickax/pickaxCopperClick.png";
		} else if(pickLevel==3) {
			pathClick = "/img/pickax/pickaxIronClick.png";
		} else if(pickLevel==4) {
			pathClick = "/img/pickax/pickaxTitaniumClick.png";
		} else if(pickLevel==5) {
			pathClick = "/img/pickax/pickaxDiamondClick.png";
		} else {
			System.out.println("에러 : 곡괭이 클릭 시 커서 이미지 경로 문제");
		}
		// 클릭 시 커서 이미지 변경
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		Image cursorimage=tk.getImage(Pickax.class.getResource(pathClick));
		Point point=new Point(20,20); 
		Cursor cursor=tk.createCustomCursor(cursorimage, point, "click");
		return cursor;		
	}

	public Cursor exitCursor() {
		// 커서 이미지 변경
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		Image cursorimage=tk.getImage(Pickax.class.getResource("/img/redExit.png"));
		Point point=new Point(20,20); 
		Cursor cursor=tk.createCustomCursor(cursorimage, point, "click");
		return cursor;		
	}
	public Cursor entranceCursor() {
		// 커서 이미지 변경
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		Image cursorimage=tk.getImage(Pickax.class.getResource("/img/entranceCursor.png"));
		Point point=new Point(20,20); 
		Cursor cursor=tk.createCustomCursor(cursorimage, point, "click");
		return cursor;		
	}
}
