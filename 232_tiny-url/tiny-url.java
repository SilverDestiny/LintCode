/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/tiny-url
@Language: Java
@Datetime: 17-03-27 01:53
*/

public class TinyUrl {
    /**
     * @param url a long url
     * @return a short url starts with http://tiny.url/
     */
    private HashMap<String, String> l2s = new HashMap<String, String>();
    private HashMap<String, String> s2l = new HashMap<String, String>();
    private String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
     
    public String longToShort(String url) {
        // Write your code here
        if (l2s.containsKey(url)) {
            return l2s.get(url);
        }
        Random random = new Random();
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append("http://tiny.url/");
            while (sb.length() < 22) {
                sb.append(chars.charAt(random.nextInt(62)));
            }
            String surl = sb.toString();
            if (!s2l.containsKey(surl)) {
                l2s.put(url, surl);
                s2l.put(surl, url);
                return surl;
            }
        }
    }

    /**
     * @param url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String url) {
        // Write your code here
        if (!s2l.containsKey(url)) {
            return null;
        }
        return s2l.get(url);
    }
}