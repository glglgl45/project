package ore;

public class Wood extends Ore {

	public Wood() {
		super();
		int oreHp = 10;
		int ranHp = (int) (oreHp + (Math.random()*(oreHp/5*2)-(oreHp/5)));
		super.maxHp = ranHp;
		super.hp = ranHp;
		super.name = "나무";
		super.reward = 1;
	}

}
