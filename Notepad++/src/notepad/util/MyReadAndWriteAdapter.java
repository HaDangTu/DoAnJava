package notepad.util;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

import org.fife.ui.rsyntaxtextarea.*;

public class MyReadAndWriteAdapter {
    private RSyntaxTextArea textArea;

    public MyReadAndWriteAdapter(RSyntaxTextArea textArea){
        this.textArea = textArea;
    }

    public MyReadAndWriteAdapter(){
        this.textArea = null;
    }

    /**
     * Read file
     * @param filePath directory of file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void read(String filePath) throws FileNotFoundException, IOException {
        File file = new File(filePath);
        if (!file.isDirectory() && file.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            textArea.read(bufferedReader, null);
            bufferedReader.close();
        }
    }

    /**
     * Write file
     * @param filePath directory of file
     * @throws IOException
     */
    public void write(String filePath) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        textArea.write(bufferedWriter);
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    public String[] readToStringArray(String filePath) throws FileNotFoundException, IOException{
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String currentLine;
        while((currentLine = reader.readLine()) != null)
            list.add(currentLine);

        String []result = new String[list.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = list.get(i);

        return result;
    }
}
