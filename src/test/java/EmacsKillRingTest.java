import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmacsKillRingTest {

    @Test
    public void testThrowException() throws EmacsKillRingOverflowException {

        // Arrange
        EmacsKillRing kr = new EmacsKillRing();

        // Act
        int nb_insertion=0;
        for(int i=0; i<19; i++){
            kr.add(""+(i+1));
            nb_insertion++;
        }

        // Assert
        Assertions.assertNotEquals(kr.MAX,nb_insertion);// kr.MAX=20 ; nb_insertion=19

        Assertions.assertDoesNotThrow(() -> kr.add("20"));
        nb_insertion++;

        System.out.println(kr.MAX);
        Assertions.assertEquals(kr.MAX,nb_insertion);// kr.MAX=20 ; nb_insertion=20

        Assertions.assertThrows(EmacsKillRingOverflowException.class, () -> kr.add("+"));
    }

    @Test
    public void testEmacsKillRingVide() {

        // Arrange
        EmacsKillRing kr = new EmacsKillRing();

        // Act

        // Assert
        Assertions.assertTrue(kr.isEmpty());

    }

    @Test
    public void testInsertion() throws EmacsKillRingOverflowException {

        // Arrange
        EmacsKillRing kr = new EmacsKillRing();

        // Act
        int nb_insertion=0;
        for(int i=0; i<10; i++){
            kr.add("test "+(i+1));
            nb_insertion++;
        }

        // Assert
        Assertions.assertFalse(kr.isEmpty());

        Assertions.assertDoesNotThrow(() -> kr.add("test 11"));
        nb_insertion++;

        Assertions.assertNotEquals(kr.MAX,nb_insertion);// kr.MAX=20 ; nb_insertion=11

    }


    @Test
    public void testDeplacement() throws EmacsKillRingOverflowException {

        // Arrange
        EmacsKillRing kr = new EmacsKillRing();

        // Act
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


        // Assert
        Assertions.assertEquals(empInitial,"test 10");
        Assertions.assertEquals(dep_1,"test 9");
        Assertions.assertEquals(dep_2,"test 5");
    }

    @Test
    public void testSortie() throws EmacsKillRingOverflowException {

        // Arrange
        EmacsKillRing kr = new EmacsKillRing();

        // Act
        for(int i=0; i<10; i++){
            kr.add("test "+(i+1));
        } // kr : [test 10, test 9, test 8, test 7, test 6, test 5, test 4, test 3, test 2, test 1]

        // Assert
        Assertions.assertEquals(kr.toString(),"[test 10, test 9, test 8, test 7, test 6, test 5, test 4, test 3, test 2, test 1]");

    }




}
