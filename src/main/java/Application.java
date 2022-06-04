import java.io.File;

public class Application {
    public static void main(String[] args) {
        String filePath = new File(System.getProperty("user.dir")+"/out/test.txt").getAbsolutePath();
        WriteFile.write(filePath);
        System.out.println("Write Success");
    }
}
