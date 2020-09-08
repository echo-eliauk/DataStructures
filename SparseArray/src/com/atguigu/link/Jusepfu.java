package com.atguigu.link;

public class Jusepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.add(125);
        //linkedList.list();
        linkedList.search(1,4,125);
    }
}
class CircleSingleLinkedList{
    private Boy first=new Boy(-1);//声明一个头
    public void add(int nums){
        if(nums<2){
            System.out.println("输入的值不合法，重新输入");
            return;
        }
        Boy cur=new Boy(-1);
        for(int i=1;i<=nums;i++){
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);
                cur=first;
            }else {
                cur.setNext(boy);
                boy.setNext(first);
                cur=boy;
            }
        }

    }
    public void list(){
        if(first.no==-1){
            System.out.println("链表为空");
            return;
        }
        Boy cur=first;
        while (cur.getNext()!=first){
            System.out.println("编号："+cur.no);
            cur=cur.getNext();
        }
        System.out.println("编号："+cur.no);
    }
    //出圈问题
    /**
     *
     * @param startNo 从第几个开始数
     * @param countNo 表示数几次
     * @param nums 表示最初有多少个孩子在圈中
     */
    public void search(int startNo,int countNo,int nums){
        //先对数据进行校验
        if(startNo<1||startNo>nums||first==null){
            System.out.println("输入的数据有误，请重新输入");
            return;
        }
        Boy cur=first;
        while (cur.getNext()!=first){
            //cur指向最后一个节点
            cur=cur.getNext();
        }
        for (int i = 0; i < startNo-1; i++) {
            //表示从第几个开始数
            first=first.getNext();
            cur=cur.getNext();
        }
        while (true){
            if (first==cur){
                //System.out.println("到最后一个元素了");
                break;
            }
            for (int i = 0; i < countNo-1; i++) {
                //数几次
                first=first.getNext();
                cur=cur.getNext();
            }
            System.out.printf("第%d个孩子出圈\n",first.getNo());
            first=first.getNext();
            cur.setNext(first);
        }
        System.out.printf("最后一个孩子出圈 编号%d\n",first.getNo());

    }
}
class Boy{
    int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}
