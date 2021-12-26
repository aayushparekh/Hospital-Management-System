//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270

public class AddPatient implements Command
{
    public void execute()
    {
        String name = IOAccess.getInstance().readString("Enter name of patient : ");
        String health_num = IOAccess.getInstance().readString("Enter health card number of patient : ");
        if (health_num == null || health_num.equals(name))
            throw new IllegalArgumentException("The health card number of a patient cannot be null or equal" +
                    "to name.  " + "It is " + health_num);
        Patient p = new Patient(name, health_num);
        Patient list = PatientMapAccess.getInstance().put(health_num,p);
        if (list != null) //checks whether list is null or not
        {
            PatientMapAccess.getInstance().put(health_num,list);
        }
        IOAccess.getInstance().outputString("The patient list is : " + PatientMapAccess.getInstance().values());
    }
}
