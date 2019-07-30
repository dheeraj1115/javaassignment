import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Three {
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
                HashMap<String, Integer> map1 = new HashMap<>();
                String path1 = file.getAbsolutePath();
                FileReader f1 = new FileReader(path1);
                String[] words = null;
                BufferedReader br = new BufferedReader(f1);
                String s;

                int dcount = 0;
                int ocount = 0;
                int swcount = 0;
                Stack<Integer> stack = new Stack<Integer>();
                while ((s = br.readLine()) != null)
                {
                    //int first_char = s.charAt(0);
                    //if(first_char != '/') {
                        words = s.split(" ");
                        for (String word : words) {
                            if (word.length() > 1) {
                                char w = word.charAt(0);
                                char w1 = word.charAt(1);

                                int flag2 =1;
                                if(w =='/' && w1 == '*')
                                {

                                    stack.push(flag2);
                                }
                                else if(w=='*' && w1=='/')
                                {
                                    stack.pop();
                                }

                                else if (w == '@' && (stack.empty())) {
                                    String s1 = "";
                                    char[] c = word.toCharArray();
                                    for (int i = 1; i < word.length(); i++) {

                                        if (Character.isAlphabetic(c[i]))
                                            s1 += c[i];
                                        else {
                                            break;
                                        }
                                    }
                                    boolean flag = map1.containsKey(s1);
                                    if (flag) {
                                        Integer count1 = map1.get(s1);
                                        map1.put(s1, count1 + 1);
                                    } else {
                                         map1.put(s1, 1);
                                    }


                                }
                            }
                        }




                }
                map.putAll(map1);
                System.out.println(file.getName()+" contains "+map1);
            }


            else if(file.isDirectory())
            {
                num_directory++;
                listFiles(file.getAbsolutePath());
            }

        }

    }
    public static void main(String [] args) throws IOException {
        listFiles("/Users/1025965/Desktop/java/learning 1/coding1");
        System.out.println("Number of directory = "+ Three.num_directory);
        System.out.println("Number of files = "+ Three.num_files);
        //System.out.println("Total number of anotations are "+" "+map);

    }
}
