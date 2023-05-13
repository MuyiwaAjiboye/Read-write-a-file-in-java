import java.io.*;

import java.util.Scanner;

public class FileWriterMain {

    public static void main(String[] args) {
        FileWriterMain fileSystem = new FileWriterMain();
        FileWriterMain readSystem = new FileWriterMain();
        FileWriterMain appendSystem = new FileWriterMain();

        fileSystem.writeData("hello world");
        readSystem.readFromFile();
        appendSystem.appendData("Hey again");

    }

    public void writeData(String data) {

        try {
            File myFile = new File("test.txt");
            FileWriter writeToFile = new FileWriter(myFile);
            writeToFile.flush();
            writeToFile.write(data);
            writeToFile.close();
        } catch (IOException ioException) {
            return;
        }

    }

    public void appendData(String data) {

        try {
            File myFile = new File("test.txt");
            FileWriter fileWriter = new FileWriter(myFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.print(data);
            printWriter.println("More Money More problems");
            printWriter.println("No Money still Problems");

            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException ioException) {
            return;
        }
    }

    public void readFromFile() {

        try {
            File myFile = new File("test.txt");
            Scanner myReader = new Scanner(myFile);
            String dataInFile = myReader.nextLine();

            while (myReader.hasNext()) {
                System.out.println(dataInFile);

            }
            myReader.close();
        }

        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File does not exist");
        }

    }
}
