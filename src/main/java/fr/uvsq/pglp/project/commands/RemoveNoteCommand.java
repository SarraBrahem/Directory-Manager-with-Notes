package fr.uvsq.pglp.project.commands;

import java.io.File;

import fr.uvsq.pglp.project.Command;
import fr.uvsq.pglp.project.CommandManager;
import fr.uvsq.pglp.project.Repertoire;

public class RemoveNoteCommand implements Command {
	private Repertoire repertoire;
	private int ner;
	private CommandManager commandManager;

	public RemoveNoteCommand(Repertoire repertoire, int ner, CommandManager commandManager) {
		this.repertoire = repertoire;
		this.ner = ner;
		this.commandManager = commandManager;
	}

	@Override
	public void execute() {
		try {
			File file = repertoire.getFile(this.ner);
			if (file != null && repertoire.noteExists(this.ner)) {
				repertoire.removeNote(file.getName());
				this.commandManager.showMessage("La note associée au fichier " + file.getName() + " a été effacée");
			} else {
				this.commandManager.showMessage("Pas de note associée à ce ner.");
			}

		} catch (Exception e) {
			System.err.println("An error occurred while removing the note: " + e.getMessage());
		}
	}
}
