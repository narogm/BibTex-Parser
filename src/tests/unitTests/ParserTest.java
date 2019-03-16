package tests.unitTests;

import static org.junit.jupiter.api.Assertions.*;

import app.Parser;
import app.Records;
import exceptions.ParseException;
import org.junit.jupiter.api.Test;
import pattern.Entry;
import pattern.Field;

import java.util.ArrayList;


public class ParserTest {

    private Parser parser = new Parser();
    private Records records = new Records();

    private String author = "Abc Xyz";
    private String title = "Title";
    private String journal = "Journal";
    private String year = "1998";

    @Test
    public void simpleParsingTest() throws ParseException{
        String example = "@ARTICLE{test,\n" +
                "author = " + addQuotes(author) + ",\n" +
                "title = " + addQuotes(title) + ",\n" +
                "journal = " + addQuotes(journal) + ",\n" +
                "year = " + year + ",\n}";
        records = parser.parse(example);
        assertEquals(1,records.container.size());
        Entry entry = (Entry) records.container.toArray()[0];
        assertArrayEquals(new String[]{author,title,journal,year},makeArrayFromEntry(entry));
    }

    @Test
    public void includeStringVariableTest() throws ParseException{
        String modyfiedAuthor = addQuotes(author) + " #a variable";
        String example = "@STRING{variable = \"constant\"}\n\n" +
                "@ARTICLE{test,\n" +
                "author = " + modyfiedAuthor + ",\n" +
                "title = " + addQuotes(title) + ",\n" +
                "journal = " + addQuotes(journal) + ",\n" +
                "year = " + year + ",\n}";
        records = parser.parse(example);
        assertEquals(1,records.container.size());
        Entry entry = (Entry) records.container.toArray()[0];
        assertArrayEquals(new String[]{author.concat("constant"),title,journal,year},makeArrayFromEntry(entry));
    }

    @Test
    public void checkObligatoryFieldsTest(){
        String example = "@ARTICLE{test,\n" +
                "author = " + addQuotes(author) + ",\n" +
                "title = " + addQuotes(title) + ",\n" +
                "year = " + year + ",\n}";
        assertThrows(ParseException.class,() -> parser.parse(example));
    }

    @Test
    public void includeCrossrefVariableTest() throws ParseException{
        String crossref = "@ARTICLE{article-crossref,\n" +
                "crossref = \"TEST\",\n" +
                "author = " + addQuotes(author) +",\n}";

        String stringWithoutCrossref =
                "@ARTICLE{test,\n" +
                "title = " + addQuotes(title) + ",\n" +
                "journal = " + addQuotes(journal) + ",\n" +
                "year = " + year + ",\n";
        String example = crossref.concat("\n" + stringWithoutCrossref);
        records = parser.parse(example);
        assertEquals(1,records.container.size());
        Entry entry = (Entry) records.container.toArray()[0];
        assertArrayEquals(new String[]{author,title,journal,year},makeArrayFromEntry(entry));
    }

    private String addQuotes(String string) {
        return "\"" + string + "\"";
    }

    private String[] makeArrayFromEntry(Entry e){
        ArrayList<String> result = new ArrayList<>();
        for(Field field : e.fields){
            if(field.value != null){
                result.add(field.value);
            }
        }
        return result.toArray(new String[0]);
    }
}