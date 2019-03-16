package pattern.entries;

import pattern.*;

public class Mastersthesis extends Entry {

    public Mastersthesis() {
        type = EntryType.MASTERSTHESIS;
        fields = new Field[]{
                new Field(FieldType.AUTHOR, null, true),
                new Field(FieldType.TITLE, null, true),
                new Field(FieldType.SCHOOL, null, true),
                new Field(FieldType.YEAR, null, true),
                new Field(FieldType.TYPE, null, false),
                new Field(FieldType.ADDRESS, null, false),
                new Field(FieldType.MONTH, null, false),
                new Field(FieldType.NOTE, null, false),
                new Field(FieldType.KEY, null, false),
        };
    }
}
