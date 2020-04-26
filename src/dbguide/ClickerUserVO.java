package dbguide;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClickerUserVO {	//오라클DB ClickerUserInfo 테이블의 컬럼과 같게 생성 (Pickax 클래스의 변수를 받아 DB에 저장하기 위해)
	
	private String id;			//아이디
	private String pwd;			//비밀번호
	private String pickName;	//곡괭이 이름 (돌, 구리, 철, 티타늄, 다이아)
	private int enhance;		//강화수치
	private int pickLevel;		//곡괭이 진화(1:돌, 2:구리, 3:철, 4:티타늄, 5:다이아)
	private int durability;		//곡괭이 내구도
	private int gold;			//소지금
	private int score;			//점수
	private int damage;			//곡괭이 공격력
	private double mul;			//강화에 따른 배수
	private int progress;		//게임 클리어 판단 (0:클리어X 1:클리어O)
}
