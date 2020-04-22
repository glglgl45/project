package ore;

public class Upgrade {
	// 강화
	public int upgrade() {
		int result = 0;
		int num = (int) (Math.random()*100);
		if(num > 80) {
			result = 0;
			System.out.println("실패");
		} else {
			result = 1;
			System.out.println("성공");
		}
		return result;
	}

	public int stoneUpgrade() {
		int result = 0;
		int num = (int) (Math.random()*100);
		if(num > 80) {
			result = 0;
			System.out.println("실패");
		} else {
			result = 1;
			System.out.println("성공");
		}
		return result;
	}
	
	public void evol() {
		if(MapStone().getLevel()==5) {
			if(upgrade()==1) {
				System.out.println("진화 성공");
				pick.setStr(pick.stagePick());
			} else {
				System.out.println("진화 실패");
			}
		} else {
			System.out.println("진화할 수 없습니다.");
		}
	}	
}
