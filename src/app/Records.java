package app;

import pattern.Entry;
import pattern.EntryType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class which has container for all parsed entries
 * and enable user to get them by specified criteria
 */
public class Records {
    public Collection<Entry> container = new ArrayList<>();

    /**
     * Method that add particular entry to container
     * @param entry particular entry
     */
    public void add(Entry entry){
        container.add(entry);
    }

    /**
     * Method that add entries from other container
     * @param records container of entries
     */
    public void add(Records records){
        container.addAll(records.container);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Entry entry : container){
            result.append(entry);
            for(int i = 0; i<7; i++)
                result.append("----------");
            result.append("\n");
            for(int i = 0; i<7; i++)
                result.append("**********");
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * Method that allows user to get entries filtered by given type
     * @param type name of type
     * @return entries that meet given criteria
     */
    public List<Entry> getEntriesByType(String type){
        List<Entry> result = new ArrayList<>();
        for(Entry entry : container){
            if(entry.type.toString().equals(type.toUpperCase()))
                result.add(entry);
        }
        return result;
    }

    /**
     * Method that allows user to get entries filtered by given surname of author
     * @param lastname surname of author
     * @return entries that meet given criteria
     */
    public List<Entry> getEntriesByAuthor(String lastname){
        List<Entry> result = new ArrayList<>();
        for(Entry entry : container){
            for(int i=0;i<entry.fields.length;i++){
                if(entry.fields[i].name.toString().equals("Author") || entry.fields[i].name.toString().equals("Editor")){
                    for(String author : entry.fields[i].lastnames){
                        if(author.equals(lastname))
                            result.add(entry);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Method that allows user to print entries in formatted way from given list
     * @param container list of entries
     * @return formatted string
     */
    public String print(List<Entry> container){
        StringBuilder result = new StringBuilder();
        for(Entry entry : container){
            result.append(entry);
            for(int i = 0; i<7; i++)
                result.append("----------");
            result.append("\n");
            for(int i = 0; i<7; i++)
                result.append("**********");
            result.append("\n");
        }
        return result.toString();
    }
}
