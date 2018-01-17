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
	public static int targetX = 1;
	public static int targetY = 1;
	public static int best_way = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		my_array = generate_array();
		int[] x_coordinates = new int[1];
		int[] y_coordinates = new int[1];
		x_coordinates[0] = 0;
		y_coordinates[0] = 0;
		go(0, 0, x_coordinates, y_coordinates, 0);
		if(best_way == 0) {
			System.out.println("Nincs út a célponthoz!");
		}
	}
	public static void print_tabs(int number) {
		for(int i = 0; i < number; i++) {
			System.out.print("\t");
		}
	}
	public static boolean[][] generate_array(){
		boolean[][] array = new boolean[10][10];
		Random random = new Random();
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				array[i][j] = random.nextBoolean();
				System.out.print((array[i][j] ? "_-_-_-_-" : "") +"\t");
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
	
	public static void go(int x, int y, int[] x_coordinates, int[] y_coordinates, int count_recursion) {
		/*for(int i = 0; i < x_coordinates.length; i++) {
			System.out.print("x: "+x_coordinates[i]+" y: "+y_coordinates[i]+"\n");
		}
		System.out.println("----");*/
		
		if(x == targetX && y == targetY) {
			System.out.println("Találat:");
			for(int i = 0; i < x_coordinates.length; i++) {
				System.out.print("x: "+x_coordinates[i]+"\ty: "+y_coordinates[i]+"\n");
			}
			System.out.println("--END TALÁLAT--");
			best_way = x_coordinates.length;
		}
		else {
			print_tabs(count_recursion);
			System.out.println("--DÖNTÉSEK KEZDETE--");
			//Fel
			if(y-1 >= 0 && !in_array(x,(y-1), x_coordinates, y_coordinates) && !my_array[x][y-1]) {
				print_tabs(count_recursion);
				System.out.println("\tLehet felfele menni.");
				int[] x_cords = Arrays.copyOf(x_coordinates, x_coordinates.length + 1);
				x_cords[x_cords.length-1] = x;
				
				int[] y_cords = Arrays.copyOf(y_coordinates, y_coordinates.length + 1);
				y_cords[y_cords.length-1] = y-1;
				
				go(x, y-1, x_cords, y_cords, count_recursion+1);
				x_cords = null;
				y_cords = null;
			}
			else {
				print_tabs(count_recursion);
				System.out.println("\tNem lehet felfele mennni.");
			}
			//Le
			if(y+1 <= 9 && !in_array(x,(y+1), x_coordinates, y_coordinates) && !my_array[x][y+1]) {
				print_tabs(count_recursion);
				System.out.println("\tLehet lefele menni.");
				int[] x_cords = Arrays.copyOf(x_coordinates, x_coordinates.length + 1);
				x_cords[x_cords.length-1] = x;
				
				int[] y_cords = Arrays.copyOf(y_coordinates, y_coordinates.length + 1);
				y_cords[y_cords.length-1] = y+1;
				
				go(x, y-1, x_cords, y_cords, count_recursion+1);
				x_cords = null;
				y_cords = null;
			}
			else {
				print_tabs(count_recursion);
				System.out.println("\tNem lehet lefele mennni.");
			}
			
			//Jobbra
			if(x+1 <= 9 && !in_array(x+1,y, x_coordinates, y_coordinates) && !my_array[x+1][y]) {
				print_tabs(count_recursion);
				System.out.println("\tLehet jobbra menni.");
				int[] x_cords = Arrays.copyOf(x_coordinates, x_coordinates.length + 1);
				x_cords[x_cords.length-1] = x+1;
				
				int[] y_cords = Arrays.copyOf(y_coordinates, y_coordinates.length + 1);
				y_cords[y_cords.length-1] = y;
				
				go(x+1, y, x_cords, y_cords, count_recursion+1);
				x_cords = null;
				y_cords = null;
			}
			else {
				print_tabs(count_recursion);
				System.out.println("\tNem lehet jobbra mennni.");
			}
			
			//Balra
			if(x-1 >= 0 && !in_array(x-1,(y), x_coordinates, y_coordinates) && !my_array[x-1][y]) {
				print_tabs(count_recursion);
				System.out.println("\tLehet balra menni.");
				int[] x_cords = Arrays.copyOf(x_coordinates, x_coordinates.length + 1);
				x_cords[x_cords.length-1] = x-1;
				
				int[] y_cords = Arrays.copyOf(y_coordinates, y_coordinates.length + 1);
				y_cords[y_cords.length-1] = y;
				
				go(x-1, y, x_cords, y_cords, count_recursion+1);
				x_cords = null;
				y_cords = null;
			}
			else {
				print_tabs(count_recursion);
				System.out.println("\tNem lehet balra mennni.");
			}
			print_tabs(count_recursion);
			System.out.println("--DÖNTÉSEK VÉGE--");
			
		}
	}

}
