package fr.uvsq.pglp.project;

import java.nio.file.NotDirectoryException;

class Application {

  private CommandManager cui;

  public Application(String directoryPath) throws NotDirectoryException {
    Repertoire repertoire = new Repertoire(directoryPath);
    Affichage affichage = new Affichage(repertoire);
    this.cui = new CommandManager(repertoire, affichage);
  }

  public void start() {
    this.cui.start();
  }
}

