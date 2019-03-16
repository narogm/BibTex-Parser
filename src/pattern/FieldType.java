package pattern;

/**
 * Enum for all possible fields' types
 */
public enum FieldType {
    AUTHOR("Author"),
    TITLE("Title"),
    JOURNAL("Journal"),
    YEAR("Year"),
    VOLUME("Volume"),
    NUMBER("Number"),
    PAGES("Pages"),
    MONTH("Month"),
    NOTE("Note"),
    KEY("Key"),
    EDITOR("Editor"),
    PUBLISHER("Publisher"),
    SERIES("Series"),
    ADDRESS("Address"),
    EDITION("Edition"),
    BOOKTITLE("Booktitle"),
    ORGANIZATION("Organization"),
    HOWPUBLISHED("Howpublished"),
    CHAPTER("Chapter"),
    SCHOOL("School"),
    TYPE("Type"),
    INSTITUTION("Institution");

    private String name;
    FieldType(String name){
        this.name=name;
    }

    @Override
    public String toString(){
        return name;
    }
}
