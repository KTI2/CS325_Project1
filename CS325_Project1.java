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
        //List<int[]> myList = readInput("C:/test_in.txt");
        System.out.println("Size 1k");
        List<int[]> myList = generateRandomInts(1000);
        testAlgorithms(myList);

        System.out.println("Size 2k");
        myList = generateRandomInts(2000);
        testAlgorithms(myList);

        System.out.println("Size 3k");
        myList = generateRandomInts(3000);
        testAlgorithms(myList);

        System.out.println("Size 5k");
        myList = generateRandomInts(5000);
        testAlgorithms(myList);

        System.out.println("Size 10k");
        myList = generateRandomInts(10000);
        testAlgorithms(myList);

        System.out.println("Size 20k");
        myList = generateRandomInts(20000);
        testAlgorithms(myList);

        System.out.println("Size 30k");
        myList = generateRandomInts(30000);
        testAlgorithms(myList);

        System.out.println("Size 40k");
        myList = generateRandomInts(40000);
        testAlgorithms(myList);

        System.out.println("Size 50k");
        myList = generateRandomInts(50000);
        testAlgorithms(myList);
    }

    public static List<int[]> generateRandomInts(int total) {
        List<int[]> myList = new ArrayList<>();
        int[] tmpIntArray = new int[total];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < total; k++) {
                tmpIntArray[k] = rand.nextInt();
            }
            myList.add(tmpIntArray);
        }
        return myList;
    }

    public static void testAlgorithms(List<int[]> myList) {
        int inversionCount;
        int listNum = 1;
        Counter counter;

        double bruteForceTime = 0;
        double divideNConquerTime = 0;
        double mergeNCountTime = 0;

        double tmpTime;

        for (int i = 0; i < 10; i++) {
            for (int[] item : myList) {
                System.out.print(".");
                //System.out.println("List " + listNum++);
                counter = new Counter(item);

                //Brute Force
                tmpTime = System.currentTimeMillis();
                inversionCount = counter.bruteForce();
                bruteForceTime += System.currentTimeMillis() - tmpTime;
            //System.out.println("Brute force inversions = " + inversionCount);

                //Divide and Conquer
                tmpTime = System.currentTimeMillis();
                inversionCount = counter.divideNConquer(0, counter.arrayLength - 1);
                divideNConquerTime += System.currentTimeMillis() - tmpTime;
            //System.out.println("Divide and conquer inversions = " + inversionCount);

                //Merge and Count
                tmpTime = System.currentTimeMillis();
                counter.counter = 0;
                inversionCount = counter.mergeNCount(0, counter.arrayLength - 1);
                mergeNCountTime += System.currentTimeMillis() - tmpTime;
                //System.out.printf("Merge and count = %d\n\n", inversionCount);
            }
            System.out.println();
        }
        //Calculate average runtime
        bruteForceTime /= 100.;
        divideNConquerTime /= 100.;
        mergeNCountTime /= 100.;

        System.out.printf("Brute force runtime: %f milliseconds.\n", bruteForceTime);
        System.out.printf("Divide and conquer runtime: %f milliseconds.\n", divideNConquerTime);
        System.out.printf("Merge and count runtime: %f milliseconds.\n", mergeNCountTime);
    }

    public static List<int[]> readInput(String fileLoc) {
        List<int[]> myList = new ArrayList<>();

        String[] tmpStringArray;
        int[] tmpIntArray;
        String line;
        int i;

        try {
            System.out.println("Importing file.");
            BufferedReader reader = new BufferedReader(new FileReader(fileLoc));

            while ((line = reader.readLine()) != null) {
                tmpStringArray = line.split(",");
                tmpIntArray = new int[tmpStringArray.length];

                i = 0;
                for (String item : tmpStringArray) {
                    tmpIntArray[i++] = Integer.parseInt(item);
                }
                myList.add(tmpIntArray);
            }
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
        return myList;
    }
}
