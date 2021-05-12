package com.company;

import java.io.File;
import java.util.Scanner;

class Pos{
    int row;
    int col;
    public Pos(){}
    public Pos(int row,int col){
        this.col=col;
        this.row=row;
    }
}

public class Main {
    static final int MAX = 100;
    static int[][] GRID = new int[MAX][MAX];
    static int row, col;

    static Pos[] queue = new Pos[MAX*MAX];
    static int front, rear;

    static int cnt =1 ;
    static Pos start ;
    static Pos goal ;
    static Pos[] D = {new Pos(0,1),new Pos(0,-1),new Pos(1,0),new Pos(-1,0)};


    static void create(int n, int m,Scanner sc){
        start = new Pos();
        goal = new Pos();
        sc.nextLine();
        for(int i=0; i<n; i++)
        {
            String str = sc.nextLine();
            for(int j=0; j<m; j++)
            {
                char ch = str.charAt(j);
                switch(ch)
                {
                    case 'S':
                        start.row = i;
                        start.col = j;
                        GRID[i][j] = 0;
                        break;
                    case 'G':
                        goal.row = i;
                        goal.col = j;
                        GRID[i][j] = -2;
                        break;
                    case '#':
                        GRID[i][j] = -1;
                        break;
                    case '.':
                        GRID[i][j] = -2;
                        break;
                }
            }
        }
    }

    static void print(int n, int m){
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                switch (GRID[i][j]){
                    case -2:
                        if(i == goal.row && j==goal.col) System.out.print("G");
                        else System.out.print(".");
                        break;
                    case -1:
                        System.out.print("#");
                        break;
                    case 0:
                        System.out.print("S");
                        break;
                    default:
                        System.out.print(GRID[i][j]);
                        break;
                }
            }
            System.out.println(" ");
        }
    }

    static void bfs(Pos p){
        front = -1;
        rear = -1;
        queue[++rear] = p;

        while(front < rear){
            Pos tmp = queue[++front];
            for(int i = 0; i < 4 ; i ++){
                Pos n = new Pos(tmp.row + D[i].row , tmp.col+D[i].col);
                if(n.row >=0 && n.row < row && n.col >=0 && n.col < col && GRID[n.row][n.col] == -2 ){
                    GRID[n.row][n.col] = GRID[tmp.row][tmp.col]+1;
                    queue[++rear] = n;
                }
            }
        }
    }

    public static void dfs (Pos p){
        if(p.row == goal.row && p.col == goal.col){
            cnt++;
        }
        else{
            for(int i = 0 ; i < 4 ; i ++){
                Pos n = new Pos(p.row + D[i].row , p.col + D[i].col);
                if(n.row >= 0 && n.row < row && n.col >= 0 && n.col < col){
                    if(GRID[n.row][n.col] == -2){
                        GRID[n.row][n.col]=GRID[p.row][p.col]+1;
                        dfs(n);
                        GRID[n.row][n.col]=-2;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("data.txt"));
        row = sc.nextInt();
        col = sc.nextInt();
        create(row,col,sc);
        print(row,col);
        System.out.println(" ");
//        bfs(start);
        dfs(start);
        print(row,col);
        System.out.println("최소거리 : "+GRID[goal.row][goal.col]);
    }
}
