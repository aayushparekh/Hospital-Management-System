//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270

public class AddDoctor implements Command {

    public void execute() {
            String doctor_name = IOAccess.getInstance().readString("Enter name of Doctor : ");
            if (doctor_name == null || doctor_name.equals(""))
                throw new IllegalArgumentException("The name of a ward cannot be null or empty.  "
                        + "It is " + doctor_name);
            String answer = IOAccess.getInstance().readString("Is this doctor a surgeon ?");
            Doctor d;
            if (answer.equals("yes") || answer.equals("Yes") || answer.equals("YES"))
                d = new Surgeon(doctor_name);
            else
                d = new Doctor(doctor_name);

            Doctor list_name = DoctorMapAccess.getInstance().put(doctor_name, d);
            if (list_name != null) {
                DoctorMapAccess.getInstance().put(doctor_name, d); // puts the doctor name in list
            }
            IOAccess.getInstance().outputString("The doctor list is : " + DoctorMapAccess.getInstance().values());
    }

}
