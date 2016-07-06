package foodportal.front.safefoodlife.foodadditive.util;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.util.HtmlUtils;

public class Utility {
	public Utility()
    {
    }

    public static String getCutNumber(String targetStr)
    {
        if(isNull(targetStr))
        {
            return null;
        } else
        {
            Pattern pattern = Pattern.compile("\\d");
            return targetStr.replaceAll(pattern.pattern(), "");
        }
    }

    public static boolean isNull(String s)
    {
        s = trimString(s);
        return s.equals("") || s.equals("null");
    }

    public static String getNull(String s, String c)
    {
        s = trimString(s);
        if(s.equals("") || s.equals("null"))
            return c;
        else
            return s;
    }

    public static String getNull(String s)
    {
        return trimString(s);
    }

    public static int getInt(String s)
    {
        return getInt(s, 0);
    }

    public static int getInt(String s, int i)
    {
        s = trimString(s);
        try
        {
            return Integer.parseInt(s);
        }
        catch(Exception e)
        {
            return i;
        }
    }

    public static long getLong(String s, long i)
    {
        s = trimString(s);
        try
        {
            return Long.parseLong(s);
        }
        catch(Exception e)
        {
            return i;
        }
    }

    public static long getLong(String s)
    {
        return getLong(s, 0L);
    }

    public static String getResourceValue(String filename, String s)
    {
        try
        {
            ResourceBundle resourcebundle = ResourceBundle.getBundle(filename, Locale.getDefault());
            return trimString(resourcebundle.getString(s));
        }
        catch(Exception exception)
        {
            return "";
        }
    }

    public static String trimString(String s)
    {
        if(s == null || s.equals("null"))
            return "";
        else
            return s.trim();
    }

    public static String getFormatNumber(int num)
    {
        NumberFormat nf = NumberFormat.getInstance();
        return nf.format(num);
    }

    public static String replaceAll(String s, String s1, String s2)
    {
        if(s == null)
            return "";
        String s3 = "";
        for(int i = 0; i < s.length(); i++)
        {
            if(i + s1.length() > s.length())
            {
                s3 = (new StringBuilder(String.valueOf(s3))).append(s.substring(i, s.length())).toString();
                return s3;
            }
            if(s.substring(i, i + s1.length()).equals(s1))
            {
                s3 = (new StringBuilder(String.valueOf(s3))).append(s2).toString();
                i = (i + s1.length()) - 1;
            } else
            {
                s3 = (new StringBuilder(String.valueOf(s3))).append(s.substring(i, i + 1)).toString();
            }
        }

        return s3;
    }

    /*
    public static String appendBR(String pm_sString)
    {
        if(pm_sString.toLowerCase().indexOf("<html>") > -1)
            return pm_sString;
        if(pm_sString == null)
            return "";
        BufferedReader lm_oReader = new BufferedReader(new StringReader(pm_sString));
        String lm_sLine = null;
        StringBuffer lm_oBuffer = new StringBuffer();
        try
        {
            while((lm_sLine = lm_oReader.readLine()) != null) 
            {
                if(lm_oBuffer.length() != 0)
                    lm_oBuffer.append("<BR>");
                lm_oBuffer.append(lm_sLine);
            }
            lm_oReader.close();
        }
        catch(Exception exception) { }
        return lm_oBuffer.toString();
    }
    //*/

    public static String getDateFormat(String format)
    {
        return getDateFormat(null, format);
    }

    public static String getDateFormat(Date date, String format)
    {
        String result = "";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        if(date == null)
            date = new Date();
        try
        {
            return formatter.format(date);
        }
        catch(Exception exception)
        {
            return result;
        }
    }

    public static Calendar getDatefromString(String date, String format)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(formatter.parse(date));
            return cal;
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    public static String getCutString(String pm_sString, int pm_iSize)
    {
        return getCutString(pm_sString, pm_iSize, "...");
    }

    public static String getCutString(String pm_sString, int pm_iSize, String pm_sAppend)
    {
        if(pm_sString == null)
            return "";
        String lm_sRetStr = "";
        int lm_iStrSize = 0;
        char charArray[] = pm_sString.toCharArray();
        byte lm_oByteArray[] = pm_sString.getBytes();
        if(lm_oByteArray.length > pm_iSize)
        {
            for(int i = 0; i < pm_sString.length(); i++)
            {
                if(charArray[i] > '\377')
                    lm_iStrSize += 2;
                else
                    lm_iStrSize++;
                if(lm_iStrSize > pm_iSize)
                    break;
                lm_sRetStr = (new StringBuilder(String.valueOf(lm_sRetStr))).append(charArray[i]).toString();
            }

            lm_sRetStr = (new StringBuilder(String.valueOf(lm_sRetStr))).append(pm_sAppend).toString();
            return lm_sRetStr;
        } else
        {
            return pm_sString;
        }
    }

    public static String getDateString(String str)
    {
        String result = str;
        try
        {
            if(str != null && str.length() > 7)
                result = (new StringBuilder(String.valueOf(str.substring(0, 4)))).append(".").append(str.substring(4, 6)).append(".").append(str.substring(6, 8)).toString();
        }
        catch(Exception exception) { }
        return result;
    }

    public static boolean fileChk(String str)
    {
        boolean check1 = false;
        boolean check2 = true;
        str = str.substring(str.lastIndexOf("\\") + 1, str.length());
        str = str.toLowerCase();
        String fileexe1 = "";
        String fileinfo[] = {
            "select", "update", "delete", "modify", "insert", "alter", "create", "replace", "drop", "table", 
            "tablespace", "session", "cookie", "php", "jsp", "asp", "script", "alert"
        };
        String fileExt[] = {
            "ai", "asf", "avi", "mov", "wmv", "mpg", "bmp", "com", "doc", "docx", 
            "gif", "hwp", "jpg", "pdf", "mp3", "png", "ppt", "pps", "pot", "pptx", 
            "rar", "txt", "wav", "xls", "xlsx", "zip"
        };
        try
        {
            for(int i = 0; i < fileinfo.length; i++)
            {
                if(str.indexOf(fileinfo[i]) <= -1)
                    continue;
                check2 = false;
                break;
            }

        }
        catch(Exception exception) { }
        try
        {
            fileexe1 = str.substring(str.lastIndexOf(".") + 1);
        }
        catch(Exception exception1) { }
        try
        {
            for(int i = 0; i < fileExt.length; i++)
            {
                if(!fileexe1.equals(fileExt[i]))
                    continue;
                check1 = true;
                break;
            }

        }
        catch(Exception exception2) { }
        return check1 && check2;
    }

    public static String getSearchText(String content)
    {
        if(content == null)
        {
            return "";
        } else
        {
            content = content.replaceAll("\\&", "");
            content = content.replaceAll("\\-\\-", "");
            content = content.replaceAll("\\%", "");
            content = content.replaceAll("\\+", "");
            content = content.replaceAll("\\-", "");
            content = content.replaceAll("\\;", "");
            return content;
        }
    }

    public static String getRssText(String pm_sSrc)
    {
        if(pm_sSrc == null)
            return "";
        StringBuffer lm_sBuffer = new StringBuffer();
        char charArray[] = pm_sSrc.toCharArray();
        for(int i = 0; i < charArray.length; i++)
            if(charArray[i] == '<')
                lm_sBuffer.append("&lt;");
            else
            if(charArray[i] == '>')
                lm_sBuffer.append("&gt;");
            else
            if(charArray[i] == '&')
                lm_sBuffer.append("&amp;");
            else
            if(charArray[i] != ' ')
                if(charArray[i] == '"')
                    lm_sBuffer.append("&quot;");
                else
                    lm_sBuffer.append(charArray[i]);

        return lm_sBuffer.toString();
    }

    public static String getText(String pm_sSrc)
    {
        if(pm_sSrc == null)
            return "";
        StringBuffer lm_sBuffer = new StringBuffer();
        char charArray[] = pm_sSrc.toCharArray();
        for(int i = 0; i < charArray.length; i++)
            if(charArray[i] == '<')
                lm_sBuffer.append("&lt;");
            else
            if(charArray[i] == '>')
                lm_sBuffer.append("&gt;");
            else
            if(charArray[i] == '&')
                lm_sBuffer.append("&amp;");
            else
            if(charArray[i] == ' ')
                lm_sBuffer.append("&nbsp;");
            else
            if(charArray[i] == '"')
                lm_sBuffer.append("&quot;");
            else
                lm_sBuffer.append(charArray[i]);

        return lm_sBuffer.toString();
    }

    public static String getPersent(int num1, int num2)
    {
        if(num1 > 0 && num2 > 0)
        {
            BigDecimal bnum1 = new BigDecimal(num1);
            bnum1 = bnum1.multiply(new BigDecimal(100));
            BigDecimal bnum2 = new BigDecimal(num2);
            BigDecimal dnum = bnum1.divide(bnum2, 1, 0);
            return String.valueOf(dnum);
        } else
        {
            return "0";
        }
    }

    public static String encode(String str)
    {
        try
        {
            return URLEncoder.encode(str, "UTF-8");
        }
        catch(Exception exception)
        {
            return str;
        }
    }

    public static String decode(String str)
    {
        try
        {
            return URLDecoder.decode(str, "UTF-8");
        }
        catch(Exception exception)
        {
            return str;
        }
    }

    public static String nullToString(String str)
    {
        return nullToString(str, "");
    }

    public static String nullToString(String str, String def)
    {
        if(str == null)
            return def;
        str = str.trim();
        if(str.trim().length() == 0)
            return def;
        if(str.equalsIgnoreCase("null"))
            return def;
        else
            return str;
    }

    public static String[] nullToString(String str[])
    {
        return nullToString(str, "");
    }

    public static String[] nullToString(String str[], String def)
    {
        if(str == null || str.length < 1)
            return new String[0];
        for(int i = 0; i < str.length; i++)
            str[i] = nullToString(str[i], def);

        return str;
    }

    public static int[] getInt(String str[])
    {
        return getInt(str, 0);
    }

    public static int[] getInt(String str[], int def)
    {
        if(str == null || str.length < 1)
            return new int[0];
        int retVal[] = new int[str.length];
        for(int i = 0; i < str.length; i++)
            retVal[i] = getInt(str[i], def);

        return retVal;
    }

    public static long[] getLong(String str[])
    {
        return getLong(str, 0L);
    }

    public static long[] getLong(String str[], long def)
    {
        if(str == null || str.length < 1)
            return new long[0];
        long retVal[] = new long[str.length];
        for(int i = 0; i < str.length; i++)
            retVal[i] = getLong(str[i], def);

        return retVal;
    }

    public static String nl2br(String comment)
    {
        int length = comment.length();
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < length; i++)
        {
            String comp = comment.substring(i, i + 1);
            if("\n".compareTo(comp) == 0)
                buffer.append("<br>");
            else
                buffer.append(comp);
        }

        return buffer.toString();
    }

    public static String getFileExtension(String fileName)
    {
        if(fileName == null || fileName.length() < 2 || fileName.indexOf(".") == -1 || fileName.lastIndexOf(".") + 1 == fileName.length())
            return "";
        else
            return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public static String getFileNameWithoutExtension(String fileName)
    {
        if(fileName == null || fileName.length() < 1)
            return "";
        if(fileName.indexOf(".") == -1 || fileName.lastIndexOf(".") + 1 == fileName.length())
            return fileName;
        else
            return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public static String[] splitFileName(String fileName)
    {
        String retVal[] = new String[2];
        retVal[0] = getFileNameWithoutExtension(fileName);
        retVal[1] = getFileExtension(fileName);
        return retVal;
    }

    public static String eraseTagString(String text)
    {
        String returnText = "";
        if(text == null || text.length() < 1)
            return "";
        int lastIdx = text.lastIndexOf("</html>") != -1 ? text.lastIndexOf("</html>") : text.lastIndexOf("</HTML>");
        if(lastIdx == -1)
            lastIdx = text.length();
        text = text.substring(0, lastIdx);
        char tempText[] = text.toCharArray();
        if(tempText.length < 1)
            return "";
        boolean eraseFlag = false;
        for(int i = 0; i < tempText.length; i++)
        {
            if(tempText[i] == '<')
                eraseFlag = true;
            else
            if(tempText[i] == '>')
                eraseFlag = false;
            if(!eraseFlag && tempText[i] != '>')
                returnText = (new StringBuilder(String.valueOf(returnText))).append(tempText[i]).toString();
        }

        if(eraseFlag)
            return null;
        else
            return returnText;
    }

    public static String[] splitByLength(String src, int len)
    {
        String deSt = "\001";
        for(int i = 0; i < 10; i++)
        {
            if(src.indexOf(deSt) == -1)
                break;
            deSt = (new StringBuilder(String.valueOf(deSt))).append((char)i * 2).toString();
            if(i + 1 == 10)
                return null;
        }

        StringBuffer regExpStr = new StringBuffer();
        for(int i = 0; i < len; i++)
            regExpStr.append('.');

        Pattern p = Pattern.compile(regExpStr.toString());
        Matcher m = p.matcher(src);
        StringBuffer sb = new StringBuffer();
        for(; m.find(); m.appendReplacement(sb, (new StringBuilder(String.valueOf(m.group()))).append(deSt).toString()));
        return sb.toString().split(deSt);
    }

    public static String isNum(String str)
    {
        String return_str = str;
        if(str == null || str.equals("null") || str.equals(""))
            return_str = "0";
        return return_str;
    }

    public static String getCurDate()
    {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String curDate = dateFormatter.format(new Date());
        return curDate;
    }

    public static String getYearHTML(String strObjName, int prevYear, int nextYear)
    {
        int selYear = Integer.parseInt(getCurDate().substring(0, 4));
        return getYearHTML(strObjName, selYear, prevYear, nextYear);
    }

    public static String getYearHTML(String strObjName, String selYear, int prevYear, int nextYear)
    {
        return getYearHTML(strObjName, Integer.parseInt(isNum(selYear)), prevYear, nextYear);
    }

    public static String getYearHTML(String strObjName, int selYear, int prevYear, int nextYear)
    {
        if(prevYear > nextYear)
        {
            int iTemp = prevYear;
            prevYear = nextYear;
            nextYear = iTemp;
        }
        String strYear = " \n";
        int iYear = Integer.parseInt(getCurDate().substring(0, 4));
        strYear = (new StringBuilder(String.valueOf(strYear))).append("\t<select id='").append(strObjName).append("' name='").append(strObjName).append("'> \n").toString();
        for(int i = iYear + prevYear; i <= iYear + nextYear; i++)
        {
            strYear = (new StringBuilder(String.valueOf(strYear))).append("\t\t<option value='").append(i).append("'").toString();
            if(i == selYear)
                strYear = (new StringBuilder(String.valueOf(strYear))).append(" selected").toString();
            strYear = (new StringBuilder(String.valueOf(strYear))).append(">").append(i).append("</option> \n").toString();
        }

        strYear = (new StringBuilder(String.valueOf(strYear))).append("\t</select>&nbsp;\uB144 \n").toString();
        return strYear;
    }

    public static String getDigitFormat(String strTargetCode, int iFormatLength, String strFormatDigit)
    {
        String temp = "";
        for(int i = 0; i < iFormatLength - strTargetCode.length(); i++)
            temp = (new StringBuilder(String.valueOf(temp))).append(strFormatDigit).toString();

        temp = (new StringBuilder(String.valueOf(temp))).append(strTargetCode).toString();
        return temp;
    }

    public static String[] split(String s, String s1)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(s, s1);
        String as[] = new String[stringtokenizer.countTokens()];
        for(int i = 0; i < as.length; i++)
            as[i] = stringtokenizer.nextToken();

        return as;
    }

    public static String crop(String s, int i)
    {
        if(s == null)
            return "";
        else
            return s.substring(0, i);
    }

    public static String rplc(String s, String s1, String s2)
    {
        if(s == null)
            return "";
        String s3 = s;
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("");
        int i;
        for(; s3.indexOf(s1) > -1; s3 = s3.substring(i + s1.length()))
        {
            i = s3.indexOf(s1);
            stringbuffer.append(s3.substring(0, i));
            stringbuffer.append(s2);
        }

        stringbuffer.append(s3);
        return stringbuffer.toString();
    }

    public static String encodeChar(String s, int i)
    {
        switch(i)
        {
        case 1: // '\001'
            s = rplc(s, "'", "''");
            s = rplc(s, "<script", "<x-script");
            s = rplc(s, "</script", "</x-script");
            s = rplc(s, "<iframe", "<x-iframe");
            s = rplc(s, "</iframe", "</x-iframe");
            s = rplc(s, "<xmp", "<x-xmp");
            s = rplc(s, "</xmp", "</x-xmp");
            s = rplc(s, "<title", "<x-title");
            s = rplc(s, "</title", "</x-title");
            s = rplc(s, "<", "&lt;");
            s = rplc(s, "\"", "&quot;");
            break;

        case 2: // '\002'
            s = rplc(s, "  ", "&nbsp;&nbsp;");
            s = rplc(s, "\n", "<br>");
            break;
        }
        return s;
    }

    public static String imgFn(String s, String s1)
    {
        s = encodeChar(s, 2);
        s = rplc(s, "<IMG>", (new StringBuilder("<img src=\"")).append(s1).toString());
        s = rplc(s, "</IMG>", "\">");
        return s;
    }

    public static String htmlEscape(String text)
    {
        return HtmlUtils.htmlEscape(HtmlUtils.htmlUnescape(text));
    }

    public static String htmlUnescape(String text)
    {
        return HtmlUtils.htmlUnescape(text);
    }

    public static String getHtmlToText(String str)
    {
        try
        {
            String convertStr = getNull(str);
            String delString = "";
            int startIdx = convertStr.indexOf("<");
            for(int endIdx = convertStr.indexOf(">"); endIdx > 0; endIdx = convertStr.indexOf(">"))
            {
                delString = convertStr.substring(startIdx, endIdx + 1);
                convertStr = convertStr.replaceAll(delString, "");
                startIdx = convertStr.indexOf("<");
            }

            return convertStr;
        }
        catch(Exception e)
        {
            return str;
        }
    }
}
