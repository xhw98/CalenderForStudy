package com.exercise;
import java.util.Scanner;
//总思路是通过计算1900年一月一日距离输入的日期的天数来推断出当月的日历
public class Calender {
    public static void main(String[] args) {
         int year = 0;
         int month = 0;
         int monthDay = 0;
        //定义总天数
         int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        year = sc.nextInt();
        System.out.println("请输入月份：");
        month = sc.nextInt();
        //遍历年份的天数
        for (int i = 1900; i < year; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                sum += 366;
            } else {
                sum += 365;
            }
        } // for循环结束 遍历年份的天数


        /*
         * 由于输入的月份，不需要遍历，直接在下面代码中打出即可.
         * 但是得取出输入月份天数所以循环月份时把月份循环 ,之后下面再减掉月份.
         * */
        for (int i = 1; i <= month; i++) {
            //当为闰年时月份
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                if (i == 2) {
                    monthDay = 29;//闰年2月29天
                } else if (i == 4 || i == 6 || i == 9
                        || i==11) {
                    monthDay = 30;//30天的日子
                } else {
                    monthDay = 31;//31
                }
            } else {
                //当为平年时
                if (i==2) {
                    monthDay = 28;
                } else if (i==4 || i==6 || i==9
                        || i==11) {
                    monthDay = 30;
                } else {
                    monthDay = 31;
                }
            }
            sum += monthDay;
        } // for循环结束 遍历月份的天数。

        System.out.println("日\t一\t二\t三\t四\t五\t六");
        //总天数得减去多遍历的那个月份的天数
        sum = sum+1-monthDay;
        //除以7便是从那天开始
        int length = sum%7;
        //之前用空格 打印
        for (int i = 0; i <= length-1; i++) {
            System.out.print(" \t");
        }
        //遍历月份  取出多加的monthDay
        for (int i = 1; i <= monthDay; i++) {
            if (sum%7==6) {
                System.out.print(i + "\n");
            }else{
                System.out.print(i + "\t");
            }
            //总天数自增
            sum++;
        }
    }
}