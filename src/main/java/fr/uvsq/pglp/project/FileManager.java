package fr.uvsq.pglp.project;

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Permet d'interagir avec un répertoire.
 */
public class FileManager {
  private File directory;
  private List<File> listFileDir;
  private int lastFileUsed = -1;

  /**
   * Instancie le répertoire avec lequel on veut interagir.
   *
   * @param path Le chemin du répertoire avec lequel on veut interagir.
   * @throws NotDirectoryException si le chemin donné n'est pas un répertoire.
   */
  public FileManager(String path) throws NotDirectoryException {
    this.directory = new File(path);
    if (!directory.isDirectory()) {
      throw new NotDirectoryException("The provided path is not a directory: " + path);
    }
    refresh();
  }

  public File getDirectory() {
    return directory;
  }

  public List<File> listFiles() {
    return listFileDir;
  }

  /**
   * Renvoie le fichier à l'index indiqué du répertoire.
   *
   * @param index L'indice du fichier.
   * @return Le File à l'indice indiqué.
   */
  public File getFile(int index) {
    if (index >= 0 && index < listFileDir.size()) {
      return listFileDir.get(index);
    }
    return null;
  }

  public int numberOfFiles() {
    return listFileDir.size();
  }

  /**
   * Crée un nouveau répertoire dans le répertoire avec lequel on interagit.
   *
   * @param name Le nom du répertoire que l'on veut créer.
   * @return true si il a bien été crée, false sinon.
   */
  public boolean createDirectory(String name) {
    File newDir = new File(directory, name);
    if (!newDir.exists()) {
      boolean isCreated = newDir.mkdirs();
      if (isCreated) {
        refresh();
      }
      return isCreated;
    }
    return false;
  }

  /**
   * Efface un fichier à un indice donné.
   *
   * @param index L'indice du fichier à effacer.
   * @return true si le fochier a bien été effacé, false sinon.
   */
  public boolean deleteFile(int index) {
    if (index >= 0 && index < listFileDir.size()) {
      File fileToDelete = getFile(index);
      if (fileToDelete != null && fileToDelete.delete()) {
        refresh();
        return true;
      }
    }
    return false;
  }

  /**
   * Mets à jour la liste des fichiers dans le répertoire en cas de changement.
   */
  public void refresh() {
    File[] files = directory.listFiles();
    if (files != null) {
      ArrayList<File> listFiles = new ArrayList<>(Arrays.asList(files));
      listFiles.removeIf(file -> file.getName().equals(".notes"));
      this.listFileDir = listFiles;
    } else {
      this.listFileDir = new ArrayList<>();
    }
  }

  public int getLastFileUsed() {
    return lastFileUsed;
  }

  /**
   * Met à jour l'indice du dernier fichier utilisé.
   *
   * @param newLastFileUsed L'indice du dernier fichier utilisé.
   * @return true si l'indice est bien inclus dans le répertoire, false sinon.
   */
  public boolean updateLastFileUsed(int newLastFileUsed) {
    if (newLastFileUsed >= 0 && newLastFileUsed < listFileDir.size()) {
      lastFileUsed = newLastFileUsed;
      return true;
    }
    return false;
  }

  public String getAbsolutePath() {
    return directory.getAbsolutePath();
  }

}
