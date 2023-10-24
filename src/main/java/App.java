//
// Utilisation nominale des classes td3.Buffer, Killring et td3.Editor
//
////////////////////////////////////////////////////////////////

import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;

public class App {

    public static void main(String[] args) {
        // A completer
    	//Test TextBuffer
    	TextBuffer buffer= new TextBuffer("test");
    	System.out.println("Test Buffer :\n\t Texte : '"+buffer.toString()+"' ");
    	System.out.println("\t\t Longueur : "+ buffer.maxP());
    	
    	buffer.ins("A",3);
    	System.out.println("\tApres l'ajout de 'A' à la position 3 : '"+buffer.toString()+"'");
    	System.out.println("\t\t Longueur : "+ buffer.maxP());
    	
    	buffer.del(1, 3);
    	System.out.println("\tApres la suppression de la position 1 à 3 : '"+buffer.toString()+"'");
    	System.out.println("\t\t Longueur : "+ buffer.maxP());
    	
    	
    	
    	
    	
    	TextEditor text=new TextEditor("Texte a tester : TesT");//21
    	
    	
    }
}
