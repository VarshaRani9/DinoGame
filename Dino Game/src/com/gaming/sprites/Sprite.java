package com.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gaming.utils.GameConstants;
import com.gaming.utils.DinoConstants;
public abstract class Sprite implements GameConstants,DinoConstants{
	protected int x;
	 protected int y;
	 protected int w;
	 protected int h;
	 protected int speed;
	 protected BufferedImage image;
	 protected int imageIndex;
	 protected int currentMove;
	 protected int force;
	 protected boolean isJump;
	 public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getCurrentMove() {
		return currentMove;
	}

	public void setCurrentMove(int currentMove) {
		this.currentMove = currentMove;
	}

	public Sprite() {
		 h=200;
		   w=200;
	 }
	 
	 public abstract BufferedImage defaultImage();
	 public void printSprite(Graphics pen) {
		   pen.drawImage(defaultImage(), x, y, w,h, null);
	   }
}
