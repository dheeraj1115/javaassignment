import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Two
{
    static int num_directory;
    static int num_files;
    static HashMap<String, Integer> map = new HashMap<>();
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
                String[] words = null;
                BufferedReader br = new BufferedReader(f1);
                String s;

                int dcount = 0;
                int ocount = 0;
                int swcount = 0;
                while ((s = br.readLine()) != null)
                {
                    words = s.split(" ");
                    for (String word : words)
                    {
                        if (word.length() > 1)
                        {
                            char w = word.charAt(0);
                            if (w == '@')
                            {
                                String s1=" ";
                                char[] c = word.toCharArray();
                                for (int i = 1; i < word.length(); i++)
                                {

                                    if (Character.isAlphabetic(c[i]))
                                        s1 += c[i];
                                     else
                                        break;
                                }
                                boolean flag = map.containsKey(s1);
                                if (flag)
                                   {
                                    Integer count1 = map.get(s1);
                                    map.put(s1, count1 + 1);
                                   }
                                else
                                    {
                                            map.put(s1, 1);
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
        listFiles("/Users/1025965/Desktop/java");
        System.out.println("Number of directory = "+ Two.num_directory);
        System.out.println("Number of files = "+ Two.num_files);
        System.out.println(map);

    }
}
