package com.atguigu.link;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 node1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 node2 = new HeroNode2(2, "吴用", "无用");
        HeroNode2 node3 = new HeroNode2(3, "林冲", "豹子头");
        HeroNode2 node4 = new HeroNode2(4, "花荣", "小李广");
        HeroNode2 node7 = new HeroNode2(7, "李逵", "大头");
        HeroNode2 node8 = new HeroNode2(8, "张飞", "大头");
        HeroNode2 node9 = new HeroNode2(9, "刘备", "大头");
       /* //添加
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        //列出
        list.list();
        System.out.println("------修改------");
        //修改
        list.update(node9);
        list.list();
        System.out.println("------删除4号------");
        //删除
        list.delete(4);
        list.list();
        System.out.println("-----按编号顺序添加----");*/
        //按编号顺序添加
        DoubleLinkedList list1 = new DoubleLinkedList();
        list1.addByOrder(node8);
        list1.list();
        list1.addByOrder(node9);
        list1.addByOrder(node1);
        list1.addByOrder(node4);
        list1.list();
    }
}
class DoubleLinkedList{

    private HeroNode2 head=new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    //添加节点
    public void add(HeroNode2 node){
        HeroNode2 temp=head;
        while (true){
            //找到链表最后
            if(temp.next==null){
                temp.next=node;
                node.pre=temp;
                break;
            }
            temp=temp.next;
        }
    }
    //按编号顺序添加
    public void addByOrder(HeroNode2 node){
        HeroNode2 temp=head;
        boolean flag=false;
        while (true){
            if(temp.next==null){
                System.out.println("直接添加到了尾部");
                flag=true;
                add(node);
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
            //顺序一定不能错！！！
            /*node.next=null,node.pre=null;node=1*/
            node.next=temp.next;
            temp.next=node;
            temp.next.pre=node;
            node.pre=temp;
        }
    }
    //修改节点信息，编号不能修改
    public void update(HeroNode2 node){
        HeroNode2 temp=head;
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
        HeroNode2 temp=head;
        while (true){
            if (temp==null){
                System.out.println("没找到");
                break;
            }
            if(temp.no==no){
                System.out.println("找到了要删除的节点");
                if(temp.next==null){
                    //要删除的是最后一个节点
                    temp.pre.next=null;
                    break;
                }
                temp.pre.next=temp.next;
                temp.next.pre=temp.pre;
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
        HeroNode2 temp=head;
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
class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;


    public HeroNode2(int no, String name, String nickName) {
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
