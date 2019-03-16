package tests;

import app.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private final ByteArrayOutputStream content = new ByteArrayOutputStream();
    private final String expectedString =
                    "----------------------------------------------------------------------\n" +
                    "|ARTICLE (article-minimal)                                           |\n" +
                    "----------------------------------------------------------------------\n" +
                    "|Author         |NAME1 SURNAME1                                      |\n" +
                    "|               |NAME2 SURNAME2                                      |\n" +
                    "----------------------------------------------------------------------\n" +
                    "|Title          |TITLE                                               |\n" +
                    "----------------------------------------------------------------------\n" +
                    "|Journal        |JOURNAL                                             |\n" +
                    "----------------------------------------------------------------------\n" +
                    "|Year           |1998                                                |\n" +
                    "----------------------------------------------------------------------\n" +
                    "**********************************************************************\n\n";

    @BeforeEach
    public void before(){
        System.setOut(new PrintStream(content));
    }

    @Test
    public void simpleFileTest(){
        App.main("test.bib -a".split(" "));
        assertEquals("Showing all entries:\n" +expectedString,content.toString());
    }

    @Test
    public void gettingEntriesByTypeTest(){
        App.main("test2.bib -t article".split(" "));
        assertEquals("Showing entries for given type: ARTICLE\n" +expectedString,content.toString());
    }

    @Test
    public void gettingEntriesByAuthorTest(){
        App.main("test2.bib -n SURNAME1".split(" "));
        assertEquals("Showing entries for given author: SURNAME1\n" +expectedString,content.toString());
    }

}