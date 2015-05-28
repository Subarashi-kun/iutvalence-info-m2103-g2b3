package fr.iutvalence.info.m2103.sokoban;

import javax.swing.SwingUtilities;

/**
 * Launcher of the Sokoban application
 */
public class Main {
		
		// TODO Auto-generated constructor stub
	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new StartMenu());
		new Sokoban(new HumanPlayerConsole(), new DisplayConsole()).play();
	}

}
