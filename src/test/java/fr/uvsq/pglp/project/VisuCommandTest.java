// package fr.uvsq.pglp.project;
// import fr.uvsq.pglp.project.Repertoire;
// import fr.uvsq.pglp.project.commands.VisuCommand;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.io.ByteArrayOutputStream;
// import java.io.File;
// import java.io.PrintStream;
// import java.nio.file.Files;
// import java.nio.file.Paths;

// import static org.junit.jupiter.api.Assertions.assertTrue;

// public class VisuCommandTest {
//     private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//     private final PrintStream originalOut = System.out;

//     private final String testDirectoryPath = "testDirectory";
//     private final String testFilePath = testDirectoryPath + File.separator + "testFile.txt";

//     @BeforeEach
//     public void setUpStreams() {
//         System.setOut(new PrintStream(outContent));
//     }

//     @Test
//     public void testVisualizeTextFileContent() {
//         // Create a text file
//         String fileContent = "Hello, world!\nThis is a test file.";
//         createFileWithContent(testFilePath, fileContent);

//         // Execute the visualization command on the text file
//         try {
//             Repertoire repertoire = new Repertoire(testDirectoryPath);
//             VisuCommand visuCommand = new VisuCommand(repertoire, 0);
//             visuCommand.execute();

//             // Check console output
//             assertTrue(outContent.toString().contains(fileContent));
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     @Test
//     public void testVisualizeNonTextFileSize() {
//         // Create a non-text file
//         String fileContent = "Non-text file content";
//         createFileWithContent(testFilePath, fileContent);

//         // Execute the visualization command on the non-text file
//         try {
//             Repertoire repertoire = new Repertoire(testDirectoryPath);
//             VisuCommand visuCommand = new VisuCommand(repertoire, 0);
//             visuCommand.execute();

//             // Check console output
//             assertTrue(outContent.toString().contains(String.valueOf(fileContent.length())));
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     @Test
//     public void testVisualizeDirectory() {
//         // Create a directory
//         String directoryPath = testDirectoryPath + File.separator + "testFolder";
//         File directory = new File(directoryPath);
//         directory.mkdir();

//         // Execute the visualization command on the directory
//         try {
//             Repertoire repertoire = new Repertoire(testDirectoryPath);
//             VisuCommand visuCommand = new VisuCommand(repertoire, 0);
//             visuCommand.execute();

//             // Check console output
//             assertTrue(outContent.toString().contains("Un dossier ne peut pas être visualisé"));
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     // Utility method to create a file with specific content
//     private void createFileWithContent(String filePath, String content) {
//         try {
//             Files.write(Paths.get(filePath), content.getBytes());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     @BeforeEach
//     public void restoreStreams() {
//         System.setOut(originalOut);
//     }
// }

