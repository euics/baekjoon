class Solution {
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		m = replaceSharp(m);
		int maxLength = Integer.MIN_VALUE;

		for (String musicInfo : musicinfos) {
			int musicLength = changeTime(musicInfo.split(",")[1]) - changeTime(musicInfo.split(",")[0]);

			StringBuilder sb = new StringBuilder();
			String melody = replaceSharp(musicInfo.split(",")[3]);
			for (int i = 0; i < musicLength; i++)
				sb.append(melody.charAt(i % melody.length()));

			if (sb.toString().contains(m) && maxLength < musicLength) {
				maxLength = musicLength;
				answer = musicInfo.split(",")[2];
			}
		}

		return answer;
	}

	public String replaceSharp(String melody) {
		return melody
			.replace("A#", "H")
			.replace("B#", "I")
			.replace("C#", "J")
			.replace("D#", "K")
			.replace("F#", "L")
			.replace("G#", "M");
	}

	public int changeTime(String time) {
		return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
	}
}