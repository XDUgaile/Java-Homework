package calender;

import java.util.Scanner;

public class calender {
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner in = new Scanner(System.in);
		System.out.println("��ѡ���ܣ�"+"1)���ĳ������\n"+"2)���ĳ�����ڡ�");
		int model = 0;
		int month1[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		model = in.nextInt();
		if(model == 1) {	//��Ϊ1��Ϊ���ĳ������
			System.out.println("���������(1900���Ժ��)��");
			int year = in.nextInt();
			int total = 0, cnt = 0;
			int i, j;
			boolean  isLeapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? true : false;
            int[]date=new int[isLeapYear?366:365];//��������
			for(i = 1900;i!=year;i+=1,total+=365) {
				if((i % 4 ==0&&i%100!=0)||(i%400==0)) {		//�ж��Ƿ�Ϊ����
					total++;
				}
			}
			total -= 365;
			total%=7;
			
			for(i=0;i<date.length;i++,total++) {
				total%=7;
				date[i] = total; 		//��Ӧ����ÿһ�����ܼ�
			}
			
			for(i=1;i<=12;i++) {
				System.out.println(year+"-"+i);
				System.out.println("Sun.\t"+"Tue.\t"+"Wed.\t"+"Thu.\t"+"Fri.\t"+"Sat.\t"+"Mon.\t");
				int max = 31;
                switch (i){//�ж��·ݵ��������
                    case 2:max = isLeapYear?29:28;break;
                    case 4:max =30;break;
                    case 6:max =30;break;
                    case 9:max=30;break;
                    case 11:max =30;break;
                	}
                for (j = 0; j <=date[cnt] ; j++) {			//�жϴ��µĵ�һ�����ܼ�����ӡ����/t
                    if((date[cnt]+1)%7==0)
                        break;
                    else{
                        System.out.print("\t");
                    	}
                	}
                for (j = 1; j <=max ; j++) {				//��1��ʼ������������һ��
                        System.out.print(j+"\t");
                    if((date[cnt]+1+j)%7==0&&j!=max){
                        System.out.println();
                    	}
                	}
                cnt+=max;								//cnt�Ǵ�0��ʼ�ģ�����ֻҪ��max���Ͼ�˳�㵽����һλ
                System.out.println("\n");
            	}
			}
		else if(model == 2){				//��Ϊ2����Ϊ���ĳ������
			System.out.println("��������ݣ�");
			int year = in.nextInt();
			System.out.println("�������·ݣ�");
			int month = in.nextInt();
			System.out.println("���������ӣ�");
			int day = in.nextInt();
			int total = 0;
			int i;
			for(i = 1900;i!=year;i+=1,total+=365) {
				if((i % 4 ==0&&i%100!=0)||(i%400==0)) {		//�ж��Ƿ�Ϊ����
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
				System.out.println(year+"��"+month+"��"+day+"��������һ");
			if(date == 2)
				System.out.println(year+"��"+month+"��"+day+"�������ڶ�");
			if(date == 3)
				System.out.println(year+"��"+month+"��"+day+"����������");
			if(date == 4)
				System.out.println(year+"��"+month+"��"+day+"����������");
			if(date == 5)
				System.out.println(year+"��"+month+"��"+day+"����������");
			if(date == 6)
				System.out.println(year+"��"+month+"��"+day+"����������");
			if(date == 0)
				System.out.println(year+"��"+month+"��"+day+"����������");
			
		}
		else{
			System.out.println("error");
		}
	}

}
