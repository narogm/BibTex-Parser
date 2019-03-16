package pattern;

/**
 * Object representation of entries from bibtex file
 */
public class Entry {
    public EntryType type;
    public String key;
    public Field[] fields;

    /**
     * Method that format an entry into string representation
     * @return String representation of entry
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        int entryCellSize = 68;
        int fieldNameCellSize = 15;
        int fieldValueCellSize = 52;
        for(int i = 0; i<7; i++)
            result.append("----------");
        result.append("\n").append("|").append(setCell(type.toString()+" (" + key + ")",entryCellSize)).append("|").append("\n");
        for(Field field : fields){
            if(field.value != null){
                for(int i = 0; i<7; i++)
                    result.append("----------");
                if(field.name != FieldType.AUTHOR && field.name != FieldType.EDITOR){
                    result.append("\n").append("|").append(setCell(field.name.toString(),fieldNameCellSize)).
                            append("|").append(setCell(field.value,fieldValueCellSize)).append("|\n");
                }
                else{
                    for(int i=0; i < field.firstnames.size() ; i++){
                        if(i==0)
                            result.append("\n").append("|").append(setCell(field.name.toString(),fieldNameCellSize)).append("|");
                        else
                            result.append("\n").append("|").append(setCell("",fieldNameCellSize)).append("|");
                        if(field.middlephrase.get(i) != null){
                            result.append(setCell(field.firstnames.get(i) + " " +
                                    field.middlephrase.get(i) + " " +
                                    field.lastnames.get(i),fieldValueCellSize)).
                                    append("|");
                        }
                        else{
                            result.append(setCell(field.firstnames.get(i) + " " +
                                    field.lastnames.get(i),fieldValueCellSize)).
                                    append("|");
                        }
                    }
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    private String setCell(String s,int len){
        return String.format("%1$" + (-len) + "s",s);
    }
}
