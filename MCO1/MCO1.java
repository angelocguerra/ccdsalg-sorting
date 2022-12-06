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
}