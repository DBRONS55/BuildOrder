import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class buildOrder {
	
	public List<Character> buildOrder(char[][] processes){
		Set<Character> tempMarks = new HashSet<Character>();
		Set<Character> permMarks = new HashSet<Character>();
		List<Character> results = new LinkedList<Character>();
		
		for (int i = 0; i < processes.length; i++){
			if(!permMarks.contains(i)){
				visit(i, processes, tempMarks, permMarks, results);
			}
		}
		return results;
	}
	public void visit(int process,
					  char[][] processes,
					  Set<Character> tempMarks,
					  Set<Character> permMarks,
					  List<Character> results){
		if(tempMarks.contains(process)) throw new RuntimeException();
		if(!permMarks.contains(process)){
			tempMarks.add((char)process);
			for(int i : processes[process]){
				visit(i, processes, tempMarks, permMarks, results);
			}
		}
		permMarks.add((char)process);
		tempMarks.remove(process);
		results.add((char)process);
	}
}