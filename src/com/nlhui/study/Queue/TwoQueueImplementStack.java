package com.nlhui.study.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueImplementStack {
    public static class TQIS<T>{
        public Queue<T> queue;
        public Queue<T> help;
        public TQIS(){
            queue=new LinkedList<>();
            help=new LinkedList<>();
        }
        public void push(T value){
            queue.offer(value);
        }
        public T poll(){
            while(queue.size()>1){
                help.offer(queue.poll());
            }

            T ans= queue.poll();
            Queue<T> temp=queue;
            queue=help;
            help=temp;
            return ans;
        }
    }




}
