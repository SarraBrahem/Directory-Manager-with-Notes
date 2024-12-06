package fr.uvsq.pglp.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Gère les notes associées aux fichiers d'un répertoire.
 */
public class NoteManager {

  private Map<String, String> notes;
  private final File notesFile;

  /**
   * Instancie une instance de NoteManager à partir du chemin
   * vers le répertoire dont on veut gérer les notes.
   *
   * @param directoryPath Le chemin du répertoire dont on veut gérer les notes.
   */
  public NoteManager(String directoryPath) {
    this.notesFile = new File(directoryPath, ".notes");
    this.notes = new HashMap<>();
    loadNotes();
  }

  private void loadNotes() {
    if (notesFile.exists()) {
      try (BufferedReader reader = new BufferedReader(new FileReader(notesFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
          String[] parts = line.split(";", 2);
          if (parts.length == 2) {
            notes.put(parts[0], parts[1]);
          }
        }
      } catch (IOException e) {
        System.err.println("Error loading notes: " + e.getMessage());
      }
    }
  }

  public void addOrUpdateNote(String filename, String note) {
    notes.put(filename, note);
    saveNotes();
  }

  public void removeNote(String filename) {
    notes.remove(filename);
    saveNotes();
  }

  public String getNote(String filename) {
    return notes.get(filename);
  }

  private void saveNotes() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(notesFile))) {
      for (Map.Entry<String, String> entry : notes.entrySet()) {
        writer.write(entry.getKey() + ";" + entry.getValue());
        writer.newLine();
      }
    } catch (IOException e) {
      System.err.println("Error saving notes: " + e.getMessage());
    }
  }
}
