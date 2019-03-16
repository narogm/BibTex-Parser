package app;

import building.Builder;
import building.EntryBuilder;
import building.Supervisor;
import exceptions.ParseException;
import pattern.CrossrefEntry;
import pattern.Entry;
import pattern.Field;

import java.util.*;

/**
 * Implementation of parser for simplified bibtex file
 */
public class Parser {

    private Map<String, String> stringVariables = new HashMap<>();
    private Map<String, CrossrefEntry> crossRefAtributes = new HashMap();

    /**
     * This method split all objects by '@'
     * what enable to iterate over entries
     * and also check if it is a string variable
     * @param bibtex String that contains content of given bibtex file
     * @return Separated entries
     * @throws ParseException when format of file is incorrect
     */
    public Records parse(String bibtex) throws ParseException {

        Records records = new Records();

        StringTokenizer str = new StringTokenizer(bibtex, "@");
        while (str.hasMoreElements()) {
            String string = str.nextElement().toString();
            String[] array = string.split("\\{", 2);
            if (string.substring(0, 6).equals("STRING")) {
                String[] tmpArray = array[1].split(",");
                stringVariables.putAll(parseSingleField(tmpArray[0].split("}")[0]));
            }
            else if(!string.substring(0,7).equals("COMMENT") && !string.substring(0,8).equals("PREAMBLE")) {
                String type = array[0];
                records.add(parseEntry(array[1], type));
            }
        }
        return records;
    }

    /**
     * Method that split entries by ',' into particular fields
     * and check crossref variables
     * @param str content of single entry
     * @param type type of entry
     * @return formatted entry
     * @throws ParseException
     */
    private Records parseEntry(String str, String type) throws ParseException {
        String[] arrayOfFields = str.split(",");
        String key = deleteRedundantSpaces(arrayOfFields[0]);
        Map<String, String> fields = parseFields(Arrays.copyOfRange(arrayOfFields, 1, arrayOfFields.length - 1));

        if(crossRefAtributes.containsKey(type.toLowerCase()+"|"+key.toLowerCase())){
            CrossrefEntry crossref = crossRefAtributes.get(type.toLowerCase()+"|"+key.toLowerCase());
            for (Field field : crossref.fields) {
                String index = field.name.toString().toLowerCase();
                if (field.value != null && !fields.containsKey(index)){
                    fields.put(field.name.toString().toLowerCase(),field.value);
                }
            }
        }
        return buildEntry(type, key, fields);
    }

    /**
     * Method that check if any string variable exist in records
     * @param arrayOfFields array of particular fields
     * @return formatted fields
     */
    private Map<String, String> parseFields(String[] arrayOfFields) {
        Map<String, String> fields = new HashMap<>();
        for (String string : arrayOfFields) {
            StringTokenizer stringTokenizer = new StringTokenizer(string,"#");
            if(stringTokenizer.countTokens()>1 || !string.substring(0, 1).equals("\"")){
                String result = "";
                while(stringTokenizer.hasMoreElements()){
                    String str = deleteRedundantSpaces(stringTokenizer.nextElement().toString());
                    if(!str.substring(0, 1).equals("\"") && !str.substring(str.length()-1).equals("\"")){
                        for(String variable : stringVariables.keySet()){
                            if(str.contains(variable)){
                                str = str.replace(variable,stringVariables.get(variable));
                            }
                        }
                    }
                    result = result.concat(str);
                }
                string = result;
            }
            Map<String,String> field = parseSingleField(string);
            fields.putAll(field);
        }
        return fields;
    }

    /**
     * Method that split particular field by '='
     * and then format records properly
     * @param string unformatted field
     * @return split field
     */
    private Map<String, String> parseSingleField(String string) {
        Map<String, String> fields = new HashMap<>();
        String[] field = string.split("=");
        field[0] = field[0].replaceAll(" ", "").replaceAll("\n", "");
        field[1] = deleteRedundantSpaces(field[1].replaceAll("\"", ""));
        fields.put(field[0], field[1]);
        return fields;
    }

    /**
     * Method that build entry from given data
     * @param type type of entry
     * @param key key of entry
     * @param fields split fields
     * @return formatted entry
     * @throws ParseException
     */
    private Records buildEntry(String type, String key, Map<String, String> fields) throws ParseException {
        Records records = new Records();
        if(fields.containsKey("crossref")){
            CrossrefEntry crossref = new CrossrefEntry();
            crossref.type = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
            crossref.key = type.toLowerCase() + "|" +fields.get("crossref").toLowerCase();
            for (Field field : crossref.fields) {
                String index = field.name.toString().toLowerCase();
                if (fields.containsKey(index))
                    field.value = fields.get(index);
            }
            crossRefAtributes.put(crossref.key,crossref);
        }
        else{
            Supervisor supervisor = new Supervisor();
            EntryBuilder builder = new Builder();
            supervisor.setEntryBuilder(builder);
            supervisor.constructEntry(type, key, fields);

            Entry entry = supervisor.getEntry();
            records.add(entry);

        }
        return records;
    }

    /**
     * Method that delete spaces from the beginning and the end of given string
     * @param string unformatted string
     * @return formatted string
     */
    private String deleteRedundantSpaces(String string) {
        if(string.length() > 1){
            while (string.substring(0, 1).equals(" "))
                string = string.substring(1);
            while (string.substring(string.length() - 1).equals(" "))
                string = string.substring(0, string.length() - 1);
        }
        return string;
    }
}
