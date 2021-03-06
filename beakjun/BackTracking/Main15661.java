import java.util.Scanner;

public class Main {
 
    static int[][] map = new int[21][21];
    static boolean[] visited = new boolean[21];
    static int n, ans = Integer.MAX_VALUE;
 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int r;
        if(n%2==0) {
        	r= n/2;
        } else {
        	r = (n/2)+1;
        }
        for(int i=1; i<=r; i++) {
        	dfs(0, 0,i);
        }
        System.out.println(ans);
        
//        for(boolean i : visited) {
//        	System.out.println(i);
//        }
    }
 
    public static void dfs(int v, int len, int r) {
        if (len == r) {
            calculateAbility(r,n-r);
        } else {
            for (int i = v + 1; i <= n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(i, len + 1,r);
                }
            }
        }
        visited[v] = false;
    }
 
    public static void calculateAbility(int a1, int b1) {
        int[] a = new int[a1+1];
        int[] b = new int[b1+1];
        int ai = 1, bi = 1;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) a[ai++] = i;
            else b[bi++] = i;
        }
 
        int abilityA = getAbility(a);
        int abilityB = getAbility(b);
        int result = Math.abs(abilityA - abilityB);
        ans = Math.min(ans, result);
    }
 
    public static int getAbility(int[] array) {
        int result = 0;
        int len = array.length-1;
        for (int i = 1; i <= len; i++) {
        	for (int j = i + 1; j <= len; j++) {
        		result += map[array[i]][array[j]];
        		result += map[array[j]][array[i]];
        	}
        }
        
//        int len = n / 2;
// 
//        for (int i = 1; i <= len; i++) {
//            for (int j = i + 1; j <= len; j++) {
//                result += map[array[i]][array[j]];
//                result += map[array[j]][array[i]];
//            }
//        }
 
        return result;
    }
 
}