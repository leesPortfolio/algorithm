public class Expressions {

    public int expressions(int num) {
        int answer = 0;
        int sum =0;
        for(int i=1; i<num; i++) {
         sum+=i;
         for(int j=i+1; j<num; j++) {
          sum+=j;
          if(sum==num) {
           answer++;
           break;
          } else if(sum>num) {
           break;
          }
       }
      sum=0;
       }

        return answer+1;
    }

    public static void main(String args[]) {
        Expressions expressions = new Expressions();
        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(expressions.expressions(15));
    }
}