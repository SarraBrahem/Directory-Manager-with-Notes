package fr.uvsq.pglp.project.commands;

import fr.uvsq.pglp.project.Command;
import fr.uvsq.pglp.project.CommandManager;
import fr.uvsq.pglp.project.Repertoire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

/**
 * VisuCommand class that retrieves the content of a text file or its size if
 * not a text file.
 */
public class VisuCommand implements Command {

	private Repertoire repertoire;
	private int ner;
	private CommandManager commandManager;

	/**
	 * Constructs a VisuCommand with a Repertoire object and a file index.
	 *
	 * @param repertoire The Repertoire containing the file.
	 * @param ner  The index of the file to visualize.
	 */
	public VisuCommand(Repertoire repertoire, int ner, CommandManager commandManager) {
		this.repertoire = repertoire;
		this.ner = ner;
		this.commandManager = commandManager;
	}

	/**
	 * Executes the command to visualize the file content or size.
	 */
	@Override
	public void execute() {
		File fileToVisualize = repertoire.getFile(ner);
		if (fileToVisualize != null) {
			try {
				if (fileToVisualize.isFile()) {
					String contentType = Files.probeContentType(fileToVisualize.toPath());
					if ("text/plain".equals(contentType)) {
						this.commandManager.showMessage("Le contenu de ce fichier est:\n" + readFileContent(fileToVisualize));
					} else {
						this.commandManager.showMessage("La taille de ce fichier est:\n" + fileToVisualize.length() + " bytes");
					}
					this.repertoire.updateLastFileUsed(this.ner);
				} else {
					this.commandManager.showMessage("Un dossier ne peut pas être visualisé");
				}
			} catch (IOException e) {
				System.err.println("Error processing file: " + e.getMessage());
			}
		} else {
			System.err.println("Invalid file index or file does not exist");
		}
	}

	/**
	 * Reads the content of a text file.
	 *
	 * @param file The file to read from.
	 * @return The content of the file as a String.
	 * @throws IOException If an I/O error occurs.
	 */
	private String readFileContent(File file) throws IOException {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
		}
		return content.toString();
	}
}
