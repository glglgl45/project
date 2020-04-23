package dbguide;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClickerItemVO {

	private String pickName;
	private int pickLevel;
	private int mul;
	private int enhance;
	private int attack;
	private int totalDurability;
}
