package algorigsm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580 {
	public static int[][] arr = new int[9][9];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0,0);
	}
	public static void sudoku(int row, int col) {
		if(col==9) {
			sudoku(row+1,0);
			return;
		}
		if(row==9) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<9;i++) {
				for(int j = 0;j<9;j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if(arr[row][col]==0) {
			for(int i = 1;i<=9;i++) {
				if(check(row,col,i)) {
					arr[row][col] = i;
					sudoku(row,col+1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		sudoku(row,col+1);
	}
	public static boolean check(int row, int col, int item) {
		
		for(int i = 0;i<9;i++) {// 같은 행에 있는 원소 중 겹치는 게 있는지 확인
			if(arr[row][i]==item) {
				return false;
			}
		}
		for(int i = 0;i<9;i++) { // 같은 열에 있는 원소 중 겹치는 게 있는지 확인
			if(arr[i][col]==item) {
				return false;
			}
		}
		int Rrow = (row/3)*3; // item에 속한 3x3 행의 첫 위치
		int Ccol = (col/3)*3; // item에 속한 3x3 열의 첫 위치
		for(int i = Rrow;i<Rrow+3;i++) {
			for(int j = Ccol;j<Ccol+3;j++) {
				if(arr[i][j]==item) {
					return false;
				}
			}
		}
		return true;
	}
}
