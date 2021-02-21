package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .map(i -> i.toString(i))
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2)
                )
                .reduce(String::concat)
                .filter(s->!s.startsWith("0"))
                .orElse("0");
    }
}
