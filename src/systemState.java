//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270

public class systemState implements Command
{
    public void execute()
    {
        IOAccess.getInstance().outputString("\nSystem state :" + WardAccess.getInstance() + "\n" +
                PatientMapAccess.getInstance().values() +
                "\n" + DoctorMapAccess.getInstance().values() + "\n");
    }
}
