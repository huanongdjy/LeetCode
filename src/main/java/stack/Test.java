package stack;

public enum Test {
//    INSTANCE{
//        String name="test123";
//        String code = "0000";
//        public String myName(){
//            return name;
//        }
//    };
    UINSTANCE("0001", "test1234");
    private final String code;
    private final String name;
    Test(String code, String name){
        this.code = code;
        this.name = name;
    }



    public static Test getInstance() {
        return UINSTANCE;
    }
    public String myName(){
        return "test";
    }
    public void Test2(){

    }
    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }


    public static void main(String[] args) {
//        Test.getInstance().Test2();
//        System.out.println(Test.getInstance().myName());
//        System.out.println(Test.getInstance().name);
//        System.out.println(tableSizeFor(15));
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";

        String s4 = "ab";
        System.out.println("s3==s4? "+ (s3==s4));

        String s5 = "a"+"b";
        System.out.println("s3==s5? "+ (s3==s5));

        String s6 = s1+s2;
        System.out.println("s3==s6? "+ (s3==s6));

        String s7 = new String("ab");
        System.out.println("s3==s7? "+ (s3==s7));

        final String s8 = "a" ;
        final String s9 = "b" ;
        String s10 = s8 + s9;
        System.out.println("s3==s10? "+ (s3==s10));
    }


}
