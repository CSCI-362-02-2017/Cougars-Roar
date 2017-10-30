import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.file.*;
import java.awt.Color;
import java.io.IOException;
import java.nio.charset.Charset;


//an example test executable

public class ContrastCheckerDriver{
  public static void main(String[] args) throws IOException, FileNotFoundException
  {
    File folder = new File("../testCases");
    folder.mkdirs();
    File[] fileList = folder.listFiles();

    for (File testfile : fileList){     
      FileReader reader = new FileReader(testfile);
      BufferedReader textReader = new BufferedReader(reader);
      String line;
      List<String> lineList = new LinkedList<String>();
      while ((line = textReader.readLine()) != null) {
        if (!line.contains("//")) lineList.add(line);
      }  

      String testCaseID = lineList.get(0);
      String method = lineList.get(1);
      String description = lineList.get(2);
      String fg = lineList.get(3);
      String bg = lineList.get(4);
      String expected = lineList.get(5);

      String[] bgColors = bg.split(",");

      Integer[] bgColorsInt = new Integer[bgColors.length];
      for(int i = 0; i < bgColors.length; i++) {
        bgColorsInt[i] = Integer.parseInt(bgColors[i]);
      }

      String[] fgColors = fg.split(",");

      Integer[] fgColorsInt = new Integer[fgColors.length];
      for(int i = 0; i < fgColors.length; i++) {
        fgColorsInt[i] = Integer.parseInt(fgColors[i]);
      }
      
      Color fgColor = new Color(fgColorsInt[0],fgColorsInt[1],fgColorsInt[2]);
      Color bgColor = new Color(bgColorsInt[0],bgColorsInt[1],bgColorsInt[2]);

      double result = ContrastChecker.getConstrastRatio(fgColor, bgColor);
      String actual = new Double(result).toString();

      String passfail = new Boolean(actual.equals(expected)).toString();


      List<String> lines = Arrays.asList(testCaseID,method,description,fg,bg,expected,actual,passfail);
      for(int i = 0; i < lines.size(); i++){
        lines.set(i,"<TD>"+lines.get(i)+"</TD>\n");
      }
      try {
          Path file = Paths.get("../temp/test1Report.txt");
          Files.write(file, lines, Charset.forName("UTF-8"));    
      } catch (IOException e) {
          System.out.println(e);
      }
      textReader.close();

    }
  }
}