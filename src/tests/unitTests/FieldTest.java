package tests.unitTests;

import org.junit.jupiter.api.Test;
import pattern.Field;
import pattern.FieldType;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void splitAuthorTest() {
        Field field = new Field(
                FieldType.AUTHOR,
                "Name Surname and Surname | Name and Surname | Middlephrase | Name",
                true
        );
        field.splitAuthor();
        String[] authorNames = field.getSplittedAuthorNames();
        assertArrayEquals(new String[]{"Name Surname","Name Surname","Name Middlephrase Surname"},authorNames);
    }
}