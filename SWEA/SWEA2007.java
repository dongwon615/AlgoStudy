import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2007 {
	static boolean done;
	static int rst;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			String s = br.readLine();
			done = false;
			for(int i = 1; i <= 11; i++) {
				isMadi(s.substring(i),s.substring(0, i));
				if(done) break;
			}
			System.out.println("#" + t + " " + rst);
		}
	}
	static void isMadi(String s, String comp) {
		if(s.length() <= comp.length()) {
			done = true;
			rst = comp.length();
			return;
		}
		if(s.startsWith(comp)) {
			isMadi(s.substring(comp.length(),s.length()),comp);
		}
	}
}
