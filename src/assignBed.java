//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270

public class assignBed implements Command
{
    public void execute()
    {
        String health_num = IOAccess.getInstance().readString("Enter health number of patient to whom " +
                "bed should be assigned :");
        if (health_num == null || health_num.equals(""))
            throw new IllegalArgumentException("The name of a ward cannot be null or empty.  "
                    + "It is " + health_num);
        Patient p = PatientMapAccess.getInstance().get(health_num);
        int bedLabel = IOAccess.getInstance().readInt("Enter bed label to be assigned for patient : ");
        p.setBedlabel(bedLabel);
        if (WardAccess.getInstance() != null) //checks whether ward is null or not
            WardAccess.getInstance().assignPatientToBed(p, bedLabel);
        IOAccess.getInstance().outputString("The bed assigned is : ");
    }
}
