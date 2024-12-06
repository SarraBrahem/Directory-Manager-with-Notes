package fr.uvsq.pglp.project.commands;

import fr.uvsq.pglp.project.Command;
import fr.uvsq.pglp.project.CommandManager;
import fr.uvsq.pglp.project.Repertoire;

import java.io.File;
import java.nio.file.NotDirectoryException;
/**
 * EnterDirectoryCommand class that changes the current directory to a specified
 * child directory.
 */
public class EnterDirectoryCommand implements Command {

	private Repertoire repertoire;
	private int ner;
	private CommandManager commandManager;

	/**
	 * Constructs an EnterDirectoryCommand.
	 *
	 * @param currentRepertoire The current directory context
	 * @param ner               The index of the subdirectory to enter
	 */
	public EnterDirectoryCommand(Repertoire repertoire, int ner, CommandManager commandManager) {
		this.repertoire = repertoire;
		this.ner = ner;
		this.commandManager = commandManager;
	}

	/**
	 * Executes the command to enter the subdirectory.
	 */
	@Override
	public void execute() {
		try {
			if (ner >= 0 && ner < this.repertoire.listFiles().size()) {
				File subdirectory = this.repertoire.getFile(ner);
				if (subdirectory.isDirectory()) {
					this.commandManager.changeRepertoire(new Repertoire(subdirectory.getAbsolutePath()));
				} else {
					this.commandManager.showMessage(subdirectory.getName() + " n'est pas un répertoire.");
				}
			} else {
				this.commandManager.showMessage("Ce ner n'est pas dans le répertoire.");
			}
		} catch (NotDirectoryException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
