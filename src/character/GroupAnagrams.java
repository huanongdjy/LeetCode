package character;

import java.util.*;

/**
 * ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
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
