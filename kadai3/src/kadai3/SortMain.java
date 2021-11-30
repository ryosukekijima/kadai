package kadai3;

import kadai3.logic.SortLogic;

/**
 * ③テキストファイル内の文字列のソート 概要 テキストファイルに出力された文字列（行単位）を独自のロジックでソートし、別ファイルに出力しなさい。
 * なお、昇順、降順は引数で指定することとします。 ※CollectionのソートはNG。
 *
 * @author kijima
 *
 */
public class SortMain {

	/**
	 * mainメソッド
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// プログラムを呼び出し
		SortMain main = new SortMain();
		main.load(args);
	}

	/**
	 * SortTextFileクラス呼び出し
	 *
	 * @param args
	 */
	private void load(String[] args) {

		if (args.length == 0 || args == null) {

			System.out.println("引数を入力してください。");
			System.out.println("入力の例 昇順モード：１　降順モード：２");
		} else if (args.length == 1) {

			if (args[0].equals("1") || args[0].equals("2")) {

				// ファイル読み書き実行
				SortLogic sortTextFile = new SortLogic();
				sortTextFile.execute(args);
			} else {

				System.out.println("引数を正しく入力してください。");
				System.out.println("入力の例 昇順モード：１　降順モード：２");
			}
		} else if (args.length >= 2) {

			System.out.println("出力モードの1つを入力してください。");
		}
	}
}
