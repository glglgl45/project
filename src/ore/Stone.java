package ore;

public class Stone extends Ore {

	public Stone() {
		super();
		int oreHp = 20;
		super.hp = (int) (oreHp + (Math.random()*(oreHp/5*2)-(oreHp/5)));
		super.name = "돌 광석";
		super.reward = 3;
	}	
}
