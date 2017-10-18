import java.util.List;
import java.util.Arrays;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.charset.Charset;

//an example test executable

public class test1
{
  public static void main(String[] args)
  {
    List<String> lines = Arrays.asList("The first line 1 ", "The second line 1 ");
    try {
        Path file = Paths.get("../temp/test1Report.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));    
    } catch (IOException e) {
        System.out.println(e);
    }
  }  
}