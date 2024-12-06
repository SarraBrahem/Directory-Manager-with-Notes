// package fr.uvsq.pglp.project;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import fr.uvsq.pglp.project.commands.NoteManager;

// import java.io.*;
// import java.util.HashMap;
// import java.util.Map;
// import static org.junit.jupiter.api.Assertions.*;

// public class NoteManagerTest {
//     private NoteManager noteManager;
//     private final String testDirectoryPath = "testDirectory";
//     private final String testFileName = "testFile.txt";

//     @BeforeEach
//     public void setUp() {
//         noteManager = new NoteManager(testDirectoryPath);
//     }

//     @Test
//     public void testAddOrUpdateNoteForFile() {
//         // Ajout d'une note pour un fichier
//         String note = "This is a test note";
//         noteManager.addOrUpdateNoteForFile(testFileName, note);

//         // Vérification que la note a bien été ajoutée
//         assertTrue(noteManager.hasNote(testFileName));
//         assertEquals(note, noteManager.getNoteForFile(testFileName));
//     }

//     @Test
//     public void testRemoveNoteForFile() {
//         // Ajout d'une note pour un fichier
//         String note = "This is a test note";
//         noteManager.addOrUpdateNoteForFile(testFileName, note);

//         // Suppression de la note pour ce fichier
//         noteManager.removeNoteForFile(testFileName);

//         // Vérification que la note a bien été supprimée
//         assertFalse(noteManager.hasNote(testFileName));
//         assertNull(noteManager.getNoteForFile(testFileName));
//     }

//     @Test
//     public void testLoadAndSaveNotes() {
//         // Création d'une map de notes
//         Map<String, String> expectedNotes = new HashMap<>();
//         expectedNotes.put("file1.txt", "Note for file 1");
//         expectedNotes.put("file2.txt", "Note for file 2");
//         expectedNotes.put("file3.txt", "Note for file 3");

//         // Ajout des notes et sauvegarde
//         expectedNotes.forEach(noteManager::addOrUpdateNoteForFile);
//         noteManager.saveNotes();

//         // Création d'un nouveau NoteManager pour charger les notes sauvegardées
//         NoteManager loadedNoteManager = new NoteManager(testDirectoryPath);

//         // Vérification que les notes ont été correctement chargées
//         expectedNotes.forEach((fileName, expectedNote) -> {
//             assertTrue(loadedNoteManager.hasNote(fileName));
//             assertEquals(expectedNote, loadedNoteManager.getNoteForFile(fileName));
//         });
//     }
// }

