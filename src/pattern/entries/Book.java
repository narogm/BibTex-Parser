package pattern.entries;

import pattern.*;

public class Book extends Entry {

    public Book() {
        type = EntryType.BOOK;
        fields = new Field[]{
                new Field(FieldType.AUTHOR, null, true),
                new Field(FieldType.EDITOR, null, true),
                new Field(FieldType.TITLE, null, true),
                new Field(FieldType.PUBLISHER, null, true),
                new Field(FieldType.YEAR, null, true),
                new Field(FieldType.VOLUME, null, false),
                new Field(FieldType.SERIES, null, false),
                new Field(FieldType.ADDRESS, null, false),
                new Field(FieldType.EDITION, null, false),
                new Field(FieldType.MONTH, null, false),
                new Field(FieldType.NOTE, null, false),
                new Field(FieldType.KEY, null, false),
        };
    }
}
