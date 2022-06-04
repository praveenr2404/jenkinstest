import java.io.*;
import java.net.URL;
import java.nio.file.Files;

public class WriteFile {
    public static void write(String filePath){
        try(FileWriter fWriter = new FileWriter(filePath,true);
            PrintWriter pWriter = new PrintWriter(fWriter);
        ){
            pWriter.println("abcd");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
