package calender;

import java.util.Scanner;
public class c2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份（1900——2099）：");
        int year = input.nextInt();
        int Total = 0;//统计总天数
        final  String WeekHead="日\t一\t二\t三\t四\t五\t六";
        if(year>=1900&&year<=2099){
            boolean  isLeapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? true : false;
            int[]aa=new int[isLeapYear?366:365];//创建数组
            //统计天数
            for (int i = 1900; i < year; i++) {
                Total += ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) ? 366 : 365;
            }
            Total%=7;
            //将星期几存入数组中，每一天都对应了星期几
            for (int i = 0; i <aa.length ; i++,Total++) {
                Total%=7;
                aa[i]=Total;
            }
            // 输出每个月的日历
            int count=0;
            for (int i = 1; i <=12 ; i++) {
                System.out.println("\n"+year+"年"+i+"月");
                System.out.println(WeekHead);
                int maxday = 31;
                switch (i){//判断月份的最大天数
                    case 2:
                        maxday = isLeapYear?29:28;
                        break;
                    case 4:case 6:case 9:case 11:
                        maxday =30;
                        break;
                }
                for (int j = 0; j <=aa[count] ; j++) {
                    if((aa[count]+1)%7==0)
                        break;
                    else{
                        System.out.print("\t");
                    }
                }
                for (int j = 1; j <=maxday ; j++) {
                        System.out.print(j+"\t");
                    if((aa[count]+1+j)%7==0&&j!=maxday){
                        System.out.println();
                    }
                }
                count+=maxday;
            }
        }else {
            System.out.println("年份输入有误，请重试");
        }
    }
}

