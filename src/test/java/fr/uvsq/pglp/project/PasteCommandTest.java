// package fr.uvsq.pglp.project;
// import fr.uvsq.pglp.project.commands.PasteCommand;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import java.io.ByteArrayOutputStream;
// import java.io.File;
// import java.io.PrintStream;

// import static org.junit.jupiter.api.Assertions.*;

// public class PasteCommandTest {

//     private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//     private final PrintStream standardOut = System.out;
//     private Repertoire repertoire;
//     private CommandUI commandUI;

//     @BeforeEach
//     public void setUp() {
//         // Créer un répertoire de test pour simuler un environnement de test
//         File testDirectory = new File("testDirectory");
//         testDirectory.mkdir();

//         // Créer un objet Repertoire pour le répertoire de test
//         try {
//             repertoire = new Repertoire(testDirectory.getAbsolutePath());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         // Créer un objet CommandUI pour simuler l'interface utilisateur
//         commandUI = new CommandUI(repertoire, null);

//         // Rediriger System.out vers le flux de sortie capturé
//         System.setOut(new PrintStream(outputStreamCaptor));
//     }

//     @Test
//     public void testExecute_CopyFile() {
//         // Créer un fichier dans le répertoire de test
//         File testFile = new File("testDirectory/testFile.txt");
//         try {
//             testFile.createNewFile();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         // Créer un fichier fictif à copier dans le répertoire de test
//         File fileToCopy = new File("testDirectory/fileToCopy.txt");
//         try {
//             fileToCopy.createNewFile();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         // Créer une commande PasteCommand pour copier le fichier
//         PasteCommand pasteCommand = new PasteCommand(repertoire, commandUI);
//         pasteCommand.execute();

//         // Vérifier que le fichier a été copié dans le répertoire
//         File copiedFile = new File("testDirectory/fileToCopy - Copy.txt");
//         assertTrue(copiedFile.exists());
//     }

//     @Test
//     public void testExecute_MoveDirectory() {
//         // Créer un répertoire fictif à copier dans le répertoire de test
//         File directoryToCopy = new File("testDirectory/directoryToCopy");
//         directoryToCopy.mkdir();

//         // Créer une commande PasteCommand pour déplacer le répertoire
//         PasteCommand pasteCommand = new PasteCommand(repertoire, commandUI);
//         pasteCommand.execute();

//         // Vérifier que le répertoire a été déplacé dans le répertoire
//         File movedDirectory = new File("testDirectory/directoryToCopy");
//         assertFalse(movedDirectory.exists());
//     }

//     // Ajouter d'autres tests selon les besoins

//     @Test
//     public void testExecute_NoFileToPaste() {
//         // Créer une commande PasteCommand sans fichier à copier
//         PasteCommand pasteCommand = new PasteCommand(repertoire, commandUI);
//         pasteCommand.execute();

//         // Vérifier qu'aucun fichier n'a été copié
//         assertEquals("No file to paste.\n", outputStreamCaptor.toString());
//     }

// }





        