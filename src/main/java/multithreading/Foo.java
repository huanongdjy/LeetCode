package multithreading;

import java.util.concurrent.Semaphore;

/**
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Foo {
    Semaphore a;
    Semaphore b;
    Semaphore c;
    public Foo() {
        a = new Semaphore(1);
        b = new Semaphore(0);
        c = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        a.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        b.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        b.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        c.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        c.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
