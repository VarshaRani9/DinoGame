package com.gaming.canvas;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.gaming.utils.GameConstants;

public class DinoFrame extends JFrame implements GameConstants{
	public DinoFrame() throws IOException {
		setTitle(TITLE);
		setSize(GWIDTH,GHEIGHT);
		setLocationRelativeTo(null);
		DinoBoard board = new DinoBoard();
		add(board);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

//	public static void main(String[] args) {
//		DinoFrame ob = null;
//		try {
//			ob = new DinoFrame();
//		}
//		catch(IOException ex) {
//			JOptionPane.showMessageDialog(ob, "Something Went Wrong...");
//			ex.printStackTrace();
//		}
//	}
}
