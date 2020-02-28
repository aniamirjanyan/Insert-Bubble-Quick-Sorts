package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertSort {
    public static List<String[]> list = new ArrayList<>();
    public static List<String> strList = new ArrayList<>();
    public static List<Integer> intList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        list = getData();
        String[] line = list.get(0); // string array
        strList.addAll(Arrays.asList(line)); // adding array elements to list
        for(String s : strList) {
            intList.add(Integer.valueOf(s)); // String to integer
        }
        System.out.println(intList);
        sortInsert(intList);
    }

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

    public static void sortInsert(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int temp = i - 1;
            while ((temp >= 0) && ((list.get(temp).compareTo(current)) > 0)) {
                list.set(temp + 1, list.get(temp));
                temp = temp - 1;
            }
            list.set(temp + 1, current);
            System.out.println(list);
        }
    }
}
