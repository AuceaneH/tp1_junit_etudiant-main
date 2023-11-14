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
    	System.out.println("Test TextBuffer :\n\t Texte, avec toString() : '"+buffer.toString()+"' ");
    	System.out.println("\t\t Longueur, avec maxP() : "+ buffer.maxP());
    	
    	buffer.ins("A",3);
    	System.out.println("\tApres l'ajout, avec ins(\"A\",3), de 'A' à la position 3 : '"+buffer.toString()+"'");
    	System.out.println("\t\t Longueur : "+ buffer.maxP());
    	
    	buffer.del(1, 2);
    	System.out.println("\tApres la suppression, avec del(1,2), de la position 1 à 2 : '"+buffer.toString()+"'");
    	System.out.println("\t\t Longueur : "+ buffer.maxP());

    	String resultSubstr=buffer.substr(0, 3);
    	System.out.println("\tsubstr(0,3) retourne : '"+resultSubstr+"'");

    	

    	//Test EmacsKillRing
//    	EmacsKillRing emacs= new EmacsKillRing();
//    	System.out.println("Test EmacsKillRing : lors de la création, une liste de String vide est créer");
//
//    	System.out.println("\tAjout de :");
//    	System.out.println("\t\tcopie");
//    	emacs.add("copie");
//    	System.out.println("\t\tmarie");
//    	emacs.add("marie");
//    	System.out.println("\t\tanticonstitutionnellement (trop grand, donc ne sajoutera normalement pas)");
//    	emacs.add("anticonstitutionnellement");
//    	System.out.println("\t\tTeSt");
//    	emacs.add("TeSt");
    	

    	//Test TextEditor
    	TextEditor editor= new TextEditor("Voici un texte à manipuler");
    	System.out.println("Test TextEditor :\n\t Texte, avec toString() : '"+buffer.toString()+"' ");
    	System.out.println("\t\t Longueur, avec maxP() : "+ buffer.maxP());
    	
    	
    	TextEditor text=new TextEditor("Texte a tester : TesT");//21
    	
    	
    }
}
