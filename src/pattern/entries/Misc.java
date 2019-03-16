package pattern.entries;

import pattern.*;

public class Misc extends Entry {

    public Misc() {
        type = EntryType.MISC;
        fields = new Field[]{
                new Field(FieldType.AUTHOR, null, false),
                new Field(FieldType.TITLE, null, false),
                new Field(FieldType.HOWPUBLISHED, null, false),
                new Field(FieldType.MONTH, null, false),
                new Field(FieldType.YEAR, null, false),
                new Field(FieldType.NOTE, null, false),
                new Field(FieldType.KEY, null, false),
        };
    }
}
