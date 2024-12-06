package fr.uvsq.pglp.project;

import java.nio.file.NotDirectoryException;

/**
 * Démarre l'application.
 */
public class App {


  /**
  * La classe principale vérifiant les arguments donnés.
  *
  * @param args Le chemin vers le répertoire que l'on veut explorer.
  */
  public static void main(String[] args) {
    try {
      String directoryPath = validateArgs(args);
      Application application = new Application(directoryPath);
      application.start();
    } catch (IllegalArgumentException | NotDirectoryException e) {
      System.out.println(e.getMessage());
    }
  }

  private static String validateArgs(String[] args) {
    if (args.length != 1) {
      throw new IllegalArgumentException("Usage: java App <directory_path>");
    }
    return args[0];
  }
}