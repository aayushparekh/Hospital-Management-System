//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270


import java.util.ArrayList;

/**
 * The below class defines a simple
 * class patient which extends the
 * Person class and which assigns
 * doctors to patient.
 */
public class Patient extends Person {

    /**
     * bedlabel gives the label of patients bed in integer
     */
    private int bedlabel;
    /**
     * Below is a list of doctors which stores doctors for
     * patients.
     */
    private ArrayList<Doctor> doctors; //Creates a list of doctors

    /**
     * The below method is a constructor method
     * which also assigns bedlabel to -1.
     * @param name:Name of the patient
     * @param number:Health number of patient
     */
    public Patient(String name, String number) // defines a constructor
    {
        super(name, number);
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("The name of a patient cannot be null or empty.  "
                    + "It is " + name);
        bedlabel = -1;
        doctors = new ArrayList<>();
    }

    /**
     * Accessor method for bed label
     * @return: returns the bed label
     */
    public int getBedLabel() {
        return bedlabel;
    }

    /**
     * mutator method for bed label.
     * It sets the bed label.
     * @param bedlabel : parameter which stores bed label
     */
    public void setBedlabel(int bedlabel) {
        this.bedlabel = bedlabel;
    }

    /**
     * The below method is the method
     * to add a doctor to doctor's list
     * @param d : stores information of the doctors
     */
    public void addDoctor(Doctor d)
    {
        if (!hasDoctor(d.getName()))
        {
            doctors.add(d);
        }
    }

    /**
     * The below method is the method
     * to remove a doctor from doctors
     * list
     * @param name : Stores the name of doctor
     */
    public void removeDoctor(String name) {
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("The name of a patient cannot be null or empty.  "
                    + "It is " + name);
        for(Doctor d : doctors)
        {
            if(d.getName().equals(name))
            {
                doctors.remove(d);
                return;
            }
        }
    }


    /**
     * The below method checks whether
     * the doctor with particular name
     * is present in the list or not.
     * @param name : stores name of doctor.
     * @return : returns True or False
     */
    public boolean hasDoctor(String name) //hasDoctor method to check whether a doctor is there or not
    {
        for (Doctor d : doctors) {
            if (d.getName().equals(name))
                return true;
        }
        return false;
    }


    /**
     * The below method is the toString
     * method which gives proper string
     * representation of all the informations
     * provided.
     * @return : String representation of all informations.
     */
    @Override
    public String toString() {
        String dn = "";
        for (Doctor d : doctors) {
            dn = dn + d.getName();
        }
        String label = "";
        if (bedlabel != -1) //checks whether bed label is assigned to -1 or not
        {
            label = label + bedlabel;
        } else {
            label = label;
        }
        return "{"+"\nName: " + super.getName()+
                "\nHealth card number: " + super.getHealthNumber()+
                "\ndoctor name:" + dn+
                "\nbedlabel:"+ label +"}";
    }


    /**
     * This method test all the above methods.
     */
    public static void main(String args[])
        {
            Patient p = new Patient("Aayush", "18304e5j");
            if (p.getBedLabel() == -1) {
                System.out.println("");
            } else {
                System.out.println("Bed label is invalid");
            }
            p.setBedlabel(210);
            if (p.getBedLabel() == 210) {
                System.out.println("");
            } else {
                System.out.println("Bed label is invalid");
            }
            Doctor d = new Doctor("Henry");
            p.addDoctor(d);
            if (p.hasDoctor("Henry")) {
                System.out.println("");
            } else {
                System.out.println("False");
            }
            //System.out.println(d);

            p.removeDoctor("Henry"); // removes doctor with name Henry

            if (p.hasDoctor("Henry")) {
                System.out.println("Something is invalid in code for remove Doctor");
            } else {
                System.out.println("");
            }
            String statement = "{" + "\nName: Aayush" +
                    "\nHealth card number: 18304e5j" +
                    "\ndoctor name:" +
                    "\nbedlabel:210" + "}";
            if (p.toString().equals(statement)) {
                System.out.println("");
            } else {
                System.out.println("toString is invalid");
            }
        }

    }
