package pattern.entries;

import pattern.*;

public class Unpublished extends Entry {

    public Unpublished() {
        type = EntryType.UNPUBLISHED;
        fields = new Field[]{
                new Field(FieldType.AUTHOR, null, true),
                new Field(FieldType.TITLE, null, true),
                new Field(FieldType.NOTE, null, true),
                new Field(FieldType.MONTH, null, false),
                new Field(FieldType.YEAR, null, false),
                new Field(FieldType.KEY, null, false),
        };
    }
}
