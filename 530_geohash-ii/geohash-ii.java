/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/geohash-ii
@Language: Java
@Datetime: 17-04-02 22:38
*/

public class GeoHash {
    /**
     * @param geohash a base32 string
     * @return latitude and longitude a location coordinate pair
     */
    public double[] decode(String geohash) {
        // Write your code here
        String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        double[] lon = {-180, 180};
        double[] lat = {-90, 90};
        int[] mask = {16, 8, 4, 2, 1};
        boolean flag = true;
        
        for (char c : geohash.toCharArray()) {
            int val = base32.indexOf(c);
            for (int i = 0; i < 5; i++) {
                if (flag) {
                    refine(lon, val, mask[i]);
                } else {
                    refine(lat, val, mask[i]);
                }
                flag = !flag;
            }
        }
        double[] location = {(lat[0] + lat[1]) / 2, (lon[0] + lon[1]) / 2};
        return location;
    }
    
    private void refine(double[] interval, int val, int mask) {
        if ((val & mask) > 0) {
            interval[0] = (interval[0] + interval[1]) / 2;
        } else {
            interval[1] = (interval[0] + interval[1]) / 2;
        }
    }
}