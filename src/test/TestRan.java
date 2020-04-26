package test;

public class TestRan {

	public static void main(String[] args) {
		int dmg = 3;
		int mul = 2;
		int atk;
		double ran = Math.random()*100;
		System.out.println("랜덤 수치 : " + ran);
		int per = 10; // 기준 확률
		if(ran < per) { // 기준 확률의 확률로
			atk = dmg*mul*2;
			System.out.println("크리티컬 : " + atk);
		} else {
			atk = dmg*mul;
			System.out.println("일반 : " + atk);
		}
	}

}

