package app;

import exceptions.ParseException;
import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * App that parse simplified bibtex file.
 * There is also an option to filter results
 * by given type or author
 *
 * @author Mateusz Naróg
 */
public class App {
    public static void main(String[] args) {

        CommandLineParser commandLineParser = new DefaultParser();
        HelpFormatter helpFormatter = new HelpFormatter();

        Options options = new Options();
        options.addOption("a", false, "Show all entries");
        options.addOption("h", false, "Show available options");
        options.addOption("n", true, "Show entries by given author/editor name");
        options.addOption("t", true, "Show entries by given entry type");

        BibtexFileReader fileReader = new BibtexFileReader();
        Parser parser = new Parser();
        Records records;

        try {
            CommandLine commandLine = commandLineParser.parse(options, args);
            if(commandLine.getArgs().length != 1){
                helpFormatter.printHelp("Program parameters:", options);
                System.out.println("\n\n");
                System.exit(1);
            }
            else{
                if(commandLine.hasOption("h")){
                    helpFormatter.printHelp("Program parameters:", options);
                    System.out.println("\n\n");
                }
                String filePath = commandLine.getArgs()[0];
                String bibtexString = fileReader.read(filePath);
                records = parser.parse(bibtexString);
                if(commandLine.hasOption("a")){
                    System.out.print("Showing all entries:\n");
                    System.out.print(records+"\n");
                }
                if(commandLine.hasOption("n")){
                    String author = commandLine.getOptionValue("n");
                    System.out.print("Showing entries for given author: " + author.substring(0,1).toUpperCase()+author.substring(1) + "\n");
                    System.out.print(records.print(records.getEntriesByAuthor(author)) + "\n");
                    if(records.getEntriesByAuthor(author).size() == 0)
                        System.out.println("Lack of entries for given author");
                }
                if(commandLine.hasOption("t")){
                    String type = commandLine.getOptionValue("t");
                    System.out.print("Showing entries for given type: " + type.toUpperCase() + "\n");
                    System.out.print(records.print(records.getEntriesByType(type)) + "\n");
                    if(records.getEntriesByType(type).size() == 0)
                        System.out.println("Lack of entries for given type");
                }
            }

        } catch (IOException | ParseException | org.apache.commons.cli.ParseException e) {
            System.err.println("Unexpected exception. Reason: " + e.getMessage());
            helpFormatter.printHelp("Program parameters:", options);
        }
    }
}
