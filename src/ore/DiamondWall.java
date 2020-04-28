package ore;

public class DiamondWall extends Ore {

	public DiamondWall() {
		super();
		int oreHp = 500000;
		double ranPer = 15; // 난수율 지정 : double 형태의 정수 입력
		double ranPerCal = ranPer/100; // 난수율 계산 : 난수율(정수)을 받아 double 형태의 비율로 변환
		int ranHp = (int) (oreHp + (Math.random()*(oreHp*ranPerCal)-(oreHp*ranPerCal))); // 난수 적용 체력 ex) 기준 체력=20 ; 난수 체력 = 16~24 상하한 20%
		super.maxHp = ranHp; // 게이지 구현을 위한 최대 체력
		super.hp = ranHp; // 변화되는 현재 hp
		
		super.name = "다이아몬드 벽";
		super.reward = 0;
		super.imgPath = "/img/ore/diamondwall.jpg";
	}

}
