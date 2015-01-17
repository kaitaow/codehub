Solution1:
public class Solution {
   public int cal(int num){
		int sum=0;
		while(num>=5){
			sum++;
			num/=5;
		}
		return sum;
	}
	public int trailingZeroes(int n) {
		int cnt=0;
		
		for(int i=5;i<=n;i+=5){
			cnt+=cal(i);
		}
		return cnt;
	}
}
the above solution will get a Time Limit Exceeded result

A better Solution
public class Solution {
  public int trailingZeroes(int n) {
		int cnt=0;
		
		while(n!=0){
			cnt+=n/5;
			n/=5;
		}
		return cnt;
	}
}
explanation:
view <<beauty of programming>> section 2.2 