//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270

public class releasePatient implements Command
{
    public void execute()
    {
        String health_num = IOAccess.getInstance().readString("Enter health card number of patient : ");
        Patient p = PatientMapAccess.getInstance().get(health_num);
        int bed_label = p.getBedLabel();
        if (bed_label == -1) {
            IOAccess.getInstance().outputString("Invalid");
        }
        if (WardAccess.getInstance().getPatient(bed_label).equals(p)) {
            WardAccess.getInstance().freeBed(bed_label);
        }
        IOAccess.getInstance().outputString("\nThe new list is : " + WardAccess.getInstance());
    }
}
