package Exceptions;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AccessException;
import java.text.ParseException;
import java.util.regex.PatternSyntaxException;

public class Exception4 {
    public static void main(String[] args) {
        try {
            run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException | ParserConfigurationException e) { // Multi-catch
            throw new RuntimeException(e);
        }
//        catch (Exception){
//              Обработка всех исключений
//        }
    }

    public static void run() throws IOException, ParseException, IllegalArgumentException, ParserConfigurationException {

    }
}
