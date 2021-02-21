package multithreading;

import java.time.LocalTime;
import java.util.Random;

public class Hello {
    static BathRoom bathRoom;
    public static void main(String[] args) throws InterruptedException {
	    /*
	    TODO
	    实现主程序
	    */
	    /*
	    需要建立是个person实例并start
	    */
        bathRoom = new BathRoom();
        BathRoom.SIZE = 0;
        Thread[] p1 = new Thread[1000];
        for(int i = 0; i<1000; i++){
            p1[i] = new Person(i%2, i+"");
        }
        for(int i = 0; i<1000; i++){
            p1[i].start();
        }
        for(int i = 0; i<1000; i++){
            p1[i].join();
        }
        System.out.println("end!");
    }

    static class BathRoom{
        private static int SIZE = 3;
        private int used = 0;
        private int capacity = SIZE;
        private int sexFlag = -1;// 0: man, 1: woman; -1: initial state
	    /*
	    TODO
	    实现你的数据变量
	    */



        public void takeBath(int sex) throws InterruptedException {
	    /*
	    TODO
	    实现你代码，洗澡时长可以使用 Random r = new Random(); r.nextInt(10)+1;
	    */
	    /*
	    应该在这里sleep一定的时间
	    */
            synchronized(this) {
                //之所以要在while循环中进行await而不用if，是为了防止notifyall唤醒后在不满足条件的情况下往后执行
                while((sexFlag!=-1&&sexFlag!=sex&&SIZE!=0)||(SIZE==3)) {
                    this.wait();//浴室有人且性别与自己不同，则挂起，释放锁
                }
                //执行到这里时，代表此时浴室有空位，且性别正确
                this.sexFlag = sex;
                SIZE++;//非原子操作，所以必须放在同步块中
                this.used = 1;
                LocalTime t = LocalTime.now(); // 当前时间
                System.out.println(Thread.currentThread().getName()+" 性别："+sex+" 开始时间"+t+"，此时浴室有 "+SIZE+" 人");
                //此时有人进入浴室，没必要唤醒其他线程去判断自己能否去洗澡，只有当有人出浴室了，才需要唤醒
            }

            Random r = new Random();
            int sleeptime = r.nextInt(10)+1;
            Thread.sleep(sleeptime);//因为不释放锁，所以不能放在sync代码块中

            synchronized(this) {
                LocalTime t = LocalTime.now(); // 当前时间
                System.out.println(Thread.currentThread().getName()+" 性别："+sex+" 结束时间"+t+"，此时浴室有 "+(SIZE-1)+" 人");
                SIZE--;
                if(SIZE == 0) {
                    this.used = 0;
                    this.sexFlag = -1;
                }
                this.notifyAll();
            }

        }
    }

    static class Person extends Thread {
        /*
        TODO
        实现你的代码
        */
        int sex = -1;// 0: man, 1: woman; -1: initial state
        Person(int sex,String name)
        {
            this.sex = sex;
            setName(name);
        }

        @Override
        public void run() {
            if(bathRoom!=null) {
                try {
                    bathRoom.takeBath(sex);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}
