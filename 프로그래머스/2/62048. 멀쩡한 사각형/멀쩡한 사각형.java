class Solution {
	public long solution(int w, int h) {
		long totalSquares = (long)w * h;
		long GCD = GCD((long)w, (long)h);
		long unusableSquares = w + h - GCD;

		return totalSquares - unusableSquares;
	}

	public long GCD(long a, long b) {
		if (b == 0)
			return a;

		return GCD(b, a % b);
	}

	public long LCM(long a, long b) {
		return a * b / GCD(a, b);
	}
}