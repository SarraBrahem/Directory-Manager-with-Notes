// package fr.uvsq.pglp.project;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.io.ByteArrayOutputStream;
// import java.io.File;
// import java.io.PrintStream;
// import fr.uvsq.pglp.project.commands.AddNoteCommand;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// public class AddNoteCommandTest {

//     private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//     private final PrintStream standardOut = System.out;
//     private Repertoire repertoire;

//     @BeforeEach
//     public void setUp() {
//         // Create a test directory with files to simulate a test environment
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

//         // Create a Repertoire object for the test directory
//         try {
//             repertoire = new Repertoire(testDirectory.getAbsolutePath());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         // Redirect System.out to the captured output stream
//         System.setOut(new PrintStream(outputStreamCaptor));
//     }

//     @Test
//     public void testExecute_ValidFileIndex() {
//         // Create an AddNoteCommand with a valid file index
//         AddNoteCommand addNoteCommand = new AddNoteCommand(repertoire, 0, "This is a test note.");

//         // Execute the command
//         addNoteCommand.execute();

//         // Check if the appropriate message is printed
//         assertEquals("Note added to file: test.txt\n", outputStreamCaptor.toString());
//     }

//     @Test
//     public void testExecute_InvalidFileIndex() {
//         // Create an AddNoteCommand with an invalid file index
//         AddNoteCommand addNoteCommand = new AddNoteCommand(repertoire, 2, "This is a test note.");

//         // Execute the command
//         addNoteCommand.execute();

//         // Check if the appropriate message is printed
//         assertEquals("Invalid file index. Cannot add note.\n", outputStreamCaptor.toString());
//     }

//     @Test
//     public void testExecute_NonExistentFile() {
//         // Create an AddNoteCommand with a non-existent file index
//         AddNoteCommand addNoteCommand = new AddNoteCommand(repertoire, 3, "This is a test note.");

//         // Execute the command
//         addNoteCommand.execute();

//         // Check if the appropriate message is printed
//         assertEquals("Cannot add note, the file at the given index does not exist or is not a file.\n", outputStreamCaptor.toString());
//     }

//     @AfterEach
//     public void tearDown() {
//         // Restore System.out
//         System.setOut(standardOut);

//         // Delete the test directory and created files after each test
//         File testDirectory = new File("testDirectory");
//         if (testDirectory.exists()) {
//             for (File file : testDirectory.listFiles()) {
//                 file.delete();
//             }
//             testDirectory.delete();
//         }
//     }
// }
