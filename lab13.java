

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class lab13 {
	ArrayList<Integer> values;
	public void readData(String filename) {
		values = new ArrayList<Integer>();
		try {
			java.io.BufferedReader input = new java.io.BufferedReader(
					new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String line;
			try {
				while ((line = input.readLine()) != null) {
					values.add(Integer.valueOf(line.trim()));
				}
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public long getTotalCount() {
		return values.stream().count();
	}
	public long getOddCount() {
		return values.stream().filter(x -> x % 2 == 1).count();
	}
	public long getEvenCount() {
		return values.stream().filter(x -> x % 2 == 0).count();
	}
	public long getDistinctGreaterThanFiveCount() {
		return values.stream().distinct().filter(x -> x > 5).count();
	}
	public Integer[] getResult1() {
		return values.stream().filter(x -> x % 2 == 0).filter(x -> x < 50).filter(x -> x > 5).sorted().toArray(Integer[] :: new);
	}
	public Integer[] getResult2() {
		return values.stream().limit(50).map(x -> x * x).map(x -> x * 3).toArray(Integer[] :: new);
	}
	public Integer[] getResult3() {
		return values.stream().filter(x -> x % 2 == 1).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[] :: new);
	}
}
