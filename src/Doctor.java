//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270


import java.util.ArrayList;

/**
 * The below class defines a simple
 * class doctor which extends the
 * Basic Doctor class.
 */


public class Doctor extends BasicDoctor
{
    /**
     * name is a variable of type String
     * which stores name.
     */
    private String name;

    /**
     * Below is a list of patient which stores patients for
     * doctors.
     */

    private ArrayList<Patient> patient ; //Creates a list of patient

    /**
     * Accessor method for getName
     * @return : returns name of patient
     */
    public String getName() {
        return name;
    }

    /**
     * constructor method for Doctor
     * @param name : Stores the name for Doctor
     */
    public Doctor(String name)
    {
        super(name);
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("The name of a patient cannot be null or empty.  "
                    + "It is " + name);
        this.name = name;
        patient = new ArrayList <Patient>();
    }

    /**
     * The below method is the method
     * to add a patient to patient's list
     * @param p : stores information of patients
     */

    public void addPatient(Patient p)
    {
        if(!hasPatient(p.getName()))
        {
            patient.add(p);
        }
    }

    /**
     * The below method is the method
     * to remove a patient from patient's
     * list
     * @param healthNum : Stores the health Number of patient
     */

    public void removePatient(String healthNum) //removes a patient by checking health number
    {
        if (healthNum == null || healthNum.equals(""))
            throw new IllegalArgumentException("The name of a patient cannot be null or empty.  "
                    + "It is " + healthNum);
        for (Patient p : patient) {
            if (p.getHealthNumber().equals(healthNum)) {
                patient.remove(p);
                break;
            }
        }
    }

    /**
     * The below method checks whether
     * the patient with particular name
     * is present in the list or not.
     * @param healthNum : stores health number of patient.
     * @return : returns True or False
     */

    public boolean hasPatient(String healthNum)
    {
        for (Patient p : patient) {
            if (p.getHealthNumber().equals(healthNum))
                return true;
        }
        return false;
    }

    /**
     * The below method is the toString
     * method which gives proper string
     * representation of all the informations
     * provided.
     * @return : String representation of all information
     */

    @Override
    public String toString() {
        String toString = "";
        if (patient.isEmpty()) {
            toString = "Doctor's Name: " + getName();
        } else {
            for (Patient p : patient) {
                toString = "Doctor's Name: " + getName() + "\n\tPatients:\n" +
                        "\t\tPatient's name: " + p.getName() + "\n\t\tHealth card number: " + p.getHealthNumber() + "\n";
            }
        }
        return toString;

    }

    /**
     * This method test all the above methods.
     */

    public static void main(String[] args)
    {
        Doctor d = new Doctor("Tom");
        Patient p = new Patient("Clarke","1536ef7j");
        d.addPatient(p);
        //System.out.println(d.toString());

        if(d.hasPatient("1536ef7j"))
        {
            System.out.println("");
        }
        else
        {
            System.out.println("Patient with given health number is not there");
        }

        d.removePatient("1536ef7j");
        if(d.hasPatient("1536ef7j"))
        {
            System.out.println("Something is wrong in the code for remove patient");
        }
        else
        {
            System.out.println("");
        }


        String statement =  ""+"Doctor name:Tom"+"\ndoctor's Patient:\n"+
                "Patient's name:Clarke"+"\nhealth card number:1536ef7j"+"\n";
        d.addPatient(p);
        //System.out.println(d.toString());

        if(d.toString().equals(statement))
        {
            System.out.println("Something is wrong with toString function");
        }
        else
        {
            System.out.println("");
        }

        d.addPatient(p); // adds patient to list
        //System.out.println(statement);


    }

}
