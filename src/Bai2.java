import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bai2 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Bai2.inp"));
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("bai2_1.out"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("bai2_2.out"));
            BufferedWriter writer3 = new BufferedWriter(new FileWriter("bai2_3.out"));
            BufferedWriter writer4 = new BufferedWriter(new FileWriter("bai2_4.out"));

            String line;
            List<String> list = new ArrayList<>();
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
                writer3.write(cleanedString + ";" + (isPalindrome ? "OK" : palindromeAfterDeletion != null ? (palindromeAfterDeletion + ";" + palindromeAfterDeletion.length()) : "NOK") + "\n");

                // Trộn 2 xâu để tạo xâu đối xứng
                if (isPalindrome(cleanedString) == false) {
                    list.add(cleanedString);
                }
            }

            int max = 0;
            String[] a = list.toArray(new String[0]);
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    String str = a[i] + a[j];
                    System.out.println("str " + str);
                    if (mergeToPalindrome(str) != null) {
                        System.out.println("Result" + mergeToPalindrome(str));
                        if (max < mergeToPalindrome(str).length()) {
                            max = mergeToPalindrome(str).length();
                        }
                    }
                }
            }
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    String str = a[i] + a[j];
                    if (mergeToPalindrome(str) != null) {
                        if (max == mergeToPalindrome(str).length()) {
                            System.out.println(max);
                            writer4.write(a[i] + "\n" + a[j] + "\n" + mergeToPalindrome(str) + "\n");
                        }
                    }
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
        for (int i = 0; i < n; i++) {
            F[i][i] = true;
        }
        String str = "", result = "";
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (len == 2 && s.charAt(i) == s.charAt(j)) {
                    F[i][j] = true;
                } else F[i][j] = (s.charAt(i) == s.charAt(j)) && F[i + 1][j - 1];
                if (F[i][j]) {
                    str = s.substring(i, j + 1);
                }
            }
        }
        if (str.length() >= 2) {

            return str;
        } else
            // Trả về null nếu không tìm thấy xâu đối xứng
            return null;
    }
    // Hàm tạo xâu đối xứng sau khi xoá ký tự
    private static String createPalindromeAfterDeletion(String s) {
        // Logic tạo xâu đối xứng sau khi xoá ký tự ở đây
        for (int len = 1; len < s.length() - 1; len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                String str = s;
                if (isPalindrome(removeCharAt(str, i, len))) {
                    return s.substring(0, i) + s.substring(i + len);
                }
            }
        }
        // Trả về null nếu không thể tạo được xâu đối xứng mới
        return null;
    }

    // Hàm trộn 2 xâu để tạo xâu đối xứng
    private static String mergeToPalindrome(String s) {

        // Logic trộn 2 xâu để tạo xâu đối xứng ở đây
        // Tạo HashMap với kích thước 36 và giá trị khởi tạo là 0
        HashMap<Character, Integer> hashMap = new HashMap<>(36);


        StringBuilder list = new StringBuilder();
        StringBuilder reverse = new StringBuilder();
        String str = "";

        // Thêm các kí tự in hoa vào HashMap với giá trị ban đầu là 0
        for (char c = 'A'; c <= 'Z'; c++) {
            hashMap.put(c, 0);

        }
        // Thêm các chữ số từ 0 đến 9 vào HashMap với giá trị ban đầu là 0
        for (char c = '0'; c <= '9'; c++) {
            hashMap.put(c, 0);

        }
        // Duyệt qua từng kí tự trong chuỗi
        for (char c : s.toCharArray()) {
            // Kiểm tra xem kí tự có tồn tại trong HashMap không
            if (hashMap.containsKey(c)) {
                // Nếu có, tăng giá trị của key đó lên 1
                int count = hashMap.get(c);
                hashMap.put(c, count + 1);
            }
        }
        int count = 0;
        for (char c : hashMap.keySet()
        ) {
            if (hashMap.get(c) % 2 != 0) {
                count++;
            }
        }
        if (count <= 1) {
            for (char c : hashMap.keySet()
            ) {

                int n = hashMap.get(c);
                //in ra nửa chuỗi đầu
                if (n % 2 == 0) {
                    n /= 2;
                    for (int i = 0; i < n; i++) {
                        list.append(c);
                    }
                    String temp = list.toString();
                    reverse = new StringBuilder(temp);
                    reverse.reverse();
                }
                //in ra phần đối xưng
                else if (n % 2 != 0) {
                    for (int i = 0; i < hashMap.get(c); i++) {
                        str += c;
                    }
                }

            }
            //có thể merge thành xâu đối xứng
            return list.toString() + str + reverse.toString();
        }
        // Trả về null nếu không thể tạo được xâu đối xứng
        return null;
    }

    public static String removeCharAt(String s, int pos, int len) {
        return s.substring(0, pos) + s.substring(pos + len);
    }
}
