package ore;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Ore {
	public int hp;
	public String name;
	public int reward;
	public int maxHp;
	public String imgPath;

	public int hit(int atk) {		
		if(hp > 0 && hp > atk) {
			hp = hp - atk;
//			System.out.println(name+ " : " + hp);
			return 0;
		} else {
			if(hp > 0 && hp <= atk) {
				hp = 0;
//				System.out.println(name + " : " + hp);
//				System.out.println(name + "채광 완료");
				return reward;
			} else {
//				System.out.println("더 이상 채광할 수 없습니다.");
				return 0;
			}
		}
	}

	public ImageIcon OreImg() {
		ImageIcon img = new ImageIcon(Ore.class.getResource(imgPath));
		return img;
	}
}
