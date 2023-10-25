import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Bai1_1 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Bai1a.inp"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("Bai1a.out"));


            String num1 = reader.readLine();
            String num2 = reader.readLine();


            BigInteger bigNum1 = new BigInteger(num1);
            BigInteger bigNum2 = new BigInteger(num2);
            BigInteger sum = bigNum1.add(bigNum2);


            writer.write(sum.toString());


            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
