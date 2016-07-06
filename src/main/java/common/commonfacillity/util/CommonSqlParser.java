package common.commonfacillity.util;

/**
 * [기능 적으세요.]
 * 
 * @author Bangmaroo
 * @since 2012. 9. 3.
 * @version 1.0
 * @see
 * 
 *      <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2012. 9. 3.   김민규   최초 생성
 * </pre>
 * 
 *      Copyright (C) 2012 by NDS., All right reserved.
 */
public class CommonSqlParser {

	/**
	 * SQL에서 테이블을 Parse하여 리턴한다.
	 * 
	 * @param sql
	 * @return
	 */
	public static String parseTable(String sql) {
		if (sql == null) {
			return null;
		} else {
			String parsedTables = sql
					.toUpperCase()
					.replaceAll("Ｆ|Ｗ|Ｃ", " ")
					.replaceAll("(\\r\\n|\\r|\\n)", " ")	// 개행기호 제거
					.replaceAll("/[^/]*/", " ")				// 주석제거
					.replaceAll("'[^']*'", " ")				// 문자열제거
					.replaceAll("\\(", " (")				// 괄호 띄어쓰기 제거
					.replaceAll("\\)", ") ")				// 괄호 띄어쓰기
					.replaceAll("ORDER BY", " Ｗ ")			
					.replaceAll(" FROM ", " Ｆ ")			// 표시
					.replaceAll("INSERT.*INTO", " Ｆ ")		// 표시
					.replaceAll("SELECT", " Ｗ ")			
					.replaceAll("UPDATE ", " Ｆ ")			// 표시
					.replaceAll(" TABLE", " Ｃ ")			
					.replaceAll(" SET | UNION | WHERE |GROUP BY | HAVING | CONNECT BY | START WITH | MODEL | SAMPLE( )*\\(|USING( )*\\(| ON|\\)|$", " Ｗ ")
					.replaceAll("Ｆ([^Ｆ|Ｗ]+)Ｗ|.", "Ｃ$1").replaceAll("( FULL| LEFT| RIGHT| CROSS| NATURAL| INNER)?( OUTER)? JOIN ", "Ｃ")
					.replaceAll("Ｃ{1,}", "Ｃ")
					.replaceAll("\\([^Ｃ]+Ｃ", "")
					.replaceAll("Ｃ", ",")
					.replaceAll("\\s+", " ")				// 공백 제거
					;
			return parsedTables;
		}
	}
}
