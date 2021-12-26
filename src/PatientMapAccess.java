//Name : Aayush Parekh
//NSID : aap409
//Student Number : 11289666
//Course Number : CMPT 270


import java.util.TreeMap;

public class PatientMapAccess
{
    private static TreeMap<String,Patient> dictionary = null;
    PatientMapAccess()
    {
    }
    public static TreeMap<String,Patient> getInstance()
    {
        if(dictionary == null)
        {
            dictionary = new TreeMap<>();
        }
        return dictionary;
    }
}
