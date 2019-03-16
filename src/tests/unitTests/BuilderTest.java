package tests.unitTests;

import app.Records;
import building.Builder;
import building.EntryBuilder;
import building.Supervisor;
import exceptions.ParseException;
import org.junit.jupiter.api.Test;
import pattern.Entry;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @Test
    public void simpleAddTest() throws ParseException {
        Supervisor supervisor = new Supervisor();
        EntryBuilder builder = new Builder();
        supervisor.setEntryBuilder(builder);
        Records records = new Records();

        String type = "ARTICLE";
        String key = "article-minimal";
        Map<String, String> fields = new HashMap<>();
        fields.put("author","NAME SURNAME");
        fields.put("title","TITLE");
        fields.put("journal","JOURNAL");
        fields.put("year","1998");

        supervisor.constructEntry(type, key, fields);
        Entry entry = supervisor.getEntry();
        records.add(entry);

        String type2 = "BOOK";
        String key2 = "book-minimal";
        Map<String, String> fields2 = new HashMap<>();
        fields2.put("author","NAME SURNAME");
        fields2.put("title","TITLE");
        fields2.put("publisher","PUBLISHER");
        fields2.put("year","1998");

        supervisor.constructEntry(type2, key2, fields2);
        Entry entry2 = supervisor.getEntry();
        records.add(entry2);

        assertEquals(2,records.container.size());
    }
}