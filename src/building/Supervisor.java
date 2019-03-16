package building;

import exceptions.ParseException;
import pattern.Entry;

import java.util.Map;

/**
 * Element of builder pattern that
 * starts process of building an entry
 */
public class Supervisor {
    private EntryBuilder entryBuilder;

    public void setEntryBuilder(EntryBuilder entryBuilder) {
        this.entryBuilder = entryBuilder;
    }
    public Entry getEntry(){
        return entryBuilder.getEntry();
    }

    public void constructEntry(String type,String key, Map<String,String> fields) throws ParseException {
        //entryBuilder.createNewEntryProduct();
        entryBuilder.setValues(type,key,fields);
    }
}
