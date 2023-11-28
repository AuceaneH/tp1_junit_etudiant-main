import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmacsKillRingTest {

    /*
        Ce teste verifie qu'une exception est bien renvoyer
            lorsqu'on dépasse la taille max, qui est de 20 (est donner par la valeur MAX)
     */
    @Test
    public void testThrowException() throws EmacsKillRingOverflowException {

        /* Arrange */
        EmacsKillRing kr = new EmacsKillRing();

        /* Act */
        int nb_insertion=0;
        for(int i=0; i<19; i++){
            kr.add(""+(i+1));
            nb_insertion++;
        }

        /* Assert */
        Assertions.assertNotEquals(kr.MAX,nb_insertion);// kr.MAX=20 ; nb_insertion=19

        Assertions.assertDoesNotThrow(() -> kr.add("20"));
        nb_insertion++;

        System.out.println(kr.MAX);
        Assertions.assertEquals(kr.MAX,nb_insertion);// kr.MAX=20 ; nb_insertion=20

        Assertions.assertThrows(EmacsKillRingOverflowException.class, () -> kr.add("+"));
    }



    /*
        Ce teste vérifie que, lors de la création de kr, le tableau créer avec EmacsKillRing soit bien vide
     */
    @Test
    public void testEmacsKillRingVide() {

        /* Arrange */
        EmacsKillRing kr = new EmacsKillRing();

        /* Act */

        /* Assert */
        Assertions.assertTrue(kr.isEmpty());

    }



    /*
        Ce teste vérifie que les insertions se passe correctement
            (test sans exceptions)
     */
    @Test
    public void testInsertion() throws EmacsKillRingOverflowException {

        /* Arrange */
        EmacsKillRing kr = new EmacsKillRing();

        /* Act */
        int nb_insertion=0;
        for(int i=0; i<10; i++){
            kr.add("test "+(i+1));
            nb_insertion++;
        }

        /* Assert */
        Assertions.assertFalse(kr.isEmpty());

        Assertions.assertDoesNotThrow(() -> kr.add("test 11"));
        nb_insertion++;

        Assertions.assertNotEquals(kr.MAX,nb_insertion);// kr.MAX=20 ; nb_insertion=11

    }



    /*
        Ce teste vérifie que, de manière basique, le déplacement de entry se passe bien,
            avec rotateFwd().
        - entry est la position de l'élément réccupérer par currentElt()
     */
    @Test
    public void testDeplacement_basique() throws EmacsKillRingOverflowException {

        /* Arrange */
        EmacsKillRing kr = new EmacsKillRing();

        /* Act */
        for(int i=0; i<10; i++){
            kr.add("test "+(i+1));
        } // kr : [test 10, test 9, test 8, test 7, test 6, test 5, test 4, test 3, test 2, test 1]

        String empInitial = kr.currentElt(); //emplacement initial de entry=0, donc le premier element visible de la liste

        kr.rotateFwd(); // entry=1
        String dep_1 = kr.currentElt(); //dep_2="test 9"

        for(int j=0; j<4; j++){
            kr.rotateFwd();
        } //entry=5
        String dep_2 = kr.currentElt(); //dep_2="test 5"


        /* Assert */
        Assertions.assertEquals(empInitial,"test 10");
        Assertions.assertEquals(dep_1,"test 9");
        Assertions.assertEquals(dep_2,"test 5");
    }



    /*
        Ce teste verifie ce qu'il se passe quand le rotateFwd() atteint/dépasse le nombre d'élément dans le tableau.
        - rotateFwd() remet a 0 entry lorsqu'il' atteint/dépasse le nombre d'élément dans le tableau.
        On teste donc cette occurence.
     */
    @Test
    public void testDeplacement_au_dela_de_la_taille_du_tableau() throws EmacsKillRingOverflowException {

        /* Arrange */
        EmacsKillRing kr = new EmacsKillRing();

        /* Act */
        int nb_insertions=0;
        for(int i=0; i<10; i++){
            kr.add("test "+(i+1));
            nb_insertions++;
        } // kr : [test 10, test 9, test 8, test 7, test 6, test 5, test 4, test 3, test 2, test 1]

        String empInitial = kr.currentElt(); //emplacement initial de entry=0, donc le premier element visible de la liste

        //Deplacement jusqu'au nombre max d'élément
        for(int j=0;j<10;j++){
            kr.rotateFwd();
        }
        String empAtteintMax = kr.currentElt(); //emplacement après avoir atteint le max entry=0, donc le premier element visible de la liste

        /* Assert */
        Assertions.assertEquals(empInitial,empAtteintMax);// empInitial=empAtteintMax="test 10"
    }



    /*
        Ce teste vérifie que la valeur de sortie de toString() soit valide
     */
    @Test
    public void testSortie() throws EmacsKillRingOverflowException {

        /* Arrange */
        EmacsKillRing kr = new EmacsKillRing();

        /* Act */
        for(int i=0; i<10; i++){
            kr.add("test "+(i+1));
        } // kr : [test 10, test 9, test 8, test 7, test 6, test 5, test 4, test 3, test 2, test 1]

        /* Assert */
        Assertions.assertEquals(kr.toString(),"[test 10, test 9, test 8, test 7, test 6, test 5, test 4, test 3, test 2, test 1]");

    }




}
