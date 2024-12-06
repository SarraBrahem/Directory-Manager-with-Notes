package fr.uvsq.pglp.project.commands;

import fr.uvsq.pglp.project.Command;
import fr.uvsq.pglp.project.CommandManager;
import fr.uvsq.pglp.project.Repertoire;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.util.Iterator;

/**
 * FindCommand class that searches for all files with a given name in the
 * current directory and its subdirectories.
 */
public class FindCommand implements Command {

	private Repertoire repertoire;
	private String fileName;
	private CommandManager commandManager;

	/**
	 * Constructs a FindCommand with a Repertoire object and a file name to search.
	 *
	 * @param repertoire The Repertoire object representing the directory to start
	 *                   the search from.
	 * @param fileName   The name of the file to search for.
	 */
	public FindCommand(Repertoire repertoire, String fileName, CommandManager commandManager) {
		this.repertoire = repertoire;
		this.fileName = fileName;
		this.commandManager = commandManager;
	}

	/**
	 * Executes the command to find all files with the given name.
	 */
	@Override
	public void execute() {
		StringBuilder res = new StringBuilder();
		File directoryToSearch = repertoire.getDirectory();
		Iterator<File> foundFiles = FileUtils.iterateFiles(
				directoryToSearch,
				new IOFileFilter() {
					@Override
					public boolean accept(File file) {
						return file.isFile() && file.getName().equals(fileName);
					}

					@Override
					public boolean accept(File dir, String name) {
						return name.equals(fileName);
					}
				},
				TrueFileFilter.TRUE);

		while (foundFiles.hasNext()) {
			res.append(foundFiles.next().getAbsolutePath()).append("\n");
		}

		if (res.length() == 0) {
			this.commandManager.showMessage("Aucun fichier avec le nom " + fileName);
		} else {
			this.commandManager.showMessage("Les fichiers suivants ont ete trouves:\n" + res);
		}
	}
}
