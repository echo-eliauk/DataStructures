package com.atguigu.recursion;

public class MiGong {
    public static void main(String[] args) {
        //新建迷宫
        int[][] map=new int[7][8];//7行8列的图
        //初始化 墙
        for(int i=0;i<7;i++){
            map[i][0]=1;
            map[i][7]=1;
        }
        for(int i=0;i<8;i++){
            map[0][i]=1;
            map[6][i]=1;
        }
        map[2][1]=1;map[3][3]=1;
        System.out.println("初始墙：");
        list(map);
        boolean way = getWay(map, 1, 1);
        System.out.println("走过之后：");
        list(map);
    }

    /**
     * 遍历地图
     * @param map
     */
    public static void list(int[][] map){
        for(int i=0;i<7;i++){
            for (int j = 0; j <8 ; j++) {
                System.out.printf("%d\t",map[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * 找路
     * @param map 地图
     * @param i 起始横坐标
     * @param j 起始纵坐标
     * @return
     * 约定 0：未走的路
     * 1：墙
     * 2.走过的路
     * 3.不能通的路（无效的路）
     * 行走顺序：下->右->上->左
     */
    public static boolean getWay(int[][] map,int i,int j){
        if(map[5][6]==2){
            return true;
        }
        else {
            if (map[i][j] == 0) {//还没走的路
                map[i][j] = 2; //假设是可以走通的路
                if (getWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (getWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (getWay(map, i - 1, j)) {//向左走
                    return true;
                } else if (getWay(map, i, j - 1)) {//向上走
                    return true;
                } else {
                    map[i][j] = 3;//这个点走不通
                    return false;
                }
            }
            else{//!=0,也就是1。2。3都是走不了的路
                return false;//死路
            }
        }
        }
    }

