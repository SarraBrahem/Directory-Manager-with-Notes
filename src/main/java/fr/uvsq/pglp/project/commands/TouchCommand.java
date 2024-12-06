package fr.uvsq.pglp.project.commands;

import fr.uvsq.pglp.project.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.time.Instant;

/**
 * TouchCommand class that creates a new file or updates the last modified time
 * if the file exists.
 */
public class TouchCommand implements Command {

	private File directory;
	private String fileName;

	/**
	 * Constructs a TouchCommand.
	 *
	 * @param directory The directory where the file is located or will be created
	 * @param fileName  The name of the file to touch
	 */
	public TouchCommand(File directory, String fileName) {
		this.directory = directory;
		this.fileName = fileName;
	}

	/**
	 * Executes the command to create or update a file.
	 */
	@Override
	public void execute() {
		File file = new File(directory, fileName);
		try {
			if (!file.exists()) {
				Files.createFile(file.toPath());
				System.out.println("File created: " + file.getAbsolutePath());
			} else {
				FileTime now = FileTime.from(Instant.now());
				Files.setLastModifiedTime(file.toPath(), now);
				System.out.println("File last modified time updated: " + file.getAbsolutePath());
			}
		} catch (IOException e) {
			System.err.println("Failed to touch the file: " + e.getMessage());
		}
	}
}
