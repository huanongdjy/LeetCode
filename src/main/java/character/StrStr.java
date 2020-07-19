package character;

public class StrStr {
    public int strStr(String haystack, String needle) {
        int sourceCount = haystack.length();
        int targetCount = needle.length();
        if(sourceCount < targetCount) return -1;
        if(sourceCount <= 0){
            return targetCount == 0? 0: -1;
        }
        if(targetCount == 0)return 0;

        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();

        char first = target[0];
        int max = sourceCount - targetCount;

        for (int i = 0 ; i <= max; i++) {
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k =  1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    return i ;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        String haystack = "abhello";
        String needle = "le";
        System.out.println(strStr.strStr(haystack, needle));

    }
}
