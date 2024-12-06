package fr.uvsq.pglp.project;

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.List;

/**
 * Gère le répertoire.
 */
public class Repertoire {
  private FileManager fileManager;
  private NoteManager noteManager;

  public Repertoire(String path) throws NotDirectoryException {
    this.fileManager = new FileManager(path);
    this.noteManager = new NoteManager(path);
  }

  public void addOrUpdateNote(String filename, String note) {
    noteManager.addOrUpdateNote(filename, note);
  }

  public String getNote(String filename) {
    return noteManager.getNote(filename);
  }

  public void removeNote(String filename) {
    noteManager.removeNote(filename);
  }

  public boolean noteExists(int index) {
    File file = fileManager.getFile(index);
    return file != null && noteManager.getNote(file.getName()) != null;
  }

  public List<File> listFiles() {
    return fileManager.listFiles();
  }

  public File getFile(int index) {
    return fileManager.getFile(index);
  }

  public void createDirectory(String name) {
    fileManager.createDirectory(name);
  }

  public void deleteFile(int index) throws Exception {
    fileManager.deleteFile(index);
  }

  public String getAbsolutePath() {
    return fileManager.getAbsolutePath();
  }

  public File getDirectory() {
    return fileManager.getDirectory();
  }

  public int numberOfFiles() {
    return fileManager.numberOfFiles();
  }

  public int getLastFileUsed() {
    return fileManager.getLastFileUsed();
  }

  public void updateLastFileUsed(int newLastFileUsed) {
    fileManager.updateLastFileUsed(newLastFileUsed);
  }

  public void refreshFiles() {
    fileManager.refresh();
  }

}
