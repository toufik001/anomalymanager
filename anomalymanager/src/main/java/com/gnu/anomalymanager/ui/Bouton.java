package com.gnu.anomalymanager.ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {

	private String name;
	private Image img;

	public Bouton(String str) {
		super(str);
		this.name = str;
		
		try {
			img = ImageIO.read(getImage("fondBouton.png"));
		} catch (IOException e) {
			
		}

		this.addMouseListener(this);
	}

	public File getImage(String name) {
		ClassLoader classLoader = getClass().getClassLoader();
		String url = classLoader.getResource("images/" + name).getFile();
		return new File(url);
	}
	
	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20,
				Color.cyan, true);
		g2d.setPaint(gp);
		// g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

		g2d.setColor(Color.black);

		// Objet qui permet de conna�tre les propri�t�s d'une police, dont la
		// taille !
		FontMetrics fm = g2d.getFontMetrics();
		// Hauteur de la police d'�criture
		int height = fm.getHeight();
		// Largeur totale de la cha�ne pass�e en param�tre
		int width = fm.stringWidth(this.name);

		// On calcule donc la position du texte dans le bouton, et le tour est
		// jou� !
		g2d.drawString(this.name, this.getWidth() / 2 - (width / 2), (this
				.getHeight() / 2)
				+ (height / 4));

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		// Pas utile d'utiliser cette m�thode ici
	}

	@Override
	public void mouseEntered(MouseEvent event) {

		// Nous changeons le fond en jaune pour notre image lors du survol
		// avec le fichier fondBoutonHover.png
		try {
			img = ImageIO.read(getImage("fondBoutonHover.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void mouseExited(MouseEvent event) {

		// Nous changeons le fond en vert pour notre image lorsqu'on quitte le
		// bouton
		// avec le fichier fondBouton.png
		try {
			img = ImageIO.read(getImage("fondBouton.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void mousePressed(MouseEvent event) {

		// Nous changeons le fond en orang� pour notre image lors du clic gauche
		// avec le fichier fondBoutonClic.png
		try {
			img = ImageIO.read(getImage("fondBoutonClic.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void mouseReleased(MouseEvent event) {

		// Nous changeons le fond en orang� pour notre image
		// lorsqu'on rel�che le clic
		// avec le fichier fondBoutonHover.png

		// Si on est � l'ext�rieur de l'objet, on dessine le fond par d�faut
		if (event.getY() > 0) {
			try {
				img = ImageIO.read(getImage("fondBoutonHover.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Sinon on met le fond jaune, la souris est encore dessus...
		else {
			try {
				img = ImageIO.read(getImage("fondBouton.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addMouseListener() {
		// TODO Auto-generated method stub
		
	}

}