//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270


import java.util.TreeMap;

public class DoctorMapAccess
{
    private static TreeMap<String,Doctor> dictionary = null;
    DoctorMapAccess(){};
    public static TreeMap<String,Doctor> getInstance()
    {
        if(dictionary == null)
        {
            dictionary = new TreeMap<>();
        }
        return dictionary;
    }
}
