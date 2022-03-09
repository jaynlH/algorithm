package com.nlhui.study.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoStackImplementQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    public TwoStackImplementQueue(){};
    public TwoStackImplementQueue(Stack<Integer> pushStack,Stack<Integer>popStack){
        pushStack=new Stack<>();
        popStack=new Stack<>();
    }

    private void pushToPop(){
        if (popStack==null){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }
    private void add(int pushNum){
        pushStack.push(pushNum);
        pushToPop();
    }
    private int poll(){
        if (pushStack.isEmpty()&&popStack.isEmpty()){
            throw new NullPointerException("null!");
        }
        pushToPop();
        return popStack.pop();

    }
}
