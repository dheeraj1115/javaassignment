import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    static int num_directory;
    static int num_files;
    HashMap<String, Integer> map = new HashMap<>();
    private static void listFiles(String path)  throws IOException
    {

        File folder = new File(path);
        File [] files = folder.listFiles();
        for(File file:files)
        {
            if(file.isFile())
            {

                num_files++;
                String path1 = file.getAbsolutePath();
                FileReader f1 = new FileReader(path1);
                String[] words=null;
                BufferedReader br = new BufferedReader(f1);
                String s;
                String [] input = {"@Deprecated","@Override","@SuppressWarnings"};
                int dcount=0;
                int ocount=0;
                int swcount=0;
                while((s=br.readLine())!=null)
                {
                    words=s.split(" ");
                    for (String word : words)
                    {
                       //Pattern pattern = Pattern.compile("@");
                        if (word.equals(input[0]))
                        {
                            dcount++;
                        }
                        else if(word.equals(input[1]))
                        {
                            ocount++;
                        }
                        else if(word.equals(input[2]))
                        {
                            swcount++;
                        }
                    }
                }
                System.out.println(file.getName() + "@override"+" "+ ocount);
                System.out.println(file.getName() + "@Deprecated"+" "+ dcount);
                System.out.println(file.getName() + "@SupperessWarnings"+" "+ swcount);

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
        System.out.println("Number of directory = "+ Program.num_directory);
        System.out.println("Number of files = "+ Program.num_files);
    }
}