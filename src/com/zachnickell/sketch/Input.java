package com.zachnickell.sketch;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{

	public boolean upPressed = false;
	public boolean downPressed = false;
	public boolean leftPressed = false;
	public boolean rightPressed = false;
	public boolean onePressed = false;
	public boolean twoPressed = false;
	public boolean threePressed = false;
	public boolean enterPressed = false;
	public boolean spacePressed = false;
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) upPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_S) downPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_A) leftPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_D) rightPressed = true;
		if(e.getKeyCode() == KeyEvent.VK_1) onePressed = true;	
		if(e.getKeyCode() == KeyEvent.VK_2) twoPressed = true;	
		if(e.getKeyCode() == KeyEvent.VK_3) threePressed = true;	
		if(e.getKeyCode() == KeyEvent.VK_ENTER) enterPressed = true;	
		if(e.getKeyCode() == KeyEvent.VK_SPACE) spacePressed = true;	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) upPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_S) downPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_A) leftPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_D) rightPressed = false;
		if(e.getKeyCode() == KeyEvent.VK_1) onePressed = false;	
		if(e.getKeyCode() == KeyEvent.VK_2) twoPressed = false;	
		if(e.getKeyCode() == KeyEvent.VK_3) threePressed = false;	
		if(e.getKeyCode() == KeyEvent.VK_ENTER) enterPressed = false;	
		if(e.getKeyCode() == KeyEvent.VK_SPACE) spacePressed = false;	
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
