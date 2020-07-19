package stack;

import java.util.Stack;

/**
 * 在经典的汉诺塔问题中，有 3 个塔和 N 个可用来堆砌成塔的不同大小的盘子。要求盘子必须按照从小到大的顺序从上往下堆 （如，任意一个盘子，其必须堆在比它大的盘子上面）。同时，你必须满足以下限制条件：
 *
 * (1) 每次只能移动一个盘子。
 * (2) 每个盘子从堆的顶部被移动后，只能置放于下一个堆中。
 * (3) 每个盘子只能放在比它大的盘子上面。
 *
 * 请写一段程序，实现将第一个堆的盘子移动到最后一个堆中。
 */
public class Tower {
    private Stack<Integer> disks;
    // create three towers (i from 0 to 2)
    public Tower() {
        disks = new Stack<Integer>();
    }

    // Add a disk into this tower
    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    // @param t a tower
    // Move the top disk of this tower to the top of t.
    public void moveTopTo(Tower t) {
        // Write your code here
        int top = disks.pop();
        t.add(top);
    }

    // @param n an integer
    // @param destination a tower
    // @param buffer a tower
    // Move n Disks from this tower to destination by buffer tower
    public void moveDisks(int n, Tower destination, Tower buffer) {
        // Write your code here
        if (n > 0) {
            moveDisks(n - 1, buffer, destination); //// 以目标杆为中介，从起始杆将1至n-1号盘移至中间杆
            moveTopTo(destination); //将起始杆里的第n号盘移动到目标杆
            buffer.moveDisks(n - 1, destination, this); //以起始杆为中介，从中间杆将1至n-1号盘移至目标杆
        }
    }

    public Stack<Integer> getDisks() {
        return disks;
    }

    public static void main(String[] args) {
        Tower t1 = new Tower();
        for(int i=3; i >=1; i--){
            t1.add(i);
        }
        Tower t2 = new Tower();
        Tower t3 = new Tower();
        t1.moveDisks(3, t3, t2);
    }
}
