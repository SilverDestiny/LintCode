/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/url-parser
@Language: Java
@Datetime: 17-03-23 21:33
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HtmlParser {
    /**
     * @param content source code
     * @return a list of links
     */
    private static final String HTML_HREF_TAG_PATTERN = "\\s*(?i)href\\s*=\\s*\"?'?([^\"'>\\s]*)";
    /**
     * @param content source code
     * @return a list of links
     */
    public List<String> parseUrls(String content) {
        // Write your code here
        List<String> links = new ArrayList<String>();
        Pattern pattern = Pattern.compile(HTML_HREF_TAG_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        String url = null;
        while (matcher.find()) {
            url = matcher.group(1);
            if (url.length() == 0 || url.startsWith("#"))
                continue;
            links.add(url);
        }
        return links;
    }
}
