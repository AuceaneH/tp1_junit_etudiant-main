
import org.junit.jupiter.api.Test;

import fr.einfolearning.tp2.metiers.TextBuffer;

import org.junit.jupiter.api.Assertions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TextBufferTest {

  @Test
  public void Texte_Correct() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // Ce qui a été mis dans buffer
    String expectedName = "Texte de test";

    // On reccupère la chaine
    String text = buffer.toString();


    /* Assert */

    // On verifie que le texte implementer dans TextBuffer sort correctement avec le toString
    assertThat(expectedName, equalTo(text));
    }
  

  
  @Test
  public void Text_Correct_avec_ins_basique() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // On essaye d'ajouter "A " a une position existante
    buffer.ins("A ", 6);

    // Le texte doit maintenant ressembler a cela
    String expectedName = "Texte A de test";

    // On reccupère la chaine modifier
    String text = buffer.toString();


    /* Assert */

    // On verifie que l'ajout de "A " fonctionne correctement de manière basique
    assertThat(expectedName, equalTo(text));
    }



  @Test
  public void Text_Correct_avec_ins_position_superieur_a_la_taille_de_la_chaine() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // On essaye d'ajouter "A " a une position superieur de la longueur de la chaine
    buffer.ins("A ", 18);

    // Aucun changement est censé avoir occurer
    String expectedName = "Texte de test";

    // On reccupère la chaine non modifier
    String text = buffer.toString();// le A  n'a pas été ajouter


    /* Assert */

    // On verifie que l'ajout de "A " ne se fait pas lorsque
    //    la position est trop élever par rapport a la taille de la chaine
    assertThat(expectedName, equalTo(text));
  }



  @Test
  public void Text_Correct_avec_ins_position_inferieur_a_la_taille_de_la_chaine() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // On essaye d'ajouter "A " a une position negative
    buffer.ins("A ", (-2));

    // Aucun changement est censé avoir occurer
    String expectedName = "Texte de test";

    // On reccupère la chaine non modifier
    String text = buffer.toString();// le A  n'a pas été ajouter


    /* Assert */

    // On verifie que l'ajout de "A " ne se fait pas lorsque
    //    la position négative
    assertThat(expectedName, equalTo(text));
  }



  @Test
  public void Text_Correct_avec_del_basique() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // On essaye d'enlever des caractères a des position existantes
    buffer.del(5, 8);

    // Le texte doit maintenant ressembler a cela
    String expectedName = "Texte test";

    // On reccupère la chaine modifier
    String text = buffer.toString();


    /* Assert */

    // On verifie que la suppression de caractères fonctionne correctement de manière basique
    assertThat(expectedName, equalTo(text));
    }



  @Test
  public void Text_Correct_avec_del_avec_from_negatif() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // On essaye d'enlever des caractères avec une position from négative et un to existante
    buffer.del(-1, 8);

    // Le texte doit maintenant ressembler a cela,
    //    car la position négative a été remplacer par 0
    String expectedName = " test";

    // On reccupère la chaine modifier
    String text = buffer.toString();


    /* Assert */

    // On verifie que la suppression de caractères fonctionne correctement
    assertThat(expectedName, equalTo(text));
  }



  @Test
  public void Text_Correct_avec_del_avec_to_negatif() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // On essaye d'enlever des caractères avec une position from existante et un to négative.
    //    Avec 0 pour from car from<=to
    buffer.del(0, (-2));

    // Le texte ne doit pas avoir changer,
    //    car la position négative a été remplacer par 0
    String expectedName = "Texte de test";

    // On reccupère la chaine non modifier
    String text = buffer.toString();


    /* Assert */

    // On verifie que la suppression de caractères fonctionne correctement
    assertThat(expectedName, equalTo(text));
  }



  @Test
  public void Text_Correct_avec_del_avec_from_et_to_au_dela_du_max() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // On essaye d'enlever des caractères avec une position from et to supérieur a la taille de la chaine.
    buffer.del(19, 17);

    // Le texte ne doit pas avoir changer,
    //    car les positions ont été remplacer par la longueur max de la chaine
    String expectedName = "Texte de test";

    // On reccupère la chaine non modifier
    String text = buffer.toString();


    /* Assert */

    // On verifie que la suppression de caractères fonctionne correctement
    assertThat(expectedName, equalTo(text));
  }



  @Test
  public void Text_Correct_avec_substr_basique() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");



    /* Act */

    // On reccupère une portion de texte a des position existante
    String text = buffer.substr(0,5);

    // Elle doit ressembler a cela
    String expectedName = "Texte";


    /* Assert */

    // On verifie que la réccupération s'est bien effectuer
    assertThat(expectedName, equalTo(text));
  }



  @Test
  public void Text_Correct_avec_substr_avec_from_negatif() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // On reccupère une portion de texte a une position from négative et to existante
    String text = buffer.substr((-3),5);

    // Elle doit ressembler a cela,
    //    car la valeur négative a été remplacer par 0
    String expectedName = "Texte";


    /* Assert */

    // On verifie que la réccupération s'est bien effectuer
    assertThat(expectedName, equalTo(text));
  }



  @Test
  public void Text_Correct_avec_substr_avec_to_negatif() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // On reccupère une portion de texte a une position from existante et to négative.
    //    from est mis a 0 car from<=to
    String text = buffer.substr(0,(-2));

    // Elle doit ressembler a cela,
    //    car la valeur négative a été remplacer par 0
    String expectedName = "";


    /* Assert */

    // On verifie que la réccupération s'est bien effectuer
    assertThat(expectedName, equalTo(text));
  }



  @Test
  public void Text_Correct_avec_substr_avec_from_et_to_au_dela_du_max() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // On reccupère une portion de texte a une position from et to supérieur a la taille de la chaine.
    String text = buffer.substr(15,18);

    // Elle doit ressembler a cela,
    //    car les positions ont été remplacer par la longueur max de la chaine
    String expectedName = "";


    /* Assert */

    // On verifie que la réccupération s'est bien effectuer
    assertThat(expectedName, equalTo(text));
  }



  @Test
  public void Good_Number_Given() {

    /* Arrange */
    TextBuffer buffer = new TextBuffer("Texte de test");


    /* Act */

    // La taille de la chaine est cencé être
    int expectedNumber = 13;

    // On reccupère la taille de la chaine
    int number = buffer.maxP();


    /* Assert */

    // On vérifie que ce qui a été renvoyer est bon
    assertThat(expectedNumber, equalTo(number));
    }
}
