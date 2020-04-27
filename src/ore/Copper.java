package ore;

public class Copper extends Ore {

	public Copper() {
		super();
		super.name = "구리 광석";
		
		// hp
		int oreHp = 600; // 기준 체력
		double ranPer = 20; // 난수율 지정 : double 형태의 정수 입력
		double ranPerCal = ranPer/100; // 난수율 계산 : 난수율(정수)을 받아 double 형태의 비율로 변환
		int ranHp = (int) (oreHp + (Math.random()*(oreHp*ranPerCal*2)-(oreHp*ranPerCal))); // 난수 적용 체력 ex) 기준 체력=20 ; 난수 체력 = 16~24 상하한 20%
		super.maxHp = ranHp; // 게이지 구현을 위한 최대 체력
		super.hp = ranHp; // 변화되는 현재 hp
		super.imgPath = "/img/Copper.png"; // 이미지 출력을 위한 경로 지정
		
		// 보상
		int reward = 80; // 기준 보상
		int ranReward = (int) (reward + (Math.random()*(reward/5*2)-(reward/5))); // 난수 적용 보상 ex) 기준 보상=80 ; 난수 보상 = 64~96 상하한 20%
		super.reward = ranReward; // 최종 보상
	}

}
