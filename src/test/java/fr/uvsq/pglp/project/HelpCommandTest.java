// package fr.uvsq.pglp.project;

// import org.junit.jupiter.api.Test;

// import fr.uvsq.pglp.project.commands.HelpCommand;

// import java.io.ByteArrayOutputStream;
// import java.io.PrintStream;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// public class HelpCommandTest {

//     @Test
//     public void testExecute_HelpCommand() {
//         // Rediriger la sortie standard vers un flux de sortie capturé
//         ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//         System.setOut(new PrintStream(outputStreamCaptor));

//         // Exécuter la commande HelpCommand
//         HelpCommand helpCommand = new HelpCommand();
//         helpCommand.execute();

//         // Récupérer la sortie capturée et la nettoyer
//         String capturedOutput = cleanString(outputStreamCaptor.toString());
        
//         // Récupérer la sortie attendue et la nettoyer
//         String expectedOutput = cleanString("\n" +
//                 "Usage : [<NER>] [<commande>] [<nom>]\n" +
//                 "\n" +
//                 "Les commandes disponibles sont les suivantes:\n" +
//                 "\t[<NER>] copy\tCopie le contenu du fichier d'indice <NER> pour un futur collage\n" +
//                 "\t[<NER>] cut\tCopie le contenu du fichier d'indice <NER> pour un futur collage et l'effacement du fichier original\n" +
//                 "\tpaste\tCopie le fichier dans le répertoire actuel et s'il existe déjà ajoute '-copy' à son nom\n" +
//                 "\t..\tSe déplace dans le répertoire parent si le répertoire actuel n'est pas la racine\n" +
//                 "\t[<NER>] .\tSe déplace dans le répertoire d'indice <NER>\n" +
//                 "\tmkdir <nom>\tCrée un répertoire de nom <nom>\n" +
//                 "\t[<NER>] visu\tVisualise le contenu du fichier s'il est de type texte ou affiche sa taille sinon\n" +
//                 "\tfind <nom>\tCherche et affiche tous les fichiers ayant le nom <nom> dans ce répertoire et ces sous-répertoires\n" +
//                 "\t[NER] + \"<texte>\"\tAjoute une note <texte> au fichier d'indice <NER>. Attention, n'utilisez pas \\n ou ;\n" +
//                 "\t[NER] - \tEfface la note associée au fichier d'indice <NER>\n" +
//                 "\n" +
//                 "Si aucun [<NER>] n'est donnée alors le NER du dernier fichier avec lequel vous avez interagi sera utilisé\n");
        
//         // Comparer la sortie capturée avec la sortie attendue
//         assertEquals(expectedOutput, capturedOutput);
//     }

//     private String cleanString(String str) {
//         // Supprimer les espaces inutiles et les caractères de fin de ligne
//         return str.trim();
//     }
// }
