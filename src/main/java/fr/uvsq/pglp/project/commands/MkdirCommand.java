package fr.uvsq.pglp.project.commands;

import java.io.File;

import fr.uvsq.pglp.project.Command;
import fr.uvsq.pglp.project.CommandManager;
import fr.uvsq.pglp.project.Repertoire;

/**
 * MkdirCommand class that creates a new directory.
 */
public class MkdirCommand implements Command {

	private Repertoire repertoire;
	private String directoryName;
	private CommandManager commandManager;

	/**
	 * Constructs a MkdirCommand with a Repertoire object and a directory name.
	 *
	 * @param repertoire    The Repertoire in which to create the new directory.
	 * @param directoryName The name of the new directory to create.
	 */
	public MkdirCommand(Repertoire repertoire, String directoryName, CommandManager commandManager) {
		this.repertoire = repertoire;
		this.directoryName = directoryName;
		this.commandManager = commandManager;
	}

	/**
	 * Executes the command to create a new directory within the Repertoire.
	 */
	@Override
	public void execute() {
		File currentDirectory = repertoire.getDirectory();
		File newDirectory = new File(currentDirectory, directoryName);
		if (newDirectory.mkdir()) {
			repertoire.refreshFiles();
			this.commandManager.showMessage("Le répertoire " + newDirectory.getName() + " a été crée");
		} else {
			this.commandManager.showMessage("N'a pas réussi à créer un nouveau répertoire. Peut-être qu'il existe déjà.");
		}
	}
}
