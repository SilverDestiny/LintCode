/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/geohash
@Language: Java
@Datetime: 17-04-02 22:00
*/

public class GeoHash {
    /**
     * @param latitude, longitude a location coordinate pair 
     * @param precision an integer between 1 to 12
     * @return a base32 string
     */
    public String encode(double latitude, double longitude, int precision) {
        // Write your code here
        String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        String lonBin = getBin(longitude, -180, 180);
        String latBin = getBin(latitude, -90, 90);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            sb.append(lonBin.charAt(i));
            sb.append(latBin.charAt(i));
        }
        String codeBin = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < 60; i += 5) {
            sb.append(base32.charAt(Integer.parseInt(codeBin.substring(i, i + 5), 2)));
        }
        return sb.toString().substring(0, precision);
    }
    
    private String getBin(double value, double left, double right) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            double mid = (left + right) / 2;
            if (value <= mid) {
                sb.append(0);
                right = mid;
            } else {
                sb.append(1);
                left = mid;
            }
        }
        return sb.toString();
    }
}