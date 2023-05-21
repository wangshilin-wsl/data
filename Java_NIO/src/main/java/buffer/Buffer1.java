package buffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Buffer1.java
 * @Description TODO
 * @createTime 2022年08月13日 22:42:00
 */
public class Buffer1 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\王世林\\Desktop\\test.txt", "rw");
        final FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);

        int byteRead = inChannel.read(buf);

        while (byteRead != -1){
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get()); // read 1 byte at a time
            }

            buf.clear();
            byteRead = inChannel.read(buf);
        }
        aFile.close();
    }


}
