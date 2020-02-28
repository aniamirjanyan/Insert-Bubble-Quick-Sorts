package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSortRecursive {
    public static List<String[]> list = new ArrayList<>();
    public static List<String> strList = new ArrayList<>();
    public static List<Integer> intList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        list = getData();
        String[] line = list.get(0); // string array
        strList.addAll(Arrays.asList(line)); // adding array elements to list
        for(String s : strList) {
            intList.add(Integer.valueOf(s));
        }
        System.out.println(insertSort(intList));

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

    public static List<Integer> insertSort(List<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            while (list.get(i+1) < list.get(i)) {
                int temp = list.get(i);
                list.set(i, list.get(i+1));
                list.set(i+1, temp);
                System.out.println(list);
                insertSort(list);
            }
        }
        return list;
    }
}
