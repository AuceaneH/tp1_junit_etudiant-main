
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
  public void should_get_correct_text_when_instanciate_textbuffer_with_text_with_substr_() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    String expectedName = "Texte";
    String text = buffer.substr(0,5);


    // Assert
    Assertions.assertEquals(expectedName, text);

    }
  
  @Test
  public void should_get_correct_text_when_instanciate_textbuffer_with_text_with_modification_from_ins_() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    buffer.ins("A ", 6);
    String expectedName = "Texte A de test";
    String text = buffer.toString();


    // Assert
    Assertions.assertEquals(expectedName, text);

    }
  
  @Test
  public void should_get_correct_text_when_instanciate_textbuffer_with_text_with_modification_from_del_() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    buffer.del(5, 8);
    String expectedName = "Texte test";
    String text = buffer.toString();


    // Assert
    Assertions.assertEquals(expectedName, text);

    }
  
  @Test
  public void should_get_correct_length_when_instanciate_textbuffer_with_text_() {

    // Arrange

    TextBuffer buffer = new TextBuffer("Texte de test");
    


    // Act
    int expectedNumber = 13;
    int number = buffer.maxP();


    // Assert
    Assertions.assertEquals(expectedNumber, number);

    }
  
  
}
