package exceptions;

/**
 * Exception that is thrown when there is a problem
 * while parsing a bibtex file
 */
public class ParseException extends Exception {

    public ParseException(String message) {
        super(message);
    }
}