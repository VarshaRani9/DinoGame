package com.gaming.sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Score extends Sprite{
    private String score;
    public Score(Integer score) {
    	this.score=score.toString();
    }
	public void printBox(Graphics pen) {
		pen.setColor(Color.WHITE);
		pen.setFont(new Font("times",Font.BOLD, 50));
		pen.drawString("Score - ",100,100);
	}
	
	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
