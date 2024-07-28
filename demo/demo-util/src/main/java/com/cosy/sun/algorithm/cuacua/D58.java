package com.cosy.sun.algorithm.cuacua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 智能手机方便了我们生活的同时，也侵占了我们不少的时间。“手机App防沉迷系统”能够让我们每天合理的规划手机App使用时间，在正确的时间做正确的事。
 * 它的大概原理是这样的：
 * 1、在一天24小时内，可注册每个App的允许使用时段；
 * 2、一个时段只能使用一个App，举例说明：不能同时在09:00-10:00注册App2和App3；
 * 3、App有优先级，数值越高，优先级越高。注册使用时段时，如果高优先级的App时间和低优先级的时段有冲突，则系统会自动注销低优先级的时段；如果App的优先级相同，则后添加的App不能注册。
 * 举例1：
 * （1）注册App3前：
 * （2）App3注册时段和App2有冲突：
 * （3）App3优先级高，系统接受App3的注册，自动注销App2的注册：
 * 举例2：
 * （1）注册App4：
 * （2）App4和App2及App3都有冲突，优先级比App2高，但比App3低，这种场景下App4注册不上，最终的注册效果如下：
 * 4、一个App可以在一天内注册多个时段。
 * 请编程实现，根据输入数据注册App，并根据输入的时间点，返回该时间点可用的App名称，如果该时间点没有注册任何App，请返回字符串"NA"。
 * 输入描述：
 * 输入分3部分：第一行表示注册的App数N（N≤100）；第二部分包括N行，每行表示一条App注册数据；最后一行输入一个时间点，程序即返回该时间点的可用App。
 * 2
 * App1 1 09:00 10:00
 * App2 2 11:00 11:30
 * 09:30
 * 数据说明如下：
 * 1、N行注册数据以空格分隔，四项数据依次表示：App名称、优先级、起始时间、结束时间
 * 2、优先级1-5，数字值越大，优先级越高
 * 3、时间格式HH:MM，小时和分钟都是两位，不足两位前面补0
 * 4、起始时间需小于结束时间，否则注册不上
 * 5、注册信息中的时间段包含起始时间点，不包含结束时间点
 * 输出描述：
 * 输出一个字符串，表示App名称，或NA表示空闲时间。
 * 补充说明：
 * 1、用例保证时间都介于00:00-24:00之间；
 * 2、用例保证数据格式都是正确的，不用考虑数据输入行数不够、注册信息不完整、字符串非法、优先级超限、时间格式不正确的问题。
 * 示例1
 * 输入：
 * 1
 * App1 1 09:00 10:00
 * 09:30
 * 输出：
 * App1
 * 说明：
 * App1注册在9点到10点间，9点半可用的应用名是App1
 */
public class D58 {

    static class App {
        String name;
        int priority;
        int startTime;
        int endTime;

        public App(String name, int priority, int startTime, int endTime) {
            this.name = name;
            this.priority = priority;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    // 将时间字符串（格式HH:MM）转换为一天中从00:00开始的分钟数
    public static int timeToMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        return hours * 60 + minutes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 读取要注册的App数量
        scanner.nextLine(); // 读取并忽略剩余的行结束符

        List<App> registeredApps = new ArrayList<>(); // 存储所有注册成功的App

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine(); // 读取一行App注册信息
            String[] parts = line.split(" ");
            String name = parts[0];
            int priority = Integer.parseInt(parts[1]);
            int startTime = timeToMinutes(parts[2]);
            int endTime = timeToMinutes(parts[3]) - 1; // 转换结束时间并-1，以符合时间包含开始但不包括结束的规则
            if(startTime > endTime) continue;
            boolean canRegister = true;
            List<App> updatedApps = new ArrayList<>();

            // 检查时间冲突并确定是否可以注册
            for (App app : registeredApps) {
                if (startTime <= app.endTime &&  endTime >= app.startTime) {
                    if (priority <= app.priority) {
                        canRegister = false;
                        break;
                    }
                }
            }

            if (canRegister) {
                // 剔除所有时间上冲突的App
                for (App app : registeredApps) {
                    if (!(startTime <= app.endTime &&  endTime >= app.startTime)) {
                        updatedApps.add(app);
                    }
                }
                updatedApps.add(new App(name, priority, startTime, endTime));
                registeredApps = updatedApps;
            }
        }

        String queryTime = scanner.nextLine(); // 读取查询时间
        int queryMinute = timeToMinutes(queryTime); // 转换查询时间为分钟

        // 检查并输出查询时间点的App
        for (App app : registeredApps) {
            if (app.startTime <= queryMinute && app.endTime >= queryMinute) {
                System.out.println(app.name);
                scanner.close();
                return;
            }
        }
        System.out.println("NA"); // 如果没有任何App活动于此时间点，输出"NA"
        scanner.close();
    }

}
