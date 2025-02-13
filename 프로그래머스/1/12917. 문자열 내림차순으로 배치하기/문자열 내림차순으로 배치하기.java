import java.util.*;

class Solution {
	public String solution(String s) {
		return s.chars()
			.boxed()
			.sorted((a, b) -> b - a)
			.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			.toString();
	}
}