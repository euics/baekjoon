import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;
    static int[] heart = new int[2];
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            boolean findHeart = false;

            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '*') {
                    boolean bool = true;

                    for (int d = 0; d < 4; d++) {
                        int nx = j + dix[d];
                        int ny = i + diy[d];

                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            if (arr[ny][nx] != '*') {
                                bool = false;
                                break;
                            }
                        }
                    }

                    if (bool) {
                        heart[0] = j;
                        heart[1] = i;
                        findHeart = true;

                        break;
                    }
                }
            }

            if (findHeart) break;
        }

        sb.append(heart[1] + 1).append(" ").append(heart[0] + 1).append("\n");
        int cnt = 0, x = heart[0], y = heart[1];
        while (true) {
            int nx = x + dix[2];
            int ny = y + diy[2];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (arr[ny][nx] == '*') {
                    cnt++;
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        sb.append(cnt).append(" ");

        cnt = 0;
        x = heart[0];
        y = heart[1];
        while (true) {
            int nx = x + dix[3];
            int ny = y + diy[3];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (arr[ny][nx] == '*') {
                    cnt++;
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        sb.append(cnt).append(" ");

        cnt = 0;
        x = heart[0];
        y = heart[1];
        int[] last = new int[2];
        while (true) {
            int nx = x + dix[1];
            int ny = y + diy[1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (arr[ny][nx] == '*') {
                    cnt++;
                    last[0] = nx;
                    last[1] = ny;

                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        sb.append(cnt).append(" ");

        cnt = 1;
        x = last[0] - 1;
        y = last[1] + 1;
        while (true) {
            int nx = x + dix[1];
            int ny = y + diy[1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (arr[ny][nx] == '*') {
                    cnt++;
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        sb.append(cnt).append(" ");

        cnt = 1;
        x = last[0] + 1;
        y = last[1] + 1;
        while (true) {
            int nx = x + dix[1];
            int ny = y + diy[1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (arr[ny][nx] == '*') {
                    cnt++;
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        sb.append(cnt).append(" ");

        System.out.println(sb.toString());
    }
}