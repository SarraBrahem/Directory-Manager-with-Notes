// package fr.uvsq.pglp.project;
// import fr.uvsq.pglp.project.commands.RemoveNoteCommand;

// import org.junit.jupiter.api.Test;
// import java.io.File;
// import static org.junit.jupiter.api.Assertions.*;
// public class RemoveNoteCommandTest {

//     @Test
//     public void testExecute() {
//         // Création d'un répertoire et ajout d'une note
//         String testDirectoryPath = "testDirectory";
//         Repertoire repertoire = null;
//         try {
//             repertoire = new Repertoire(testDirectoryPath);
//             repertoire.addOrUpdateNote("testFile.txt", "This is a test note");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         // Création d'une commande pour supprimer la note
//         RemoveNoteCommand removeNoteCommand = new RemoveNoteCommand(repertoire, 0);

//         // Exécution de la commande
//         removeNoteCommand.execute();

//         // Vérification que la note a bien été supprimée
//         assertNull(repertoire.getNote("testFile.txt"));
//     }
// }
