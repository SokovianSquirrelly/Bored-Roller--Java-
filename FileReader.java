import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader
{
    String filename;

    public FileReader(String filename)
    {
        this.filename = filename;
    }

    public ArrayList<String> LoadFile()
    {
        try
        {
            ArrayList<String> contents = new ArrayList<String>();
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
    
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                contents.add(line);
            }

            return contents;
        }
        catch (FileNotFoundException e)
        {
            return null;
        }
    }
}
