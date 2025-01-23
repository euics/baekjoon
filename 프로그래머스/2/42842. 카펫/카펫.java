class Solution {
	public int[] solution(int brown, int yellow) {
		for (int height = 3; ; height++) {
			for (int width = 3; width * height <= brown + yellow; width++) {
				int y = (height - 2) * (width - 2);
				int b = (height * width) - y;

				if (b == brown && y == yellow) {
					return new int[] {width, height};
				}
			}
		}
	}
}