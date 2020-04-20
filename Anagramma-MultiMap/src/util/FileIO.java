package util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileIO {

    public List<String> readFromFile(String fileName) {
        List<String> list = Collections.emptyList();
        try {
            list = Files.readAllLines(Paths.get(fileName));
            System.out.print("The file: ");
            System.out.print(fileName);
            System.out.println(" is read.");
        } catch (Exception e) {
            Util.printException(e);
        }
        return list;
    }

}