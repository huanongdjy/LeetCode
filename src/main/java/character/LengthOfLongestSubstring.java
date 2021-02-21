package character;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 滑动窗口
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)return 0;
        int len = s.length();
        int result = 0;
        int i = 0;
        Queue queue = new LinkedList();
        while(i<len){
            char curr = s.charAt(i);
            if(queue.contains(curr)){
                result = Math.max(result, queue.size());
                while (queue.contains(curr)){
                    queue.poll();
                }
            }else {
                i++;
                queue.add(curr);
            }
        }
        return Math.max(result, queue.size());
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
        System.out.println(lols.lengthOfLongestSubstring(" "));

    }
}
