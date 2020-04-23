package ore;

public class Titanium extends Ore {

	public Titanium() {
		super();
		int oreHp = 35000;
		super.hp = (int) (oreHp-(oreHp/5) + Math.random()*(oreHp/5*2));
		super.name = "티타늄 광석";
		super.reward = 9000;
	}	
}
