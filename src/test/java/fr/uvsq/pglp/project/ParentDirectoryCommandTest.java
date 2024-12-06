// package fr.uvsq.pglp.project;
// import fr.uvsq.pglp.project.commands.ParentDirectoryCommand;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.io.ByteArrayOutputStream;
// import java.io.File;
// import java.io.PrintStream;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// public class ParentDirectoryCommandTest {

//     private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//     private final PrintStream standardOut = System.out;

//     @BeforeEach
//     public void setUp() {
//         System.setOut(new PrintStream(outputStreamCaptor));
//     }

//     @Test
//     public void testExecute_ParentDirectoryCommand() {
//         // Création d'un répertoire parent factice pour les tests
//         File parentDirectory = new File("parent");
//         parentDirectory.mkdir();

//         // Création d'un répertoire enfant factice pour les tests
//         File childDirectory = new File(parentDirectory, "child");
//         childDirectory.mkdir();

//         // Répertoire actuel (répertoire enfant)
//         Repertoire currentRepertoire = null;
//         try {
//             currentRepertoire = new Repertoire(childDirectory.getAbsolutePath());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         // Répertoire parent
//         Repertoire parentRepertoire = null;
//         try {
//             parentRepertoire = new Repertoire(parentDirectory.getAbsolutePath());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         // Création d'une instance de CommandUI avec le répertoire actuel
//         CommandUI commandUI = new CommandUI(currentRepertoire, null);

//         // Création d'une instance de ParentDirectoryCommand avec le répertoire parent
//         ParentDirectoryCommand parentDirectoryCommand = new ParentDirectoryCommand(parentRepertoire, commandUI);

//         // Exécution de la commande ParentDirectoryCommand
//         parentDirectoryCommand.execute();

//         // Vérification de la sortie
//         assertEquals("Moved to parent directory: parent\n", outputStreamCaptor.toString());

//         // Suppression des répertoires factices créés pour les tests
//         childDirectory.delete();
//         parentDirectory.delete();
//     }
// }
