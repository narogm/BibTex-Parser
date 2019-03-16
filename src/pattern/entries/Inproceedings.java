package pattern.entries;

import pattern.*;

public class Inproceedings extends Entry {

    public Inproceedings() {
        type = EntryType.INPROCEEDINGS;
        fields = new Field[]{
                new Field(FieldType.AUTHOR, null, true),
                new Field(FieldType.TITLE, null, true),
                new Field(FieldType.BOOKTITLE, null, true),
                new Field(FieldType.YEAR, null, true),

                new Field(FieldType.EDITOR, null, false),
                new Field(FieldType.VOLUME, null, false),
                new Field(FieldType.NUMBER, null, false),
                new Field(FieldType.SERIES, null, false),
                new Field(FieldType.PAGES, null, false),
                new Field(FieldType.ADDRESS, null, false),
                new Field(FieldType.MONTH, null, false),
                new Field(FieldType.ORGANIZATION, null, false),
                new Field(FieldType.PUBLISHER, null, false),
                new Field(FieldType.NOTE, null, false),
                new Field(FieldType.KEY, null, false),
        };
    }
}
