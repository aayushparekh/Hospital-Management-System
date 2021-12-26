//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270

/**
 * The below class defines a
 * hospital system class
 * which represents information
 * about patient,doctor and beds.
 */
public class HospitalSystemA5Q6 {
    /**
     * The below variable is a
     * variable of type Ward
     * which stores information of
     * ward.
     */

    private static WardAccess ward;
    /**
     * Below is the list of patient
     * which is stored as a TreeMap.
     */
    private static PatientMapAccess patient_list;
    /**
     * Below is the list of doctor
     * which is also stored as a TreeMap.
     */
    private static DoctorMapAccess doctor_list;
    private static IOAccess io = new IOAccess();


    /**
     * The below method is the constructor
     * method which takes input of ward
     * name,first bed label and last bed
     * label.
     */
    public HospitalSystemA5Q6() {
        patient_list = new PatientMapAccess();
        doctor_list = new DoctorMapAccess();
        String ward_name = IOAccess.getInstance().readString("Enter name of ward : ");
        int min_label = IOAccess.getInstance().readInt("Enter a minimum bed label : ");
        int max_label = IOAccess.getInstance().readInt("Enter a maximum bed label : ");
        WardAccess.initialize(ward_name,min_label,max_label);
        ward = new WardAccess();
        if (ward_name == null || ward_name.equals(""))
            throw new IllegalArgumentException("The name of a ward cannot be null or empty.  "
                    + "It is " + ward_name);

    }


    public static void main(String args[]) {
        HospitalSystemA5Q6 hs = new HospitalSystemA5Q6();
        Command[] commands = new Command[10];
        AddPatient ad = new AddPatient();
        commands[2] = ad;
        AddDoctor ad1 = new AddDoctor();
        commands[3] = ad1;
        assignDoctorToPatient ad2 = new assignDoctorToPatient();
        commands[4] = ad2;
        displayEmptyBeds ad3 = new displayEmptyBeds();
        commands[5] = ad3;
        assignBed ad4 = new assignBed();
        commands[6] = ad4;
        releasePatient ad5 = new releasePatient();
        commands[7] = ad5;
        dropAssociation ad6 = new dropAssociation();
        commands[8] = ad6;
        systemState ad7 = new systemState();
        commands[9] = ad7;
        String[] options = {"","1:quit", "2:add a new patient to system", "3:add a new doctor to system",
                "4:assign a doctor to a patient", "5:display the empty beds of the ward", "6:assign a patient a bed",
                "7:release a patient", "8:drop doctor patient association", "9:display current system state"};


        int select_number = 0;


        while (select_number >= 0) {
            if (select_number == 1) {
                commands[9].execute();
                break;
            }
            select_number = IOAccess.getInstance().readChoice(options);
            switch (select_number) {
                case 1:
                    IOAccess.getInstance().outputString("quit");
                    break;
                case 2:
                    commands[2].execute();
                    break;
                case 3:
                    commands[3].execute();
                    break;
                case 4:
                    commands[4].execute();
                    break;
                case 5:
                    commands[5].execute();
                    break;
                case 6:
                    commands[6].execute();
                    break;
                case 7:
                    commands[7].execute();
                    break;
                case 8:
                    commands[8].execute();
                    break;
                case 9:
                    commands[9].execute();
                    break;
                default:
                    IOAccess.getInstance().outputString("Invalid");
            }
        }
    }
}

