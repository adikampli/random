package leetcode;

public class StringIndexOf {
    public static void main(String[] args) {
        System.out.println(strStr("", ""));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int needleLength = needle.length();
        for (int j = 0; j <= haystack.length() - needleLength; j++) {
            if (haystack.charAt(j) == needle.charAt(0) &&
                    haystack.charAt(j + needleLength - 1) == needle.charAt(needleLength - 1)) {
                int i = 1;
                for (; i < needleLength; i++) {
                    if (haystack.charAt(j + i) != needle.charAt(i)) break;
                }
                if (i == needleLength) return j;

            }
        }
        return -1;
    }
}
