package pattern.entries;


import pattern.*;

public class Booklet extends Entry {

    public Booklet() {
        type = EntryType.BOOKLET;
        fields = new Field[]{
                new Field(FieldType.TITLE, null, true),
                new Field(FieldType.AUTHOR, null, false),
                new Field(FieldType.HOWPUBLISHED, null, false),
                new Field(FieldType.ADDRESS, null, false),
                new Field(FieldType.MONTH, null, false),
                new Field(FieldType.YEAR, null, false),
                new Field(FieldType.NOTE, null, false),
                new Field(FieldType.KEY, null, false),
        };
    }
}
