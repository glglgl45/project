package dbguide;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClickerItemVO {

	private String itemName;
	private int enhance;
	private int attack;
	private int totalDurability;
	private int successPercent;
	private int failPercent;
}
