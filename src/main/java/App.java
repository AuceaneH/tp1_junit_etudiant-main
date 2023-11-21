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

		TextBuffer buffer= new TextBuffer("test");
		EmacsKillRing emacs= new EmacsKillRing();
		TextEditor ed = new TextEditor("Je suis un éditeur de texte");

		try {
			//Test TextEditor
			System.out.println("Test TextEditor :");
			System.out.println(ed.getBuffer());
			ed.setCursor(3);
			ed.setMark(7);
			ed.killRingBackup();
			System.out.println(ed.getBuffer());

			ed.setCursor(11);
			ed.setMark(16);
			ed.killSection();
			System.out.println(ed.getBuffer());
			ed.setCursor(8);
			ed.yank();
			System.out.println(ed.getBuffer());

			//Test TextBuffer
			System.out.println("\nTest TextBuffer :\n\t Texte, avec toString() : '"+buffer.toString()+"' ");
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
			System.out.println("\nTest EmacsKillRing : lors de la création, une liste de String vide est créer");

			System.out.println("\tLa liste est vide de :"+emacs.isEmpty());

			System.out.println("\tAjout de :");
			System.out.println("\t\tcopie");
			emacs.add("copie");
			System.out.println("\t\tmarie");
			emacs.add("marie");
			System.out.println("\t\tanticonstitutionnellement");
			emacs.add("anticonstitutionnellement");
			System.out.println("\t\tTeSt");
			emacs.add("TeSt");

			System.out.println("\tIl y a dans la liste :\n"+emacs.toString());

			System.out.println("\tElement actuellement sélectionner :\n"+emacs.currentElt());
			emacs.rotateFwd();
			System.out.println("\tElement sélectionner apres rotateFwd():\n"+emacs.currentElt());


		} catch (EmacsKillRingOverflowException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}




    	
    }
}
