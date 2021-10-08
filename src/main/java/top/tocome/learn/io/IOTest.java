package top.tocome.learn.io;

import top.tocome.learn.util.Program;
import top.tocome.learn.util.Time;

import java.io.*;

/**
 * io方法测试
 */
public class IOTest {

    public static void main(String[] args) {

        //创建文件
        File txtFile = new File("LICENSE");//文本文件
        File txtFile_copy = new File("LICENSE_copy.txt");//将文本文件复制到该文件
        File binaryFile = new File("image.jpg");//二进制文件
        File binaryFile_copy = new File("image_copy.jpg");//将二进制文件复制到该文件

        int times = 1;//单个程序执行次数
        try {
            //字节流
            run("字节流 普通读写 文本文件", times, () -> IOMethod.byteStreamNormalIO(
                    new FileInputStream(txtFile),
                    new FileOutputStream(txtFile_copy)));
            run("字节流 缓存读写 文本文件", times, () -> IOMethod.byteStreamBufferedIO(
                    new FileInputStream(txtFile),
                    new FileOutputStream(txtFile_copy)));
            run("缓存字节流 普通读写 文本文件", times, () -> IOMethod.byteStreamNormalIO(
                    new BufferedInputStream(new FileInputStream(txtFile)),
                    new BufferedOutputStream(new FileOutputStream(txtFile_copy))));
            run("缓存字节流 缓存读写 文本文件", times, () -> IOMethod.byteStreamBufferedIO(
                    new BufferedInputStream(new FileInputStream(txtFile)),
                    new BufferedOutputStream(new FileOutputStream(txtFile_copy))));
            //字节流可正确读写二进制文件
            run("字节流 普通读写 二进制文件", times, () -> IOMethod.byteStreamNormalIO(
                    new FileInputStream(binaryFile),
                    new FileOutputStream(binaryFile_copy)));
            run("字节流 缓存读写 二进制文件", times, () -> IOMethod.byteStreamBufferedIO(
                    new FileInputStream(binaryFile),
                    new FileOutputStream(binaryFile_copy)));
            run("缓存字节流 普通读写 二进制文件", times, () -> IOMethod.byteStreamNormalIO(
                    new BufferedInputStream(new FileInputStream(binaryFile)),
                    new BufferedOutputStream(new FileOutputStream(binaryFile_copy))));
            run("缓存字节流 缓存读写 二进制文件", times, () -> IOMethod.byteStreamBufferedIO(
                    new BufferedInputStream(new FileInputStream(binaryFile)),
                    new BufferedOutputStream(new FileOutputStream(binaryFile_copy))));

            //字符流
            run("字符流 普通读写 文本文件", times, () -> IOMethod.CharStreamNormalIO(
                    new InputStreamReader(new FileInputStream(txtFile)),
                    new OutputStreamWriter(new FileOutputStream(txtFile_copy))));
            run("字符流 缓存读写 文本文件", times, () -> IOMethod.CharStreamBufferedIO(
                    new InputStreamReader(new FileInputStream(txtFile)),
                    new OutputStreamWriter(new FileOutputStream(txtFile_copy))));
            run("缓存字符流 普通读写 文本文件", times, () -> IOMethod.CharStreamNormalIO(
                    new BufferedReader(new InputStreamReader(new FileInputStream(txtFile))),
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtFile_copy)))));
            run("缓存字符流 缓存读写 文本文件", times, () -> IOMethod.CharStreamBufferedIO(
                    new BufferedReader(new InputStreamReader(new FileInputStream(txtFile))),
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtFile_copy)))));

            //字符流读写二进制文件会损坏文件格式
            run("字符流 普通读写 二进制文件", times, () -> IOMethod.CharStreamNormalIO(
                    new InputStreamReader(new FileInputStream(binaryFile)),
                    new OutputStreamWriter(new FileOutputStream(binaryFile_copy))));
            run("字符流 缓存读写 二进制文件", times, () -> IOMethod.CharStreamBufferedIO(
                    new InputStreamReader(new FileInputStream(binaryFile)),
                    new OutputStreamWriter(new FileOutputStream(binaryFile_copy))));
            run("缓存字符流 普通读写 二进制文件", times, () -> IOMethod.CharStreamNormalIO(
                    new BufferedReader(new InputStreamReader(new FileInputStream(binaryFile))),
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(binaryFile_copy)))));
            run("缓存字符流 缓存读写 二进制文件", times, () -> IOMethod.CharStreamBufferedIO(
                    new BufferedReader(new InputStreamReader(new FileInputStream(binaryFile))),
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(binaryFile_copy)))));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //封装测试输出
    static void run(String name, int times, Program program) throws Exception {
        System.out.println(name + " 执行" + times + "次时间: " + Time.getRunningTime(program, times) + " ms");
    }

    //常用实例创建
    void newInstance() {

        //创建文件
        File txtFile = new File("LICENSE");//文本文件
        File txtFile_copy = new File("LICENSE_copy.txt");//将文本文件复制到该文件

        File binaryFile = new File("image.jpg");//二进制文件
        File binaryFile_copy = new File("image_copy.jpg");//将二进制文件复制到该文件

        //创建流
        try {
            //获取文件字节流
            FileInputStream fis = new FileInputStream(txtFile);
            FileOutputStream fos = new FileOutputStream(txtFile_copy);

            //将普通字节流转换为缓存字节流
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            //将字节流转换成字符流
            InputStreamReader isr = new InputStreamReader(fis);
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            //将普通字符流转换为缓存字符流
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(osw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
