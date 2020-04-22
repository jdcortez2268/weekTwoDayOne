
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Lambdas {
	
	public static int helperMethod(String one, String two) {
		
		if(one.charAt(0) == 'e') {
			return -1;
		}
		return 1;
	}

	
	public static void main(String args[]) {
		
		List<String> stringList = Arrays.asList("joseph", "jose", "cat", "car", "pizza", "i","e", "everybody", "ant");
		
		//first task to sort in ascending length of string
		Collections.sort(stringList, (stringOne, stringTwo) -> stringOne.length() - stringTwo.length());
		//second task to sort in descending length
		Collections.sort(stringList, (stringOne, stringTwo) -> stringTwo.length() - stringOne.length());
		
		//third task to sort alphabetically by first character only
		Collections.sort(stringList, (stringOne, stringTwo) -> stringOne.charAt(0) - stringTwo.charAt(0));
		
		//fourth task to return strings that contain e first, everything else second
		Collections.sort(stringList, (stringOne, stringTwo) ->{
		
		if(stringOne.charAt(0) == 'e') {
			return -1;
		}
		return 1;
	});
		
		//fifth task to return strings that contain e first, everything else second.  do this with static method
		Collections.sort(stringList, (stringOne, stringTwo)-> helperMethod(stringOne, stringTwo));
		
		//sixth task to write a method that returns a comma seperated string given list of integers
		//and prefix letter e if number is even, and prefix letter o if number is odd 
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		String modifiedIntList = intList.stream()
				.map(i -> String.valueOf(i))
				.map(i-> {
					if(Integer.parseInt(i) %2 ==0) {
						String even = "e";
						return even + i;
					}else {
						String odd = "o";
						return odd + i;
					}
				})
				.collect(Collectors.joining(","));
		
		//last task to write a method that returns a list of all strings that start with letter a 
		//and have exactly 3 letters
		List<String> threeLetterAList = stringList.stream()
								.filter(word -> word.length() == 3)
								.filter(word -> word.startsWith("a"))
								.collect(Collectors.toList());
		
		
		
		System.out.println(stringList);
		System.out.println(modifiedIntList);
		System.out.println(threeLetterAList);

}
}
