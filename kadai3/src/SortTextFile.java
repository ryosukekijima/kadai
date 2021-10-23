
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ③テキストファイルの昇順降順入れ替え[ファイル内の文字列を引数:昇順、降順をもとに並び替え、別ファイルに出力しなさい。]
 *
 * @author kijima
 *
 */
public class SortTextFile {

	/**
	 * 昇順モード
	 */
	public static String ASC_MODE = "1";

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

			if (args[0].equals(Consts.ASC_MODE) || args[0].equals(Consts.DESC_MODE)) {

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
		List<String> inputList = readFile();

		if (exeMode.equals(Consts.ASC_MODE)) {

			// ファイルそのまま書き込み
			writeFile(sortAsc(inputList));
		} else if (exeMode.equals(Consts.DESC_MODE)) {

			// ファイル逆順に書き込み
			writeFile(sortDesc(inputList));
		}
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
	 * @param sortAsc
	 */
	private void writeFile(List<String> list) {

		FileWriter filewriter = null;
		try {
			File file = new File("/Users/kijima/Desktop/output.txt");
			filewriter = new FileWriter(file);

			for (String s : list) {
				filewriter.write(s + Consts.CRLF);
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

	/**
	 * 文字列を昇順に並べ替える
	 */
	/**
	 * @param inputStr
	 * @return
	 * @throws IOException
	 *
	 */
	private List<String> sortAsc(List<String> inputList) {

		List<String> outputList = new ArrayList<String>();

		for (String input : inputList) {
			StringBuffer output = new StringBuffer();
			char[] charList = input.toCharArray();

			for (int i = 0; i < charList.length - 1; i++) {
				for (int j = 0; j < charList.length - 1 - i; j++) {
					if (charList[j] > charList[j + 1]) {
						char temp = charList[j];
						charList[j] = charList[j + 1];
						charList[j + 1] = temp;
					}
				}
			}
			outputList.add(output.append(charList).toString());
		}

		return outputList;
	}

	/**
	 * 文字列を降順に並べ替える
	 *
	 * @return
	 */
	private List<String> sortDesc(List<String> inputList) {

		List<String> outputList = new ArrayList<String>();

		for (String input : inputList) {
			StringBuffer output = new StringBuffer();
			char[] charList = input.toCharArray();

			for (int i = 0; i < charList.length - 1; i++) {
				for (int j = 0; j < charList.length - 1 - i; j++) {
					if (charList[j] < charList[j + 1]) {
						char temp = charList[j];
						charList[j] = charList[j + 1];
						charList[j + 1] = temp;
					}
				}
			}
			outputList.add(output.append(charList).toString());
		}

		return outputList;
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
