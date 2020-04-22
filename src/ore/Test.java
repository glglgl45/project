package ore;

public class Test {
	public static void main(String[] args) {
		int num = (int) (Math.random()*100);
		if(num > 90) {
			System.out.println("강화 실패");
		} else {
			System.out.println("강화 성공");
		}
	}
}
