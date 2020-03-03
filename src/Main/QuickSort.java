package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public static List<String> strList = new ArrayList<>();
    public static List<String[]> list = new ArrayList<>();
    public static List<Integer> intList = new ArrayList<>();
    public static List<Integer> sortedList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        list = getData(); //array list
        String[] line = list.get(0); // string array
        strList.addAll(Arrays.asList(line)); // adding array elements to list
        for(String s : strList) {
            intList.add(Integer.valueOf(s));
        }
        System.out.println("Here is the initial list: " + intList);

        sortedList = quickSort(intList);
        System.out.println("Here is the sorted list: " + sortedList);
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

    public static List<Integer> quickSort(List<Integer> newList) {
        // already sorted case
        if (newList.size() <= 1) {
            return newList;
        }

        // the last element is the pivot
        int pivot = newList.get(newList.size() - 1);
        System.out.println("The pivot is: " + pivot);

        // two lists for numbers smaller and greater than the pivot
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();

        for (int i = 0; i < newList.size()-1; i++) {
            if (pivot < newList.get(i)) {
                more.add(newList.get(i));
            } else {
                less.add(newList.get(i));
            }
        }
        // recurring over the lists again
        less = quickSort(less);
        more = quickSort(more);
        // combining all together
        less.add(pivot);
        less.addAll(more);

        return less;
    }
}
