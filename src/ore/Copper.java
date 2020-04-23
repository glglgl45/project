package ore;

public class Copper extends Ore {

	public Copper() {
		super();
		int oreHp = 600;
		super.hp = (int) (oreHp-(oreHp/5) + Math.random()*(oreHp/5*2));
		super.name = "구리 광석";
		super.reward = 80;
	}

}
