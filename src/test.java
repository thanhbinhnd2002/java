import java.util.ArrayList;
import java.util.HashMap;

public class test {
    public static void main(String args[]) {
        // Tạo HashMap với kích thước 36 và giá trị khởi tạo là 0
        ArrayList<String> list = new ArrayList<>();
        list.add("hel");
        list.add("lo");
        String[] stringArray = list.toArray(new String[0]);
        String str = list.get(0) + list.get(1);
        System.out.println(str);

    }

}