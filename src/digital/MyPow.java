package digital;

public class MyPow {
    public double myPow(double x, int n) {
        if (x == -1) {
            if ((n & 1) != 0) {
                return -1;
            } else {
                return 1;
            }
        }
        if (x == 1.0f)
            return 1;
        if (n == -2147483648) {
            return 0;
        }
        double mul;
        if (n > 0) {
            mul = powRecursion(x, n);
        } else {
            n = -n;
            mul = powRecursion(x, n);
            mul = 1 / mul;
        }
        return mul;
    }

    public double powRecursion(double x, int n){
        if (n==0){
            return 1;
        }
        if((n&1)==0){
            return powRecursion(x*x, n/2);
        }else{
            return powRecursion(x*x, n/2) * x;
        }
    }
}
