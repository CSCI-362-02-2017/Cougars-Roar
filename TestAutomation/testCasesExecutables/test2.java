import java.util.List;
import java.util.Arrays;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.charset.Charset;

//an example test executable

public class test2
{
  public static void main(String[] args)
  {
    List<String> lines = Arrays.asList("The first line 2 ", "The second line 2 ");
    try {
        Path file = Paths.get("../temp/test2Report.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));    
    } catch (IOException e) {
        System.out.println(e);
    }
  }
}