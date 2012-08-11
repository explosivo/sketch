package com.zachnickell.sketch.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.zachnickell.sketch.Input;

public class Player extends Entity{

	Input input;
	Color color = Color.blue;
	public Player(Input input){
		x = 0;
		y = 0;
		this.input = input;
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(x+1, y+1, 14, 14);
		g.setColor(color);
		g.drawRect(x, y, 16, 16);
		if(input.enterPressed){
			g.setColor(Color.black);
			g.fillRect(0, 0, 640, 480);
		}
	}
	public void tick(){
		System.out.println(y);
		if(input.upPressed) y--;
		if(input.downPressed) y++;
		if(input.leftPressed) x--;
		if(input.rightPressed) x++;
		if(input.onePressed) color = Color.blue;
		if(input.twoPressed) color = Color.red;
		if(input.threePressed) color = Color.white;
		if (x < 0) x = 0;
		if (x > (640-24)) x = (640-24);
		if (y < 0) y = 0;
		if (y > 480-40) y = 480-40;
	}
}
