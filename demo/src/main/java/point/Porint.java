package point;

import java.util.LinkedList;

/**
 * Porint
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2020/4/20 16:11
 */
public class Porint {

    public static void main(String[] args) {
        MyNodeList st=new MyNodeList();
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        st.add(5);
        System.out.println("<<--初始化-->>");
        st.print();
        //System.out.println("size()---->>"+st.size());
        //System.out.println("<<--add-->>");
        //st.add(24);
        //st.print();
        //System.out.println("size()---->>"+st.size());
        //System.out.println("<<--del 0 -->>");
        //st.del(0);
        //st.print();
        //System.out.println("size()---->>"+st.size());
        //System.out.println("<<--del 6 -->>");
        //st.del(6);
        //st.print();
        System.out.println("size()---->>"+st.size());
        //System.out.println("getEndK()---->>"+st.getEndK(10));
        st.reserve();
        st.print();

        String s=null;
    }
}

class MyNodeList{

    MyNode head = null;

    public void reserve(){
        MyNode cur=head;
        MyNode per=null;
        while (cur.next!=null){
            MyNode next=cur.next;
            cur.next=per;
            per=cur;
            cur=next;
        }
        head=cur;
        head.next=per;

    }

    public boolean hasLoop(){
        if (size()>1){
            MyNode slow=head;
            MyNode fast=head;
            while (slow.next!=null&&fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if (slow.data==fast.data){
                    return true;
                }
            }
        }
        return false;
    }

    public int getEndK(int k){
        int size=size();
        if (size>0&&k<size){
            MyNode slow=head;
            MyNode fast=head;
            int i=0;
            while (i<k){
                i++;
                fast=fast.next;
            }
            while (fast.next!=null){
                slow=slow.next;
                fast=fast.next;
            }
            return slow.data;
        }
        return -1;
    }

    public int getMidNode(){
        if (size()>0){
            if (head.next==null){
                return head.data;
            }
            MyNode slow=head;
            MyNode fast=head;
            while (fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow.data;
        }
        return -1;
    }

    public void add(int data){
        MyNode node=new MyNode(data);
        if (head==null){
            head=node;
            return;
        }
        MyNode tmp=head;
        while (tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=node;
    }

    public void del(int index){
        if (index<0||index>size()){
            return;
        }
        if (index==0){
            head=head.next;
            return;
        }
        int i=0;
        MyNode cur=head;
        while (cur!=null){
            if (i==index-1){
                cur.next=cur.next.next;
                break;
            }
            i++;
            cur=cur.next;
        }
    }

    public void print(){
        MyNode tmp=head;
        while (tmp!=null){
            System.out.println(tmp.data);
            tmp=tmp.next;
        }
    }

    public int size(){
        int size=0;
        MyNode tmp=head;
        while (tmp!=null){
            size++;
            tmp=tmp.next;
        }
        return size;
    }

}

class MyNode{
    MyNode next = null;
    int data;
    public MyNode(int data){
        this.data=data;
    }
}
