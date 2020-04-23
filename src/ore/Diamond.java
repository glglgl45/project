package ore;

public class Diamond extends Ore {

	public Diamond() {
		super();
		int oreHp = 100000;
		super.hp = (int) (oreHp + (Math.random()*(oreHp/5*2)-(oreHp/5)));
		super.name = "다이아몬드 광석";
		super.reward = 30000;
	}	
}
