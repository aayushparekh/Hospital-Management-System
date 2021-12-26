//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270


import java.util.Scanner;

public class ConsoleIO implements InputOutputInterface {


    private final Scanner in = new Scanner(System.in);
    @Override
    public String readString(String prompt)
    {
        System.out.print(prompt);
        prompt = in.next();
        return prompt;
    }

    @Override
    public int readInt(String prompt)
    {
         int number;
         System.out.print(prompt);
         number = in.nextInt();
         while(number<0)//checks whether the number is valid integer or not
         {
             System.out.print("\nEnter the number again : ");
             number = in.nextInt();
         }
         return number;
    }

    @Override
    public int readChoice(String[] options)
    {
        String display = "\nPlease select a number";
        for(int i=0;i<options.length;i++)
        {
           display = display + "\n" + i + "=" + options[i];
        }
        display = display + "\nSelect a number from above : ";
        int number = readInt(display);
        if(number<0 || number>=options.length)
        {
            System.out.print("Number is invalid.");
            System.out.print("\nPlease try again");
            return readChoice(options);
        }
        else
        {
            return number;
        }
    }

    @Override
    public void outputString(String outString)
    {
        System.out.print(outString);
    }

    public static void main(String args[])
    {
        String options[] = {"0","1","2","3","4","5","6","7","8","9"};
        InputOutputInterface io = new ConsoleIO();
        io.outputString("\nThis will show given string to user");
        int number = io.readInt("\nEnter an integer value : ");
        io.outputString("The integer value is : " + number);
        String statement = io.readString("\nEnter a string : ");
        io.outputString("The string value is : " + statement);
        int opt = io.readChoice(options);
        io.outputString("The selected option is : " + options[opt]);
    }
}
