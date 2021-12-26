//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270

public class dropAssociation implements Command
{
    public void execute()
    {
        String health_num = IOAccess.getInstance().readString("Enter health card number of patient :");
        String name = IOAccess.getInstance().readString("Enter name of doctor :");
        Patient p = PatientMapAccess.getInstance().get(health_num);
        Doctor d = DoctorMapAccess.getInstance().get(name);
        if (p.hasDoctor(d.getName())) {
            p.removeDoctor(name);
        }
        if (d.hasPatient(p.getHealthNumber())) {
            d.removePatient(health_num);
        }
        IOAccess.getInstance().outputString("*******************");
        IOAccess.getInstance().outputString("The new list is : " + p);
    }
}
