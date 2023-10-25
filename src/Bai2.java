import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bai2 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Bai2.inp"));
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("bai2_1.out"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("bai2_2.out"));
            BufferedWriter writer3 = new BufferedWriter(new FileWriter("bai2_3.out"));
            BufferedWriter writer4 = new BufferedWriter(new FileWriter("bai2_4.out"));

            String line;
            while ((line = reader.readLine()) != null) {
                // Loại bỏ dấu cách và chuyển thành chữ hoa
                String cleanedString = line.replaceAll("\\s", "").toUpperCase();

                // Kiểm tra xâu đối xứng
                boolean isPalindrome = isPalindrome(cleanedString);

                // Ghi vào tệp tin bai2_1.out
                writer1.write(cleanedString + ";" + (isPalindrome ? "TRUE" : "FALSE") + "\n");

                // Tìm xâu đối xứng dài nhất
                String longestPalindrome = findLongestPalindrome(cleanedString);
                writer2.write(cleanedString + ";" + (longestPalindrome != null ? longestPalindrome : "NULL") + ";" +
                        (longestPalindrome != null ? longestPalindrome.length() : "0") + "\n");

                // Tạo xâu đối xứng bằng cách xoá ký tự
                String palindromeAfterDeletion = createPalindromeAfterDeletion(cleanedString);
                writer3.write(cleanedString + ";" + (isPalindrome ? "OK" : palindromeAfterDeletion != null ? (palindromeAfterDeletion +";"+ palindromeAfterDeletion.length()) : "NOK") + "\n");

                // Trộn 2 xâu để tạo xâu đối xứng
                if(isPalindrome(cleanedString)==false){
                    String str1 = cleanedString;

                }
                String mergedPalindrome = mergeToPalindrome(cleanedString,cleanedString);
                if (mergedPalindrome != null) {
                    writer4.write(cleanedString + "\n" + cleanedString + "\n" + mergedPalindrome + "\n");
                }
            }

            // Đóng các luồng
            reader.close();
            writer1.close();
            writer2.close();
            writer3.close();
            writer4.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm kiểm tra xâu đối xứng
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Hàm tìm xâu đối xứng dài nhất
    private static String findLongestPalindrome(String s) {
        // Logic tìm xâu đối xứng dài nhất ở đây
        int n = s.length();
        boolean F[][] = new boolean[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                F[i][j] = false;
//            }
//        }
        for (int i = 0; i < n; i++) {
            F[i][i] = true;
        }
        String str="",result ="";
        for (int len = 2; len < n; len++) {
            for (int i = 0 ; i < n - len + 1 ; i++) {
                int j = i + len -1 ;
                if (len == 2 && s.charAt(i)== s.charAt(j)){
                    F[i][j] = true;
                }
                else F[i][j] = (s.charAt(i)== s.charAt(j)) && F[i+1][j-1];
                if (F[i][j]){
                        str = s.substring(i,j+1);
                }
            }
        }
        if (str.length()>=2){

            return str;
        }
        else
        // Trả về null nếu không tìm thấy xâu đối xứng
        return null;
    }

    // Hàm tạo xâu đối xứng sau khi xoá ký tự
    private static String createPalindromeAfterDeletion(String s) {
        // Logic tạo xâu đối xứng sau khi xoá ký tự ở đây
        for (int len = 1; len < s.length()-1; len++) {
            for (int i = 0; i <s.length()-len+1; i++) {
                String str = s;
                if (isPalindrome(removeCharAt(str,i,len))){
                    return s.substring(0, i) + s.substring(i + len);
                }
            }
        }
        // Trả về null nếu không thể tạo được xâu đối xứng mới
        return null;
    }

    // Hàm trộn 2 xâu để tạo xâu đối xứng
    private static String mergeToPalindrome(String s1, String s2 ) {
        // Logic trộn 2 xâu để tạo xâu đối xứng ở đây


        // Trả về null nếu không thể tạo được xâu đối xứng
        return null;
    }
    public static String removeCharAt(String s, int pos, int len) {
        return s.substring(0, pos) + s.substring(pos + len);
    }
}
