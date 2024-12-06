package fr.uvsq.pglp.project.commands;

import java.io.File;

import fr.uvsq.pglp.project.Command;
import fr.uvsq.pglp.project.CommandManager;
import fr.uvsq.pglp.project.Repertoire;

/**
 * AddNoteCommand class that adds a note to a specific file within the
 * Repertoire.
 */
public class AddNoteCommand implements Command {
	private Repertoire repertoire;
	private int ner; // The index of the file to which the note will be added
	private String note;
	private CommandManager commandManager;

	/**
	 * Constructs an AddNoteCommand with a Repertoire object, a file index, and a
	 * note.
	 *
	 * @param repertoire The Repertoire containing the file.
	 * @param fileIndex  The index of the file to which the note will be added.
	 * @param note       The note to be added to the file.
	 */
	public AddNoteCommand(Repertoire repertoire, CommandManager commandManager, int ner, String note) {
		this.repertoire = repertoire;
		this.ner = ner;
		this.note = note;
		this.commandManager = commandManager;
	}

	/**
	 * Executes the command to add a note to a file.
	 */
	@Override
	public void execute() {
		if (ner < 0 || ner > repertoire.numberOfFiles()) {
			this.commandManager.showMessage("Ce ner n'est pas dans le répertoire.");
		} else {
			File fileToAddNote = repertoire.getFile(ner);
			if (fileToAddNote != null && fileToAddNote.isFile()) {
				String fileName = fileToAddNote.getName();
				repertoire.addOrUpdateNote(fileName, note);
				repertoire.updateLastFileUsed(ner);
				this.commandManager.showMessage("Note ajoutée au fichier " + fileName);
			} else {
				System.err.println("Cannot add note, the file at the given index does not exist or is not a file.");
			}
		}
	}
}
