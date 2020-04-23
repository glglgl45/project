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
	private String itemName;
	private int gold;
	private int score;
	private int CurrentEnhance;
	private int CurrentDurability;
}
