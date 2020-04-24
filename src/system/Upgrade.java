package system;


public class Upgrade {
	
	private Pickax pick = new Pickax();
	
	// 강화하기 메소드
	public void upgrade() {
		// 강화 실패 확률
		int failPer = (pick.getLevel()*pick.getPickLevel()+pick.getPickLevel()*10);
		// 난수 생성
		int num = (int) (Math.random()*100);
		// 강화 비용
		int upMoney = (int) (Math.pow(pick.getPickLevel(), pick.getPickLevel())*100+pick.getLevel()*20*pick.getPickLevel());
		//강화 성공 실패 결과
		if(pick.getMoney() >= upMoney) {
			if(pick.getLevel()<5) {
				pick.setScore(pick.getScore()-(pick.getPickLevel()+pick.getLevel()));
				if(num > (100-failPer)) {
					System.out.println("실패");
					System.out.println(failPer);
					pick.infoPick();
				} else {
					System.out.println("성공");
					System.out.println("현재 레벨 : " + pick.getLevel());
					System.out.println(pick.getLevel());
					pick.setLevel(pick.getLevel()+1);
					System.out.println("강화 후 레벨 : " + pick.getLevel());
					System.out.println(failPer);
					pick.multi();
				}
				pick.setMoney(pick.getMoney()-upMoney);
			} else {
				System.out.println("더 이상 강화할 수 없습니다.");
			}
		} else {
			System.out.println("소지금이 부족합니다.");
		}
	}
	
	// 진화하기 메소드
	public void evol() {
		// 진화 실패확률
		int failPer = (pick.getLevel()*pick.getPickLevel()+pick.getPickLevel()*10/*진화 확률*/);
		// 난수 생성
		int num = (int) (Math.random()*100);
		// 진화 비용
		int evolMoney = (int) (Math.pow(pick.getPickLevel(), pick.getPickLevel())*100)/*진화 비용*/;
		System.out.println("진화 금액 : "+evolMoney);
		// 진화 성공 실패 결과
		if(pick.getMoney() >= evolMoney) {
			if(pick.getLevel()==5 && pick.getPickLevel()!=5) {
				pick.setScore(pick.getScore()-pick.getPickLevel()*pick.getLevel());
				pick.setMoney(pick.getMoney()-evolMoney);
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
			} else if(pick.getPickLevel()==5){
				System.out.println("최종 진화 단계 입니다.");
			} else {
				System.out.println("진화할 수 없습니다.");
			}
		} else {
			System.out.println("소지금이 부족합니다.");
		}
	}	
	
	// 수리하기 메소드
	public void fixPick() {
		// 수리 비용
		int fixMoney = pick.getPickLevel()*pick.getPickLevel()*10+pick.getLevel()*pick.getPickLevel();
		if(pick.getDura()>=100) {
			System.out.println("내구도가 최대치 이므로 수리가 불가능 합니다.");
		} else {
			pick.setScore(pick.getScore()-pick.getPickLevel());
			if(pick.getMoney() < fixMoney) {
				System.out.println("소지금이 부족합니다.");
			} else {
				System.out.println("곡괭이가 수리 되었습니다.");
				pick.setDura(100);
				pick.setMoney(pick.getMoney()-fixMoney);
			}
		}
	}
}
