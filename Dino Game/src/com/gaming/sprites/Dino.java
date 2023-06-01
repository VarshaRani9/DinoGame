package com.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dino extends Sprite{
	private BufferedImage jumpImages[] = new BufferedImage[2];
	   private BufferedImage standingImages[] = new BufferedImage[4];
	   
	   public Dino() throws IOException{
		   x=100;
		   y = FLOOR - h;
		   currentMove = STANDING;
		   image = ImageIO.read(Dino.class.getResource(DINO_IMAGE));
		   loadStandingImages();
		   loadJumpImages();
	   }
	   
	   
	   public void jump() {
		   if(!isJump) {
		   force = DEFAULTFORCE;
		   y = y + force;
		   isJump = true;
		   }
	   }
	   public void fall() {
		   if(y>=(FLOOR-h)) {
			   isJump = false;
			   return;
			   }
		   force = force+ GRAVITY;
		   y = y + force;
		   
	   }
	   
	   
	   private void loadJumpImages() {
		   jumpImages[0] = image.getSubimage(766,1,43,50);
		   jumpImages[1] = image.getSubimage(809,3,44,48);
	   }
	   private BufferedImage jumpImage() {
		   if(imageIndex>1) {
			   imageIndex = 0;
			   currentMove = STANDING;
		   }
		   BufferedImage img = jumpImages[imageIndex];
		   imageIndex++;
		   return img;
	   }
	   private void loadStandingImages() {
		   standingImages[0] = image.getSubimage(675,2,46,48);
		   standingImages[1] = image.getSubimage(721,1,43,50);
		   standingImages[2] = image.getSubimage(853,1,42,51);
		   standingImages[3] = image.getSubimage(898,3,40,45);
	   }
	   private BufferedImage standingImage() {
		   if(imageIndex>3) {
			   imageIndex = 0;
		   }
		   BufferedImage img = standingImages[imageIndex];
		   imageIndex++;
		   return img;
	   }
	@Override
	public BufferedImage defaultImage() {
		if(currentMove == JUMP) {
			   return jumpImage();
		   }
		   return standingImage();
	}
}
