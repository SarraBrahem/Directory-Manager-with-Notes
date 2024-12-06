package fr.uvsq.pglp.project;

import fr.uvsq.pglp.project.commands.EnterDirectoryCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class EnterDirectoryCommandTest {

    private Repertoire repertoire;
    private CommandManager commandManager;

    @BeforeEach
    public void setUp() {
        String tempDir = System.getProperty("java.io.tmpdir") + File.separator + "testDirectory";
        File directory = new File(tempDir);
        if (!directory.exists()) {
            directory.mkdir();
        }

        List<File> files = Arrays.asList(new File(tempDir + File.separator + "file1.txt"),
                new File(tempDir + File.separator + "file2.txt"),
                new File(tempDir + File.separator + "file3.txt"));

        try {
            for (File file : files) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File subdirectory = new File(tempDir + File.separator + "subdirectory");
        subdirectory.mkdir();

        try {
            repertoire = new Repertoire(tempDir);
        } catch (Exception e) {
            e.printStackTrace();
        }

        commandManager = new CommandManager(repertoire, new Affichage(this.repertoire));
    }

    @Test
    public void testExecute_EnterValidDirectory() {
        File expectedDirectory = repertoire.getFile(0).getParentFile();

        EnterDirectoryCommand enterDirectoryCommand = new EnterDirectoryCommand(repertoire, 0, commandManager);
        enterDirectoryCommand.execute();

        assertEquals(expectedDirectory, repertoire.getDirectory());
    }

    @Test
    public void testExecute_EnterInvalidDirectory() {
        EnterDirectoryCommand enterDirectoryCommand = new EnterDirectoryCommand(repertoire, 3, commandManager);
        enterDirectoryCommand.execute();

        assertEquals(repertoire.getDirectory(), repertoire.getDirectory());
    }

    @Test
    public void testExecute_EnterNonDirectory() {
        File file = new File(repertoire.getDirectory() + File.separator + "nonDirectory.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EnterDirectoryCommand enterDirectoryCommand = new EnterDirectoryCommand(repertoire, 3, commandManager);
        enterDirectoryCommand.execute();

        assertEquals(repertoire.getDirectory(), repertoire.getDirectory());
    }
}
