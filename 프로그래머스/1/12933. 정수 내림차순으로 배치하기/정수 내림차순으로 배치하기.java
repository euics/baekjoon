import java.util.*;

class Solution {
	public long solution(long n) {
		String string = Long.toString(n)
			.chars()
			.boxed()
			.sorted((a, b) -> b - a)
			.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			.toString();

		return Long.parseLong(string);
	}
}