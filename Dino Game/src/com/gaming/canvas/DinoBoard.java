package com.gaming.canvas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.gaming.sprites.Dino;
import com.gaming.sprites.Hurdles;
//import com.gaming.sprites.Score;
import com.gaming.utils.DinoConstants;
import com.gaming.utils.GameConstants;

public class DinoBoard extends JPanel implements GameConstants,DinoConstants{
	private Dino dino;
	private Hurdles hurdle;
	private boolean isGameOver;
	private Timer timer;
	BufferedImage backgroundImage;
//	private Score dinoScore;
	private int score=10;
	private JLabel jlabel;
//	private void loadScore() {
//		dinoScore = new Score(score);
//	}
	public DinoBoard() throws IOException {
		jlabel = new JLabel("Score : "+score);
		jlabel.setFont(new Font("Serif",Font.BOLD,47));
		add(jlabel);
		dino = new Dino();
		hurdle = new Hurdles();
		bindEvents();
		gameLoop();
		loadBackgroundImage();
		setFocusable(true);
//		loadScore();
	}
	public int incScore() {
		score+=1;
		return score;
	}         
	
	@Override
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		printBackgroundImage(pen);
		pen.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D)pen;
    	g2.setStroke(new BasicStroke(6));
		pen.drawLine(0,690,1500,690);
		dino.printSprite(pen);
		hurdle.printSprite(pen);
//		paintScore(pen);
		if(isGameOver) {
			printMsg(pen);
			timer.stop();
		}
	}	
	
	private void gameLoop() {
		timer = new Timer(80, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				dinoScore = new Score(score+100);
				incScore();
				jlabel.setText("Score :"+score);
				repaint();
				dino.fall();
				hurdle.move();
				collision();
			}
		});
		timer.start();
	}
	
//	private void paintScore(Graphics pen) {
//		dinoScore.printBox(pen);                       
//	}
	public void collision() {
		if(isCollide()) {
			isGameOver = true;
			dino.setSpeed(0);
			hurdle.setSpeed(0);
		}
		else {
			dino.setSpeed(30);
			hurdle.setSpeed(-40);        
		}
	}
	
	private void printMsg(Graphics pen) {
		pen.setColor(Color.YELLOW);
		pen.setFont(new Font("times",Font.BOLD, 60));
		pen.drawString("GAME OVER ...", GWIDTH/2-200, GHEIGHT/2);
	}
	private boolean isCollide() {
		int xDistance = Math.abs(dino.getX()-hurdle.getX());
		int yDistance = Math.abs(dino.getY()-hurdle.getY());
		int maxW = Math.max(dino.getW(), hurdle.getW());
		int maxH = Math.max(dino.getH(), hurdle.getH());
		return xDistance<=maxW-80 && yDistance<=maxH-20;
	}
	
	private void bindEvents() {
		this.addKeyListener(new KeyAdapter() {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				dino.jump();
				dino.setCurrentMove(JUMP);
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				dino.fall();
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			dino.setCurrentMove(STANDING);
			dino.setSpeed(0);
		}	
		});
	}
	
	private void printBackgroundImage(Graphics pen) {
		pen.drawImage(backgroundImage, 0,0, GWIDTH,GHEIGHT,null);
	}
	private void loadBackgroundImage() {
		try {
			backgroundImage = ImageIO.read(DinoBoard.class.getResource("DinoBg.jpg"));
			}
			catch(Exception ex) {
				System.out.println("Background Image Loading Fail...");
				System.exit(0);
			
			}
	}	
}
