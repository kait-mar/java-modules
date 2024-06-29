package ex00;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileProcess {
    private Map<String, String>     FILE_SIGNATURES;
    // private File                    FILE_RESULTS;
    FileOutputStream fos;

    public FileProcess() throws Exception {
        FILE_SIGNATURES = new HashMap<String, String>();
        this.setSignatures("/home/kait/Desktop/java-modules/d02/ex00/signatures.txt");
        // this.createResultFile();
        new File("/home/kait/Desktop/java-modules/d02/ex00/results.txt");
        fos = new FileOutputStream("/home/kait/Desktop/java-modules/d02/ex00/results.txt");
        // fos = new FileOutputStream("./ex00/results.txt");

    }
    
    private void    setSignatures(String filePath) throws IOException{
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(isr);

        String line;
        while ((line = reader.readLine()) != null) {
            // Process each line here
            String[] arr = line.split(",");
            if (arr.length == 2) {
                FILE_SIGNATURES.put(arr[1], arr[0]);
            }
        }
        reader.close();
            // System.out.println(FILE_SIGNATURES);
    }

    private void    writeResults(String content, FileOutputStream fos) throws Exception {
        Writer writer = new OutputStreamWriter(fos, "UTF-8");
        writer.write(content);
        writer.flush();
    }

    public void lunch() throws Exception {
        Scanner scan = new Scanner(System.in);
        // FileOutputStream fos = new FileOutputStream("./ex00/results.txt");
        
        while (true) {
            try {
                System.out.print("-> ");
                String line = scan.nextLine();
                if (line.equals("42"))
                    break ;
                FileInputStream file = new FileInputStream(line);
                byte[] first = new byte[8];
                file.read(first);
                StringBuilder sb = new StringBuilder();
                for (byte b : first) {
                    sb.append(String.format("%02X ", b));
                }
                String sbs = sb.toString();
                sbs = sbs.trim();
                String res = FILE_SIGNATURES.get(sbs);
                int check = 0;
                for (Map.Entry<String, String> entry : FILE_SIGNATURES.entrySet()) {
                    String key = entry.getKey();
                    if (sbs.contains(key)) {
                        check = 1;
                        String value = entry.getValue();
                        this.writeResults(value + "\n", fos);
                        System.out.println("PROCESSED");
                        file.close();
                        break ;
                    }
                    // System.out.println("Key: " + key + ", Value: " + value);
                }
                if (check == 0) {
                // System.out.println("file signature: " + sbs);
                // if (res == null) {
                    file.close();
                    System.out.println("UNDEFINED");
                    continue;
                }
                // this.writeResults(res + "\n", fos);
                // System.out.println("PROCESSED");
                // file.close();
                // System.out.println(first);
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scan.close();
    } 
}
