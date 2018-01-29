import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Node {
	int[] numbers_;
	int id_;
	final int SUM_ = 38;

	protected Node(int[] value, int id) {
		numbers_ = new int[19];
		for(int i = 0; i < 19; i++) {
			numbers_[i] = value[i];
		}
		id_ = id;
	}
	
	protected boolean contain(int[] list, int i) {
		for(int j : list) {
			if(i == j) {
				return true;
			}
		}
		return false;
	}
	
	protected void next() {
		/*System.out.println("id: " + id_);*/
		
		if(id_ == 19) {
			if(check()) {
				System.out.println("Solution found: ");
				for(int i : numbers_) {
					System.out.print(i + " ");
				}
				System.out.println(" ");
				System.out.println("--------------");
				//System.exit(0);
			}
			return;
		}
		
		//if not possible
		if(!possible()) {
			/*System.out.println("Not possible");
			for(int i : numbers_) {
				System.out.print(i + " ");
			}*/
			return;
		}
		
		for(int i = 1; i <= 19; i++) {
			if (!contain(numbers_,i)) {
				this.numbers_[id_] = i;
				Node new_node = new Node(numbers_, id_ + 1);
				new_node.next();
			}
		}

	}
	 //to eliminate expensive branches
	protected boolean possible() {
		List<int []> lines = new ArrayList<int[]>();
		lines.add(new int[]{numbers_[0],numbers_[1],numbers_[2]});
		lines.add(new int[]{numbers_[0],numbers_[3],numbers_[7]});
		lines.add(new int[]{numbers_[16],numbers_[17],numbers_[18]});
		lines.add(new int[]{numbers_[11],numbers_[15],numbers_[18]});
		lines.add(new int[]{numbers_[7],numbers_[12],numbers_[16]});
		lines.add(new int[]{numbers_[2],numbers_[6],numbers_[11]});
		lines.add(new int[]{numbers_[3],numbers_[4],numbers_[5],numbers_[6]});
		lines.add(new int[]{numbers_[12],numbers_[13],numbers_[14],numbers_[15]});
		lines.add(new int[]{numbers_[1],numbers_[4],numbers_[8],numbers_[12]});
		lines.add(new int[]{numbers_[6],numbers_[10],numbers_[14], numbers_[17]});
		lines.add(new int[]{numbers_[3],numbers_[8],numbers_[13], numbers_[17]});
		lines.add(new int[]{numbers_[1],numbers_[5],numbers_[10], numbers_[15]});
		lines.add(new int[]{numbers_[2],numbers_[5],numbers_[9], numbers_[13],numbers_[16]});
		lines.add(new int[]{numbers_[7],numbers_[8],numbers_[9], numbers_[10],numbers_[11]});
		lines.add(new int[]{numbers_[0],numbers_[4],numbers_[9], numbers_[14],numbers_[18]});
		
		
		for(int[] line : lines) {
			if(sum(line) > 38) {
				return false;
			}
			if(sum(line) != 38 && !(contain(line,0))) {
				return false;
			}
		}
		return true;
	}
	
	protected int sum(int[] n) {
		int total = 0;
		for(int i : n) {
			total += i;
		}
		return total;
	}
	
	protected boolean check() {
		if (check3(numbers_) && check4(numbers_) && check5(numbers_)) {
			return true;
		}
		return false;
	}
	
	protected boolean check3(int[] n) {
		if (n[0] + n[1] + n[2] == SUM_
			&& n[0] + n[3] + n[7] == SUM_
			&& n[11] + n[15] + n[18] == SUM_
			&& n[7] + n[12] + n[16] == SUM_
			&& n[2] + n[6] + n[11] == SUM_
			&& n[16] + n[17] + n[18] == SUM_) {
			return true;
		}
		return false;
	}
	
	protected boolean check4 (int[] n ) {
		if(n[3] + n[4] + n[5] + n[6] == SUM_
				&& n[12] + n[13] + n[14] + n[15] == SUM_
				&& n[1] + n[4] + n[8] + n[12]  == SUM_
				&& n[6] + n[10] + n[14] + n[17]  == SUM_
				&& n[3] + n[8]  + n[13] + n[17]  == SUM_
				&& n[1] + n[5] + n[10] +  n[15]  == SUM_) {
			return true;
		}

		return false;
	}
	
	protected boolean check5 (int[] n) {
		if(n[7] + n[8] + n[9] + n[10] + n[11] == SUM_
				&& n[2] + n[5] + n[9] + n[13] + n[16] == SUM_
				&& n[0] + n[4] + n[9] + n[14] + n[18] == SUM_) {
			return true;
		}

		return false;
	}

}
