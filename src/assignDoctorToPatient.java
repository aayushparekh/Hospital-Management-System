//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270

public class assignDoctorToPatient implements Command
{
    public void execute()
    {
        String doctor_name = IOAccess.getInstance().readString("Enter name of Doctor to assign : ");
        Doctor d = DoctorMapAccess.getInstance().get(doctor_name);
        String health_num = IOAccess.getInstance().readString("Enter health card number of patient to whom " +
                "doctor should be assigned :");
        Patient p = PatientMapAccess.getInstance().get(health_num);
        if (d != null) {
            d.addPatient(p);
            p.addDoctor(d);
        }
        IOAccess.getInstance().outputString("\nThe patient assigned is : " + d);
        IOAccess.getInstance().outputString("\nThe doctor assigned is : " + p);
    }
}
