package dbguide;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserVO {
	private String ItemName;
	private int Enhance;
	private int Attack;
	private int TotalDurability;

}
