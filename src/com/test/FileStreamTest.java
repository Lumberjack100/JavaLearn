package com.test;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;;
import java.io.IOException;

/**
 * FileInputStream 和FileOutputStream 测试程序
 *
 * @author skywang
 */
public class FileStreamTest {

    private static final String FileName = "file.txt";

    public static void main(String[] args) {
        testWrite();
        testRead();
    }

    /**
     * FileOutputStream 演示函数
     * <p>
     * 运行结果：
     * 在源码所在目录生成文件"file.txt"，文件内容是“abcdefghijklmnopqrstuvwxyz0123456789”
     * <p>
     * 加入，我们将 FileOutputStream fileOut2 = new FileOutputStream(file, true);
     * 修改为 FileOutputStream fileOut2 = new FileOutputStream(file, false);
     * 然后再执行程序，“file.txt”的内容变成"0123456789"。
     * 原因是：
     * (01) FileOutputStream fileOut2 = new FileOutputStream(file, true);
     * 它是以“追加模式”将内容写入文件的。即写入的内容，追加到原始的内容之后。
     * (02) FileOutputStream fileOut2 = new FileOutputStream(file, false);
     * 它是以“新建模式”将内容写入文件的。即删除文件原始的内容之后，再重新写入。
     */
    private static void testWrite() {
        try {
            // 创建文件“file.txt”对应File对象
            File file = new File(FileName);
            // 创建文件“file.txt”对应的FileOutputStream对象，默认是关闭“追加模式”
            FileOutputStream fileOut1 = new FileOutputStream(file);
            // 创建FileOutputStream对应的PrintStream，方便操作。PrintStream的写入接口更便利
            PrintStream out1 = new PrintStream(fileOut1);
            // 向“文件中”写入26个字母
            out1.print("abcdefghijklmnopqrstuvwxyz");
            out1.close();

            // 创建文件“file.txt”对应的FileOutputStream对象，打开“追加模式”
            FileOutputStream fileOut2 = new FileOutputStream(file, true);
            // 创建FileOutputStream对应的PrintStream，方便操作。PrintStream的写入接口更便利
            PrintStream out2 = new PrintStream(fileOut2);
            // 向“文件中”写入"0123456789"+换行符
            out2.println("0123456789");
            out2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileInputStream 演示程序
     */
    private static void testRead() {
        try {
            // 方法1：新建FileInputStream对象
            // 新建文件“file.txt”对应File对象
            File file = new File(FileName);
            FileInputStream fileInputStream = new FileInputStream(file);

            // 测试read()，从中读取一个字节
            char c1 = (char) fileInputStream.read();
            System.out.println("c1=" + c1);

            // 测试skip(long byteCount)，跳过4个字节
            fileInputStream.skip(25);

            // 测试read(byte[] buffer, int byteOffset, int byteCount)
            byte[] buf = new byte[2];
            fileInputStream.read(buf, 0, buf.length);
            System.out.println("buf1=" + (new String(buf)));

            buf = new byte[2];
            fileInputStream.read(buf, 0, buf.length);
            System.out.println("buf2=" + (new String(buf)));


            fileInputStream.close();


            FileInputStream fileInputStream2 = new FileInputStream(file);
            byte[] readBytes = new byte[10];
            int len;
            while ((len = fileInputStream2.read(readBytes, 0, 10)) != -1) {
                byte[] tempBytes;
                if (len < readBytes.length) {
                    tempBytes = new byte[len];
                    System.arraycopy(readBytes, 0, tempBytes, 0, len);
                } else
                    tempBytes = readBytes;

                System.out.println("tempBytes=" + (new String(tempBytes)));
            }
            fileInputStream2.close();


            FileInputStream fileInputStream3 = new FileInputStream(file);

            int readBytesCount = 0;
            do {
                byte[] readBytes2 = new byte[10];
                readBytesCount = fileInputStream3.read(readBytes2, 0, readBytes2.length);
                if (readBytesCount >= readBytes2.length)//未读完数据
                {
                    //数据流读取中
                } else if (readBytesCount > 0) {
                    byte[] tempBytes = new byte[readBytesCount];
                    System.arraycopy(readBytes2, 0, tempBytes, 0, tempBytes.length);
                    readBytes2 = tempBytes;
                    readBytesCount = 0;
                } else//数据读完了
                {
                    break;
                }
//                offset += readBytesCount;//数据偏移
                System.out.println("readBytes2=" + (new String(readBytes2)));

            }
            while (readBytesCount > 0);
            fileInputStream3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
