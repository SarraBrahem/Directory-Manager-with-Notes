package fr.uvsq.pglp.project.commands;

import fr.uvsq.pglp.project.Command;
import fr.uvsq.pglp.project.CommandManager;
import fr.uvsq.pglp.project.Repertoire;
import java.io.File;
public class CutCommand implements Command {

	private final Repertoire repertoire;
	private final int ner;
	private File file;
	private final CommandManager commandManager;

	public CutCommand(Repertoire repertoire, CommandManager commandManager) {
		this.repertoire = repertoire;
		this.ner = repertoire.getLastFileUsed();
		this.commandManager = commandManager;
	}

	public CutCommand(Repertoire repertoire, int ner, CommandManager commandManager) {
		this.repertoire = repertoire;
		this.ner = ner;
		this.commandManager = commandManager;
	}

	@Override
	public void execute() {
		if (ner < 0 || ner >= repertoire.numberOfFiles()) {
			this.commandManager.showMessage("Ce ner n'est pas dans le répertoire.");
		} else {
			this.file = repertoire.getFile(ner);
			this.commandManager.copyFile(this);
			this.repertoire.updateLastFileUsed(ner);
			if (this.file.isDirectory()) {
				this.commandManager.showMessage("Le répertoire " + this.file.getName() + " est prêt à être déplacé");
			} else {
				this.commandManager.showMessage("Le fichier " + this.file.getName() + " est prêt à être déplacé");
			}
		}
	}

	public File getFile() {
		return this.file;
	}
}
