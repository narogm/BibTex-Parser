package building;

import exceptions.ParseException;
import pattern.Entry;
import pattern.Field;

import java.util.Map;

public class Builder extends EntryBuilder {

    /**
     *{@inheritDoc}
     */
    @Override
    public void setValues(String type, String key, Map<String, String> fields) throws ParseException {
        type = formatString(type);
        try {
            Class c = Class.forName("pattern.entries." + type);
            entry = (Entry) c.newInstance();
            entry.key = key;
            setFieldsAndValidateObligatory(entry, fields);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ParseException("Error while parsing " + type + " (" + key + ")");
        }
    }

    /**
     * Method that set values of particular fields
     * and validate if there are all obligatory fields
     * @param entry entry to work with
     * @param fields values that will be assigned to the entry
     * @throws ParseException when there is missing obligatory field
     */
    private void setFieldsAndValidateObligatory(Entry entry, Map<String, String> fields) throws ParseException {
        for (Field field : entry.fields) {
            String index = field.name.toString().toLowerCase();
            if (fields.containsKey(index))
                field.value = fields.get(index);
            if (field.name.toString().equals("Author") || field.name.toString().equals("Editor")) {
                if (field.value != null){
                    field.splitAuthor();
                }
            }

            if (field.value == null && field.isObligatory) {
                String fieldName = field.name.toString();
                if(!fieldName.equals("Author") && !fieldName.equals("Editor") && !fieldName.equals("Chapter") && !fieldName.equals("Pages")){
                    throw new ParseException(entry.type + " (" + entry.key + ")" + " doesn't have an obligatory field " + field);
                } else if (fieldName.equals("Editor") && !fields.containsKey("author")) {
                    throw new ParseException(entry.type + " (" + entry.key + ")" + " doesn't have an obligatory field " + field);
                } else if (fieldName.equals("Author") && !fields.containsKey("editor")) {
                    throw new ParseException(entry.type + " (" + entry.key + ")" + " doesn't have an obligatory field " + field);
                } else if (fieldName.equals("Chapter") && !fields.containsKey("pages")) {
                    throw new ParseException(entry.type + " (" + entry.key + ")" + " doesn't have an obligatory field " + field);
                } else if (fieldName.equals("Pages") && !fields.containsKey("chapter")) {
                    throw new ParseException(entry.type + " (" + entry.key + ")" + " doesn't have an obligatory field " + field);
                }
            }
        }
    }

    private String formatString(String str) {
        str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        return str;
    }

}
