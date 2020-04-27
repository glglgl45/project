package ore;

import java.awt.Image;
import img.*;
import javax.swing.ImageIcon;

public class Stone extends Ore {

	public Stone() {
		super();
		// hp
		int oreHp = 20;	// 기준 체력
		int ranHp = (int) (oreHp + (Math.random()*(oreHp/5*2)-(oreHp/5))); // 난수 적용 체력 ex) 기준 체력=20 ; 난수 체력 = 16~24 상하한 20%
		super.maxHp = ranHp; // 게이지 구현을 위한 최대 체력
		super.hp = ranHp; // 변화되는 현재 hp
		
		super.name = "돌 광석";
		super.imgPath = "/img/stone.png"; // 이미지 출력을 위한 경로 지정
		
		// 보상
		int reward = 3; // 돌 광석은 보상이 낮아 난수 적용 안함 구리부터 적용
		super.reward = 3;
	}
}
