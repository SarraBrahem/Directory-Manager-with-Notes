package fr.uvsq.pglp.project;

import java.io.File;
import java.util.ArrayList;

/**
 * Responsable de l'affichage du texte du programme.
 */
public class Affichage {

  private Repertoire repertoire;

  public Affichage(Repertoire repertoire) {
    this.repertoire = repertoire;
  }


  public void showMessage(String s) {
    System.out.println(s);
  }

  /**
   * Mets à jour l'affichage de la liste des éléments.
   */
  public void majAffichage() {
    clearScreen();
    System.out.println(this.repertoire.getAbsolutePath());
    System.out.println();
    int lastFileUsed = this.repertoire.getLastFileUsed();
    if (lastFileUsed != -1) {
      System.out.printf("L'indice du dernier élément utilisé est %d\n", lastFileUsed);
      displayNoteForLastFileUsed(lastFileUsed);
    }
    System.out.println("Elements du répertoire:");
    ArrayList<File> listFiles = (ArrayList<File>) this.repertoire.listFiles();
    for (int i = 0; i < listFiles.size(); i++) {
    	System.out.print(i);
    	System.out.print(": ");
    	System.out.println(listFiles.get(i).getName());
    }
    System.out.println();
  }

  private void displayNoteForLastFileUsed(int index) {
    if (repertoire.noteExists(index)) {
      File file = repertoire.getFile(index);
      if (file != null) {
        String note = repertoire.getNote(file.getName());
        System.out.printf("Note associée à l'élément %s: \"%s\"\n", file.getName(), note);
      }
    }
  }

  private void clearScreen() {
    if (System.getProperty("os.name").startsWith("Windows")) {
      System.out.println("----------------------------------\n");
    } else {
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }
  }

}
