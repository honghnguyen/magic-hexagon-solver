import java.util.Arrays;

public class Solver {

	
	public static void main(String[] args) {
		int[] init = new int[19];
		for(int i = 0; i < 19; i++) {
			init[i] = 0;
		}
		Node n = new Node(init, 0);
		n.next();
	}
}
