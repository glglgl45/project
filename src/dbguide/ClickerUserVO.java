package dbguide;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClickerUserVO {

	private String id;
	private String pwd;
	private String pickName;
	private int enhance;
	private int pickLevel;
	private int durability;
	private int gold;
	private int score;
	private int damage;
	private double mul;
}
