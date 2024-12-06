package fr.uvsq.pglp.project.commands;

import fr.uvsq.pglp.project.Command;
import fr.uvsq.pglp.project.CommandManager;
import fr.uvsq.pglp.project.Repertoire;

import java.io.File;
import java.nio.file.NotDirectoryException;

/**
 * ParentDirectoryCommand class that navigates to the parent directory.
 */
public class ParentDirectoryCommand implements Command {

	private Repertoire repertoire;
	private CommandManager commandManager;

	/**
	 * Constructs a ParentDirectoryCommand.
	 *
	 * @param currentRepertoire The current directory context
	 */
	public ParentDirectoryCommand(Repertoire repertoire, CommandManager commandManager) {
		this.repertoire = repertoire;
		this.commandManager = commandManager;
	}

	/**
	 * Executes the command to navigate to the parent directory.
	 */
	@Override
	public void execute() {
		File parentDirectory = new File(repertoire.getDirectory().getParent());
		if (parentDirectory != null && parentDirectory.isDirectory()) {
			try {
				commandManager.changeRepertoire(new Repertoire(parentDirectory.getAbsolutePath())); // Change to the parent directory
			} catch (NotDirectoryException e) {
				e.printStackTrace();
			}
		} else {
			this.commandManager.showMessage("Pas de répertoire parent.");
		}
	}

}
