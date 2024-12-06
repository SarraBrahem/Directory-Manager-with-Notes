package fr.uvsq.pglp.project;

import java.io.File;

/**
 * MkdirCommand class that creates a new directory.
 */
public class MkdirCommandTest implements Command {

    private Repertoire repertoire;
    private String directoryName;

    /**
     * Constructs a MkdirCommand with a Repertoire object and a directory name.
     *
     * @param repertoire    The Repertoire where the directory will be created.
     * @param directoryName The name of the directory to create.
     */
    public MkdirCommandTest(Repertoire repertoire, String directoryName) {
        this.repertoire = repertoire;
        this.directoryName = directoryName;
    }

    /**
     * Executes the command to create a new directory.
     */
    @Override
    public void execute() {
        try {
            File newDirectory = new File(repertoire.getDirectory(), directoryName);
            if (newDirectory.exists()) {
                System.err.println("Failed to create directory. It already exists.");
            } else {
                newDirectory.mkdir();
                System.out.println("Directory created: " + directoryName);
            }
        } catch (Exception e) {
            System.err.println("Failed to create directory: " + e.getMessage());
        }
    }
}
