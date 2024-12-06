package fr.uvsq.pglp.project.commands;

import fr.uvsq.pglp.project.Command;
import fr.uvsq.pglp.project.CommandManager;

/**
 * HelpCommand class that displays help information.
 */
public class HelpCommand implements Command {
	
	private CommandManager commandManager;
	
	public HelpCommand(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	/**
	 * Executes the command to display help information.
	 */
	@Override
	public void execute() {
		StringBuilder help = new StringBuilder();
		help.append("Usage : [<NER>] [<commande>] [<nom>]\n\n");
		help.append("Les commandes disponibles sont les suivantes:\n\n");
		help.append("\t[<NER>] copy\tCopie le contenu du fichier");
		help.append("d'indice <NER> pour un futur collage\n");
		help.append("\t[<NER>] cut\tCopie le contenu du fichier d'indice <NER>");
		help.append("pour un futur collage et l'effacement du fichier original\n");
		help.append("\tpaste\tCopie le fichier dans le répertoire actuel");
		help.append(" et s'il existe déjà ajoute '-copy' à son nom\n");
		help.append("\t..\tSe déplace dans le répertoire parent");
		help.append(" si le répertoire actuel n'est pas la racine\n");
		help.append("\t[<NER>] .\tSe déplace dans le répertoire d'indice <NER>\n");
		help.append("\tmkdir <nom>\tCrée un répertoire de nom <nom>\n");
		help.append("\t[<NER>] visu\tVisualise le contenu du fichier\n");
		help.append(" s'il est de type texte ou affiche sa taille sinon\n");
		help.append("\tfind <nom>\tCherche et affiche tous les fichiers ayant\n");
		help.append(" le nom <nom> dans ce répertoire et ces sous-répertoires\n");
		help.append("\t[NER] + \"<texte>\"\tAjoute une note <texte> au fichier\n");
		help.append("d'indice <NER>. Attention, n'utilisez pas \\n ou ;\n");
		help.append("\t[NER] - \tEfface la note associée au fichier d'indice <NER>\n\n");
		help.append("Si aucun [<NER>] n'est donnée alors le NER du dernier fichier\n");
		help.append(" avec lequel vous avez interagi sera utilisé\n");
		this.commandManager.showMessage(help.toString());
	}
}
