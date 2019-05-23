package notepad.util;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import org.fife.ui.rsyntaxtextarea.*;

public class MyReadAndWriteAdapter {
    private RSyntaxTextArea textArea;

    public MyReadAndWriteAdapter(RSyntaxTextArea textArea){
        this.textArea = textArea;
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
}
