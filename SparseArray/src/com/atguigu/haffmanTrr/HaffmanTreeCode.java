package com.atguigu.haffmanTrr;

import java.util.*;

public class HaffmanTreeCode {
    public static int count=0;
    public static void main(String[] args) {
        String content="i a cc qwe";
        byte[] bytes = content.getBytes();
        System.out.println("十进制："+Arrays.toString(bytes));
        List<Node1> nodes = getNodes(bytes);
        Node1 root = haffmanTree(nodes);
        System.out.println("哈夫曼树根节点："+root);
        System.out.println("--------");
        //preList(root);
        toHaffmanCode(root,"",stringBuilder);
        System.out.println("对应哈弗曼编码："+haffmanCode);
        byte[] arr = codeToArr(bytes, haffmanCode);
        System.out.println("二进制转十进制："+Arrays.toString(arr));
        byte[] b1= toStr(haffmanCode, arr);
        System.out.println("二进制:"+new String(b1));

    }
    //将字节码转成字符串
    public static byte[] toStr(Map<Byte,String> haffmanCode, byte[] arr){
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag=true;
        for (int i = 0; i <arr.length ; i++) {
            if(i==arr.length-1){
                flag=false;
            }
            stringBuilder.append(toByte(flag, arr[i]));
        }
        //翻转Map
        Map<String,Byte> map=new HashMap<>();
        for(Map.Entry<Byte,String> entry: haffmanCode.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        System.out.println("字节码："+stringBuilder);
        List<Byte> list=new ArrayList<>();
        Byte b=null;
        for (int i = 0; i <stringBuilder.length() ;) {
            int count=1;
            boolean flag1=true;
            String s="";
            while (flag1){
                s = stringBuilder.substring(i, i + count);
                b = map.get(s);
                if(b==null){
                    count++;
                }else{
                    flag1=false;
                }
            }
            list.add(b);
            i+=count;
        }
        byte b1[]=new byte[list.size()];
        for (int i = 0; i <b1.length ; i++) {
            b1[i]=list.get(i);
        }
        return b1;
    }
    //将哈夫曼编码转成字节码
    public static String toByte(boolean flag,byte b){
        int temp=b;//将字节转int型
        //不是最后一个数，正数需要补字节
        if(flag){
            temp|=256;
        }
        String s = Integer.toBinaryString(temp);
        if(s.length()>8){
            return s.substring(s.length()-8);
        }
        if(s=="0"){
            for (int i = 0; i < count-1; i++) {
                s="0"+s;
            }
        }
        else{
            for (int i = 0; i < count; i++) {
                s="0"+s;
            }
        }
        System.out.println("count=="+count);
        return s;
    }
    public static byte[] codeToArr(byte[] bytes,Map<Byte,String> haffmanCode){
        StringBuilder stringBuilder=new StringBuilder();
        for (byte b:bytes) {
            stringBuilder.append(haffmanCode.get(b));
        }
        System.out.println("对应二进制编码："+stringBuilder);
        int len;
        if(stringBuilder.length()/8==0){
            len=stringBuilder.length()/8;
        }else{
            len=stringBuilder.length()/8+1;
        }
        byte[] b=new byte[len];
        int index=0;
        for (int i = 0; i <stringBuilder.length() ; i+=8) {
            String ch;
            if(i+8>stringBuilder.length()){
                ch=stringBuilder.substring(i);
                for (int j=0;j<ch.length();j++){
                    if(ch.length()==1){
                        break;
                    }if(ch.charAt(j)==48){//0对应的阿斯克码为48
                        count++;
                    }else{
                        break;
                    }
                }
            }else{
                ch=stringBuilder.substring(i,i+8);
            }
            b[index]=(byte)Integer.parseInt(ch,2);//将二进制字符串转成十进制
            index++;
        }
        System.out.println("cccc:"+count);
        return b;
    }
    //存放哈希曼编码表
    static Map<Byte,String> haffmanCode=new HashMap<>();
    //存放字符串，拼接
    static StringBuilder stringBuilder=new StringBuilder();
    //将哈希曼树转换成哈希曼编码表
    /**
     *
     * @param node 传入节点
     * @param code 表示向左为0 ，向右为1
     * @param stringBuilder 用于拼接code
     */
    public static void toHaffmanCode(Node1 node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(node.data==null){//非叶子节点
            //向左遍历
            toHaffmanCode(node.left,"0",stringBuilder1);
            //向右遍历
            toHaffmanCode(node.right,"1",stringBuilder1);
        }//叶子节点
        else{
            haffmanCode.put(node.data,stringBuilder1.toString());
        }
    }
    /**
     * 将字节数组转为Node1节点列表数组
     * @param bytes
     * @return
     */
    public static List<Node1> getNodes(byte[] bytes){
        List<Node1> list=new ArrayList<>();
        Map<Byte,Integer> maps=new HashMap<>();
        for(byte b:bytes){
            Integer count = maps.get(b);
            if(count==null){
                maps.put(b,1);
            }else{
                maps.put(b,count+1);
            }
        }
        //System.out.println(maps);
        //遍历map
        for(Map.Entry<Byte,Integer> entry:maps.entrySet()){
            list.add(new Node1(entry.getKey(),entry.getValue()));
        }
        return list;
    }

    /**
     * 将节点数组转化成哈夫曼树
     * @param nodes
     */
    public static Node1 haffmanTree(List<Node1> nodes){
        while(nodes.size()>1){
            Collections.sort(nodes);
            Node1 left=nodes.get(0);
            Node1 right=nodes.get(1);
            //根节点没有数据，只有权值
            Node1 parent=new Node1(null,left.value+right.value);
            parent.left=left;
            parent.right=right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    //前序遍历
    public static void preList(Node1 root){
        if(root!=null){
            root.preList();
        }else {
            System.out.println("空树");
            return;
        }
    }
}

class Node1 implements Comparable<Node1>{
    Byte data;//节点的信息
    Integer value;//权值
    Node1 left;
    Node1 right;

    public Node1(Byte data, Integer value) {
        this.data = data;
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node1{" +
                "data=" + data +
                ", value=" + value +
                '}';
    }
    //前序遍历
    public void preList(){
        System.out.println(this.value);
        if(this.left!=null){
            this.left.preList();
        }
        if(this.right!=null){
            this.right.preList();
        }
    }
    @Override
    public int compareTo(Node1 o) {
        return this.value-o.value;
    }
}
