package system;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class HpBar extends JPanel{
	
	private int maxHp = 100;
	private int curHp = 100;
	private int height = 20;
	private int posX,posY;
	
	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getCurHp() {
		return curHp;
	}

	public void setCurHp(int curHp) {
		this.curHp = curHp;
	}

	public HpBar(int maxHp, int curHp) {
		super();
		this.curHp = curHp/maxHp*100;
		System.out.println(maxHp);
		System.out.println(curHp);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(posX, posY, maxHp+2, height+2);
		if(curHp > 0) {
			if(curHp > 70) {
				g.setColor(Color.GREEN);
				g.fillRect(posX+1, posY+1, curHp, height);				
			} else if(curHp > 30) {
				g.setColor(Color.ORANGE);
				g.fillRect(posX+1, posY+1, curHp, height);
			} else {
				g.setColor(Color.RED);
				g.fillRect(posX+1, posY+1, curHp, height);
			}
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(posX+1, posY+1, maxHp, height);		
		}
	}
}
