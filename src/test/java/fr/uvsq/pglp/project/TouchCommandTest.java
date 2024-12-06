// package fr.uvsq.pglp.project;
// import fr.uvsq.pglp.project.Repertoire;
// import fr.uvsq.pglp.project.commands.TouchCommand;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import java.io.File;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.attribute.FileTime;

// import static org.junit.jupiter.api.Assertions.*;

// public class TouchCommandTest {
//     private final String testDirectoryPath = "testDirectory";
//     private final String testFileName = "testFile.txt";

//     @BeforeEach
//     public void setUp() {
//         File directory = new File(testDirectoryPath);
//         if (!directory.exists()) {
//             directory.mkdir();
//         }
//     }

//     @Test
//     public void testCreateFile() {
//         TouchCommand touchCommand = new TouchCommand(new File(testDirectoryPath), testFileName);
//         touchCommand.execute();

//         File createdFile = new File(testDirectoryPath, testFileName);
//         assertTrue(createdFile.exists());
//     }

//     @Test
//     public void testUpdateLastModifiedTime() throws InterruptedException {
//         // Création d'un fichier
//         TouchCommand touchCommand = new TouchCommand(new File(testDirectoryPath), testFileName);
//         touchCommand.execute();

//         // Récupération du temps de dernière modification initial
//         Path filePath = Path.of(testDirectoryPath, testFileName);
//         try {
//             FileTime initialTime = Files.getLastModifiedTime(filePath);

//             // Attendre 1 seconde pour assurer une modification de l'horodatage
//             Thread.sleep(1000);

//             // Exécuter à nouveau la commande pour mettre à jour le temps de modification
//             touchCommand.execute();

//             // Récupération du nouveau temps de dernière modification
//             FileTime updatedTime = Files.getLastModifiedTime(filePath);

//             // Vérification que le temps de dernière modification a été mis à jour
//             assertNotEquals(initialTime, updatedTime);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     @Test
//     public void testTouchCommandIntegration() {
//         // Création d'un objet Repertoire pour vérifier les données
//         try {
//             Repertoire repertoire = new Repertoire(testDirectoryPath);

//             // Exécution de la commande pour créer ou mettre à jour un fichier
//             TouchCommand touchCommand = new TouchCommand(repertoire.getDirectory(), testFileName);
//             touchCommand.execute();

//             // Vérification que le fichier a été créé ou mis à jour
//             assertTrue(repertoire.noteExists(0)); // Note: Cette méthode vérifie si le fichier existe dans la liste des fichiers du répertoire
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

