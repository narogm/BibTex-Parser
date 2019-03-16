package pattern.entries;

import pattern.*;

public class Article extends Entry {

    public Article() {
        type = EntryType.ARTICLE;
        fields = new Field[]{
                new Field(FieldType.AUTHOR, null, true),
                new Field(FieldType.TITLE, null, true),
                new Field(FieldType.JOURNAL, null, true),
                new Field(FieldType.YEAR, null, true),
                new Field(FieldType.VOLUME, null, false),
                new Field(FieldType.NUMBER, null, false),
                new Field(FieldType.PAGES, null, false),
                new Field(FieldType.MONTH, null, false),
                new Field(FieldType.NOTE, null, false),
                new Field(FieldType.KEY, null, false),
        };
    }
}
