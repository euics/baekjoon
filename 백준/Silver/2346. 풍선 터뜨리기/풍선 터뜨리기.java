import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n= Integer.parseInt(br.readLine());
		ArrayDeque<int[]> q= new ArrayDeque<>();
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			int[] arr= {i+1,Integer.parseInt(st.nextToken())};
			q.add(arr);
		}
		
		while(q.size()>1) {
			int[] arr=q.pollFirst();
			bw.write(arr[0]+" ");
			int k=arr[1];
			if(k>0) {
				for(int j=1;j<k;j++) {
					q.addLast(q.pollFirst());
				}
			}else {
				for(int j=k;j!=0;j++) {
					q.addFirst(q.pollLast());
				}
			}
		}
		bw.write(String.valueOf(q.poll()[0]));
		bw.flush();
		bw.close();
	}
}