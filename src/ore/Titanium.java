package ore;

public class Titanium extends Ore {

	public Titanium() {
		super();
		int oreHp = 35000;
		int ranHp = (int) (oreHp + (Math.random()*(oreHp/5*2)-(oreHp/5)));
		super.maxHp = ranHp;
		super.hp = ranHp;
		super.name = "티타늄 광석";
		super.reward = 9000;
	}	
}
