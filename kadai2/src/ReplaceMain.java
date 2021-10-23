
/**
 *
 * @author kijima
 *
 */
public class ReplaceMain {

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
	 * SortTextFileクラス呼び出し
	 *
	 * @param args
	 */
	private static void load(String[] args) {

		// テキストファイル内文字列の置換
		ReplaceTextFile replaceTextFile = new ReplaceTextFile();
		replaceTextFile.execute();

		// if (args.length == 0 || args == null) {
		//
		// System.out.println("検索 / 置換する文字を入力してください。");
		// } else if (args.length == 1) {
		//
		// System.out.println("置換する文字を入力してください。");
		// } else if (args.length == 2) {
		//
		// // テキストファイル内文字列の置換
		// ReplaceTextFile replaceTextFile = new ReplaceTextFile();
		// replaceTextFile.execute(args);
		// }
	}

}
