package ex01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Iterator;

public class Similarity {
    private BufferedReader              reader1;
    private BufferedReader              reader2;
    private Map<String, Integer>        wordsDictionary;
    private Vector<Integer>             vector1;
    private Vector<Integer>             vector2;

    public Similarity(String[] args) throws Exception {
        this.reader1 = new BufferedReader(new FileReader(args[0]), 16384);
        this.reader2 = new BufferedReader(new FileReader(args[1]), 16384);
        this.wordsDictionary = new TreeMap<>();
        this.vector1 = new Vector<>();
        this.vector2 = new Vector<>();
    }

    private String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;
        
        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(" ");
        }

        return content.toString();
    }

    private void    writeDictionary(String content) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("/home/kait/Desktop/java-modules/d02/ex01/Dictionary.txt"));
        Writer writer = new OutputStreamWriter(fos, "UTF-8");

        writer.write(content);
        writer.flush();
    }

    private void constructDict(String line1, String line2) throws Exception {
        String[]    arr1 = line1.split(" ");
        String[]    arr2 = line2.split(" ");
        int i = 0;
        for (String str: arr1) {
            wordsDictionary.put(str, i++);
        }
        for (String str: arr2) {
            wordsDictionary.put(str, i++);
        }
        for (Map.Entry<String, Integer> entry : wordsDictionary.entrySet()) {
            String key = entry.getKey();
            // String value = entry.getValue();
            int count = 0;
            for (String str: arr1) {
                if (key.equals(str))
                    count++;
            }
            vector1.add(count);
            count = 0;
            for (String str: arr2) {
                if (key.equals(str))
                    count++;
            }
            vector2.add(count);
            // System.out.println("Key: " + key + ", Value: " + value);
        }
        
        for (Map.Entry<String, Integer> entry : wordsDictionary.entrySet()) {
            writeDictionary(entry.getKey());
        }
        // System.out.println(wordsDictionary);
        // System.out.println(vector1);
        // System.out.println(vector2);
    }

    // private int factor1(Vector<Integer> vector1, Vector<Integer> vector2) {
    // }

    public  double calculateSimilarity() {
        int factor1 = 0;
        int factor2 = 0;
        int factor3 = 0;
    
        Iterator<Integer>   iter1 = vector1.iterator();
        Iterator<Integer>   iter2 = vector2.iterator();
    
        while (iter1.hasNext() && iter2.hasNext()) {
            factor1 += iter1.next() * iter2.next();
        }

        iter1 = vector1.iterator();
        iter2 = vector2.iterator();

        while(iter1.hasNext()) {
            factor2 += Math.pow(iter1.next(), 2);
        }
        while(iter2.hasNext()) {
            factor3 += Math.pow(iter2.next(), 2);
        }

        double similarity = factor1 / (Math.sqrt(factor2) * Math.sqrt(factor3));
        return similarity;
    }

    public void lunch() throws Exception {
        String line1 = readAllLines(reader1);
        String line2 = readAllLines(reader2);

        constructDict(line1, line2);

        // System.out.println(line1);
        // System.out.println(line2);
    }
}
