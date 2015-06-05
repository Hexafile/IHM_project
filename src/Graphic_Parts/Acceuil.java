package Graphic_Parts;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Tech_Part.Eleve;
import Tech_Part.Groupe;

/**
 * 
 * @author PC
 *
 */

public class Acceuil {

	protected Groupe g = new Groupe("G");

	protected CardLayout cl = new CardLayout();

	protected BorderLayout bl = new BorderLayout();

	protected Border bBlack = BorderFactory.createLineBorder(Color.black, 2);

	protected String[] listContent = { "ListText", "ListFaces", "ListHybride" };

	JFrame main = new JFrame("Acceuil");
	JPanel content = new JPanel();
	JPanel menu = new JPanel();
	JPanel listText = new JPanel();
	JPanel listFaces = new JPanel();
	JPanel listHybride = new JPanel();
	JPanel info = new JPanel();
	JButton format = new JButton();
	JButton tri = new JButton();
	JLabel infoL = new JLabel(g.getNomG());

	public Acceuil() {
		g.Load();

		main.setSize(320, 480);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setResizable(false);

		menu.setBackground(Color.black);

		format.setIcon(new ImageIcon("src/main/resources/format-icon.png"));
		format.setBorder(bBlack);
		format.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cl.next(content);
			}
		});

		tri.setIcon(new ImageIcon("src/main/resources/arrow-icon.jpg"));
		tri.setBorder(bBlack);

		info.setBorder(bBlack);
		info.setBackground(Color.white);
		info.setOpaque(true);
		info.setForeground(Color.black);
		info.add(infoL);
		
		menu.add(tri, BorderLayout.EAST);
		menu.add(info, BorderLayout.CENTER);
		menu.add(format, BorderLayout.WEST);
		menu.setBorder(bBlack);

		listText.setBackground(Color.white);
		initInfoText();
		listFaces.setBackground(Color.white);
		initInfoFaces();
		listHybride.setBackground(Color.white);

		content.setLayout(cl);
		content.add(listText, listContent[0]);
		content.add(listFaces, listContent[1]);
		content.add(listHybride, listContent[2]);

		main.add(menu, BorderLayout.NORTH);
		main.add(content, BorderLayout.CENTER);
		main.setVisible(true);
	}

	public void initInfoText() {
		
		int x = 0 ;
		int y = 10 ;
		
		for(Eleve e : g.group) {
			JButton name = new JButton(e.getName() + " " + e.getSurname() + " [" + e.getId() + "]");
			name.setBounds(x, y+=30,200,25);
			name.setForeground(Color.black);
			name.setBackground(Color.white);
			listText.setLayout(null);
			listText.add(name, BorderLayout.CENTER);
			listText.repaint();	
			name.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					click(event);
				}
			});
		}
		listText.setLayout(bl);
		listText.repaint();
	}
	
	public void initInfoFaces() {
		
		int x = 0 ;
		int y = 10 ;
		
		for(Eleve e : g.group) {
			JButton name = new JButton(e.getName() + " " + e.getSurname());
			JPanel image = new JPanel();
			JLabel cont = new JLabel(new ImageIcon("src/main/resources/" + e.getSurname() + ".png"));
			name.setBounds(x, y+=70,150,25);
			name.setForeground(Color.black);
			name.setBackground(Color.white);
			image.setBounds(x+170,y,50,60);
			image.setBorder(bBlack);
			image.add(cont, BorderLayout.CENTER);
			listFaces.setLayout(null);
			listFaces.add(name, BorderLayout.CENTER);
			listFaces.add(image, BorderLayout.EAST);
			listFaces.repaint();
			name.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					click(event);
				}
			});
		}
		listFaces.setLayout(bl);
		listFaces.repaint();
	}

	public void click(ActionEvent event) {
		JButton jb = (JButton) event.getSource();
		if (jb.getBackground() == Color.white) {
			jb.setBackground(Color.red);
		} else if (jb.getBackground() == Color.red) {
			jb.setBackground(Color.orange);
		} else if (jb.getBackground() == Color.orange) {
			jb.setBackground(Color.white);
		}
	}

	public static void main(String[] args) {
		Acceuil test = new Acceuil();
	}
}
