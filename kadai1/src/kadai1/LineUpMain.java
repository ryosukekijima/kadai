package kadai1;
<<<<<<< HEAD

import kadai1.logic.LineUpLogic;

/**
 * ①テキストファイルの並び替え[ファイル内の文字列を引数:昇順、降順をもとに並び替え、別ファイルに出力しなさい。]
 *
 * @author kijima
 *
 */
public class LineUpMain {

	/**
	 * mainメソッド
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// プログラムを呼び出し
		LineUpMain main = new LineUpMain();
		main.load(args);
	}

	/**
	 * LineUpTextFileクラス呼び出し
	 *
	 * @param args
	 */
	private void load(String[] args) {
=======
import kadai1.logic.LineUpLogic;

/**
 * ①テキストファイルの並び替え[ファイル内の文字列を引数:昇順、降順をもとに並び替え、別ファイルに出力しなさい。]
 *
 * @author kijima
 *
 */
public class LineUpMain {

	/**
	 * mainメソッド
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// プログラムを呼び出し
		load(args);
	}

	/**
	 * LineUpTextFileクラス呼び出し
	 *
	 * @param args
	 */
	private static void load(String[] args) {
>>>>>>> branch 'master' of https://github.com/ryosukekijima/kadai.git

		if (args.length == 0 || args == null) {

			System.out.println("引数を入力してください。");
			System.out.println("入力の例 通常モード：１　逆順モード：２");
		} else if (args.length == 1) {

			if (args[0].equals("1") || args[0].equals("2")) {

				// ファイル読み書き実行
				LineUpLogic lineUpextFile = new LineUpLogic();
				lineUpextFile.execute(args);
			} else {

				System.out.println("引数を正しく入力してください。");
				System.out.println("入力の例 通常モード：１　逆順モード：２");
			}
		} else if (args.length >= 2) {

			System.out.println("出力モードの1つを入力してください。");
		}
	}
}
