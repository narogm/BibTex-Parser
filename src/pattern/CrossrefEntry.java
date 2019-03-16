package pattern;

public class CrossrefEntry extends Entry{

    public String type;
    public CrossrefEntry() {
        fields = new Field[]{
                new Field(FieldType.AUTHOR, null, false),
                new Field(FieldType.TITLE, null, false),
                new Field(FieldType.JOURNAL, null, false),
                new Field(FieldType.YEAR, null, false),
                new Field(FieldType.VOLUME, null, false),
                new Field(FieldType.NUMBER, null, false),
                new Field(FieldType.PAGES, null, false),
                new Field(FieldType.MONTH, null, false),
                new Field(FieldType.NOTE, null, false),
                new Field(FieldType.KEY, null, false),
                new Field(FieldType.EDITOR, null, false),
                new Field(FieldType.PUBLISHER, null, false),
                new Field(FieldType.SERIES, null, false),
                new Field(FieldType.ADDRESS, null, false),
                new Field(FieldType.EDITION, null, false),
                new Field(FieldType.BOOKTITLE, null, false),
                new Field(FieldType.ORGANIZATION, null, false),
                new Field(FieldType.HOWPUBLISHED, null, false),
                new Field(FieldType.CHAPTER, null, false),
                new Field(FieldType.SCHOOL, null, false),
                new Field(FieldType.TYPE, null, false),
                new Field(FieldType.INSTITUTION, null, false),
        };
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(type).append(" (").append(key).append(")\n");
        for(Field field : fields)
            if(field.value != null)
                str.append(field).append("\n");
        return str.toString();
    }
}
