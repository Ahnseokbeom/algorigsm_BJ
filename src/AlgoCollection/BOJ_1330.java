package AlgoCollection;

import java.util.Scanner;

public class BOJ_1330 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		if(a>b) {
			sb.append(">");
		}else if(a<b) {
			sb.append("<");
		}else {
			sb.append("==");
		}
		System.out.println(sb);
		sc.close();
	}

}