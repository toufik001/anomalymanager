package com.myprojects.anomalymanager.ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MonPanel extends JPanel {

	/** variable de classe contenant l'image � afficher en fond */
	private Image image;

	public MonPanel() {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			String url = classLoader.getResource("images/logo-oncf.jpg").getFile();
			image = ImageIO.read(new File(url));
		} catch (IOException e) {
			System.out.println("imaage");
		}
	}

	/** Surcharge de la fonction paintComponent() pour afficher notre image */
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
		g2d.setPaint(gp);
		// g.drawImage(image,0,0,null);
		g2d.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);

	}

}