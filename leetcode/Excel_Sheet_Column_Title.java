Problem Descrition
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

MYCode
public class Solution {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		int[] table = { 1, 26, 676, 17576, 456976, 11881376, 308915776 };
		int[] range = new int[7];
		range[0] = 0;
		for (int i = 1; i < 7; i++)
			range[i] = range[i - 1] + table[i];

		int len = range.length;
		int curLen = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (n > range[i]) {
				curLen = i + 1;
				break;
			}
		}

		for (int i = 0; i < curLen - 1; i++) {
			if (n % table[curLen - 1 - i] < (range[curLen - 2 - i] + 1)) {
				sb.append((char) ('A' + n / table[curLen - 1 - i] - 1 - 1));
				n = n % table[curLen - 1 - i] + table[curLen - 1 - i];
			} else {
				sb.append((char) ('A' + n / table[curLen - 1 - i] - 1));
				n = n % table[curLen - 1 - i];
			}
		}
		sb.append((char) ('A' + n - 1));
		return sb.toString();
	}
}

思路
首先判断title的长度curLen，然后顺次推导每一位。
需要注意低位是Z的情况，这样在用n/table[curLen-1-i]的时候会把低位的值算进来，从而导致后面的计算出错，比如说52对应的数字是AZ，但是计算的时候用52除以26得到2，导致低位的值直接变为0。
因此在计算的时候要特别处理这种情况。
这道题目和171题是相反的题目，给出序号求title以及给出title求序号。相对来说给出title求序号要简单一些因为不需要处理上面的特殊情况。
