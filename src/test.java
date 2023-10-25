public class test {
    public static void main(String args[]) {
        String str = "this is Java";
        System.out.println(removeCharAt(str, 0));
        System.out.println(str);
    }
    public static String removeCharAt(String s, int pos) {
        return  s.substring(0,pos);
    }
}