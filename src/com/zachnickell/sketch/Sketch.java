package com.zachnickell.sketch;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.zachnickell.sketch.entity.*;

public class Sketch extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public static final String NAME = "Sketch";
	public static final String VERSION = "Alpha 1.0";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	public static int FRAMES = 0;
	
	private boolean paused = false;
	private boolean running = false;
	private BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private Graphics dbg;
	private Input input;
	private Player player;

	public void start(){
		if (!running){
			running = true;
			input = new Input();
			player = new Player(input);
			addKeyListener(input);
			requestFocus();
			new Thread(this).start();
		}
	}
	
	@Override
	public void run() {
		long lastTime = System.currentTimeMillis();
		while(running){
			
			if(System.currentTimeMillis() - lastTime >= 1000){
				System.out.println("fps: " + FRAMES);
				FRAMES = 0;
				lastTime += 1000;
			}
			if(input.spacePressed) getImg();
			gameUpdate();
			render();
			paintScreen();
			try{
				Thread.sleep(1);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	private void getImg(){
		//new SaveDialog();
		File out = new File("img.png");
		try {
			ImageIO.write(img, "png", out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void gameUpdate(){
		if(!paused){
			player.tick();
		}
	}
	
	private void render(){
		dbg = img.createGraphics();
		//dbg.fillRect(0, 0, WIDTH, HEIGHT);
		player.render(dbg);
		dbg.dispose();
	}
	
	private void paintScreen(){
		FRAMES++;
		Graphics g = getGraphics();
		g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
	}

	public static void main(String[] args) {
		Sketch one = new Sketch();
		JFrame frame = new JFrame(NAME + " " + VERSION);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(one);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		one.start();
	}
	
}
