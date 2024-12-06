package fr.uvsq.pglp.project;
import fr.uvsq.pglp.project.commands.CopyCommand;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
public class CopyCommandTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private Repertoire repertoire;
    private CommandManager commandManager;
    private Affichage affichage;

    @BeforeEach
    public void setUp() {
        // Créez un répertoire de test avec des fichiers pour simuler un environnement de test
        File testDirectory = new File("testDirectory");
        testDirectory.mkdir();
        File testFile1 = new File(testDirectory, "test.txt");
        File testFile2 = new File(testDirectory, "another_test.txt");
        try {
            testFile1.createNewFile();
            testFile2.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Créez un objet Repertoire pour le répertoire de test
        try {
            repertoire = new Repertoire(testDirectory.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirigez System.out vers le flux de sortie capturé
        System.setOut(new PrintStream(outputStreamCaptor));
        this.affichage = new Affichage(this.repertoire);
        this.commandManager = new CommandManager(this.repertoire, this.affichage);
    }

    @Test
    public void testExecute_ValidFileIndex() {
    	System.out.println("azsdfghjugfvbn,");
        // Créez une commande CopyCommand avec un index de fichier valide
        CopyCommand copyCommand = new CopyCommand(repertoire, this.commandManager);
        copyCommand.execute();

        // Ajoutez vos assertions ici
    }

    @Test
    public void testExecute_InvalidFileIndex() {
        // Configurez un index de fichier invalide pour le répertoire
        repertoire.updateLastFileUsed(10);

        // Créez une commande CopyCommand avec un index de fichier invalide
        CopyCommand copyCommand = new CopyCommand(repertoire, this.commandManager);
        copyCommand.execute();

        // Ajoutez vos assertions ici
    }

    // Assurez-vous d'écrire d'autres tests selon vos besoins

    @AfterEach
    public void tearDown() {
        // Rétablissez System.out
        System.setOut(standardOut);

        // Supprimez le répertoire de test et les fichiers créés après chaque test
        File testDirectory = new File("testDirectory");
        if (testDirectory.exists()) {
            for (File file : testDirectory.listFiles()) {
                file.delete();
            }
            testDirectory.delete();
        }
    }
}
