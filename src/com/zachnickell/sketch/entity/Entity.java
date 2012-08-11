package com.zachnickell.sketch.entity;

import java.awt.Graphics;
import java.awt.Image;

public class Entity {
	int x, y;
	int health;
	public void render(Graphics g){
		g.drawString("N/A", x, y);
	}
	public void tick (){
		
	}
}
