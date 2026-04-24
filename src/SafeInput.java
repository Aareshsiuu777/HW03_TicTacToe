import java.util.Scanner;

public class SafeInput
{
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                valid = true;
            }
            else
            {
                System.out.println("Invalid input! Please enter an integer.");
                pipe.next();
            }
            pipe.nextLine();
        } while (!valid);

        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0.0;
        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                valid = true;
            }
            else
            {
                System.out.println("Invalid input! Please enter a numeric value.");
                pipe.next();
            }
            pipe.nextLine();
        } while (!valid);

        return retVal;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " -- " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                if (retVal >= low && retVal <= high)
                {
                    valid = true;
                }
                else
                {
                    System.out.println("Out of range! Enter a value between " + low + " and " + high + ".");
                }
            }
            else
            {
                System.out.println("Invalid input! Please enter an integer.");
                pipe.next();
            }
            pipe.nextLine();
        } while (!valid);

        return retVal;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0.0;
        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " -- " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                if (retVal >= low && retVal <= high)
                {
                    valid = true;
                }
                else
                {
                    System.out.println("Out of range! Enter a value between " + low + " and " + high + ".");
                }
            }
            else
            {
                System.out.println("Invalid input! Please enter a numeric value.");
                pipe.next();
            }
            pipe.nextLine();
        } while (!valid);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = false;
        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            String response = pipe.nextLine().trim();

            if (response.equals("y") || response.equals("Y") ||
                    response.equals("yes") || response.equals("Yes") || response.equals("YES"))
            {
                retVal = true;
                valid = true;
            }
            else if (response.equals("n") || response.equals("N") ||
                    response.equals("no") || response.equals("No") || response.equals("NO"))
            {
                retVal = false;
                valid = true;
            }
            else
            {
                System.out.println("Invalid input! Please enter Y or N.");
            }
        } while (!valid);

        return retVal;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retString = "";
        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine().trim();

            if (retString.matches(regEx))
            {
                valid = true;
            }
            else
            {
                System.out.println("Invalid format! Please try again.");
            }
        } while (!valid);

        return retString;
    }
}