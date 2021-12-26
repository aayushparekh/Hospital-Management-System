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
public class HospitalSystemA5Q4 {
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
    public HospitalSystemA5Q4() {
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

    /**
     * The below is the method which
     * adds a doctor to a doctor list
     * by asking for console input name.
     */
    public void addDoctor() {
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

        Doctor list_name = DoctorMapAccess.getInstance().put(doctor_name,d);
        if (list_name != null) {
            DoctorMapAccess.getInstance().put(doctor_name,d); // puts the doctor name in list
        }
        IOAccess.getInstance().outputString("The doctor list is : " + DoctorMapAccess.getInstance().values());
    }

    /**
     * The below is the method which
     * assigns a patient to a doctor
     * by asking for name of doctor to
     * assign and health card number
     * of patient.
     */
    public void assignDoctorToPatient() {
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

    /**
     * The below is the method which
     * assigns a bed to a patient
     * by asking for console input of
     * health card number and also input
     * bed label.
     */
    public void assignBed() {
        String health_num = IOAccess.getInstance().readString("Enter health number of patient to whom " +
                "bed should be assigned :");
        if (health_num == null || health_num.equals(""))
            throw new IllegalArgumentException("The name of a ward cannot be null or empty.  "
                    + "It is " + health_num);
        Patient p = PatientMapAccess.getInstance().get(health_num);
        int bedLabel = IOAccess.getInstance().readInt("Enter bed label to be assigned for patient : ");
        p.setBedlabel(bedLabel);
        if (ward != null) //checks whether ward is null or not
            WardAccess.getInstance().assignPatientToBed(p, bedLabel);
        IOAccess.getInstance().outputString("The bed assigned is : ");
    }


    /**
     * The below is the method which
     * drops association between patient
     * and the doctor by checking whether
     * they are connected or not.
     */
    public void dropAssociation() {
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

    /**
     * The below is the method
     * which displays the current
     * system state of the system.
     */
    public void systemState() {
        IOAccess.getInstance().outputString("\nSystem state :" + WardAccess.getInstance() + "\n" +
                PatientMapAccess.getInstance().values() +
                "\n" + DoctorMapAccess.getInstance().values() + "\n");
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
        IOAccess.getInstance().outputString("The number of available beds are : "
                + WardAccess.getInstance().availableBeds());
    }

    public void releasePatient() {
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

    /**
     * The below method is the main
     * method which is used to ask
     * user to select a method to
     * perform and display that method.
     */
    public static void main(String args[]) {
        HospitalSystemA5Q4 hs = new HospitalSystemA5Q4();

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
