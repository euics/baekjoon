class Solution {
	public int solution(int n, int k) {
		int answer = 0;

		String[] formations = convertFormation(n, k).split("0");
		for(String formation : formations) {
			if(formation.equals("")) continue;

			if(checkPrime(Long.parseLong(formation))) {
				answer++;
			}
		}

		return answer;
	}

	public String convertFormation(int n, int k) {
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			sb.insert(0, n % k);
			n /= k;
		}

		return sb.toString();
	}
	
	public boolean checkPrime(long num) {
		if(num <= 1) return false;
		if(num == 2) return true;
		if(num % 2 == 0) return false;

		for(long i = 3; i * i <= num; i += 2) {
			if(num % i == 0) return false;
		}

		return true;
	}
}