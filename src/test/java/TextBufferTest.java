
import org.junit.jupiter.api.Test;

import fr.einfolearning.tp2.metiers.TextBuffer;

import org.junit.jupiter.api.Assertions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TextBufferTest {

  @Test
  public void Texte_Correct() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    String expectedName = "Texte de test";
    String text = buffer.toString();


    // Assert
    assertThat(expectedName, equalTo(text));

    }
  
  @Test
  public void Text_Correct2() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    String expectedName = "Texte";
    String text = buffer.substr(0,5);


    // Assert
    assertThat(expectedName, equalTo(text));

    }
  
  @Test
  public void Text_Correct3() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    buffer.ins("A ", 6);
    String expectedName = "Texte A de test";
    String text = buffer.toString();


    // Assert
    assertThat(expectedName, equalTo(text));

    }
  
  @Test
  public void Text_Correct4() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    buffer.del(5, 8);
    String expectedName = "Texte test";
    String text = buffer.toString();


    // Assert
    assertThat(expectedName, equalTo(text));

    }
  
  @Test
  public void Good_Number_Given() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    int expectedNumber = 13;
    int number = buffer.maxP();


    // Assert
    assertThat(expectedNumber, equalTo(number));

    }
  
  
}
