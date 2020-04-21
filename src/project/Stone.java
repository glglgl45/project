package project;

class Stone {
	private static int hp=100;
	private static String oreName = "돌";
	
	public static void hit(int atk) {		
		if(hp > 0 && hp > atk) {
			hp = hp - atk;
			System.out.println(oreName+ " : " + hp);
		} else {
			if(hp > 0 && hp < atk) {
				hp = 0;
				System.out.println(0);
				System.out.println(oreName + "채광 완료");
			} else {
				System.out.println("더 이상 채광할 수 없습니다.");
			}
		}
	}
}
