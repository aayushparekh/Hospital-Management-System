//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270


import java.util.Scanner;
import java.util.TreeMap;

/**
 * The below class defines a
 * hospital system class
 * which represents information
 * about patient,doctor and beds.
 */
public class HospitalSystemA5Q1 {
    /**
     * The below variable is a
     * variable of type Ward
     * which stores information of
     * ward.
     */
    private Ward w;
    /**
     * Below is the list of patient
     * which is stored as a TreeMap.
     */
    private TreeMap<String, Patient> patient_list;
    /**
     * Below is the list of doctor
     * which is also stored as a TreeMap.
     */
    private TreeMap<String, Doctor> doctor_list;
    Scanner in = new Scanner(System.in); // creates a Scanner object

    /**
     * The below method is the constructor
     * method which takes input of ward
     * name,first bed label and last bed
     * label.
     */
    public HospitalSystemA5Q1() {
        patient_list = new TreeMap<String, Patient>();
        doctor_list = new TreeMap<String, Doctor>();
        System.out.print("Enter name of Ward :"); //Ask user to input for ward name
        String ward_name = in.next();
        System.out.print("Enter label for first bed :");
        int min_label = in.nextInt();
        System.out.print("Enter label for last bed :");
        int max_label = in.nextInt();
        w = new Ward(ward_name, min_label, max_label);
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
        System.out.print("Enter name of patient :");
        String name = in.next();
        System.out.print("Enter health card number for patient :");
        String health_num = in.next();
        if (health_num == null || health_num.equals(name))
            throw new IllegalArgumentException("The health card number of a patient cannot be null or equal" +
                    "to name.  " + "It is " + health_num);
        Patient p = new Patient(name, health_num);
        Patient list = patient_list.put(health_num, p);
        if (list != null) //checks whether list is null or not
        {
            patient_list.put(health_num, list);
        }
        System.out.println(patient_list.values());
    }

    /**
     * The below is the method which
     * adds a doctor to a doctor list
     * by asking for console input name.
     */
    public void addDoctor() {
        System.out.print("Enter name of Doctor :");
        String doctor_name = in.next();
        if (doctor_name == null || doctor_name.equals(""))
            throw new IllegalArgumentException("The name of a ward cannot be null or empty.  "
                    + "It is " + doctor_name);
        System.out.print("Is this doctor a surgeon ?");
        String answer = in.next();
        Doctor d;
        if (answer.equals("yes") || answer.equals("Yes") || answer.equals("YES"))
            d = new Surgeon(doctor_name);
        else
            d = new Doctor(doctor_name);

        Doctor list_name = doctor_list.put(doctor_name, d);
        if (list_name != null) {
            doctor_list.put(doctor_name, list_name); // puts the doctor name in list
        }
        System.out.println(doctor_list);
    }

    /**
     * The below is the method which
     * assigns a patient to a doctor
     * by asking for name of doctor to
     * assign and health card number
     * of patient.
     */
    public void assignDoctorToPatient() {
        System.out.print("Enter name of Doctor to assign:");
        String doctor_name = in.next();
        Doctor d = doctor_list.get(doctor_name);
        System.out.print("Enter health card number of patient to whom doctor should be assigned :");
        String health_num = in.next();
        Patient p = patient_list.get(health_num);
        if (d != null) {
            d.addPatient(p);
            p.addDoctor(d);
        }
        System.out.println(d);
        System.out.println(p);
    }

    /**
     * The below is the method which
     * assigns a bed to a patient
     * by asking for console input of
     * health card number and also input
     * bed label.
     */
    public void assignBed() {
        System.out.print("Enter health number of patient to whom bed should be assigned :");
        String health_num = in.next();
        if (health_num == null || health_num.equals(""))
            throw new IllegalArgumentException("The name of a ward cannot be null or empty.  "
                    + "It is " + health_num);
        Patient p = patient_list.get(health_num);
        System.out.print("Enter bed label to be assigned for patient :");
        int bedLabel = in.nextInt();
        p.setBedlabel(bedLabel);
        if (w != null) //checks whether ward is null or not
            w.assignPatientToBed(p, bedLabel);
        System.out.println(w);
    }


    /**
     * The below is the method which
     * drops association between patient
     * and the doctor by checking whether
     * they are connected or not.
     */
    public void dropAssociation() {
        System.out.println("Enter health card number of patient :");
        String health_num = in.next();
        System.out.println("Enter name of doctor :");
        String name = in.next();
        Patient p = patient_list.get(health_num);
        Doctor d = doctor_list.get(name);
        if (p.hasDoctor(d.getName())) {
            p.removeDoctor(name);
        }
        if (d.hasPatient(p.getHealthNumber())) {
            d.removePatient(health_num);
        }
        System.out.println("*******************");
        System.out.println(d);
    }

    /**
     * The below is the method
     * which displays the current
     * system state of the system.
     */
    public void systemState() {
        System.out.println("System state :" + "\n" + w + patient_list +
                "\n" + doctor_list + "\n");
    }

    /**
     * The below is the method
     * which represents proper
     * string representation of
     * whole system.
     * @return : returns string representation
     * of the system.
     */
    @Override
    public String toString() {
        return "HospitalSystem{" +
                "w=" + w +
                ", patient_list=" + patient_list +
                ", doctor_list=" + doctor_list +
                '}';
    }

    /**
     * The below two methods are the stub method.
     */
    public void displayEmptyBeds()
    {
        System.out.println(w.availableBeds());
    }

    public void releasePatient()
    {
        System.out.println("Enter health card number of patient : ");
        String health_num = in.next();
        Patient p = patient_list.get(health_num);
        int bed_label = p.getBedLabel();
        if(bed_label == -1)
        {
            System.out.println("Invalid");
        }
        if(w.getPatient(bed_label).equals(p))
        {
            w.freeBed(bed_label);
        }
        System.out.println(w);
    }

    /**
     * The below method is the main
     * method which is used to ask
     * user to select a method to
     * perform and display that method.
     */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        HospitalSystemA5Q1 hs = new HospitalSystemA5Q1();
        System.out.println("Select a method to perform :" +
                "\n1: quit" +
                "\n2: add a new patient to system" +
                "\n3: add a new doctor to system" +
                "\n4: assign a doctor to a patient" +
                "\n5: display the empty beds of the ward" +
                "\n6: assign a patient a bed" +
                "\n7: release a patient" +
                "\n8: drop doctor patient association" +
                "\n9: display current system state");
        int method_number = 0;
        while (method_number >= 0) {
            if (method_number == 1) {
                hs.systemState();
                break;
            }
            System.out.println("Enter number to select a method to perform: ");
            method_number = in.nextInt();
            switch(method_number) {
                case 1:
                    System.out.println("quit");
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
                    System.out.println("Invalid");


            }
        }
    }
}
