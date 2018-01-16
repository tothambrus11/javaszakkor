/**
 * 
 */
package labirintus;
import java.util.Random;

/**
 * @author Tóth Ambrus
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
	}
	
	public static boolean[][] generate_array(){
		boolean[][] array = new boolean[10][10];
		Random random = new Random();
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				array[i][j] = random.nextBoolean();
			}
		}
		return array;
	}

}
