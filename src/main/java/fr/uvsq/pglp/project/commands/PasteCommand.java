package fr.uvsq.pglp.project.commands;

import fr.uvsq.pglp.project.Command;
import fr.uvsq.pglp.project.CommandManager;
import fr.uvsq.pglp.project.Repertoire;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
public class PasteCommand implements Command {

	private Repertoire repertoire;
	private CommandManager commandManager;

	public PasteCommand(Repertoire repertoire, CommandManager commandManager) {
		this.repertoire = repertoire;
		this.commandManager = commandManager;
	}

	@Override
	public void execute() {
		if (this.commandManager.fileToCopy() == null) {
			this.commandManager.showMessage("Utilisez la command copy ou cut avant paste.");
			return;
		}
		File originalFile = this.commandManager.fileToCopy();
		File copiedFile = new File(
				this.repertoire.getAbsolutePath() + File.separator + this.commandManager.fileToCopy().getName());
		while (copiedFile.exists()) {
			String name = copiedFile.getName();
			int lastDot = -1;
			if (name.contains(".")) {
				lastDot = name.lastIndexOf('.');
			} else {
				lastDot = name.length();
			}
			String newName = name.substring(0, lastDot) + " - Copy" + name.substring(lastDot);
			copiedFile = new File(this.repertoire.getAbsolutePath() + File.separator + newName);
		}
		try {
			if (!this.commandManager.eraseAfterCopy()) {
				if (originalFile.isDirectory()) {
					FileUtils.copyDirectory(originalFile, copiedFile);
					this.commandManager.showMessage("Le répértoire " + copiedFile.getName() + " a été crée.");
				} else {
					FileUtils.copyFile(originalFile, copiedFile);
					this.commandManager.showMessage("Le fichier " + copiedFile.getName() + " a été crée.");
				}
			} else {
				if (originalFile.isDirectory()) {
					FileUtils.moveDirectory(originalFile, copiedFile);
					this.commandManager.showMessage("Le répértoire " + copiedFile.getName() + " a été crée.");
				} else {
					FileUtils.moveFile(originalFile, copiedFile);
					this.commandManager.showMessage("Le fichier " + copiedFile.getName() + " a été crée.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.repertoire.refreshFiles();
	}
}
