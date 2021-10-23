
import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {

		// ファイルの一行
		String s = "こんにちは、いい天気ですね。";

		// 検索文字列
		String searchValue = "いい";

		// 読み込んだファイルの1行の文字列の長さ
		int inputLength = s.toCharArray().length;

		// 検索文字列の長さ
		int searchLength = searchValue.toCharArray().length;

		// ファイルの文字列を検索文字数分に分割
		List<String> splitString = new ArrayList<String>();
		char[] c = s.toCharArray();
		for (int i = 0; i <= inputLength - searchLength; i++) {
			StringBuilder buff = new StringBuilder();
			for (int j = i; j < i + searchLength; j++) {
				buff.append(c[j]);
			}
			splitString.add(buff.toString());
		}

		for (String split : splitString) {
			System.out.println(split);
		}
	}

}
