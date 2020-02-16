import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7568 {
	static class Data {
		int weight;
		int height;
		int order;

		public Data(int weight, int height, int order) {
			this.weight = weight;
			this.height = height;
			this.order = order;
		}

	}

	static int n;
	static Data[] rst;
	static int[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		rst = new Data[n];
		v = new int[2];

		int w, h;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			rst[i] = new Data(w, h, 1);
		}
		
		for(int i = 0; i < n; i++) {
			compOrder(rst[i], i);
			
		}

		for (Data d : rst) {
			System.out.print(d.order + " ");
		}
	}



	static void compOrder(Data crnt, int idx) {
		Data td;
		int dh, dw;
		for(int i = 0; i < n; i ++) {
			if(i == idx) {
				continue;
			}
			td = rst[i];
			dh = crnt.height - td.height;
			dw = crnt.weight - td.weight;

			if (dh < 0 && dw < 0) {
				crnt.order++;
			}
		}
	}
}
