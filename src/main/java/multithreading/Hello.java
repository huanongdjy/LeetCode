package multithreading;

import java.time.LocalTime;
import java.util.Random;

public class Hello {
    static BathRoom bathRoom;
    public static void main(String[] args) throws InterruptedException {
	    /*
	    TODO
	    ʵ��������
	    */
	    /*
	    ��Ҫ�����Ǹ�personʵ����start
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
	    ʵ��������ݱ���
	    */



        public void takeBath(int sex) throws InterruptedException {
	    /*
	    TODO
	    ʵ������룬ϴ��ʱ������ʹ�� Random r = new Random(); r.nextInt(10)+1;
	    */
	    /*
	    Ӧ��������sleepһ����ʱ��
	    */
            synchronized(this) {
                //֮����Ҫ��whileѭ���н���await������if����Ϊ�˷�ֹnotifyall���Ѻ��ڲ��������������������ִ��
                while((sexFlag!=-1&&sexFlag!=sex&&SIZE!=0)||(SIZE==3)) {
                    this.wait();//ԡ���������Ա����Լ���ͬ��������ͷ���
                }
                //ִ�е�����ʱ�������ʱԡ���п�λ�����Ա���ȷ
                this.sexFlag = sex;
                SIZE++;//��ԭ�Ӳ��������Ա������ͬ������
                this.used = 1;
                LocalTime t = LocalTime.now(); // ��ǰʱ��
                System.out.println(Thread.currentThread().getName()+" �Ա�"+sex+" ��ʼʱ��"+t+"����ʱԡ���� "+SIZE+" ��");
                //��ʱ���˽���ԡ�ң�û��Ҫ���������߳�ȥ�ж��Լ��ܷ�ȥϴ�裬ֻ�е����˳�ԡ���ˣ�����Ҫ����
            }

            Random r = new Random();
            int sleeptime = r.nextInt(10)+1;
            Thread.sleep(sleeptime);//��Ϊ���ͷ��������Բ��ܷ���sync�������

            synchronized(this) {
                LocalTime t = LocalTime.now(); // ��ǰʱ��
                System.out.println(Thread.currentThread().getName()+" �Ա�"+sex+" ����ʱ��"+t+"����ʱԡ���� "+(SIZE-1)+" ��");
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
        ʵ����Ĵ���
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
