package ore;

public class Stone extends Ore {

	public Stone() {
		super();
		int oreHp = 20;
		super.hp = (int) (oreHp-(oreHp/5) + Math.random()*(oreHp/5*2));
		super.name = "돌 광석";
		super.reward = 3;
	}	
}
