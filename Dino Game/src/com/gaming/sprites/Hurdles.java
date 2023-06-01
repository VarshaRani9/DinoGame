package com.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hurdles extends Sprite{
	   private BufferedImage images[] = new BufferedImage[8];
	   
	   public Hurdles() throws IOException{
		   x=1400;
		   y = FLOOR - h;
		   speed = -60;
		   currentMove = STANDING;
		   image = ImageIO.read(Dino.class.getResource(DINO_IMAGE));
		   loadImages();
	   }
	   
	   public void move() {
			x = x+speed+10;
		}
	   
	   private void loadImages() {
		   images[0] = image.getSubimage(357,0,25,52);
		   images[1] = image.getSubimage(381,0,26,51);
		   images[2] = image.getSubimage(431,1,26,52);
		   images[3] = image.getSubimage(295,0,18,39);
		   images[4] = image.getSubimage(228,2,34,37);
		   images[5] = image.getSubimage(407,2,50,46);
		   images[6] = image.getSubimage(431,1,52,51);
		   images[7] = image.getSubimage(228,0,34,38);
	   }

	@Override
	public BufferedImage defaultImage() {
		BufferedImage img = images[imageIndex];
		if(x<0) {
			imageIndex++;
			x=1400;
		}
		if(imageIndex>7) {
			imageIndex = 0;
		}
		   return img;
	}

}
