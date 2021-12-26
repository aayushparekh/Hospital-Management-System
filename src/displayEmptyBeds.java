//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270

public class displayEmptyBeds implements Command
{
    public void execute()
    {
        IOAccess.getInstance().outputString("The number of available beds are : "
                + WardAccess.getInstance().availableBeds());
    }
}
