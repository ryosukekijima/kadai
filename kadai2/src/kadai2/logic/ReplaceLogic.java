package kadai2.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ②テキストファイル内文字列の置換 概要 テキストファイルに出力された文字列を、引数:文字列で置換し、別ファイルに出力しなさい。
 * ※String.replaceは利用は禁止。
 *
 * @author kijima
 *
 */
public class ReplaceLogic {

	/**
	 * 検索値
	 */
	public String searchString;

	/**
	 * 置換値
	 */
	public String replaceString;

	/**
	 * 処理実行
	 *
	 * @param args
	 */
	public void execute(String[] args) {

		// 初期処理
		init(args);

		// 処理開始
		prcessing();
	}

	/**
	 * 初期処理
	 *
	 * @param args
	 */
	private void init(String[] args) {

		// // 検索値入力受付
		// System.out.println("検索する文字を入力してください。");
		// Scanner search = new Scanner(System.in);
		// searchString = search.nextLine();
		// search.close();
		//
		// // 置換値入力受付
		// System.out.println("置換する文字を入力してください。");
		// Scanner replace = new Scanner(System.in);
		// replaceString = replace.nextLine();
		// replace.close();

		// 検索文字列
		searchString = args[0];
		// 置換文字列
		replaceString = args[1];
	}

	/**
	 * テキストファイル内文字列の置換、書き出し
	 */
	private void prcessing() {

		// ファイル読み込み
		String input = readFile();

		// テキストファイル内文字列の置換して書き出し
		writeFile(input);
	}

	/**
	 * ファイル読み込み
	 *
	 * @return
	 * @throws IOException
	 *
	 */
	private String readFile() {

		StringBuffer input = new StringBuffer();
		BufferedReader br = null;
		try {
			File file = new File("/Users/kijima/Desktop/input.txt");
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);

			String text;
			while ((text = br.readLine()) != null) {
				input.append(text);
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

		return input.toString();
	}

	/**
	 * ファイル書き込み
	 *
	 * @param list：読み込んだファイルの1行単位の文字列のリスト
	 */
	private void writeFile(String list) {

		FileWriter filewriter = null;
		try {
			File file = new File("/Users/kijima/Desktop/output.txt");
			filewriter = new FileWriter(file);

			// 文字列置換
			list = replace(list);

			// 書き込み
			filewriter.write(list);
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

	/**
	 * 文字列置換
	 *
	 * @param list
	 * @return
	 */
	private String replace(String list) {

		// 検索文字列の文字数
		int searchStringLength = searchString.length();

		// 入力文字列を1文字ずつ格納
		char[] array = list.toCharArray();

		// 検索文字列を1文字ずつ格納
		char[] searchChar = searchString.toCharArray();

		// 検索文字列が何回出てくるかをカウント
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (searchChar[0] == array[i]) {
				int juge = 0;
				// 検索文字列にヒットするかの判定
				for (int j = 0; j < searchChar.length; j++) {
					if (searchChar[j] == array[i + j]) {
						juge++;
					} else {
						juge = 0;
					}
				}
				if (juge == searchChar.length) {
					count++;
					// 初期化
					juge = 0;
				}
			}
		}

		// 文字列を置換
		for (int i = 0; i < count; i++) {
			// 入力文字列を文字に変換
			array = list.toCharArray();
			for (int j = 0; j < array.length; j++) {
				if (searchChar[0] == array[j]) {
					// 判定
					int juge = 0;
					// 検索文字列にヒットするかの判定
					for (int x = 0; x < searchChar.length; x++) {
						if (searchChar[x] == array[j + x]) {
							juge++;
						} else {
							juge = 0;
						}
					}
					if (juge == searchChar.length) {
						// 文字列の指定範囲の部分文字列を削除する
						StringBuilder sb = new StringBuilder(list);
						sb.delete(j, j + searchStringLength);

						// 文字列に別の文字列を挿入する
						sb.insert(j, replaceString);

						list = sb.toString();
						// 初期化
						juge = 0;
						break;
					}
				}
			}
		}
		return list;
	}
}
