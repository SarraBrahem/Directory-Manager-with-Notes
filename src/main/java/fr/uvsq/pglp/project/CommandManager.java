package fr.uvsq.pglp.project;

import fr.uvsq.pglp.project.commands.CopyCommand;
import fr.uvsq.pglp.project.commands.CutCommand;
import java.io.File;
import java.util.Scanner;

/**
 * Gère l'entrée des commandes et leur exécution.
 */
public class CommandManager {

  private Scanner scanner;
  private Affichage affichage;
  private Command lastCopy;
  private InputParser parser;

  /**
   * Initialise le CommandManager.
   *
   * @param repertoire Le répertoire avec lequel les commandes vont interagir.
   * @param affichage L'affichage utilisée par les commandes.
   */
  public CommandManager(Repertoire repertoire, Affichage affichage) {
    this.affichage = affichage;
    this.scanner = new Scanner(System.in);
    this.parser = new InputParser(repertoire, this);
    this.lastCopy = null;
  }

  /**
   * Démarre la récupération des commandes.
   */
  public void start() {
    while (true) {
      affichage.majAffichage();
      System.out.print("Entrez votre commande: ");
      String input = scanner.nextLine();
      if ("exit".equalsIgnoreCase(input)) {
        break;
      }
      processCommand(input);
    }
    this.scanner.close();
  }

  private void processCommand(String input) {
    try {
      Command command = parser.parse(input);
      if (command != null) {
        command.execute();
        System.out.println("Appuyez sur entrée pour continuer.");
        this.scanner.nextLine();
      } else {
        System.out.println("Commande inconnue ou invalide.");
      }
    } catch (Exception e) {
      System.out.println("Erreur lors de l'exécution de la commande: " + e.getMessage());
    }
  }

  public void copyFile(Command copy) {
    this.lastCopy = copy;
  }

  /**
   * Donne le fichier qui a été sauvegardé pour la copie.
   *
   * @return Le File à copier ou null s'il n'y en a pas.
   */
  public File fileToCopy() {
    if (lastCopy instanceof CopyCommand) {
      return ((CopyCommand) lastCopy).getFile();
    } else if (lastCopy instanceof CutCommand) {
      return ((CutCommand) lastCopy).getFile();
    }
    return null;
  }

  public boolean eraseAfterCopy() {
    return lastCopy instanceof CutCommand;
  }

  public void changeRepertoire(Repertoire newRepertoire) {
    this.parser = new InputParser(newRepertoire, this);
    this.affichage = new Affichage(newRepertoire);
  }

  public void showMessage(String s) {
    this.affichage.showMessage(s);
  }

}