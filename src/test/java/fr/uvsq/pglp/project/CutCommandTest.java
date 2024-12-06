// package fr.uvsq.pglp.project;
// import fr.uvsq.pglp.project.commands.CutCommand;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.io.ByteArrayOutputStream;
// import java.io.File;
// import java.io.PrintStream;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNull;

// public class CutCommandTest {

//     private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//     private final PrintStream standardOut = System.out;
//     private Repertoire repertoire;

//     @BeforeEach
//     public void setUp() {
//         // Créer un répertoire de test avec des fichiers pour simuler un environnement de test
//         File testDirectory = new File("testDirectory");
//         testDirectory.mkdir();
//         File testFile1 = new File(testDirectory, "test.txt");
//         File testFile2 = new File(testDirectory, "another_test.txt");
//         try {
//             testFile1.createNewFile();
//             testFile2.createNewFile();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         // Créer un objet Repertoire pour le répertoire de test
//         try {
//             repertoire = new Repertoire(testDirectory.getAbsolutePath());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         // Rediriger System.out vers le flux de sortie capturé
//         System.setOut(new PrintStream(outputStreamCaptor));
//     }

//     @Test
//     public void testExecute_ValidFileIndex() {
//         // Définir un index de fichier valide pour le répertoire
//         repertoire.setLastFileUsed(0);

//         // Créer une commande CutCommand avec un index de fichier valide
//         CutCommand cutCommand = new CutCommand(repertoire, null);
//         cutCommand.execute();

//         // Vérifier que le fichier a été récupéré
//         File cutFile = cutCommand.getFile();
//         assertEquals("test.txt", cutFile.getName());
//     }

//     @Test
//     public void testExecute_InvalidFileIndex() {
//         // Définir un index de fichier invalide pour le répertoire
//         repertoire.setLastFileUsed(10);

//         // Créer une commande CutCommand avec un index de fichier invalide
//         CutCommand cutCommand = new CutCommand(repertoire, null);
//         cutCommand.execute();

//         // Vérifier que le fichier n'a pas été récupéré
//         assertNull(cutCommand.getFile());
//     }

//     // Assurez-vous d'écrire d'autres tests selon vos besoins

//     @AfterEach
//     public void tearDown() {
//         // Restaurer System.out
//         System.setOut(standardOut);

//         // Supprimer le répertoire de test et les fichiers créés après chaque test
//         File testDirectory = new File("testDirectory");
//         if (testDirectory.exists()) {
//             for (File file : testDirectory.listFiles()) {
//                 file.delete();
//             }
//             testDirectory.delete();
//         }
//     }
// }
