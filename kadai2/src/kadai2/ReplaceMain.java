package kadai2;

import kadai2.logic.ReplaceLogic;

/**
 *
 * @author kijima
 *
 */
public class ReplaceMain {

	/**
	 * mainメソッド 第一引数：検索文字列, 第二引数：置換文字列
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// プログラムを呼び出し
<<<<<<< HEAD
		ReplaceMain main = new ReplaceMain();
		main.load(args);
	}

	/**
	 * SortTextFileクラス呼び出し
	 *
	 * @param args
	 */
	private void load(String[] args) {
=======
		load(args);
	}

	/**
	 * SortTextFileクラス呼び出し
	 *
	 * @param args
	 */
	private static void load(String[] args) {
>>>>>>> branch 'master' of https://github.com/ryosukekijima/kadai.git

		// テキストファイル内文字列の置換
		ReplaceLogic replaceTextFile = new ReplaceLogic();
		replaceTextFile.execute(args);
	}

}
