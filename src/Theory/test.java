package Theory;

import java.util.ArrayList;
import java.util.HashMap;

public class test {
    private String name;
    private int age;
    public String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
            System.out.println("tuổi thỏa mãn");
        } else {
            System.out.println("tuổi không thỏa mãn");
        }

    }
}



