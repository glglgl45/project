package ore;

public class Copper extends Ore {

	public Copper() {
		super();
		int oreHp = 600;
		int ranHp = (int) (oreHp + (Math.random()*(oreHp/5*2)-(oreHp/5)));
		super.maxHp = ranHp;
		super.hp = ranHp;
		super.name = "구리 광석";
		super.reward = 80;
	}

}
