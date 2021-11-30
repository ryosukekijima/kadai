package kadai1.logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import kadai1.Consts;

/**
 *
 *
 * @author kijima
 *
 */
public class LineUpLogic {

	/**
	 * 実行モード
	 */
	public static String exeMode;

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

		// パラメータチェック
		if (isNotEmpty(args)) {

			if (args[0].equals(Consts.NORMAL_MODE) || args[0].equals(Consts.REVERSE_MODE)) {

				exeMode = args[0];
			} else {
				System.out.println("入力内容が正しくありません。");
				System.out.println("昇順に並べ替えたい場合：1　降順に並べ替えたい場合：2　を入力してください。");
			}
		}
	}

	/**
	 * ファイル内の文字列を並び替え、別ファイルに出力
	 */
	private void prcessing() {
		// ファイル読み込み
		String inputStr = readFile();

		if (exeMode.equals(Consts.NORMAL_MODE)) {

			// ファイルそのまま書き込み
			writeFile(inputStr);
		} else if (exeMode.equals(Consts.REVERSE_MODE)) {

			// ファイル逆順に書き込み
			writeFile(reverseText(inputStr));
		}
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
	 * @param sortAsc
	 */
	private void writeFile(String str) {

		FileWriter filewriter = null;
		try {
			File file = new File("/Users/kijima/Desktop/output.txt");
			filewriter = new FileWriter(file);

			filewriter.write(str);
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
	 * 文字列を逆順にする
	 *
	 * @param inputStr
	 * @return
	 */
	private String reverseText(String str) {

		StringBuffer output = new StringBuffer();
		char[] charList = str.toCharArray();
		for (int i = charList.length - 1; i >= 0; i--) {
			output.append(charList[i]);
		}
		return output.toString();
	}

	/**
	 * isNotEmptyメソッド
	 *
	 * @param val
	 * @return
	 */
	public boolean isNotEmpty(String[] args) {

		if (args == null || args.length == 0) {
			return false;
		}
		return true;
	}
}
