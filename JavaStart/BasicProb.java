package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static int cntFun(int number){
//        int ss = number;
        int num1 = number;
        int cnt=1;
        while(true){
            if(num1/10 == 0){
                break;
            }
            num1/=10;
            cnt++;
        }
        int num = 1;
        for(int i = 1 ; i < cnt; i ++){
            num*=10;
        }

        int returnCnt = 0;
        for(int i = 0 ; i < cnt;i++){
            if((number/num)!=0&&(number/num)%3 == 0){
                returnCnt++;
            }
            number%=num;
            num/=10;
        }
//        if(returnCnt != 0 ){
//            System.out.print(ss+" ");
//        }
        return returnCnt;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = null;

        sc = new Scanner(new File("data.txt"));

        int cnt = sc.nextInt();
        for(int i = 1 ; i <= cnt ; i ++)
        {
            int date = sc.nextInt();
            int period = sc.nextInt();
            int periodPay = sc.nextInt();
            int dailyPay = sc.nextInt();
            if(date%period == 0)
            {
                if (date * dailyPay > (date / period * periodPay))
                {
                    System.out.println((date/period)*periodPay);
                } else
                {
                    System.out.println(date*dailyPay);
                }
            }
            else{
                int a = date - (date/period)*period;
                a += period;
                if(a*dailyPay > ((a-period)*dailyPay)+periodPay){
                    System.out.println( periodPay*(date/period)+dailyPay*(date-((date/period)*period)) );
                }
                else{
                    System.out.println(dailyPay*date);
                }
            }
        }

//        int N = sc.nextInt();
//        int cnt = 0;
//        for(int i = 1; i <= N ; i ++){
//            cnt+=cntFun(i);
//        }
//        System.out.println(cnt);


        //
//        int N = sc.nextInt();
//        for(int i = 0 ; i < N/2 ; i++){
//            System.out.print(i+1+" ");
//            System.out.print(N-i+" ");
//        }
//        if(N%2 != 0){
//            System.out.println(N/2+1+" ");
//        }

        // 수를 한자리씩 출력하기
        // 5115
        // 5 1 1 5
//        int N = sc.nextInt();
//        int num1 = N;
//        int cnt=1;
//        while(true){
//            if(num1/10 == 0){
//                break;
//            }
//            num1/=10;
//            cnt++;
//        }
//        int num = 1;
//        for(int i = 1 ; i < cnt; i ++){
//            num*=10;
//        }
//
//        for(int i = 0 ; i < cnt;i++){
//            System.out.println(N/num);
//            N%=num;
//            num/=10;
//        }

        // 숫자가 입력되었을 때 한글로 변환 ( 단위 포함 )
        // 1234 -> 일천 이백 삼십 사
//        String[] unit= {" ","십","백","천","만","십","백","천","억"};
//        String[] number={"영","일","이","삼","사","오","육","칠","팔","구","십"};
//        int num = sc.nextInt();
//        int cnt=1;
//        StringBuffer sb = new StringBuffer();
//        while(true){
//            sb.insert(0,number[num%10]+unit[cnt-1]+" ");
//            if(num/10 == 0){
//                break;
//            }
//            num/=10;
//            cnt ++;
//        }
//        System.out.println(sb.toString());

        // 선풍기 문제
        // 선풍기 한대당 3명이 바람을 쐴 수 있다.
        // 3
        // 8 2  --> 1대 부족
        // 9 3  --> 일치
        // 6 3  --> 1대 남음
        // ----- 최종 0대 필요
//        int cnt = sc.nextInt();
//        int requNum = 0;
//        for(int i = 1 ; i <= cnt ; i ++){
//            int people= sc.nextInt();
//            int fan = sc.nextInt();
//            if(people%3 == 0){
//                continue;
//            }
//            int num = fan - people/3 ;
//            requNum+=num;
//        }
//        System.out.println(requNum);

//        // 첫 번째 수는 기준 수
//        // 두 번째 수는 승수
        // 2 5 --> 2의 1~5 제곱의 수 출력
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int doub = N;
//        for(int i=0 ; i < M ; i++){
//            System.out.println(N);
//            N*=doub;
//        }

        // 첫 번째 수는 testCase 가 주어진다.
        // 두 번째 수부터는 범위가 주어진다. 범위까지의 수 중 소수를 출력하시오
        // 2
        // 10 20
//        int testCount = sc.nextInt();
//        for(int tc = 0 ; tc < testCount ; tc++)
//        {
//            int num = sc.nextInt();
//            int[] ary = new int[num + 1];
//
//            for (int i = 2; i <= num; i++)
//            {
//                for (int j = i + i; j <= num; j += i)
//                {
//                    if (ary[j] == 0)
//                    {
//                        ary[j] = i;
//                    }
//                }
//            }
//            for (int i = 2; i <= num; i++)
//            {
//                if (ary[i] == 0)
//                {
//                    System.out.print(i + " ");
//                }
//            }
//            System.out.println(" ");
//        }

        // N까지의 수 중 소수인 수 출력
        // 20
//        boolean isNum = false;
//        for( int i = 2; i <= num ; i ++){
//            for(int j = 2 ; j<i ; j++){
//                if( i%j == 0){
//                    isNum = true;
//                    break;
//                }
//            }
//            if(!isNum)
//            {
//                System.out.print(i + " ");
//            }
//            isNum = false;
//        }
    }
}
