package leetcode;

public class LongestUniformString {
    public static void main(String[] args) {
        System.out.println(longestUniformString("abcdddss"));
    }

    private static String longestUniformString(String s) {
        int len = s.length();
        String res = "";
        for(int i =0;i<len;i++) {
            for(int j =i+1;j<len;j++) {
                if(s.charAt(i) != s.charAt(j)) break;
                else {
                    if(j-i >= res.length()) {
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }
}
