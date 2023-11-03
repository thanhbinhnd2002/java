package Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Bai1_1 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Bai1a.inp"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("Bai1a.out"));

            String line1 = reader.readLine();
            String line2 = reader.readLine();
            StringBuilder result = new StringBuilder();
            boolean du = false;

            int n1 = line1.length();
            int n2 = line2.length();
            int len;

            if (n1 < n2 ){
                int n = n2-n1 ;
                for (int i = 0; i < n; i++) {
                    line1 = "0" + line1;
                }
                len = n2;
            }
            else {
                int n = n1-n2 ;
                for (int i = 0; i < n; i++) {
                    line2 = "0" + line2;
                }
                len = n1;
            }

            for (int i = len-1; i >=0 ; i--) {
                int sum = (line1.charAt(i)-'0') + (line2.charAt(i)-'0') + (du?1:0);
                if(sum>9){
                    du = true;
                    result.append(sum-10);
                } else {
                    du = false;
                    result.append(sum);
                }
            }
            result.append(du?"1":"");
            writer.write(result.reverse().toString());

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
