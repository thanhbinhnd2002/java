package Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bai1_2 {
    public static void main(String[] args) throws IOException {
        Bai1_2 test = new Bai1_2();
        test.tinhGiaiThua();
    }
    public void tinhGiaiThua() throws IOException {
        int n,result = 1 ;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Moi nhap n: ");
            n = sc.nextInt();

        }while (n<=0 || n>=500);
        System.out.println(n);
        if (n==0||n==1){
            result = 1;
        }
        else {
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
        }
        System.out.println(result);
        BufferedWriter bw = new BufferedWriter(new FileWriter("bai1b.out"));
        bw.write(String.valueOf(result));
        bw.close();
    }
}
