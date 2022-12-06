package MCO1;

import java.util.Scanner;

public class MCO1
{
    public static void main(String[] args)
    {
        int counter = 0;

        Scanner Scan = new Scanner(System.in);
        do {
            System.out.print("Input String: ");
            String InputString = Scan.nextLine();

            char[] InputArr = InputString.toCharArray();
            for (int i = 0; i < InputArr.length; i++)
            {
                System.out.println(InputArr[i]);
            }

        } while (counter > 1); // input validation pero di ko pa ginagawa

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

    public static int[] sortSuffixArrays(String[] suffixes) //to be modified for Strings; selection sort
    {
        for ( int j=0; j < array.length-1; j++ )
        {
            int min = j;
            for ( int k=j+1; k < array.length; k++ )
                if ( array[k].compareTo( array[min] ) < 0 )
                {
                    min = k;
                }

            String temp = array[j];
            array[j] = array[min];
            array[min] = temp;
        }
    }

    /* idk if dalawa gagawin based on the specs*/
    public static String[] sortSuffixArrays2(String[] suffixes)
    {
        //merge sort
    }
}