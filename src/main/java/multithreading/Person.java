package multithreading;

public class Person extends Thread {
    /*
    TODO
    实现你的代码
    */
    BathRoom br;
    int sex;
    Person(BathRoom tbr, int sex){
        br = tbr;
        this.sex = sex;
    }
    /*
    首先判断当前bathroom是否被使用，如果没有，则使用，将used置为1，同时把浴室性别置为自己的性别，size=1;
    如果当前有人使用浴室，则先判断自己的性别和浴室的性别是否一致，如果一致，则判断遇是size是否小于3，如果是，则开始洗澡，并size++;如果size==3，则等待，直到有人退出浴室(唤醒)
    如果性别不一致，则等待浴室size变为0
    */
    @Override
    public void run() {
        if(br!=null) {
            boolean isLave = true;
            while(isLave){
                try {
                    if(br.lock.tryLock()) {
                        if (br.getUsed() == 0 || (br.getSexFlag() == sex && br.SIZE < 3)) {
                                System.out.println("来洗 " + sex);
                                br.change(sex);
                                br.lock.unlock();
                                System.out.println(br.SIZE + " " + br.getUsed());
                                br.takeBath(sex);
                                br.leave();
                                System.out.println("洗好了 " + sex);
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
