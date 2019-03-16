package app;

import java.io.*;
import java.util.Scanner;

/**
 * Class for reading bibtex files
 */
public class BibtexFileReader {

    /**
     * Method that reads file from given file
     * and returns its content as a string
     * @param file_name name of the file
     * @return content of the file
     * @throws IOException when there is any problem with the file
     */
    public String read(String file_name) throws IOException {

        File file = new File(file_name);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        StringBuilder result = new StringBuilder();

        while((st = br.readLine()) != null)
            result.append(st).append("\n");

        return result.toString();
    }
}
