package system;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class HpBar extends JPanel{
	
	private int width;	// 체력 게이지의 테두리 가로 길이
	private int maxHp = 100;	// 최대 체력
	private int curHp = 100;	// 현재 체력
	private int height = 10;		// 체력 게이지의 테두리 세로 길이
	private int posX,posY;		// 게이지의 위치 조정

	// 최대체력, 현재체력, 가로 길이 세팅 메소드
	public void settingHp(int maxHp, int curHp, int width) {
		this.curHp = curHp;
		this.maxHp= maxHp;
		this.width = width;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int perHp = (curHp*width)/maxHp;
		g.setColor(Color.BLACK);
		g.drawRect(posX, posY, width-2, height-1);
		if(perHp > 0) {
			if(perHp >= 70) {	// 게이지 70% 이상 초록색
				g.setColor(Color.GREEN);
				g.fillRect(posX+1, posY+1, perHp, height-2);				
			} else if(perHp >= 30) {	// 게이지 30%~70% 주황색
				g.setColor(Color.ORANGE);
				g.fillRect(posX+1, posY+1, perHp, height-2);
			} else {		// 게이지 30% 미만 빨간색
				g.setColor(Color.RED);
				g.fillRect(posX+1, posY+1, perHp, height-2);
			}
		} else {
			g.setColor(Color.BLACK);	// 채광 완료시 검은색 꽉찬 게이지
			g.fillRect(posX+1, posY+1, width, height);		
		}
	}
}
