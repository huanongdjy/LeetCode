package multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BathRoom {
    public static int SIZE = 3;
    private int used = 0;
    private int capacity = SIZE;
    private int sexFlag = -1;// 0: man, 1: woman; -1: initial state
    public Lock lock = new ReentrantLock();
    /*
    TODO
    实现你的数据变量
    */
    public BathRoom(int size){
        this.SIZE = size;
    }
    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSexFlag() {
        return sexFlag;
    }

    public void setSexFlag(int sexFlag) {
        this.sexFlag = sexFlag;
    }

    public void takeBath(int sex) throws InterruptedException {
        /*
        TODO
        实现你代码，洗澡时长可以使用 Random r = new Random(); r.nextInt(10)+1;
        */
        /*
        应该在这里sleep一定的时间
        */

        Random r = new Random();
        int sleeptime = r.nextInt(10)+1;
        Thread.sleep(sleeptime);
    }
    public void change(int sex){
        synchronized(BathRoom.class) {
            SIZE++;
            used=1;
            sexFlag=sex;
        }

    }
    public void leave(){
        synchronized(BathRoom.class) {
            SIZE--;
            if(SIZE==0){
                used=0;
                sexFlag=-1;
            }
        }
    }
}
