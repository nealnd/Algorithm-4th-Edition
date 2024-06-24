package Exercise1_2;
public class Exercise1_2_06 {

    public static boolean is_CircularRotation(String s,String t)
    {
        String r = s + s;
        return (s.length() == t.length() && (r.indexOf(t) != -1));


    }
    public static void main(String[] args) {
        
        String s = "ACTGACG";
        String t = "TGACGAC";
        System.out.println(is_CircularRotation(s, t));


    }

}
