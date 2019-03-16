package pattern.entries;

import pattern.*;

public class Inbook extends Entry {

    public Inbook() {
        type = EntryType.INBOOK;
        fields = new Field[]{
                new Field(FieldType.AUTHOR, null, true),
                new Field(FieldType.EDITOR, null, true),
                new Field(FieldType.TITLE, null, true),
                new Field(FieldType.CHAPTER, null, true),
                new Field(FieldType.PAGES, null, true),
                new Field(FieldType.PUBLISHER, null, true),
                new Field(FieldType.YEAR, null, true),
                new Field(FieldType.VOLUME, null, false),
                new Field(FieldType.NUMBER, null, false),
                new Field(FieldType.SERIES, null, false),
                new Field(FieldType.TYPE, null, false),
                new Field(FieldType.ADDRESS, null, false),
                new Field(FieldType.EDITION, null, false),
                new Field(FieldType.MONTH, null, false),
                new Field(FieldType.NOTE, null, false),
                new Field(FieldType.KEY, null, false),
        };
    }
}
