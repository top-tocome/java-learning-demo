package top.tocome.learn.util;

public class Time {
    /**
     * 计算程序的运行时间
     *
     * @param program 要运行的程序
     * @param times   运行的次数
     * @return 运行时间
     */
    public static long getRunningTime(Program program, int times) throws Exception {
        //记录开始时间
        long t1 = System.currentTimeMillis();

        //运行times次
        for (int i = 0; i < times; i++) {
            program.run();
        }

        //返回运行时间
        return System.currentTimeMillis() - t1;
    }
}
