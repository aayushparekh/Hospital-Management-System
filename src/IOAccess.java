public class IOAccess
{

    private static InputOutputInterface io = null;
    IOAccess()
    {
        io = new DialogIO();
        String statement = io.readString("Do you want to continue by using DialogIO ?? Y or N or y or n");
        if(statement!=null && (statement.equals("Y") || statement.equals("y")))
        {
            io.outputString("You are good\n");
        }
        else if(statement!=null && (statement.equals("N") || statement.equals("n")))
        {
            io = new ConsoleIO();
        }
    };
    public static InputOutputInterface getInstance()
    {
        return io;
    }
}
