package pattern.entries;

import pattern.*;

public class Manual extends Entry {

    public Manual() {
        type = EntryType.MANUAL;
        fields = new Field[]{
                new Field(FieldType.TITLE, null, true),
                new Field(FieldType.AUTHOR, null, false),
                new Field(FieldType.ORGANIZATION, null, false),
                new Field(FieldType.ADDRESS, null, false),
                new Field(FieldType.EDITION, null, false),
                new Field(FieldType.MONTH, null, false),
                new Field(FieldType.YEAR, null, false),
                new Field(FieldType.NOTE, null, false),
                new Field(FieldType.KEY, null, false),
        };
    }
}
