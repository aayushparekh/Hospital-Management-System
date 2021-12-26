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
public class HospitalSystemA5Q5 {
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
    public HospitalSystemA5Q5() {
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

    /**
     * The below is the method which
     * adds a patient to a patient list
     * by asking for console input name and
     * health card number.
     */
    public void addPatient() {
            Command cmd = new AddPatient();
            cmd.execute();
    }

    /**
     * The below is the method which
     * adds a doctor to a doctor list
     * by asking for console input name.
     */
    public void addDoctor() {
            Command cmd = new AddDoctor();
            cmd.execute();
    }

    /**
     * The below is the method which
     * assigns a patient to a doctor
     * by asking for name of doctor to
     * assign and health card number
     * of patient.
     */
    public void assignDoctorToPatient() {
        Command cmd = new assignDoctorToPatient();
        cmd.execute();
    }

    /**
     * The below is the method which
     * assigns a bed to a patient
     * by asking for console input of
     * health card number and also input
     * bed label.
     */
    public void assignBed() {
        Command cmd = new assignBed();
        cmd.execute();
    }


    /**
     * The below is the method which
     * drops association between patient
     * and the doctor by checking whether
     * they are connected or not.
     */
    public void dropAssociation() {
        Command cmd = new dropAssociation();
        cmd.execute();
    }

    /**
     * The below is the method
     * which displays the current
     * system state of the system.
     */
    public void systemState() {
        Command cmd = new systemState();
        cmd.execute();
    }

    /**
     * The below is the method
     * which represents proper
     * string representation of
     * whole system.
     *
     * @return : returns string representation
     * of the system.
     */
    @Override
    public String toString() {
        return "HospitalSystem{" +
                "w=" + WardAccess.getInstance() +
                ", patient_list=" + PatientMapAccess.getInstance().values() +
                ", doctor_list=" + DoctorMapAccess.getInstance().values() +
                '}';
    }

    /**
     * The below two methods are the stub method.
     */
    public void displayEmptyBeds() {
        Command cmd = new displayEmptyBeds();
        cmd.execute();
    }

    public void releasePatient() {
        Command cmd = new releasePatient();
        cmd.execute();
    }

    /**
     * The below method is the main
     * method which is used to ask
     * user to select a method to
     * perform and display that method.
     */
    public static void main(String args[]) {
        HospitalSystemA5Q5 hs = new HospitalSystemA5Q5();

        String[] options = {"","quit", "add a new patient to system", "add a new doctor to system",
                "assign a doctor to a patient", "display the empty beds of the ward", "assign a patient a bed",
                "release a patient", "drop doctor patient association", "display current system state"};
        int select_number = 0;

        while (select_number >= 0) {
            if (select_number == 1) {
                hs.systemState();
                break;
            }
            select_number = IOAccess.getInstance().readChoice(options);
            switch (select_number) {
                case 1:
                    IOAccess.getInstance().outputString("quit");
                    break;
                case 2:
                    hs.addPatient();
                    break;
                case 3:
                    hs.addDoctor();
                    break;
                case 4:
                    hs.assignDoctorToPatient();
                    break;
                case 5:
                    hs.displayEmptyBeds();
                    break;
                case 6:
                    hs.assignBed();
                    break;
                case 7:
                    hs.releasePatient();
                    break;
                case 8:
                    hs.dropAssociation();
                    break;
                case 9:
                    hs.systemState();
                    break;
                default:
                    IOAccess.getInstance().outputString("Invalid");
            }
        }
    }
}
