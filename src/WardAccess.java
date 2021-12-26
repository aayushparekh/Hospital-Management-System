//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270


public class WardAccess
{
    private static Ward ward;
    WardAccess(){};
    public static void initialize(String name,int first,int last)
    {
        if(ward != null)
        {
            throw new IllegalArgumentException("The creation and initialization should be done once");
        }
        if((name == null || name.equals(""))&& (last<first || first<0))
        {
            throw new IllegalArgumentException("The name of a ward cannot be null or empty.  "
                    + "It is " + name);
        }
        ward = new Ward(name,first,last);
    }
    public static Ward getInstance()
    {
        if(ward==null)
        {
            throw new IllegalArgumentException("The ward should have been created and initialized previously");
        }
        return ward;
    }
}
