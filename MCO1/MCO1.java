package MCO1;

import java.util.Scanner;
import java.util.Random;

/**
 CCDSALG MAJOR COURSE OUTPUT 1:
 SORTING SUFFIX ARRAYS

 @author ATUTUBO, Regner
 @author GUERRA, Jose Maria Angelo
 @author INOCENCIO, Rey Vincent
 @author LABABIDI, Mezen
 */
public class MCO1
{
    /**
     * Generates a random string of size n (requested from user input)
     * Program generates n suffixes and placed in an array
     * Program sorts the suffixarrays lexicographically in either Selection or Merge Sort
     */
    public static void main(String[] args)
    {
        String InputString = "";
        int nSortingAlg = 0;

        // Request User Input for String Length
        Scanner Scan = new Scanner(System.in);
        System.out.print("Input Length: ");
        int InputLength = Scan.nextInt();
        InputString = createRandomInput(InputLength);
        System.out.println("Input: " + InputString);

        String [] SuffixArr = createSuffixArray(InputString);

        // Request User Input for choice of Sorting Algorithm
        System.out.println("Select your sorting Algorithm: 1 = Selection Sort, 2 = Merge Sort");
        while (nSortingAlg == 0)
        {
            nSortingAlg = Scan.nextInt();
            if (nSortingAlg != 1 && nSortingAlg != 2)
            {
                System.out.println("input out of range. Try Again.");
                nSortingAlg = 0;
            }
        }

        // Selects Sorting Algorithm based on User Input
        switch (nSortingAlg)
        {
            case 1:
                SelectionSort(SuffixArr);
                break;
            case 2:
                SuffixArr = mergeSort(SuffixArr, 0, InputString.length() - 1);
                break;
        }

        // Displays the Sorted Array
        for (int nCount = 0; nCount < SuffixArr.length; nCount++)
        {
            System.out.println(SuffixArr[nCount]);
        }

        Scan.close();
    }

    /**
     * Creates an array of suffixes from an input string
     * @param sInput - The String value to create a suffix array for
     * @return the suffix array of the input string
     */
    public static String[] createSuffixArray(String sInput)
    {
        int nCount;
        String[] suffixes = new String[sInput.length()];
        for (nCount = 0; nCount < sInput.length(); nCount++)
        {
            suffixes[nCount] = sInput.substring(nCount);
        }

        return suffixes;
    }

    /**
     * Standard Selection Sort algorithm modified to be used for strings
     * Sorts the given suffix array from the random input string
     * @param Strings - Array of String values to be sorted.
     */
    public static void SelectionSort(String[] SuffixArr)
    {
        for ( int j=0; j < SuffixArr.length-1; j++ )
        {
            int min = j;
            for ( int k=j+1; k < SuffixArr.length; k++ )
                if ( SuffixArr[k].compareTo( SuffixArr[min] ) < 0 )
                {
                    min = k;
                }

            String temp = SuffixArr[j];
            SuffixArr[j] = SuffixArr[min];
            SuffixArr[min] = temp;
        }
    }

    /**
     * Sub-Phase 2 of Merge Sort Algorithm
     * Combines and merges two sorted subarrays
     * @param Arr1 - subarray1 to be merged
     * @param Arr2 - subarray2 to be merged
     * @return the new sorted and merged array
     */
    public static String[] merge(String[] Arr1, String[] Arr2)
    {
        int m = Arr1.length;
        int n = Arr2.length;
        String[] Arr3 = new String[m + n];

        int idx = 0;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (Arr1[i].compareTo(Arr2[j]) < 0)
            {

                Arr3[idx] = Arr1[i];
                i++;
                idx++;
            }
            else {
                Arr3[idx] = Arr2[j];
                j++;
                idx++;
            }
        }
        while (i < m) {
            Arr3[idx] = Arr1[i];
            i++;
            idx++;
        }
        while (j < n) {
            Arr3[idx] = Arr2[j];
            j++;
            idx++;
        }

        return Arr3;
    }

    /**
     * Standard Merge Sort algorithm modified to be used for strings
     * Sorts the given suffix array from the random input string
     * @param Arr - suffix array of string values to be sorted
     * @param lo - value of the smallest array index
     * @param hi - value of the largest array index
     * @return the new sorted and merged array
     */
    public static String[] mergeSort(String[] Arr, int lo, int hi)
    {
        if (lo == hi)
        {
            String [] A = {Arr[lo]};
            return A;
        }

        int mid = lo + (hi - lo) / 2;
        String[] arr1 = mergeSort(Arr, lo, mid);
        String[] arr2 = mergeSort(Arr, mid + 1, hi);

        String[] arr3 = merge(arr1, arr2);
        return arr3;
    }

    /**
     * Generates a random string with only characters a,t,c,g
     * from a given input string size
     * @param inputSize - size of the random string
     * @return the random input string to be suffixed and sorted
     */
    public static String createRandomInput(int inputSize)
    {
        String charSet = "atcg";
        String randomInput = "";

        Random rand = new Random();
        char[] text = new char[inputSize];

        for(int i = 0; i < inputSize; i++)
            text[i] = charSet.charAt(rand.nextInt(charSet.length()));

        for(int i = 0; i < text.length; i++)
            randomInput += text[i];

        return randomInput;
    }
}