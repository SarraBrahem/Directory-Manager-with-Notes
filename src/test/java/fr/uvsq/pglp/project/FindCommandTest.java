package fr.uvsq.pglp.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import fr.uvsq.pglp.project.commands.FindCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindCommandTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private Repertoire repertoire;
    private CommandManager commandManager;
    private Affichage affichage;

    @BeforeEach
    public void setUp() {
        // Créez un répertoire de test avec des fichiers pour simuler un environnement de test
        File testDirectory = new File("src/test/resources/testDirectory");
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
    public void testExecute_NoFilesFound() {
        // Créez une commande FindCommand avec un nom de fichier qui n'existe pas
        FindCommand findCommand = new FindCommand(repertoire, "non_existent_file.txt", this.commandManager);

        // Exécutez la commande
        findCommand.execute();

        // Vérifiez si le message approprié est imprimé
        String expectedOutput = "Aucun fichier avec le nom non_existent_file.txt\n";
        assertEquals(cleanString(expectedOutput), cleanString(getOutput()), "Incorrect output message");
    }

    @Test
    public void testExecute_FilesFound() {
        // Créez une commande FindCommand avec un nom de fichier qui existe
        FindCommand findCommand = new FindCommand(repertoire, "test.txt", this.commandManager);

        // Exécutez la commande
        findCommand.execute();

        // Vérifiez si le message approprié est imprimé
        assertTrue(getOutput().contains("Les fichiers suivants ont ete trouves:\n"), "Expected 'Found files:' message");
        assertTrue(getOutput().contains("test.txt"), "Expected 'test.txt' file found");
    }

    @AfterEach
    public void tearDown() {
        // Rétablissez System.out
        System.setOut(standardOut);

        // Supprimez le répertoire de test et les fichiers créés après chaque test
        File testDirectory = new File("src/test/resources/testDirectory");
    }

    private String getOutput() {
        try {
            return outputStreamCaptor.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String cleanString(String str) {
        // Supprimer les espaces inutiles et les caractères de fin de ligne
        return str.trim();
    }
}
