package Theory;

import java.io.*;

public class Launcher {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Bai1a.inp"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("Bai1a.out"));

             String line1 = reader.readLine();
             String line2 = reader.readLine();

             int n1 = line1.length();
             int n2 = line2.length();

             if (n1 < n2 ){
                 int n = n2-n1 ;
                 for (int i = 0; i < n; i++) {
                     line1 = "0" + line1;
                 }
             }
             else {
                 int n = n2-n1 ;
                 for (int i = 0; i < n; i++) {
                     line2 = "0" + line2;
                 }
             }


             //int max = max(line1.length(),line2.length());
             String str ="";


             reader.close();
             writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Test1 test = new Test1();
        //Loi pham vi truy cập
        //test.age = 18;

        //Phạm vi truy cập private
        test.address = "String";
        test.setAge(15);
        System.out.println(test.getAge());//in ra 0


    }


}
