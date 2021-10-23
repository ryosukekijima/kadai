
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ②テキストファイル内文字列の置換 概要 テキストファイルに出力された文字列を、引数:文字列で置換し、別ファイルに出力しなさい。
 * ※String.replaceは利用は禁止。
 *
 * @author kijima
 *
 */
public class ReplaceTextFile {

	/**
	 * 検索値
	 */
	public String searchValue;

	/**
	 * 置換値
	 */
	public String replaceValue;

	/**
	 * 処理実行
	 */
	public void execute() {

		// 初期処理
		init();

		// 処理開始
		prcessing();
	}

	/**
	 * 初期処理
	 *
	 * @param args
	 */
	private void init() {

		// 検索値入力受付
		System.out.println("検索する文字を入力してください。");
		Scanner search = new Scanner(System.in);
		searchValue = search.nextLine();
		search.close();

		// 置換値入力受付
		System.out.println("置換する文字を入力してください。");
		Scanner replace = new Scanner(System.in);
		replaceValue = replace.nextLine();
		replace.close();
	}

	/**
	 * テキストファイル内文字列の置換、書き出し
	 */
	private void prcessing() {

		// ファイル読み込み
		List<String> inputList = readFile();

		// テキストファイル内文字列の置換して書き出し
		writeFile(inputList);
	}

	/**
	 * ファイル読み込み
	 *
	 * @return
	 * @throws IOException
	 *
	 */
	private List<String> readFile() {

		List<String> inputList = new ArrayList<String>();
		BufferedReader br = null;
		try {
			File file = new File("/Users/kijima/Desktop/input.txt");
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);

			String text;
			while ((text = br.readLine()) != null) {
				inputList.add(text);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ファイルを閉じる
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}

		return inputList;
	}

	/**
	 * ファイル書き込み
	 *
	 * @param list：読み込んだファイルの1行単位の文字列のリスト
	 */
	private void writeFile(List<String> list) {

		FileWriter filewriter = null;
		try {
			File file = new File("/Users/kijima/Desktop/output.txt");
			filewriter = new FileWriter(file);

			// 書き込みようの文字列リスト
			List<String> newString = new ArrayList<String>();

			for (String s : list) {

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

				// 検索文字列にヒットした場合に、置換
				for (String split : splitString) {
					if (split.equals(searchValue)) {
						// 文字列置換

					}
				}

				// filewriter.write(s + Consts.CRLF);
			}

			filewriter.flush();
		} catch (IOException e) {

			System.out.println(e);
		} finally {
			// ファイルを閉じる
			if (filewriter != null) {
				try {
					filewriter.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
