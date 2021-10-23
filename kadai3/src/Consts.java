/**
 * 定数クラス
 *
 * @author kijima
 *
 */
public class Consts {

	/**
	 * 昇順モード
	 */
	public static String ASC_MODE = "1";

	/**
	 * 降順モード
	 */
	public static String DESC_MODE = "2";

	/**
	 * 改行コード
	 */
	public static String CRLF = System.getProperty("line.separator");

	public static enum EXE_MODE {
		ASC_MODE, DESC_MODE;
	}

}
