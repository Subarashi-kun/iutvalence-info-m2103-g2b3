/**
 * 
 */
package fr.iutvalence.info.m2103.sokoban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * @author robinhug
 *
 */
public class StartMenu implements Runnable,ActionListener {

	/**
	 * La fen�tre
	 */
	private JFrame fenetre;

	/**
	 * L'item de menu "A propos"
	 */
	private JMenuItem menuItemAPropos;

	/**
	 * L'item de menu "Fermer"
	 */
	private JMenuItem menuItemFermer;

	/**
	 * Le bouton d�marrer
	 */
	private JButton boutonStart;

	@Override
	public void run()
	{
		this.fenetre = new JFrame();

		this.fenetre.setTitle("Sokoban");
		this.fenetre.setSize(800, 600);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// Cr�ation du composant associ� � la barre de menu
		JMenuBar barreDeMenu = new JMenuBar();

		// Cr�ation de la rubrique de menu "Menu"
		JMenu menu = new JMenu("Menu");

		// Cr�ation de l'item de rubrique "A propos"
		this.menuItemAPropos = new JMenuItem("A propos");

		// Association de la t�che comme auditeur d'�v�nement
		this.menuItemAPropos.addActionListener(this);

		// Ajout du premier item � la rubrique (l'ordre d'ajout est l'ordre
		// d'apparition)
		menu.add(this.menuItemAPropos);

		// (idem pour le second item de rubrique)
		this.menuItemFermer = new JMenuItem("Fermer");
		this.menuItemFermer.addActionListener(this);
		menu.add(this.menuItemFermer);

		// Ajout de la rubrique � la barre de menu
		barreDeMenu.add(menu);

		// Affectation de la barre de menu � la fen�tre
		this.fenetre.setJMenuBar(barreDeMenu);

		// Cr�ation du composant graphique associ� au bouton
		// un contenu texte est associ� au bouton (mais pas d'icone)
		
		this.boutonStart = new JButton("Je marche pas comme �a!");
		this.boutonStart.setSize(50,50);
		
		// Ajout du bouton dans le conteneur principal associ� � la fen�tre
		// (c'est le seul composant)
			this.fenetre.getContentPane().add(this.boutonStart);


		this.fenetre.setVisible(true);
	}

	/**
	 * Traitement des �v�nements associ�s aux items de rubriques
	 * 
	 * @param event
	 *            l'�v�nement survenu
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Identification de l'item s�lectionn�, source de l'�v�nement
		JMenuItem itemSelectionne = (JMenuItem) event.getSource();

		if (itemSelectionne == this.menuItemAPropos)
		{
			// Affichage d'un boite de dialogue d�livrant un simple message
			JOptionPane.showMessageDialog(this.fenetre, "C'est appli est ENORME! Comme ma... Euh wait!", "A propos", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (itemSelectionne == this.menuItemFermer)
		{
			// Affichage d'un boite de dialogue proposant 2 options
			// (confirmer/annuler)
			if (JOptionPane.showConfirmDialog(this.fenetre, "WESHEUH! Ferme pas notre application comme �a!", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				// destruction de la fen�tre en cas de confirmation de fermeture
				this.fenetre.dispose();
		}
	}

}
