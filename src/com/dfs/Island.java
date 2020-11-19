package com.dfs;

import java.util.Scanner;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
//此外，你可以假设该网格的四条边均被水包围
//解题思路：DFS
public class Island {
    public static char[][] creat(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入高度：");
        int height = scanner.nextInt();
        System.out.println("请输入宽度: ");
        int width = scanner.nextInt();
        System.out.println("请构建你的世界(只允许输入0或者1，，1代表陆地，0代表水域，构成二维网格大陆)：");
        char[][] world = new char[height][width];
        //String regex="^[01]$";正则表达式
        for(int i=0;i<height;i++){
            String s=scanner.next();
            for(int j=0;j<width;j++){
                world[i][j]=s.charAt(j);
            }
        }
        return world;
    }
    public static int numIsland(char[][] grid){
        int num=0;
        if(grid!=null&&grid.length!=0){
            int height = grid.length;
            int width = grid[0].length;
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    if(grid[i][j]=='1'){
                        num++;
                        DFSinfect(grid,i,j);
                    }
                }
            }
        }
        return num;
    }
    public static void DFSinfect(char[][] grid,int y,int x){//利用深度优先搜索算法感染陆地
        if(grid[y][x]=='1'){
            grid[y][x]='2';
            int height = grid.length;
            int width = grid[0].length;
            if(y<height-1){//纵象上的感染
                DFSinfect(grid,y+1,x);
            }
            if(y>=1){
               DFSinfect(grid,y-1,x);
            }
            if(x<width-1){//横象上的感染
                DFSinfect(grid,y,x+1);
            }
            if(x>=1){
                DFSinfect(grid,y,x-1);
            }
        }
            return;
    }
    public static void main(String[] args) {
        char[][] chars=creat();
        System.out.print(numIsland(chars));
    }
}
