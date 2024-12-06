package fr.uvsq.pglp.project;

import fr.uvsq.pglp.project.commands.AddNoteCommand;
import fr.uvsq.pglp.project.commands.CopyCommand;
import fr.uvsq.pglp.project.commands.CutCommand;
import fr.uvsq.pglp.project.commands.EnterDirectoryCommand;
import fr.uvsq.pglp.project.commands.FindCommand;
import fr.uvsq.pglp.project.commands.HelpCommand;
import fr.uvsq.pglp.project.commands.MkdirCommand;
import fr.uvsq.pglp.project.commands.NoteExtractor;
import fr.uvsq.pglp.project.commands.ParentDirectoryCommand;
import fr.uvsq.pglp.project.commands.PasteCommand;
import fr.uvsq.pglp.project.commands.RemoveNoteCommand;
import fr.uvsq.pglp.project.commands.VisuCommand;

/**
 * Permet de récupérer la bonne commande à partir d'une chaîne de caractères.
 */
public class InputParser {

  private Repertoire repertoire;
  private CommandManager commandManager;

  public InputParser(Repertoire repertoire, CommandManager commandManager) {
    this.repertoire = repertoire;
    this.commandManager = commandManager;
  }

  /**
   * Donne la command correspondant à la chaîne de caractères donnée.
   *
   * @param input Une chaîne de caractères correspondant à une commande.
   * @return La commande associée.
   */
  public Command parse(String input) {
    String[] splitInput = input.split(" ");
    Command command;
    if (splitInput.length == 1) {
      switch (splitInput[0]) {
        case "copy":
          command = new CopyCommand(this.repertoire, commandManager);
          break;
        case "cut":
          command = new CutCommand(this.repertoire, commandManager);
          break;
        case "paste":
          command = new PasteCommand(this.repertoire, commandManager);
          break;
        case "..":
          command = new ParentDirectoryCommand(this.repertoire, commandManager);
          break;
        case ".":
          command = new EnterDirectoryCommand(this.repertoire, this.repertoire.getLastFileUsed(), commandManager);
          break;
        case "visu":
          command = new VisuCommand(this.repertoire, this.repertoire.getLastFileUsed(), this.commandManager);
          break;
        case "-":
	      command = new RemoveNoteCommand(this.repertoire, this.repertoire.getLastFileUsed(), this.commandManager);
          break;
        case "help":
          command = new HelpCommand(this.commandManager);
          break;
        default:
          command = new HelpCommand(this.commandManager);
          break;
      }
    } else if (splitInput.length == 2) {
      switch (splitInput[0]) {
        case "mkdir":
          command = new MkdirCommand(this.repertoire, splitInput[1], this.commandManager);
          break;
        case "find":
          command = new FindCommand(this.repertoire, splitInput[1], this.commandManager);
          break;
        case "+":
          String note = NoteExtractor.extractNote(splitInput, 1);
          command = new AddNoteCommand(this.repertoire, this.commandManager, this.repertoire.getLastFileUsed(), note);
          break;
        default:
          switch (splitInput[1]) {
            case "copy":
              command = new CopyCommand(this.repertoire, Integer.parseInt(splitInput[0]), commandManager);
              break;
            case "cut":
              command = new CutCommand(this.repertoire, Integer.parseInt(splitInput[0]), commandManager);
              break;
            case ".":
              command = new EnterDirectoryCommand(this.repertoire, Integer.parseInt(splitInput[0]), commandManager);
              break;
            case "visu":
              command = new VisuCommand(this.repertoire, Integer.parseInt(splitInput[0]), this.commandManager);
              break;
            case "-":
              command = new RemoveNoteCommand(this.repertoire, Integer.parseInt(splitInput[0]), this.commandManager);
              break;
            default:
              command = new HelpCommand(this.commandManager);
              break;
          }
          break;
      }
    } else if (splitInput.length >= 3) {
      if (splitInput[1].equals("+")) {
        int fileNer = Integer.parseInt(splitInput[0]);
        String note = NoteExtractor.extractNote(splitInput, 2);
        command = new AddNoteCommand(this.repertoire, this.commandManager, fileNer, note.toString());
      } else if (splitInput[0].equals("+")) {
        int fileNer = this.repertoire.getLastFileUsed();
        String note = NoteExtractor.extractNote(splitInput, 1);
        command = new AddNoteCommand(this.repertoire, this.commandManager, fileNer, note.toString());
      } else {
        command =  new HelpCommand(this.commandManager);
      }
    } else {
      command = new HelpCommand(this.commandManager);
    }
    return command;
  }

}
