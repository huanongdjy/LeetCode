package character;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length <= 0) return new ArrayList<>();
        Map<String, List<String>> ret = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            if(!ret.containsKey(String.valueOf(ch))){
                ret.put(String.valueOf(ch), new ArrayList());
            }
            ret.get(String.valueOf(ch)).add(str);
        }
        return new ArrayList<>(ret.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ga.groupAnagrams(strs);
    }
}
