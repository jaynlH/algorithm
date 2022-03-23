package com.nlhui.study.Leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LineCoincide {
    public static class Line{
        int start;
        int end;
        public Line(){};
        public Line(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public static int maxCover(int[][] m){
        Line[] lines=new Line[m.length];
        for (int i = 0; i < lines.length ; i++) {
            lines[i]=new Line(m[i][0],m[0][1]);
        }
        Arrays.sort(lines,new startUpSort());
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        int max=0;
        for (int i = 0; i <lines.length ; i++) {
            while (!heap.isEmpty()&&heap.peek()<=lines[i].start){
                heap.poll();
            }
            heap.add(lines[i].end);
            max=Math.max(max,heap.size());
        }
        return max;
    }



    static class startUpSort implements Comparator<Line> {
        @Override
        public int compare(Line o1, Line o2) {
            return o1.start-o2.start;
        }
    }

}
