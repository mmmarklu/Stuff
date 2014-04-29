import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class GeneratePermutations {

	static public Set<String> dict = new HashSet<String>(Arrays.asList(new String[] { "mark", "kram", "ulkram" }));  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gen("", "marklu");

	}
	
	public static void gen(String lhs, String rhs){
		//if (rhs.length()==0){
			if (dict.contains(lhs)){
				System.out.println(lhs);
			}
		
		//else {
			for (int i = 0; i < rhs.length(); i++){
				gen(lhs+rhs.charAt(i), rhs.substring(0,i) + rhs.substring(i+1, rhs.length()) );
			}
		//}
	}

}
