package com.nlhui.study.Comparators;

import java.util.Arrays;
import java.util.Comparator;

public class ShowComparator {
    public static class Student{
        private String name;
        private int id;
        private int age;

        public  Student(){}

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", age=" + age +
                    '}';
        }
    }

    public static class IdCompare implements Comparator<Student>{
        /**
         * 任何的compare方法
         * 只要返回负数，则认为第一个参数应该排在前面
         * 只要返回正数，则认为第二个参数应放在前面
         * 若返回0，谁在前面无所谓
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id<o2.id){
                return -1;
            }else if (o1.id> o2.id){
                return 1;
            }else {
                return 0;
            }
        }
    }



    public static void main(String[] args) {
        Student student1 = new Student("nlh", 5, 20);
        Student student2 = new Student("yxy", 2, 19);
        Student student3 = new Student("lrx", 3, 17);
        Student student4 = new Student("mxt", 7, 20);
        Student[] students=new Student[]{student1,student3,student2,student4};
        for (Student student : students) {
            System.out.print(student.toString()+" ");
        }
        System.out.println("=========");
        Arrays.sort(students,new IdCompare());
        for (Student student : students) {
            System.out.print(student.toString()+" ");
        }

    }


}
