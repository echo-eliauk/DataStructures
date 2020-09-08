package com.atguigu.link;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "吴用", "无用");
        HeroNode node3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode node4 = new HeroNode(4, "花荣", "小李广");
        HeroNode node7 = new HeroNode(7, "李逵", "大头");
        HeroNode node8 = new HeroNode(8, "张飞", "大头");
        HeroNode node9 = new HeroNode(9, "刘备", "大头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList1.addByOrder(node1);
        singleLinkedList1.addByOrder(node3);
        singleLinkedList1.addByOrder(node4);
        singleLinkedList1.addByOrder(node7);
        singleLinkedList2.addByOrder(node2);
        singleLinkedList2.addByOrder(node8);
        singleLinkedList2.addByOrder(node9);
        singleLinkedList1.list();
        System.out.println("---------------------");
        singleLinkedList2.list();
        System.out.println("---------------------");
        HeroNode node = addTwo(singleLinkedList1.getHead(), singleLinkedList2.getHead());
        //System.out.println(node);
        /*System.out.println("-----------------");
        singleLinkedList1.list();*/
       /* singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.delete(1);
        singleLinkedList.list();
        int length = getLength(singleLinkedList.getHead());
        System.out.println("链表长度："+length);
        HeroNode node=getNode(singleLinkedList.getHead(),4);
        System.out.println("倒数第4节点："+node);
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();*/
        /*singleLinkedList.list();
        reversePrint(singleLinkedList.getHead());*/
    }

    //合并两张有序链表
    public static HeroNode addTwo(HeroNode head1, HeroNode head2){
        if (head1.next==null||head2.next==null){
            System.out.println("有空链表，不需要合并");
            return null;
        }
        HeroNode head=new HeroNode(0,"","");
        HeroNode temp=head;
        HeroNode cur1=head1.next;
        HeroNode cur2=head2.next;
        while(cur1!=null||cur2!=null) {
            if(cur1==null){
                temp.next=cur2;
                cur2=cur2.next;
                temp=temp.next;
                System.out.println(temp+"---------");
                continue;
            }
            if(cur2==null){
                temp.next=cur1;
                cur1=cur1.next;
                temp=temp.next;
                System.out.println(temp+"---------");
                continue;
            }
            if (cur1.no > cur2.no) {
                temp.next=cur2;
                cur2=cur2.next;
                temp=temp.next;
            } else {
                temp.next=cur1;
                cur1=cur1.next;
                temp=temp.next;
            }
            temp.next=head.next;
            head.next=temp;
            System.out.println(temp+"---------");
        }
        return head;
    }
    //各节点反转打印
    public static void reversePrint(HeroNode head){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode cur=head.next;
        Stack<HeroNode> heroNodes = new Stack<>();
        while(cur!=null){
            heroNodes.push(cur);
            cur=cur.next;
        }
        for(int i=0;i<getLength(head);i++){//while(heroNodes.size>0)
            System.out.println("出栈："+heroNodes.pop());;
        }
    }
    //翻转链表
    public static void reverseList(HeroNode head){
        if(head.next==null||head.next.next==null){
            System.out.println("0或1个节点不需要反转");
            return;
        }
        HeroNode reverseNode=new HeroNode(0,"","");
        HeroNode cur=head.next;
        HeroNode next=null;
        while (cur!=null){
            next=cur.next;
            cur.next=reverseNode.next;
            reverseNode.next=cur;
            cur=next;
        }
        head.next=reverseNode.next;
        System.out.println("翻转："+head);
    }

    //获取倒数第k的节点
    public static HeroNode getNode(HeroNode head, int k ){
        int length = getLength(head);
        if(length==0||length<k){
            return null;
        }
        HeroNode temp=head.next;
        for(int i=0;i<length-k;i++){
            temp=temp.next;
        }
        return temp;
    }
    //获取链表的长度出去头结点
    public static int getLength(HeroNode head){
        HeroNode temp=head;
        int length=0;
        if(head.next==null){
            return 0;
        }
        while (temp.next!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
}
class SingleLinkedList{
    private HeroNode head=new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //添加节点
    public void add(HeroNode node){
        HeroNode temp=head;
        while (true){
            //找到链表最后
            if(temp.next==null){
                temp.next=node;
                break;
            }
            temp=temp.next;
        }
    }
    //按编号顺序添加
    public void addByOrder(HeroNode node){
        HeroNode temp=head;
        boolean flag=false;
        while (true){
            if(temp.next==null){
                System.out.println("直接添加到了尾部");
                break;
            }
            if(temp.next.no>node.no){
                System.out.println("位置找到了");
                break;
            }else if(temp.next.no==node.no){
                System.out.println("有相同编号，不能添加");
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==false){
            node.next=temp.next;
            temp.next=node;
        }
    }
    //修改节点信息，编号不能修改
    public void update(HeroNode node){
        HeroNode temp=head;
        while (true){
            if(temp.next==null){
                System.out.println("没有找到相同节点");
                break;
            }
            if(temp.next.no==node.no){
                temp.next.name=node.name;
                temp.next.nickName=node.nickName;
                break;
            }
            temp=temp.next;
        }
    }
    //删除节点
    public void delete(int no){
        //判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head;
        while (true){
            if (temp.next==null){
                System.out.println("没找到");
                break;
            }
            if(temp.next.no==no){
                System.out.println("找到了要删除的节点");
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
    }
    //显示链表
    public void list(){
        //判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head;
        temp=temp.next;
        while(temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }
        /*while(true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }*/
    }

}
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;


    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
