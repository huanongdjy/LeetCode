package digital;

public class Divide {
    public int divide(int dividend, int divisor) {
      if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
      if(dividend==0)return 0;
      int a = Math.abs(dividend);
      int b = Math.abs(divisor);
        if(a < b && dividend != Integer.MIN_VALUE) return 0;
      int multiple = 1;
      int temp = b;
      while((a - temp)>0){
          if(a - temp - temp > 0){
              multiple += multiple;
              temp += temp;
          }else{
              break;
          }
      }
      while((a - temp - b)>=0){
          if(a - temp - b >= 0){
              multiple++;
              temp += b;
          }else{
              break;
          }
      }
      if((dividend>0&&divisor>0) || (dividend<0&&divisor<0))
          return multiple;
      else
          return -multiple;
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        int a = divide.divide(-2147483648, 1);
        System.out.println(a);
    }
}
