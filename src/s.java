import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class s {
    private static Scanner inputOriginal, inputChanged, inputDeneme;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        try {
            inputOriginal = new Scanner(Paths.get("original_account_file.txt"));
            inputDeneme = new Scanner(Paths.get("original_account_file.txt"));
            inputChanged = new Scanner(Paths.get("changed_account_file.txt"));
        } catch (IOException ioEx) {
            System.err.println("Error Opening the file.");
            System.exit(1);
        }
        recordReader();
        fileCloser(inputOriginal);
        fileCloser(inputChanged);
        fileCloser(inputDeneme);

    }

    private static void fileCloser(Scanner input) {
        // TODO Auto-generated method stub
        if (input != null)
            input.close();

    }

    private static void recordReader() throws IOException {
        // TODO Auto-generated method stub
        System.out.printf("%-10s%-5s%-12s%-12s%-10s%-11s%-20s%n", "Changed?", "ID", "Name", "Surname", "Balance", "Tel", "E-mail");
        try {
            while (inputOriginal.hasNext() && inputChanged.hasNext()) {
                boolean changed = false;
                StringBuilder changedline= new StringBuilder();
                String line = inputDeneme.nextLine();
                for (int i = 0; i < 6; i++) {
                    String a = inputOriginal.next();
                    if (!a.equals(inputChanged.next())) {
                        changed = true;
                        changedline.append(" *").append(a).append("*");
                    }else
                        changedline.append(" ").append(a);
                }
                if (changed) {
                    System.out.printf("%-10s%s%n", "Yes", changedline);
                    writer("File_Changed_Records.txt", line);
                } else {
                    System.out.printf("%-11s%s%n", "No", line);
                    writer("File_Unchanged_Records.txt", line);
                }
            }

        } catch (NoSuchElementException elEx) {
            System.err.println("File is not well structred");
            System.exit(1);

        }
    }
    private static void writer(String filePath, String line) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(line);
        bw.newLine();
        bw.close();
    }

}