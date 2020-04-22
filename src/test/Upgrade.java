package test;


public class Upgrade {
	
	private Pickax pick = new Pickax();
	public int upgrade() {
		int failPer = (pick.getLevel()*pick.getPickLevel()+pick.getPickLevel()*10);
		int result = 0;
		int num = (int) (Math.random()*100);
		if(pick.getLevel()<5) {
			if(num > (100-failPer)) {
				result = 0;
				System.out.println("실패");
				System.out.println(failPer);
				pick.infoPick();
			} else {
				result = 1;
				System.out.println("성공");
				System.out.println("현재 레벨 : " + pick.getLevel());
				System.out.println(pick.getLevel());
				pick.setLevel(pick.getLevel()+1);
				System.out.println("강화 후 레벨 : " + pick.getLevel());
				System.out.println(failPer);
				pick.multi();
			}
		} else {
			System.out.println("더 이상 강화할 수 없습니다.");
		}
		return result;
	}
	
	public void evol() {
		int failPer = (pick.getLevel()*pick.getPickLevel()+pick.getPickLevel()*10);
		int num = (int) (Math.random()*100);
		if(pick.getLevel()==5 && pick.getPickLevel()!=5) {
			if(num < (100-failPer)) {
				System.out.println("진화 성공");
				System.out.println(failPer);
				pick.setPickLevel(pick.getPickLevel()+1);
				switch (pick.getPickLevel()) {
				case 2:
					pick.copperPick();
					pick.setLevel(0);
					pick.multi();
					break;
				case 3:
					pick.ironPick();
					pick.setLevel(0);
					pick.multi();
					break;
				case 4:
					pick.titaniumPick();
					pick.setLevel(0);
					pick.multi();
					break;
				case 5:
					pick.diamondPick();
					pick.setLevel(0);
					pick.multi();
					break;
				default:
					break;
				}
			} else {
				System.out.println("진화 실패");
				System.out.println(failPer);
				pick.infoPick();
			}
		} else {
			System.out.println("진화할 수 없습니다.");
		}
	}	
}
