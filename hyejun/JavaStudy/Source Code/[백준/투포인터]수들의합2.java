import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);    
		int len = sc.nextInt();
        long m = sc.nextLong();
        int[] arr = new int[len];
        long sum=0;
        int cnt=0;
        int s=0, e=0;
        for (int i = 0; i <len ; i++) {
            arr[i] =  sc.nextInt();
        }
        while(true) {
			if(sum >= m ) { // sum >= m
				sum = sum - arr[s++];
 			} else if(e >= len) {
				break;
			}
			else {  // sum < m
				sum = sum + arr[e++];
			}
			if(sum == m) {
				cnt++;
			}
			
		}
        
        System.out.println(cnt);
    }
}