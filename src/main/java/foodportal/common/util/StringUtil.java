package foodportal.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

/**
 * StringUtil
 * @author 박재형
 * @since 2014.08.27
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.08.27 박재형 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */
public final class StringUtil {

    /**
     * 문자열을 파싱해 long 값을 구한다. 파싱에 문제가 있으면 기본값 반환
     * <pre>
     * long n = Util.parseLong("12345", 0); // 12345 반환
     * long x = Util.parseLong("12345L", 0); // 0 반환
     * </pre>
     * @param num 문자열
     * @param defaultVal 오류 발생시 기본값
     * @return 변환된 long 값
     */
    public static long parseLong(String num, long defaultVal) {
        try {
            return Long.parseLong(num);
        } catch (Exception e) {
            return defaultVal;
        }
    }

    /**
     * 문자열을 파싱해 int 값을 구한다. 파싱에 문제가 있으면 기본값 반환
     * <pre>
     * int n = Util.parseInt("12345", 0); // 12345 반환
     * int x = Util.parseInt("0x12345", 0); // 0 반환
     * </pre>
     * @param num 문자열
     * @param defaultVal 오류 발생시 기본값
     * @return 변환된 int 값
     */
    public static int parseInt(String num, int defaultVal) {
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            return defaultVal;
        }
    }

    /**
     * 문자열을 파싱해 double 값을 구한다. 파싱에 문제가 있으면 기본값 반환
     * <pre>
     * double n = Util.parseDouble("+12.345", 0); // 12.345 반환
     * double x = Util.parseDouble("-.123", 0); // -0.123 반환
     * double y = Util.parseDouble(".123.", 0); // 0 반환
     * </pre>
     * @param num 문자열
     * @param defaultVal 오류 발생시 기본값
     * @return 변환된 double 값
     */
    public static double parseDouble(String num, double defaultVal) {
        try {
            return Double.parseDouble(num);
        } catch (Exception e) {
            // Double.parseDouble에 null을 전달하면
            // NumberFormatException이 아니라
            // NullPointerException이 발생한다.....
            return defaultVal;
        }
    }
    
    final private static Pattern digitYmdPattern1 = Pattern.compile("^(\\d+)\\D+(\\d+)\\D+(\\d+)"); // 09/09/09 또는 09-09-09 또는 2009-09-09 또는 2009년 9월 9일 형식
    final private static Pattern digitYmdPattern2 = Pattern.compile("^(\\d{8}|\\d{6})"); // 20090909 또는 090909 형식
    final private static Pattern nameYmdPattern = Pattern.compile("^(\\w+)\\W+(\\w+)\\W+(\\d+)"); // Sep 09 09 또는 09 Sep 09 형식
    final private static Pattern hmsPattern = Pattern.compile("(^|\\b)(\\d{1,2})\\D+(\\d{1,2})(\\D+(\\d{1,2})\\D*)?$"); // 12:34:56 또는 12시 34분 56초 형식
    final private static String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /**
     * 2009-01-01, 20090101, 090101, 09/01/01, Sep 09 09 등 다양한 형식의 날짜, 시간을 자동 인식하여
     * unix 시간으로 반환한다.
     * @param dateStr
     * @param defaultMillis 파싱 오류 발생시 defaultMillis를 반환한다.
     * @return
     */
    public static long parseFuzzyDateTime(String dateStr, long defaultMillis) {
        return parseFuzzyDateTime(dateStr, defaultMillis, false);
    }

    /**
     * 2009-01-01, 20090101, 090101, 09/01/01, Sep 09 09 등 다양한 형식의 날짜, 시간을 자동 인식하여
     * unix 시간으로 반환한다.
     * @param dateStr
     * @param defaultMillis 파싱 오류 발생시 defaultMillis을 반환한다.
     * @param defaultMonthFirst 01-01-2009와 같은 형식일 때 월을 우선하게 한다
     * @return
     */
    public static long parseFuzzyDateTime(String dateStr, long defaultMillis, boolean defaultMonthFirst) {
        final Calendar now = Calendar.getInstance();
        final int currYear = now.get(Calendar.YEAR);

        if (dateStr == null || (dateStr = dateStr.trim()).length() < 6)
            return defaultMillis;

        Matcher matcher;
        int year = -1;
        int month = 0;
        int day = 0;

        if ((matcher = digitYmdPattern1.matcher(dateStr)).find()) {
            int val1 = Integer.parseInt(matcher.group(1));
            int val2 = Integer.parseInt(matcher.group(2));
            int val3 = Integer.parseInt(matcher.group(3));

            if (val3 > 31 || (val1 < 13 && val2 > 12) || (val1 > 12 && val1 < 32 && val2 < 13)) { // val3가 연도인 경우
                year = val3;
                if (val2 > 12) {
                    month = val1 - 1;
                    day = val2;
                } else {
                    month = (defaultMonthFirst ? val1 : val2) - 1;
                    day = (defaultMonthFirst ? val2 : val1);
                }
            } else { // val1이 연도인 경우
                year = val1;
                month = val2 - 1;
                day = val3;
            }

        } else if ((matcher = digitYmdPattern2.matcher(dateStr)).find()) {
            int val = Integer.parseInt(matcher.group(1));
            year = val / 10000;
            month = val % 10000 / 100 - 1;
            day = val % 100;

        } else if ((matcher = nameYmdPattern.matcher(dateStr)).find()) {
            String val1 = matcher.group(1);
            String val2 = matcher.group(2);
            year = Integer.parseInt(matcher.group(3));

            if (val1.length() <= 2) {
                String temp = val2;
                val2 = val1;
                val1 = temp;
            }

            for (int i = 0; i < monthNames.length; i++)
                if (monthNames[i].equals(val1)) {
                    month = i;
                    break;
                }

            day = Integer.parseInt(val2);

        } else
            matcher = null;

        if (year >= 0 && matcher != null) {
            if (year <= currYear % 100)
                year += 2000;
            else if (year < 1000)
                year += 1900;

            int hour = 0, min = 0, sec = 0;

            String hms = dateStr.substring(matcher.group().length()).trim();
            if (hms.length() > 0 && (matcher = hmsPattern.matcher(hms)).find()) {
                hour = Integer.parseInt(matcher.group(2));
                min = Integer.parseInt(matcher.group(3));
                String val = matcher.group(5);
                sec = val != null && val.length() > 0 ? Integer.parseInt(val) : 0;
            }

            Calendar cal = new GregorianCalendar(year, month, day, hour, min, sec);
            return cal.getTimeInMillis();

        } else
            return defaultMillis;
    }

    private final static char[] upperLetters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' }; 
    private final static char[] lowerLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' }; 

    /**
     * Java 식별어 형식의 문자열 만들기. 모든 단어의 첫 글자는 대문자가 되며
     * 언더스코어(_)는 제거된다. 영문 알파벳에 대해서만 처리된다.
     * @param str 원래 문자열
     * @param initialUpper 참이면 원래 문자열의 첫 글자를 대문자로 만든다.
     * @return
     * 아예 이런 명칭 변환에 대해 별도의 클래스로 뽑아내는 것이 어떨지!
     */
    public static String makeJavaName(String str, boolean initialUpper) {
        char[] buf = str.toCharArray();
        int len = buf.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            char c = buf[i];

            if (c == '_') {
                initialUpper = true;
            } else {
                if ( initialUpper ) {
                    buf[count++] = 'a' <= c && c <= 'z' ? upperLetters[c-'a'] : c;
                } else {
                    buf[count++] = 'A' <= c && c <= 'Z' ? lowerLetters[c-'A'] : c;
                }
                initialUpper = false;
            }
        }

        return new String(buf, 0, count);
    }

    static final char[] htmlRaw = { '<', '>', '&', '"', '\'', (char)0xa0 };
    static final String[] htmlEncoded = { "&lt;", "&gt;", "&amp;", "&quot;", "&#39;", "&nbsp;" };
    static final String[] htmlEncoded2 = { "&lt;", "&gt;", "&amp;", "&quot;", "&apos;", "&nbsp;" };

    /**
     * html, xml 태그 등을 있는 그대로 웹페이지에 나타내기 위해 이스케이핑하는 메서드
     * &lt;는 &amp;lt;로, &amp;는 &amp;amp;로, "는 &amp;quot;로 변환한다.
     * @param raw 원래의 html
     * @return 이스케이프된 html
     */
    public static String escapeHTML(String raw) {
        if (raw == null)
            return null;

        int n = raw.length();
        StringBuffer sb = new StringBuffer(n + 100);

        outer:

            for (int i = 0; i < n; i++) {
                char c = raw.charAt(i);

                for (int j = 0; j < htmlRaw.length; j++)
                    if (c == htmlRaw[j]) {
                        sb.append(htmlEncoded[j]);
                        continue outer;
                    }

                sb.append(c);
            }

        return sb.toString();
    }

    final static Pattern htmlEntityPattern = Pattern.compile("&#(\\d+);");

    /**
     * html, xml 인코드된 문자열을 원래의 문자로 변환한다.
     * &amp;lt;는 &lt;로, &amp;amp;는 &amp;로, &amp;quot;는 " 등으로 변환한다.
     * @param raw 원래의 html
     * @return 이스케이프된 html
     */
    public static String unescapeHTML(String encoded) {
        if (encoded == null)
            return null;

        // 먼저 숫자로 인코드된 문자열을 복원
        Matcher m = htmlEntityPattern.matcher(encoded);
        StringBuffer sb = new StringBuffer();

        while (m.find()) {
            char ch = (char) Integer.parseInt(m.group(1)); // 찾은 숫자 문자열을 문자로 변환
            m.appendReplacement(sb, Character.toString(ch));
        }
        m.appendTail(sb);

        // 흔히 사용하는 기호 복원
        // TODO htmlEncoded에 들어있는 값의 순서에 따라 결과가 달라질 수 있으므로 수정 필요
        for (int i = 0; i < htmlEncoded2.length; i++) {
            int occ = 0;
            int start = 0;
            encoded = htmlEncoded2[i];
            int encodedLen = encoded.length();

            while (-1 != (occ = sb.indexOf(encoded, start))) {
                String replace = Character.toString(htmlRaw[i]);
                sb.replace(occ, occ + encodedLen, replace);
                start = occ + replace.length();
            }
        }

        return sb.toString();
    }

    /**
     * html, xml에서 태그를 걷어내는 메서드. &nbsp;를 빈칸으로 바꾸고 무조건 &lt;부터 &gt; 사이의
     * 내용을 걷어내므로 정확한 결과가 나오지 않을 수 있다.
     * @param raw   원래의 html
     * @return      태그가 제거된 htmls
     */
    public static String stripHTMLSimple( String raw ) {
        if ( raw == null )
            return null;

        int n = raw.length();
        StringBuffer sb = new StringBuffer( n + 100 );

        for ( int i=0; i<n; i++ ) {
            char c = raw.charAt(i);
            if ( c=='<' ) {
                do i++;
                while ( i<n && raw.charAt(i)!='>' );

            } else
                sb.append( c );
        }

        return StringUtil.replace(StringUtil.replace(sb.toString(), "&nbsp;", " "), "&nbsp", " ");
    }

    /**
     * 배열의 값들을 연결하여 문자열로 만든다. null인 값은 연결되지 않는다. StringBuffer를 사용하지 않고
     * char 배열을 직접 처리하는데 20% 이상 속도 향상이 있는 것 같다.
     * <pre>
     * String[] values = { "I", "am", "a", "boy" };
     * String result = Util.joinArray(" ", values); // "I am a boy" 반환
     * </pre> 
     * @param values 연결할 값의 배열
     * @param delimiter 연결점마다 반복해서 끼워넣을 문자열. null이면 끼워넣지 않는다.
     * @return 새로운 문자열
     */
    public static String joinArray(String delimiter, Object... values) {
        if (values == null || values.length == 0)
            return "";

        String[] stringValues = new String[values.length];
        int delimiterLen = delimiter == null ? 0 : delimiter.length();
        int length = delimiterLen * (values.length - 1);

        for (int i = 0; i < values.length; i++) {
            if (values[i] != null)
                length += (stringValues[i] = values[i].toString()).length();
        }

        char[] delim;
        if (delimiterLen > 0) {
            delim = new char[delimiterLen];
            delimiter.getChars(0, delimiterLen, delim, 0);
        } else
            delim = null;

        char[] buf = new char[length];
        length = stringValues[0].length();
        stringValues[0].getChars(0, length, buf, 0);

        for (int i = 1; i < stringValues.length; i++) {
            String s = stringValues[i];
            if (s != null) {
                if (delimiterLen > 0) {
                    System.arraycopy(delim, 0, buf, length, delimiterLen);
                    length += delimiterLen;
                }
                s.getChars(0, s.length(), buf, length);
                length += s.length();
            }
        }

        return new String(buf);
    }

    /**
     * 한 문자열을 반복하여 연결한 새로운 문자열 만들기. StringBuffer를 사용하지 않고
     * char 배열을 직접 처리하는데 20% 이상 속도 향상이 있는 것 같다.
     * <pre>
     * String s = Util.repeat("?", 5, ", "); // "?, ?, ?, ?, ?" 반환
     * </pre>
     * @param s 반복할 문자열
     * @param count 반복 횟수
     * @param delimiter 연결점마다 반복해서 끼워넣을 문자열. null이면 끼워넣지 않는다.
     * @return 
     */
    public static String repeat(String s, int count, String delimiter) {
        if (s == null || count <= 0)
            return "";

        int delimiterLen = delimiter == null ? 0 : delimiter.length();
        int strLen = s.length();
        int length = delimiterLen * (count - 1) + strLen * count;

        char[] delim;
        if (delimiterLen > 0) {
            delim = new char[delimiterLen];
            delimiter.getChars(0, delimiterLen, delim, 0);
        } else
            delim = null;

        char[] buf = new char[length];
        char[] str = new char[strLen];
        s.getChars(0, strLen, str, 0);

        length = strLen;
        System.arraycopy(str, 0, buf, 0, length);

        for (int i = 1; i < count; i++) {
            if (delimiterLen > 0) {
                System.arraycopy(delim, 0, buf, length, delimiterLen);
                length += delimiterLen;
            }
            System.arraycopy(str, 0, buf, length, strLen);
            length += strLen;
        }

        return new String(buf);
    }

    /**
     * 문자열에서 특정 부분 문자열을 전부 다른 문자열로 치환하는 메서드
     * 
     * @param orig 원래의 문자열
     * @param o 찾을 문자열
     * @param n 새로 대치하는 문자열
     * @return 변환된 문자열
     */
    public static String replace(String orig, String o, String n) {
        return replace(orig, o, n, false);
    }

    /**
     * 문자열에서 특정 부분 문자열을 전부 다른 문자열로 치환하는 메서드
     * 
     * @param orig 원래의 문자열
     * @param o 찾을 문자열
     * @param n 새로 대치하는 문자열
     * @param ignoreCase 대소문자 구별 여부
     * @return 변환된 문자열
     */
    public static String replace(String orig, String o, String n, boolean ignoreCase) {
        if (orig == null || orig.length() == 0 || o == null || o.length() == 0 || n == null)
            return orig;

        int olen = o.length();
        StringBuffer sb = new StringBuffer(olen + 100);
        int occ = 0;
        int start = 0;
        String newOrig = ignoreCase ? orig.toLowerCase() : orig;
        if (ignoreCase)
            o = o.toLowerCase();

        while (-1 != (occ = newOrig.indexOf(o, start))) {
            sb.append(orig.substring(start, occ));
            sb.append(n);
            start = occ + olen;
        }

        sb.append(orig.substring(start));
        return sb.toString();
    }

    private static final Pattern tagPattern = Pattern.compile("&lt;(/?)(\\w+)\\b([^>]*+)(>?)", Pattern.DOTALL);
    private static final Pattern goodTags = Pattern.compile("^string|b|em|i|strike|u|"
            + "li|br|sup|sub|blockquote|tbody|thead|tfoot|div|span|code|pre|address|"
            + "h[1-6]|dd|dl|dt|cite|abbr|acronym|bdo|dfn|fieldset|kbd|legend|samp|"
            + "small|tt|var|big$");
    private static final Pattern attribPattern = Pattern.compile("\\s(\\w+)(?:\\s*=\\s*(\"[^\"]*(?:\"|$)|'[^']*(?:'|$)|[^\"'\\s]+))?", Pattern.DOTALL);
    private static final Pattern goodAttribs = Pattern.compile("^title|dir|lang$");
    private static final HashMap<String, Pattern> goodTagsWithAttribs = new HashMap<String, Pattern>();
    private static final String[][] tagsWithAttribs = {
        {"a", "^rel|rev|charset|hreflang|tabindex|accesskey|type|name|href|target|title$"},
        {"ol", "^type|compact$"},
        {"ul", "^type|compact$"},
        {"table", "^border|cellspacing|cellpadding|width|frame|rules|height|align|summary|bgcolor|background|bordercolor$"},
        {"tr", "^rowspan|width|height|align|valign|bgcolor|background|bordercolor$"},
        {"td", "^colspan|rowspan|width|height|align|valign|bgcolor|background|bordercolor|scope$"},
        {"th", "^colspan|rowspan|width|height|align|valign|scope$"},
        {"hr", "^size|noshade$"},
        {"font", "^face|size|color$"},
        {"del", "^datetime|cite$"},
        {"ins", "^datetime|cite$"},
        {"map", "^name$"},
        {"area", "^shape|coords|href|alt|target$"},
        {"col", "^align|char|charoff|span|valign|width$"},
        {"colgroup", "^align|char|charoff|span|valign|width$"},
        {"label", "^for$"},
        {"optgroup", "^label|disabled$"},
        {"option", "^disabled|label|selected|value$"},
        {"q", "^cite$"},
        {"img", "^longdesc|usemap|src|border|alt|title|hspace|vspace|width|height|align$"}
    };
    static {
        for (int i = 0; i < tagsWithAttribs.length; i++)
            goodTagsWithAttribs.put(tagsWithAttribs[i][0], Pattern.compile(tagsWithAttribs[i][1]));
    };

    /**
     * 허용된 태그가 아니면 <를 &lt;로 바꾸고 속성은 제거하는 메서드.
     * 또한 태그, 속성 이름은 모두 소문자로 변환된다.
     * @param html
     * @return
     */
    public static String sanitizeHtml(String html) {
        // 일단 모든 <를 &lt;로 바꿔 태그가 아닌 것들이 잘 처리되도록 한다.
        html = replace(html, "<", "&lt;");

        Matcher m = tagPattern.matcher(html);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String tag = m.group(2).toLowerCase();
            String rest = m.group(3);

            StringBuffer sb2 = new StringBuffer("<").append(m.group(1)).append(tag);
            Pattern p = goodTagsWithAttribs.get(tag);
            if (p != null) {
                Matcher m2 = attribPattern.matcher(rest);
                while (m2.find()) {
                    String attrib = m2.group(1).toLowerCase();
                    String value = m2.group(2);
                    if ((attrib.equals("href") || attrib.equals("src")) && badProtocolsIn(value)) {
                        sb2.append(" ").append(attrib).append("=\"#\"");
                        continue;
                    }
                    if (goodAttribs.matcher(attrib).matches() || p.matcher(attrib).matches()) {
                        appendAttrib(sb2, attrib, value);
                    }
                }
                sb2.append(m.group(4));
            } else if (goodTags.matcher(tag).matches()) {
                Matcher m2 = attribPattern.matcher(rest);
                while (m2.find()) {
                    String attrib = m2.group(2).toLowerCase();
                    String value = m2.group(2);
                    if (goodAttribs.matcher(attrib).matches()) {
                        appendAttrib(sb2, attrib, value);
                    }
                }
                sb2.append(m.group(4));
            } else {
                sb2 = new StringBuffer("&lt;").append(m.group(1)).append(tag).append("&gt;");
            }

            m.appendReplacement(sb, sb2.toString());
        }
        m.appendTail(sb);

        return sb.toString();
    }

    private static boolean badProtocolsIn(String value) {
        if (value.charAt(0) == '"' || value.charAt(0) == '\'')
            value = value.substring(1);

        value = unescapeHTML(value).trim();
        String[] protocols = {"javascript:", "vbscript:", "about:"};
        for (int i = 0; i < protocols.length; i++)
            if (value.regionMatches(true, 0, protocols[i], 0, protocols[i].length()))
                return true;

        return false;
    }

    private static void appendAttrib(StringBuffer buf, String attrib, String val) {
        buf.append(" ").append(attrib).append("=").append(val);
        if (val.charAt(0) == '"') {
            if (val.charAt(val.length() - 1) != '"')
                buf.append('"');
        } else if (val.charAt(0) == '\'') {
            if (val.charAt(val.length() - 1) != '\'')
                buf.append('\'');
        }
    }

    /**
     * [날짜]
     * 주어진 java.sql.Date객체에서 해당 연도를 구해서 return해주는 메서드.
     * @return int 해당 연도.
     */
    public static int getYear() {
        java.util.Date date = new java.util.Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(calendar.YEAR);
    }

    /**
     * [날짜]
     * 주어진 java.sql.Date객체에서 해당 월을 구해서 return해주는 메서드.
     * @return int 해당 월.
     */
    public static int getMonth() {
        java.util.Date date = new java.util.Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(calendar.MONTH) + 1;
    }

    /**
     * [날짜]
     * 주어진 java.sql.Date객체에서 해당 날짜를 구해서 return해주는 메서드.
     * @return int 해당 날짜
     */
    public static int getDay() {
        java.util.Date date = new java.util.Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(calendar.DAY_OF_MONTH);
    }
    
    /**
     * [날짜]
     * 주어진 java.sql.Date객체에서 해당 시간을 구해서 return해주는 메서드.
     * 24시간 단위로 리턴
     * @return int 해당 날짜
     */
    public static int getHour() {
        java.util.Date date = new java.util.Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(calendar.HOUR_OF_DAY);
    }

    /**
     * [날짜]
     * 주어진 String에서 해당 연도를 구해서 return해주는 메서드.
     * @param date String
     * @return String 해당 연도.
     */
    public static String getYear(String date) {
        String s = nullToStr(date);
        String year = "";
        
        if (s.length() == 6) {
            year = s.substring(0, 2);
        }
      
        if (s.length() == 8) {
            year = s.substring(0, 4);
        }

        return year;
    }

    /**
     * [날짜]
     * 주어진 String객체에서 해당 월을 구해서 return해주는 메서드.
     * @param date String
     * @return String 해당 월.
     */
    public static String getMonth(String date) {
        String s = nullToStr(date);
        String year = "";
      
        if (s.length() == 6) {
            year = s.substring(2, 4);
        }

        if (s.length() == 8) {
            year = s.substring(4, 6);
        }
        
        return year;
    }

    /**
     * [날짜]
     * 주어진 String객체에서 해당 날짜를 구해서 return해주는 메서드.
     * @param date String
     * @return String 해당 날짜
     */
    public static String getDay(String date) {
        String s = nullToStr(date);
        String year = "";
      
        if (s.length() == 6) {
            year = s.substring(4);
        }
      
        if (s.length() == 8) {
            year = s.substring(6);
        }
      
        return year;
    }
    
    /**
     * 값이 null이면 화면에 default값 리턴
     * @param   obj     대상 오브젝트
     * @param   value   Null일 경우 대치할 문자열
     * @return  String  Null이 아닌 문자열
    */
    public static String NVLToSpace(Object obj){
        return (obj == null ? "" : obj.toString().trim());
    }
    
    /**
     * [기타]
     * Object를 스트링으로 변환후 null이면 공백을 넘겨준다.
     * @param s 문자열
     * @return String 변환된 String
     */
    public static String nullToStr(String s) {
        return (s == null ? "" : s.trim());
    }
    
    /**
     * [기타]
     * Object를 스트링으로 변환후 default값을 넘겨준다.
     * @param s 문자열
     * @return String 변환된 String
     */
    public static String nullToStr(String s, String defaultS) {
        String str = nullToStr(s);
        return (str.equals("")? nullToStr(defaultS) : str); 
    } 
    
    /**
     * [기타]
     * String을 int로 바꾸어 return 한다.
     * String이 숫자형식이 아니거나 null인경우 숫자 0을 넘겨준다.
     * @param s1 숫자형식의 String
     * @return int 변환된 int
     */
    public static int nullToZero(String s1) {
        String s = nullToStr(s1);
        DecimalFormat myFormatter = new DecimalFormat();
        
        try {
            int result = myFormatter.parse(s).intValue();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }  

    /**
     * [기타]
     * String을 int로 바꾸어 return 한다.
     * String이 숫자형식이 아니거나 null인경우 숫자 0을 넘겨준다.
     * @param s1 숫자형식의 String
     * @return int 변환된 int
     */
    public static double nullToZeroD(String s1) {
        String s = nullToStr(s1);
        DecimalFormat myFormatter = new DecimalFormat();

        try {
            double result = myFormatter.parse(s).doubleValue();
            return result;
        } catch (Exception e) {
            return 0.0;
        }
    }       

    /**
     * [기타]
     * String이 숫자형식이 아니거나 null인경우 숫자 0을 넘겨준다.
     * @param s1 숫자형식의 String
     * @return String
     */
    public static String nullToZeroStr(String s1) {
        String str = nullToStr(s1);
        return (str.equals("")? "0" : str); 
    } 
    
    /**
     * 숫자체크
     *
     * @param s the string
     * @return true if it is
     */
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * @name CheckBizNo
     * @contents 사업자 등록 번호 유효성 체크
     * @param bbNum
     * @return
     */
    public static boolean CheckBizNo(Object bbNum){
        int sum = 0;
        
        String bNumber = bbNum.toString();
        
        sum += Integer.valueOf(bNumber.substring(0, 1));
        sum += Integer.valueOf(bNumber.substring(1, 2)) * 3 % 10;
        sum += Integer.valueOf(bNumber.substring(2, 3)) * 7 % 10;
        sum += Integer.valueOf(bNumber.substring(3, 4)) * 1 % 10;
        sum += Integer.valueOf(bNumber.substring(4, 5)) * 3 % 10;
        sum += Integer.valueOf(bNumber.substring(5, 6)) * 7 % 10;
        sum += Integer.valueOf(bNumber.substring(6, 7)) * 1 % 10;
        sum += Integer.valueOf(bNumber.substring(7, 8)) * 3 % 10;
        sum += Math.floor(Integer.valueOf(bNumber.substring(8, 9)) * 5 / 10);
        sum += Integer.valueOf(bNumber.substring(8, 9)) * 5 % 10;
        sum += Integer.valueOf(bNumber.substring(9, 10));
        
        return (sum % 10 == 0);
    } 
    
    /**
     * @name checkDateType
     * @contents 날짜 시간 유효성 체크(1990년 부터 2037년 까지)
     * @param date
     * @return
     */
    public static boolean CheckDateType(Object date){
        boolean result = false;
        int minYear = 1990;     //최소년도
        int maxYear = 2037;     //최대년도
        String year = "";
        String patten = "";     // 시간 포함 해서 유효성 체크 여부
        
        if(getTxtValue(date).length() > 0){
            if(date.toString().length() <= 6){
                patten = "yyyyMM";
            }else if(date.toString().length() <= 8){
                patten = "yyyyMMdd";
            }else if(date.toString().length() <= 12){
                patten = "yyMMddHHmmss";
            }else if(date.toString().length() <= 14){
                 patten = "yyyyMMddHHmmss";
            }
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        sdf.setLenient(false);
        
        try{
            Date formatDate = sdf.parse(date.toString());
            
            year = date.toString().substring(0, 4);
            
            if(Integer.parseInt(year) < minYear || Integer.parseInt(year) > maxYear){
                result = false;
            }else{
                result = true;
            }
        }catch(Exception e){
            result = false;
        }
        
        return result;
    }
    
    /**
     * @name checkDateType
     * @contents 날짜 시간 유효성 체크(minYear, maxYear 파라미터로 받음)
     * @param date
     * @return
     */
    public static boolean CheckDateType(String date, int minYear, int maxYear){
        boolean result = false;
        String year = "";
        String patten = "";     // 시간 포함 해서 유효성 체크 여부
        
        if(getTxtValue(date).length() > 0){
            if(date.length() <= 6){
                patten = "yyyyMM";
            }else if(date.length() <= 8){
                patten = "yyyyMMdd";
            }else if(date.length() <= 12){
                patten = "yyMMddHHmmss";
            }else if(date.length() <= 14){
                 patten = "yyyyMMddHHmmss";
            }
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        sdf.setLenient(false);
        
        try{
            Date formatDate = sdf.parse(date);
            
            year = date.substring(0, 4);
            
            if(Integer.parseInt(year) < minYear || Integer.parseInt(year) > maxYear){
                result = false;
            }else{
                result = true;
            }
        }catch(Exception e){
            result = false;
        }
        
        return result;
    }
    
    /**
     * @name getTxtValue
     * @contents Object 값 null 체크 후 공백 돌려주고 아니면 String Type 변환 후 반환
     * @param value
     * @return
     */
    public static String getTxtValue(Object value){
        String retunVal = "";
        if(value != null){
            retunVal = value.toString().trim();
        }
        return retunVal;
    } 
    
    /**
     * @name getFoarmater
     * @contents 텍스트 포멧 변경
     * @param str
     * @param type
     * @return
     */
    public static String getFoarmater(String str, String type){
        MessageFormat megFmtStr = null; 
        String[] arrStr = null;
        
        if(type.equals("serial")){
            if(str.length() == 20){
                megFmtStr = new MessageFormat("{0}-{1}-{2}-{3}-{4}");
                arrStr = new String[5];
                arrStr[0] = str.substring(0, 2);
                arrStr[1] = str.substring(2, 7);
                arrStr[2] = str.substring(7, 12);
                arrStr[3] = str.substring(12, 14);
                arrStr[4] = str.substring(14, 20);
            }else{
                return str;
            }
        }else if(type.equals("offserial")){
            if(str.length() == 20){
                megFmtStr = new MessageFormat("{0}-{1}-{2}-{3}-{4}");
                arrStr = new String[5];
                arrStr[0] = str.substring(0, 2);
                arrStr[1] = str.substring(2, 3);
                arrStr[2] = str.substring(3, 8);
                arrStr[3] = str.substring(8, 14);
                arrStr[4] = str.substring(14, 20);
            }else{
                return str;
            }
        }else if(type.equals("datetime")){
            if(str.length() == 14){
                megFmtStr = new MessageFormat("{0}/{1}/{2} {3}:{4}:{5}");
                arrStr = new String[6];
                arrStr[0] = str.substring(0, 4);
                arrStr[1] = str.substring(4, 6);
                arrStr[2] = str.substring(6, 8);
                arrStr[3] = str.substring(8, 10);
                arrStr[4] = str.substring(10, 12);
                arrStr[5] = str.substring(12, 14);
            }else{
                return str;
            }
        }else if(type.equals("date")){
            if(str.length() == 8){
                megFmtStr = new MessageFormat("{0}/{1}/{2}");
                arrStr = new String[3];
                arrStr[0] = str.substring(0, 4);
                arrStr[1] = str.substring(4, 6);
                arrStr[2] = str.substring(6, 8);
            }else{
                return str;
            }   
        }else if(type.equals("buySerialNo")){
            if(str.length() == 20){
                megFmtStr = new MessageFormat("{0}-{1}-{2}-{3}-{4}");
                arrStr = new String[5];
                arrStr[0] = str.substring(0, 2);
                arrStr[1] = str.substring(2, 7);
                arrStr[2] = str.substring(7, 12);
                arrStr[3] = str.substring(12, 14);
                arrStr[4] = str.substring(14, 20);
            }else{
                return str;
            }       
        }else if(type.equals("phone")){
            if(str.length() <= 11){
                megFmtStr = new MessageFormat("{0}){1}-{2}");
                arrStr = new String[3];
                arrStr[0] = str.substring(0, 3);
                arrStr[1] = str.substring(3, 6);
                arrStr[2] = str.substring(6, 10);
            }else{
                return str;
            }           
        }else if(type.equals("cardno")){
            if(str.length() == 16){
                megFmtStr = new MessageFormat("{0}-{1}-{2}-{3}");
                arrStr = new String[4];
                arrStr[0] = str.substring(0, 4);
                arrStr[1] = str.substring(4, 8);
                arrStr[2] = str.substring(8, 12);
                arrStr[3] = str.substring(12, 16);
            }else{
                return str;
            }
        }else if(type.equals("comno")){
            if(str.length() == 10){
                megFmtStr = new MessageFormat("{0}-{1}-{2}");
                arrStr = new String[3];
                arrStr[0] = str.substring(0, 3);
                arrStr[1] = str.substring(3, 5);
                arrStr[2] = str.substring(5, 10);
            }else{
                return str;
            }
        }
        str = megFmtStr.format(arrStr);
        return str; 
    }
    
    /**
     * 백분율 형식에 부합하는지 체크
     * @param1 String(target)
     * @param2 String(소수점 자리수)
     * @return boolean
     */
    public static boolean isPercent(String s, String point){
        String regex = "^(100)(\\.[0]{0,"+point+"})?$|^([0-9]{1,2})(\\.[0-9]{0,"+point+"})?$";
        
        return Pattern.matches(regex, s);
    }
    
    /**
     * 이메일 형식에 부합하는지 체크
     * @param String s(target)
     * @return boolean
     */
    public static boolean isEmail(String s){
        String regex = "^([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\\.[0-9a-zA-Z_-]+){1,2}$";
        
        return Pattern.matches(regex, s);
    }
    
    
    /**
     * 전화번호/핸드폰 형식에 부합하는지 체크
     * @param String s(target)
     * @return boolean
     */
    public static boolean isPhoneNumber(String s){
        String regex = "^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-[0-9]{3,4}-[0-9]{4}$";
        
        return Pattern.matches(regex, s);
    }
    
    /**
     * 우편번호 형식에 부합하는지 체크
     * @param String s(target)
     * @return boolean
     */
    public static boolean isZipCode(String s){
        String regex = "^[1-9][0-9]{2}-[0-9]{3}$";
        
        return Pattern.matches(regex, s);
    }
    
    /**
     * 한글인지 체크(뛰어쓰기 사용가능)
     * @param String s(target)
     * @return boolean
     */
    public static boolean isHanglUseSpace(String s){
        String regex = "^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣\\s+]*$";
        
        return Pattern.matches(regex, s);
    }
    
    /**
     * 한글이면 오류 체크(뛰어쓰기 사용가능)
     * @param String s(target)
     * @return boolean
     */
    public static boolean isHanglNotUseSpace(String s){
        String regex = "^[^(ㄱ-ㅎ|ㅏ-ㅣ|가-힣)+]*$";
        
        return Pattern.matches(regex, s.replaceAll(" ", ""));
    }
    
    /**
     * 영문인지 체크(뛰어쓰기 사용가능)
     * @param String s(target)
     * @return boolean
     */
    public static boolean isEnglUseSpace(String s){
        String regex = "^[A-Za-z0-9+]*$";
        
        return Pattern.matches(regex, s.replaceAll(" ", ""));
    }
    
    
    
    /**
     * 특수문자를 제거 후 반환한다.
     * @param String s(target)
     * @return String (replace)
     */
    public static String replaceSpecialChar(String s){
        String regex = "[~#$^&*=+|:;?\"<>']";
        
        String regex2 = "\\";//원화표시제거
        
        String regex3 = "replace";//replace
        
        String regex4 = "iframe";//iframe
        
        if(s != null){
            s = s.toString().replaceAll(regex, "").trim();
            s = s.toString().replace(regex2, "").trim();
            s = s.toString().replace(regex3, "").trim();
            s = s.toString().replace(regex4, "").trim();
        }else{
            s = "";
        }
        return s;
    }
    
    /**
     * 특수문자를 제거 후 반환한다.
     * @param Object s(target)
     * @return String (replace)
     */
    public static String replaceSpecialChar(Object obj){
        String regex = "[~#$^&*=+|:;?\"<>']";//특수문자
        
        String regex2 = "\\";//원화표시제거
        
        String regex3 = "replace";//replace
        
        String regex4 = "iframe";//iframe
        
        if(obj != null){
            obj = obj.toString().replaceAll(regex, "").trim();
            obj = obj.toString().replace(regex2, "").trim();
            obj = obj.toString().replace(regex3, "").trim();
            obj = obj.toString().replace(regex4, "").trim();
        }else{
            obj = "";
        }
        return (String) obj;
    }

    /**
     * 메시지
     * @param response
     * @param msg
     * @return
     * @throws IOException
     */
    public static String alertRedirect(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html; charset=\"utf-8\"");
        response.getWriter().println("<script type=\"text/javascript\">alert('"+msg+"'); history.back();</script>");
        response.getWriter().flush();
        response.getWriter().close();
        return  "redirect:/";
    }
    
    /**
     * 메시지2
     * @param response
     * @param msg
     * @param url
     * @return
     * @throws IOException
     */
    public static String alertRedirect(HttpServletResponse response, String msg, String url) throws IOException {
        return  "redirect:/"+url;
    }
    
    /**
     * 금액형식인지 체크(숫자체크랑 같으나 0이면 false 리턴)
     * @param s
     * @return
     */
    public static boolean isCash(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        if("0".equals(s.substring(0, 1))){
            return false;
        }
        return true;
    }
    /*
    public ArrayList<HashMap<String, String>> getClobData(ArrayList<HashMap<String, String>> list, String[] strKey){

    	try {
			for(int i=0;i<list.size();i++){
				HashMap map = list.get(i);
				for(int k=0; k<strKey.length; k++){
					if(map.get(strKey[k]) != null && !"".equals(map.get(strKey[k]).toString())){
						Clob clob = 	(Clob) map.get(strKey[k]);
						//String info = clob.stringValue();
						String str = clobToString(clob);
						map.put(strKey[k], str);
						list.set(i, map);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

    	return list;
    }
    */
    
    /**
     * clob -> string
     * @param clob
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public static String clobToString(Clob clob) throws SQLException, IOException {
    	if (clob == null) {
    		return "";
    	}
    	StringBuffer strOut = new StringBuffer();
    	String str = "";
    	BufferedReader br = new BufferedReader(clob.getCharacterStream());
    	while ((str = br.readLine()) != null) {
    		strOut.append(str);
    	}
    	return strOut.toString();
    }

    /**
     * clob -> string
     * @param clob
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public static String clobToString(Object clob) throws SQLException, IOException {
    	if (clob == null) {
    		return "";
    	}
    	StringBuffer strOut = new StringBuffer();
    	String str = "";
    	Clob clobN = (Clob) clob;
    	BufferedReader br = new BufferedReader(clobN.getCharacterStream());
    	while ((str = br.readLine()) != null) {
    		strOut.append(str);
    	}
    	return strOut.toString();
    }

    
}
