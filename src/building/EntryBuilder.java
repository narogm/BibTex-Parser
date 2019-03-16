package building;

import exceptions.ParseException;
import pattern.Entry;
import pattern.EntryType;

import java.util.Map;

/**
 * Builder for entries
 * It enables to add entry and validate its field
 */
public abstract class EntryBuilder {
    protected Entry entry;

    public Entry getEntry() {
        return entry;
    }

    /**
     * Method that set values of entry
     * @param type type of entry
     * @param key key of entry
     * @param fields split fields
     * @throws ParseException
     */
    public abstract void setValues(String type, String key, Map<String, String> fields) throws ParseException;
}
