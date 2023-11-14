
import org.junit.jupiter.api.Test;

import fr.einfolearning.tp2.metiers.TextBuffer;

import org.junit.jupiter.api.Assertions;

public class TextBufferTest {

  @Test
  public void should_get_correct_text_when_instanciate_textbuffer_with_text_() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    String expectedName = "Texte de test";
    String text = buffer.toString();


    // Assert
    Assertions.assertEquals(expectedName, text);

    }
  
  @Test
  public void should_get_correct_int_when_instanciate_textbuffer_with_text_() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    int expectedNumber = 13;
    int number = buffer.maxP();


    // Assert
    Assertions.assertEquals(expectedNumber, number);

    }
  
  @Test
  public void should_get_correct_text_with_substr_when_instanciate_textbuffer_with_text_() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    String expectedName = "Texte";
    String text = buffer.substr(0,5);


    // Assert
    Assertions.assertEquals(expectedName, text);

    }
}
