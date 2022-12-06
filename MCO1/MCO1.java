package MCO1;

import java.util.Scanner;
import java.util.Random;

public class MCO1
{
    public static void main(String[] args)
    {
        String InputString = "";
        int nSortingAlg = 0;


        Scanner Scan = new Scanner(System.in);
        System.out.print("Input Length: ");
        int InputLength = Scan.nextInt();
        InputString = createRandomInput(InputLength);

        String [] SuffixArr = createSuffixArray(InputString);

        //User Input for choice of Sorting Algorithm
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

        //selects sorting algorithm based on user input
        switch (nSortingAlg){
            case 1:
                SelectionSort(SuffixArr);
                break;
            case 2:
                SuffixArr = mergeSort(SuffixArr, 0, InputString.length() - 1);
                break;
        }

        //displays the sorted array
        for (int nCount = 0; nCount < SuffixArr.length; nCount++)
        {
            System.out.println(SuffixArr[nCount]);
        }



        Scan.close();
    }

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