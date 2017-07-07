/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/gfs-client
@Language: Java
@Datetime: 17-03-27 00:44
*/

/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */
public class GFSClient extends BaseGFSClient {

    private int chunkSize;
    private HashMap<String, Integer> chunkNum;
    
    public GFSClient(int chunkSize) {
        // initialize your data structure here
        this.chunkSize = chunkSize;
        chunkNum = new HashMap<String, Integer>();
    }
    
    // @param filename a file name
    // @return conetent of the file given from GFS
    public String read(String filename) {
        // Write your code here
        if (!chunkNum.containsKey(filename)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chunkNum.get(filename); i++) {
            sb.append(readChunk(filename, i));
        }
        return sb.toString();
    }

    // @param filename a file name
    // @param content a string
    // @return void
    public void write(String filename, String content) {
        // Write your code here
        if (content == null || content.length() == 0) {
            return;
        }
        int num = (content.length() - 1) / chunkSize + 1;
        chunkNum.put(filename, num);
        for (int i = 0; i < num; i++) {
            int start = i * chunkSize;
            int end = i == num - 1 ? content.length() : start + chunkSize;
            writeChunk(filename, i, content.substring(start, end));
        }
    }
}