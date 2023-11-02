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
            int num1 = line1.length();
            int num2 = line2.length();
            if (num1 > num2){
                for (int i = num2-1; i >=0; i--) {
                    int n1 = Integer.parseInt(String.valueOf(line1.charAt(i+(num1-num2))));
                    int n2 = Integer.parseInt(String.valueOf(line2.charAt(i)));
                    if (du == true){
                        n2 +=1;
                    }
                    int n = n1 + n2;
//                    System.out.println(n);
                    if (n>= 10){
                        result.append(n-10) ;
//                        System.out.println(result);
                        du = true;
                    }
                    else {
                        du = false;
                        result.append(n);
                    }
                }

                if (du == true){
                    int n1 = Integer.parseInt(String.valueOf(line1.charAt((num1-num2)-1)));
                    n1 += 1;
                    result.append(n1);
                    for (int i = 0; i < num1-(num1-num2)-1; i++) {
                        result.append(String.valueOf(line1.charAt(i)));
                    }
                }
                else {
                    for (int i = 0; i < num1-(num1-num2); i++) {
                        result.append(String.valueOf(line1.charAt(i)));
                    }
                }
            }
            else if(num2 > num1) {
                for (int i = num1-1; i >=0; i--) {
                    int n1 = Integer.parseInt(String.valueOf(line1.charAt(i)));
                    int n2 = Integer.parseInt(String.valueOf(line2.charAt(i+(num2-num1))));
                    if (du == true){
                        n2 +=1;
                    }
                    int n = n1 + n2;
                    if (n>= 10){
                        result.append(n-10);
                        du = true;
                    }
                    else {
                        du = false;
                        result.append(n);
                    }

                }
                if (du == true){

                    int n2 = Integer.parseInt(String.valueOf(line2.charAt((num2-num1)-1)));
                    n2 += 1;
                    result.append(n2);
                    for (int i = 0; i < num2-(num2-num1)-1; i++) {
                        result.append(String.valueOf(line2.charAt(i)));
                    }
                }
                else {
                    for (int i = 0; i < num2-(num2-num1)-1; i++) {
                        result.append(String.valueOf(line1.charAt(i)));
                    }
                }
            }
            else {
                for (int i = num1-1; i >=0; i--) {
                    int n1 = Integer.parseInt(String.valueOf(line1.charAt(i)));
                    int n2 = Integer.parseInt(String.valueOf(line2.charAt(i)));
                    if (du == true){
                        n2 +=1;
                    }
                    int n = n1 + n2;
                    if (n>= 10){
                        result.append(n-10);
                        du = true;
                    }
                    else {
                        du = false;
                        result.append(n);
                    }

                }
                if (du == true){
                    result.append(1);
                }
            }
//            System.out.println(result.toString());
            writer.write(result.reverse().toString());

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
