/**
 * 
 */

/**
 * @author fazekas
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(128);
	}
	
	public static int[][] generate(int N){
		int[][] array = new int[N][N];
		int[] items = new int[4];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				items[0] = N-j-1;
				items[1] = j;
				items[2] = N-i-1;
				items[3] = i;
				array[i][j] = min(items);
				System.out.print(array[i][j]+"\t");
			}
			System.out.print("\n");
		}
		return array;
	}
	
	
	public static int min(int[] items) {
		int min = items[0];
		for(int i = 0; i < items.length; i++) {
			if(items[i] < min) {
				min = items[i];
			}
		}
		return min;
	}
}
