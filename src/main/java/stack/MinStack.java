package stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Elem> stackList;
    private int length;
    public MinStack() {
        stackList = new ArrayList<>();
    }

    public void push(int x) {
        Elem e;
        if(stackList.size()==0){
            e = new Elem(x, x);
        }else{
            int min = Math.min(stackList.get(length-1).min, x);
            e = new Elem(min, x);
        }
        stackList.add(e);
        length++;
    }

    public void pop() {
        if(length!=0) {
            stackList.remove(length - 1);
            length--;
        }
    }

    public int top() {
        return stackList.get(length - 1).value;
    }

    public int getMin() {
        return stackList.get(length - 1).min;
    }

    class Elem{
        int min;
        int value;
        public Elem(int tMin, int tValue){
            min = tMin;
            value = tValue;
        }
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-10);
        ms.push(14);
        System.out.println(ms.getMin());
        System.out.println(ms.getMin());
        ms.push(-20);
        System.out.println(ms.getMin());
        System.out.println(ms.getMin());
        System.out.println(ms.top());
        System.out.println(ms.getMin());
        ms.pop();
        ms.push(10);
        ms.push(-7);
        System.out.println(ms.getMin());
        ms.push(-7);
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());
        ms.pop();
    }
}
