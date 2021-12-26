//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270


import javax.swing.*;

public class DialogIO extends AbstractDialogIO{
    @Override
    public String readString(String prompt)
    {
        prompt = JOptionPane.showInputDialog(null,prompt);
        return prompt;
    }

    @Override
    public int readInt(String prompt)
    {
        String number;
        number = JOptionPane.showInputDialog(null,prompt);
        int num = Integer.parseInt(number);
        while(num<0)//checks whether the number is valid integer or not
        {
            num = readInt(prompt);
        }
        return num;
    }

    @Override
    public void outputString(String outString)
    {
        JOptionPane.showMessageDialog(null,outString);
    }

    public  static void main(String args[])
    {
        String options[] = {"0","1","2","3","4","5","6","7","8","9"};
        AbstractDialogIO io = new DialogIO();
        io.outputString("It will display complete scenario");
        //int number = io.readInt("\nEnter an integer value : ");
        //io.outputString("The integer value is : " + number);
        String statement = io.readString("\nEnter a string : ");
        io.outputString("The string value is : " + statement);
        int opt = io.readChoice(options);
        io.outputString("The selected option is : " + options[opt]);
    }
}
