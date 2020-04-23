package ore;

public class Iron extends Ore {

	public Iron() {
		super();
		int oreHp = 3000;
		super.hp = (int) (oreHp + (Math.random()*(oreHp/5*2)-(oreHp/5)));
		super.name = "철 광석";
		super.reward = 600;
	}	
}
