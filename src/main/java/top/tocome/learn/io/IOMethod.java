package top.tocome.learn.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * 常见使用方式
 */
public interface IOMethod {

    /**
     * 字节流普通读写
     */
    static void byteStreamNormalIO(InputStream i, OutputStream o) throws Exception {
        int t;//单次读取的一个字节数据
        while ((t = i.read()) != -1) {//读取一个字节，若到达文件结尾则退出
            o.write(t);//写入输出流
        }
        //关闭流
        i.close();
        o.close();
    }

    /**
     * 字节流缓存读写
     */
    static void byteStreamBufferedIO(InputStream i, OutputStream o) throws Exception {
        byte[] buffer = new byte[8096];//创建8k缓存
        int t;//单次读取到的字节数
        while ((t = i.read(buffer)) != -1) {//读取到t个字节，若到达文件结尾则退出
            o.write(buffer, 0, t);//将读取到的t个字节写入输出流
        }
        //关闭流
        i.close();
        o.close();
    }

    /**
     * 字符流普通读写
     */
    static void CharStreamNormalIO(Reader r, Writer w) throws Exception {
        int t;//单次读取的一个字符数据
        while ((t = r.read()) != -1) {//读取一个字符，若到达文件结尾则退出
            w.write(t);//写入输出流
        }
        //关闭流
        r.close();
        w.close();
    }

    /**
     * 字符流缓存读写
     */
    static void CharStreamBufferedIO(Reader r, Writer w) throws Exception {
        char[] buffer = new char[8096];//创建8k缓存
        int t;//单次读取到的字符数
        while ((t = r.read(buffer)) != -1) {//读取到t个字符，若到达文件结尾则退出
            w.write(buffer, 0, t);//将读取到的t个字符写入输出流
        }
        //关闭流
        r.close();
        w.close();
    }
}
