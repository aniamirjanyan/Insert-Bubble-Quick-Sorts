package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSortRecursive {
    public static List<String> strList = new ArrayList<>();
    public static List<String[]> list = new ArrayList<>();
    public static List<Integer> intList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        list = getData(); //array list
        String[] line = list.get(0); // string array
        strList.addAll(Arrays.asList(line)); // adding array elements to list
        for(String s : strList) {
            intList.add(Integer.valueOf(s));
        }
        checkPairs(intList);
    }

    // reading the numbers from csv file
    public static List<String[]> getData() throws IOException {
        String file = "C:\\Users\\aniam\\Documents\\JAVA\\numbers.csv";
        List<String[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] l = line.split(",");
            data.add(l);
        }
        return data;
    }

    public static List<Integer> checkPairs(List<Integer> newList) {
        for (int i = 0; i < newList.size() - 1; i++) {
            if (newList.get(i) > newList.get(i + 1)) {
                    int temp = newList.get(i);
                    newList.set(i, newList.get(i + 1));
                    newList.set(i + 1, temp);
                    System.out.println(newList);
                    checkPairs(newList);
                }
            }
        return newList;
    }


}
