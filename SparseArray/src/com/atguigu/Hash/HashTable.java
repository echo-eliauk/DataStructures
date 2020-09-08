package com.atguigu.Hash;

public class HashTable {
    public static void main(String[] args) {
        Emp emp1=new Emp(3,"张三");
        Emp emp2=new Emp(4,"李四");
        Emp emp3=new Emp(5,"王五");
        Emp emp4=new Emp(6,"赵六");
        Emp emp5=new Emp(7,"七七");
        Emp emp6=new Emp(8,"八八");
        HashLinkedArr arr = new HashLinkedArr(6);
        arr.add(emp1);
        arr.add(emp2);
        //arr.add(emp3);
        arr.add(emp4);
        arr.add(emp5);
        arr.add(emp6);
        arr.list();
        System.out.println("-----------");
        Emp emp = arr.findById(8);
        System.out.println(emp);
        System.out.println("---------");
        arr.del(9);
        arr.list();
    }
}
class HashLinkedArr{
    public HashLinkedEmp[] hashLinkedEmps;
    int size;
    public HashLinkedArr(int size){
        this.size=size;
        hashLinkedEmps=new HashLinkedEmp[size];
        //！！！很重要，初始化这个链表
        for (int i = 0; i <size ; i++) {
            hashLinkedEmps[i]=new HashLinkedEmp();
        }
    }
    public int hash(int id){
        return id%size;
    }
    public void add(Emp emp){
        int i=hash(emp.id);
        hashLinkedEmps[i].add(emp);
    }
    public void list(){
        for(int i=0;i<size;i++){
            hashLinkedEmps[i].list(i);
        }
    }
    public Emp findById(int id){
        Emp emp = null;
        emp = hashLinkedEmps[id%size].find(id);
        return emp;
    }
    public void del(int id){
        hashLinkedEmps[id%size].delete(id);
    }
}
class Emp{
    int id;
    String name;
    Emp next;
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class HashLinkedEmp{
    private Emp head;
    public boolean isEmpty(){
        return head==null;
    }
    public void add(Emp emp){
        if (head==null){
            head=emp;
            return;
        }
        Emp cur=head;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=emp;
    }
    public void list(int t){
        if(isEmpty()){
           // System.out.printf("%d号链表为空\n",t);
            return;
        }
        Emp cur=head;
        System.out.printf("%d号emp 信息：",t);
        while (cur!=null){
            System.out.printf("emp.id=%d,emp.name=%s\n",cur.id,cur.name);
            cur=cur.next;
        }
    }
    public Emp find(int id){
        if(isEmpty()){
            System.out.println("链表为空");
            return null;
        }
        Emp cur=head;
        while (cur!=null){
            if(cur.id==id){
                return cur;
            }
            cur=cur.next;
        }
        System.out.println("没有改id雇员");
        return null;
    }
    public void delete(int id){
        if (isEmpty()){
            System.out.println("链表为空");
            return;
        }
        Emp cur=head;
        if(cur.id==id){
            head=head.next;
        }
        boolean flag=true;
        while (cur.next!=null){
            if(cur.next.next!=null){
                if(cur.next.id==id){
                    cur.next=cur.next.next;
                    System.out.println("删除了");
                    flag=false;
                    break;
                }
            }else{
                if(cur.next.id==id){
                    cur.next=null;
                    System.out.println("删除了");
                    flag=false;
                    break;
                }
            }
            cur=cur.next;
        }
        if (flag){
            System.out.println("没有此id可以删除");
        }
    }
}