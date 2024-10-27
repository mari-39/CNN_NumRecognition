import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class InputLayer {
    static int TEST_IMG = 10000;
    static int TRAINING_IMG = 60000;

    static double[][] testInput = new double[TEST_IMG][];
    static int[] testLabels = new int[TEST_IMG];
    static double[][] trainingInput = new double[TRAINING_IMG][];
    static int[] trainingLabels = new int[TRAINING_IMG];



    public static void readCSV(String path, double[][] input, int numOfImages, int[] labels) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader bfr = new BufferedReader(fr);
         String[] beforeParsing = new String[numOfImages];
        String line;
        int index = 0;

        while ((line = bfr.readLine()) != null) {
            beforeParsing[index] = line;
            index++;
        }
        bfr.close();

        for (int i = 0; i < beforeParsing.length; i++) {
            String[] temp = beforeParsing[i].split(",");
            labels[i] = Integer.parseInt(temp[0]);
            int k = 0;
            for (int j = 1; j < temp.length; j++) {
                input[i][k++] = Double.parseDouble(temp[j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        readCSV("mnist_train.csv", trainingInput, TRAINING_IMG, trainingLabels);
        readCSV("mnist_test.csv", testInput, TEST_IMG, testLabels);
        for(int i = 0; i < 10; i++) {
            System.out.println(trainingLabels[i]);
        }
    }
}
