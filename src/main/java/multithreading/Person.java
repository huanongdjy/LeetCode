package multithreading;

public class Person extends Thread {
    /*
    TODO
    ʵ����Ĵ���
    */
    BathRoom br;
    int sex;
    Person(BathRoom tbr, int sex){
        br = tbr;
        this.sex = sex;
    }
    /*
    �����жϵ�ǰbathroom�Ƿ�ʹ�ã����û�У���ʹ�ã���used��Ϊ1��ͬʱ��ԡ���Ա���Ϊ�Լ����Ա�size=1;
    �����ǰ����ʹ��ԡ�ң������ж��Լ����Ա��ԡ�ҵ��Ա��Ƿ�һ�£����һ�£����ж�����size�Ƿ�С��3������ǣ���ʼϴ�裬��size++;���size==3����ȴ���ֱ�������˳�ԡ��(����)
    ����Ա�һ�£���ȴ�ԡ��size��Ϊ0
    */
    @Override
    public void run() {
        if(br!=null) {
            boolean isLave = true;
            while(isLave){
                try {
                    if(br.lock.tryLock()) {
                        if (br.getUsed() == 0 || (br.getSexFlag() == sex && br.SIZE < 3)) {
                                System.out.println("��ϴ " + sex);
                                br.change(sex);
                                br.lock.unlock();
                                System.out.println(br.SIZE + " " + br.getUsed());
                                br.takeBath(sex);
                                br.leave();
                                System.out.println("ϴ���� " + sex);
                                System.out.println(br.SIZE + " " + br.getUsed());
                                isLave = false;

                        }else {
                            br.lock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        BathRoom br = new BathRoom(0);
        Thread[] p1 = new Thread[1000];
        for(int i = 0; i<100; i++){
            p1[i] = new Person(br,i%2 );
        }
        for(int i = 0; i<100; i++){
            p1[i].start();
        }
        for(int i = 0; i<100; i++){
            p1[i].join();
        }

        System.out.println("end!");
    }
}
