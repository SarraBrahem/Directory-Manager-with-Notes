package fr.uvsq.pglp.project.commands;

public class NoteExtractor {

	/**
	 * Extracts a note from command line input.
	 *
	 * @param commands       Array of command parts.
	 * @param firstWordIndex Index of the first word in the commands array to start
	 *                       the extraction from.
	 * @return The extracted note as a string.
	 */
	public static String extractNote(String[] commands, int firstWordIndex) {
		StringBuilder note = new StringBuilder();
		if (commands[firstWordIndex].length() > 1) {
			if (commands.length == firstWordIndex + 2) { // Adjusting for one-word notes with quotes
				note.append(commands[firstWordIndex].substring(1, commands[firstWordIndex].length() - 1));
			} else {
				note.append(commands[firstWordIndex].substring(1));
			}
		}
		for (int i = firstWordIndex + 1; i < commands.length - 1; i++) {
			note.append(" ");
			note.append(commands[i]);
		}
		if (commands.length > firstWordIndex + 2 && commands[commands.length - 1].length() > 1) {
			note.append(" ");
			String lastCommand = commands[commands.length - 1];
			note.append(lastCommand.substring(0, lastCommand.length() - 1));
		}
		return note.toString();
	}
}