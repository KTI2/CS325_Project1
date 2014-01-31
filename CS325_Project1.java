package cs325_project1;

/**
 * @author Kevin Stephenson CS 325 1/29/14
 */
import java.util.List;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class CS325_Project1 {

    public static void main(String[] args) {
        List<int[]> myList = new ArrayList<>();
        String[] tmpStringArray;
        int[] tmpIntArray;
        String line;
        int i;

        try {
            System.out.println("Importing file.");
            BufferedReader reader = new BufferedReader(new FileReader("C:/test_in.txt"));
            
            while((line = reader.readLine()) != null) {
                tmpStringArray = line.split(",");
                tmpIntArray = new int[tmpStringArray.length];
                
                i=0;
                for(String item : tmpStringArray) {
                    tmpIntArray[i++] = Integer.parseInt(item);
                }
                myList.add(tmpIntArray);
            }
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return;
        } catch(java.io.IOException e) {
            e.printStackTrace();
            return;
        }

        int inversionCount;
        int listNum = 1;
        Counter counter;

        for (int[] item : myList) {
            System.out.println("List " + listNum);
            counter = new Counter(item);

            inversionCount = counter.bruteForce();
            System.out.println(
                    "Brute force inversions = " + inversionCount);

            inversionCount = counter.divideNConquer(0, counter.arrayLength - 1);
            System.out.println(
                    "Divide and conquer inversions = " + inversionCount);

            counter.counter = 0;
            inversionCount = counter.mergeNCount(0, counter.arrayLength - 1);
            System.out.printf(
                    "Merge and count = %d\n\n", inversionCount);
            listNum++;
        }
    }
}
