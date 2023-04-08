package FileManipulations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteInFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/FileManipulations/testFile");
        PrintWriter pw = new PrintWriter(file); // Только для текстовых значений (не для звуков и прочего)

        pw.println("E");

        pw.close();
    }
}
