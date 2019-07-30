import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.util.*;
import java.io.*;
public class Five {


    static int num_directory;
    static int num_files;
    static int num=1;
    static HashMap<String, Integer> map = new HashMap<>();

    private static void listFiles(String path) throws IOException {

        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
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
                while ((s = br.readLine()) != null) {
                    words = s.split(" ");
                    for (String word : words) {
                        if (word.length() > 1) {
                            char w = word.charAt(0);
                            if (w == '@') {
                                String s1 = " ";
                                char[] c = word.toCharArray();
                                for (int i = 1; i < word.length(); i++) {

                                    if (Character.isAlphabetic(c[i]))
                                        s1 += c[i];
                                    else
                                        break;
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

                //FileOutputStream fout=new FileOutputStream("/Users/1025965/Desktop/file.txt");
                //FileWriter fw=new FileWriter("/Users/1025965/Desktop/file.txt");
                //File file22 = new File("/Users/1025965/Desktop/file.txt");
                //FileWriter fr = new FileWriter(file22, true);
                //FileWriter fstream;
                //BufferedWriter out;
                //fstream = new FileWriter("/Users/1025965/Desktop/values"+ num+".txt");
                //num++;
                //out = new BufferedWriter(fstream);
                /*for (Map.Entry<String,Integer> entry : map1.entrySet())
                {
                    String p = entry.getKey();
                    Integer a = entry.getValue();
                    System.out.println(p +" "+" "+ a);
                    out.write(p + "\n");

                    //fr.write(a);
                    //fr.close();

                    //fw.write("p");
                    //fw.write(a);
                    //fw.close();
                }*/
                FileWriter fstream;
                BufferedWriter out;


                fstream = new FileWriter("/Users/1025965/Desktop/output/output" + num + ".txt");
                num++;
                out = new BufferedWriter(fstream);
                //Iterator<Entry<String, Integer>> it = map1.entrySet().iterator();
                if (map1.size() == 0)
                    System.out.println("no anotations found");
                else {
                    Iterator<Map.Entry<String, Integer>> itr = map1.entrySet().iterator();

                    while (itr.hasNext()) {

                        Map.Entry<String, Integer> pairs = itr.next();
                        System.out.println("Value is " + pairs.getKey() + " " + pairs.getValue());
                        out.write(pairs.getKey() + "  ");
                        out.write(pairs.getValue() + "\n");
                    }

                    out.close();
                }
            }
            else if (file.isDirectory()) {
                num_directory++;
                listFiles(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) throws IOException {

        File file1 = new File("/Users/1025965/Desktop/input.txt");
        FileReader f1 = new FileReader(file1);
        BufferedReader bf1 = new BufferedReader(f1);
        //System.out.println(bf1.readLine());
        String S;
        while ((S = bf1.readLine()) != null && S.length() != 0) {
            System.out.println(S);
            listFiles(S);
        }
        System.out.println("Number of directory = " + Four.num_directory);
        System.out.println("Number of files = " + Four.num_files);
        //System.out.println(map);


    }
}
