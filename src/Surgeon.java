//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270

/**
 * The below class is a surgeon
 * class and it extends the
 * Doctor class.
 */
public class Surgeon extends Doctor // creates a class surgeon
{

    /**
     * The below method is a
     * constructor method which
     * takes name as a parameter.
     * @param name : name of surgeon
     */
    public Surgeon(String name) {
        super(name);
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("The name of a patient cannot be null or empty.  "
                    + "It is " + name);
    }

    /**
     * The below method is a
     * toString method which
     * represents proper string
     * representation of all the
     * information.
     * @return : returns string representation
     * of all information.
     */
    @Override
    public String toString() {
        return "Surgeon:" + super.getName();
    }

    /**
     * The below method is the
     * main method which is used
     * to test the above methods.
     */
    public static void main(String args[])
    {
        Surgeon s = new Surgeon("Adrianne"); //creates an instance for surgeon
        String statement = "Surgeon:" + "Adrianne";
        if(s.toString().equals(statement))
        {
            System.out.println("");
        }
        else
        {
            System.out.println("Something is invalid in toString");
        }
        //System.out.println(statement);
        //System.out.println(s.toString());
    }
}
