/**
 * 
 */
package labirintus;
import java.util.Arrays;
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
	public static boolean[][] my_array;
	public static int targetX = 5;
	public static int targetY = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		my_array = generate_array();
		int[] x_coordinates = new int[1];
		int[] y_coordinates = new int[1];
		x_coordinates[0] = 0;
		y_coordinates[0] = 0;
		go(0, 0, x_coordinates, y_coordinates);
	}
	
	public static boolean[][] generate_array(){
		boolean[][] array = new boolean[10][10];
		Random random = new Random();
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				array[i][j] = random.nextBoolean();
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
		return array;
	}
	public static boolean in_array(int x, int y, int[] x_coordinates, int[] y_coordinates) {
		for(int i = 0; i < x_coordinates.length; i++) {
			if(x_coordinates[i] == x && y_coordinates[i] == y) {
				return true;
			}
		}
		return false;
	}
	
	public static void go(int x, int y, int[] x_coordinates, int[] y_coordinates) {
		for(int i = 0; i < x_coordinates.length; i++) {
			System.out.print("x: "+x_coordinates[i]+" y: "+y_coordinates[i]+"\n");
		}
		System.out.println("----");
		
		if(x == targetX && y == targetY) {
			for(int i = 0; i < x_coordinates.length; i++) {
				System.out.print("x: "+x_coordinates[i]+"\ty: "+y_coordinates[i]+"\n");
			}
			System.out.println();
		}
		else {
			//Fel
			if(y-1 >= 0 && !in_array(x,(y-1), x_coordinates, y_coordinates) && !my_array[x][y-1]) {
				int[] x_cords = Arrays.copyOf(x_coordinates, x_coordinates.length + 1);
				x_cords[x_cords.length-1] = x;
				
				int[] y_cords = Arrays.copyOf(y_coordinates, y_coordinates.length + 1);
				y_cords[y_cords.length-1] = y-1;
				
				go(x, y-1, x_cords, y_cords);
				x_cords = null;
				y_cords = null;
			}
			//Le
			if(y+1 <= 9 && !in_array(x,(y+1), x_coordinates, y_coordinates) && !my_array[x][y+1]) {
				int[] x_cords = Arrays.copyOf(x_coordinates, x_coordinates.length + 1);
				x_cords[x_cords.length-1] = x;
				
				int[] y_cords = Arrays.copyOf(y_coordinates, y_coordinates.length + 1);
				y_cords[y_cords.length-1] = y+1;
				
				go(x, y-1, x_cords, y_cords);
				x_cords = null;
				y_cords = null;
			}
			//Jobbra
			if(x+1 <= 9 && !in_array(x+1,y, x_coordinates, y_coordinates) && !my_array[x+1][y]) {
				int[] x_cords = Arrays.copyOf(x_coordinates, x_coordinates.length + 1);
				x_cords[x_cords.length-1] = x+1;
				
				int[] y_cords = Arrays.copyOf(y_coordinates, y_coordinates.length + 1);
				y_cords[y_cords.length-1] = y;
				
				go(x+1, y, x_cords, y_cords);
				x_cords = null;
				y_cords = null;
			}
			
			//Balra
			if(x-1 >= 0 && !in_array(x-1,(y), x_coordinates, y_coordinates) && !my_array[x-1][y]) {
				int[] x_cords = Arrays.copyOf(x_coordinates, x_coordinates.length + 1);
				x_cords[x_cords.length-1] = x-1;
				
				int[] y_cords = Arrays.copyOf(y_coordinates, y_coordinates.length + 1);
				y_cords[y_cords.length-1] = y;
				
				go(x-1, y, x_cords, y_cords);
				x_cords = null;
				y_cords = null;
			}
		}
	}

}
