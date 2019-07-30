import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class One {
    static int num_directory;
    static int num_files;
    static HashMap<String, Integer> map = new HashMap<>();
    private static void listFiles(String path)  throws IOException
    {

        File folder = new File(path);
        File [] files = folder.listFiles();
        for(File file:files)
        {
            if(file.isFile()) {
                num_files++;
                String path1 = file.getAbsolutePath();
                FileReader f1 = new FileReader(path1);
                String[] words = null;
                BufferedReader br = new BufferedReader(f1);
                String s;
                int dcount = 0;
                int ocount = 0;
                int swcount = 0;
                while ((s = br.readLine()) != null) {
                    words = s.split(" ");
                    for (String word : words) {
                        if(word.length()>=1) {
                            char w = word.charAt(0);
                            if (w == '@') {
                                boolean flag = map.containsKey(word);
                                if (flag) {
                                    Integer count1 = map.get(word);
                                    map.put(word, count1 + 1);
                                } else {
                                    map.put(word, 1);
                                }



                            }
                        }
                    }

            }

            }
            else if(file.isDirectory())
            {
                num_directory++;
                listFiles(file.getAbsolutePath());
            }
        }
    }
    public static void main(String [] args) throws IOException {
        listFiles("/Users/1025965/Desktop/java/learning 1/coding2");
        System.out.println("Number of directory = "+ One.num_directory);
        System.out.println("Number of files = "+ One.num_files);
        System.out.print(map);
        //System.out.println('\n');

    }
}

