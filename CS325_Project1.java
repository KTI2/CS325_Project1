package cs325_project1;

/**
 * @author Kevin Stephenson CS 325 1/29/14
 */
public class CS325_Project1 {

    public static void main(String[] args) {
        int[] myArray = {4, 2, 5, 3, 1, 8};
        int inversionCount = 0;
        
        
        //inversionCount = bruteForce(myArray);
        inversionCount = divideNConquer(myArray, 0, myArray.length-1);
        System.out.println("Inversions = " + inversionCount);
    }

    public static int bruteForce(int[] myArray) {
        int k;
        int arrayLength = myArray.length;
        int counter = 0;

        for (int i = 0; i < arrayLength; i++) {
            for (k = i+1; k < arrayLength; k++) {
                if (myArray[i] > myArray[k])
                    counter++;
            }
        }

        return counter;
    }
    
    public static int divideNConquer(int[] myArray, int start, int end) {
        int counter = 0;
        int k;
        
        if(end-start <=0)
            return 0;
        
        counter+= divideNConquer(myArray, start, (start+end)/2);    //Al
        counter+= divideNConquer(myArray, (start+end)/2+1, end);     //Ar
         
        for(int i=start; i <= (start+end)/2; i++) { //Each element in Al
            for(k=(start+end)/2+1; k <= end; k++) {   //Each element in Ar
                if(myArray[i] > myArray[k])
                    counter++;
            }
        }
        
        return counter;
    }
}
