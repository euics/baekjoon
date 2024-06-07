class Solution {
	public long solution(int w, int h) {
		long gcd = gcd(w, h);
		long totalSquare = (long) w * h;
		long unusableSquares = w + h - gcd;
		
		return totalSquare - unusableSquares;
	}

	public long gcd(long a, long b) {
		while (b != 0) {
			long tmp = b;
			b = a % b;
			a = tmp;
		}

		return a;
	}
}