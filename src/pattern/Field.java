package pattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Object representation of particular field
 */
public class Field {
    public final FieldType name;
    public String value;
    public final boolean isObligatory;
    public List<String> firstnames = new LinkedList<>();
    public List<String> lastnames = new LinkedList<>();
    public List<String> middlephrase = new LinkedList<>();

    public Field(FieldType name, String value, boolean isObligatory) {
        this.name = name;
        this.value = value;
        this.isObligatory = isObligatory;
    }

    /**
     * Method that split author or editor value
     * according to requirements
     */
    public void splitAuthor() {
        String[] authors = value.split("and");
        for (String string : authors) {
            string = deleteRedundantSpaces(string);
            String[] tmp = string.split(" \\| ");
            if (tmp.length == 1) {
                String[] authorNames = string.split(" ");
                if (authorNames.length == 2) {
                    firstnames.add(authorNames[0]);
                    middlephrase.add(null);
                    lastnames.add(authorNames[1]);
                }
                if (authorNames.length == 3) {
                    firstnames.add(authorNames[0]);
                    middlephrase.add(authorNames[1]);
                    lastnames.add(authorNames[2]);
                }
            }
            if (tmp.length == 2) {
                lastnames.add(tmp[0]);
                middlephrase.add(null);
                firstnames.add(tmp[1]);
            }
            if (tmp.length == 3) {
                lastnames.add(tmp[0]);
                middlephrase.add(tmp[1]);
                firstnames.add(tmp[2]);
            }
        }
    }

    @Override
    public String toString() {
        if (name == FieldType.AUTHOR) {
            if (firstnames.size() > 1) {
                StringBuilder stringBuilder = new StringBuilder();
                for(int i = 1; i<=firstnames.size() ; i++){
                    if(middlephrase.get(i-1) != null){
                        stringBuilder.append(this.name.toString() + i + " -> ").
                                append(firstnames.get(i-1) + " " +
                                        middlephrase.get(i-1) + " " +
                                        lastnames.get(i-1)).
                                append("\n");
                    }
                    else{
                        stringBuilder.append(this.name.toString() + i + " -> ").
                                append(firstnames.get(i-1) + " " +
                                        lastnames.get(i-1)).
                                append("\n");
                    }
                }
                return stringBuilder.toString();
            }
        }
        return this.name + " -> " + value;
    }

    /**
     * Method that return array of particular authors or editors
     * @return array of particular authors or editors
     */
    public String[] getSplittedAuthorNames(){
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<firstnames.size(); i++){
            if(middlephrase.get(i) != null){
                result.add(firstnames.get(i) + " "
                        + middlephrase.get(i) + " "
                        + lastnames.get(i));
            }
            else{
                result.add(firstnames.get(i) + " "
                        + lastnames.get(i));
            }
        }
        return result.toArray(new String[0]);
    }

    private String deleteRedundantSpaces(String string) {
        while (string.substring(0, 1).equals(" "))
            string = string.substring(1);
        while (string.substring(string.length() - 1).equals(" "))
            string = string.substring(0, string.length() - 1);

        return string;
    }
}
