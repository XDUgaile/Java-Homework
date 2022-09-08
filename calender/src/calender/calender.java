package calender;

import java.util.Scanner;

public class calender {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		System.out.println("请选择功能："+"1)输出某年日历\n"+"2)输出某天星期。");
		int model = 0;
		int month1[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		model = in.nextInt();
		if(model == 1) {	//若为1则为输出某年日历
			System.out.println("请输入年份(1900年以后的)：");
			int year = in.nextInt();
			int total = 0, cnt = 0;
			int i, j;
			boolean  isLeapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? true : false;
            int[]date=new int[isLeapYear?366:365];//创建数组
			for(i = 1900;i!=year;i+=1,total+=365) {
				if((i % 4 ==0&&i%100!=0)||(i%400==0)) {		//判断是否为闰年
					total++;
				}
			}
			total -= 365;
			total%=7;
			
			for(i=0;i<date.length;i++,total++) {
				total%=7;
				date[i] = total; 		//对应的是每一天是周几
			}
			
			for(i=1;i<=12;i++) {
				System.out.println(year+"-"+i);
				System.out.println("Sun.\t"+"Tue.\t"+"Wed.\t"+"Thu.\t"+"Fri.\t"+"Sat.\t"+"Mon.\t");
				int max = 31;
                switch (i){//判断月份的最大天数
                    case 2:max = isLeapYear?29:28;break;
                    case 4:max =30;break;
                    case 6:max =30;break;
                    case 9:max=30;break;
                    case 11:max =30;break;
                	}
                for (j = 0; j <=date[cnt] ; j++) {			//判断此月的第一天是周几，打印几个/t
                    if((date[cnt]+1)%7==0)
                        break;
                    else{
                        System.out.print("\t");
                    	}
                	}
                for (j = 1; j <=max ; j++) {				//从1开始输出到本月最后一天
                        System.out.print(j+"\t");
                    if((date[cnt]+1+j)%7==0&&j!=max){
                        System.out.println();
                    	}
                	}
                cnt+=max;								//cnt是从0开始的，所以只要将max加上就顺便到了下一位
                System.out.println("\n");
            	}
			}
		else if(model == 2){				//若为2，则为输出某天星期
			System.out.println("请输入年份：");
			int year = in.nextInt();
			System.out.println("请输入月份：");
			int month = in.nextInt();
			System.out.println("请输入日子：");
			int day = in.nextInt();
			int total = 0;
			int i;
			for(i = 1900;i!=year;i+=1,total+=365) {
				if((i % 4 ==0&&i%100!=0)||(i%400==0)) {		//判断是否为闰年
					total++;	
				}
				//System.out.println("Total:"+total);
			}
			for(i=0;i<month-1;i++) {
				if((year % 4 ==0&&year%100!=0)||(year%400==0)) {
					month1[1] = 29;
				}
				total += month1[i];
			}
			total += day;
			//System.out.println("Total:"+total);
			int date = total%7;
			//System.out.println("Date:"+date);
			if(date == 1)
				System.out.println(year+"年"+month+"月"+day+"日是星期一");
			if(date == 2)
				System.out.println(year+"年"+month+"月"+day+"日是星期二");
			if(date == 3)
				System.out.println(year+"年"+month+"月"+day+"日是星期三");
			if(date == 4)
				System.out.println(year+"年"+month+"月"+day+"日是星期四");
			if(date == 5)
				System.out.println(year+"年"+month+"月"+day+"日是星期五");
			if(date == 6)
				System.out.println(year+"年"+month+"月"+day+"日是星期六");
			if(date == 0)
				System.out.println(year+"年"+month+"月"+day+"日是星期日");
			
		}
		else{
			System.out.println("error");
		}
	}

}
