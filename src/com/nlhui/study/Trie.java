    package com.nlhui.study;

    public class Trie {
        public static class Node1{
            int pass;
            int end;
            //'a' - 'z' 26个字母
            Node1[] next;
            public Node1(){
                int pass=0;
                int end=0;
                next=new Node1[26];
            }
        }

        private static Node1 start;
        //向前缀树中加入某个字符串
        public  static void insertStr(String word){
            if (word==null){
                return;
            }
            char[] chars = word.toCharArray();
            int path=0;
            Node1 node=start;
            for (int i = 0; i <chars.length ; i++) {
                path= chars[i]-'a';
                node.pass++;
                if (node.next[path]==null){
                    node.next[path]=new Node1();

                }
                node.next[path].pass++;
                node=node.next[path];
            }
            node.end++;

        }
        //搜索某个字符串出现了几次
        public  static int searchStrTimes(String word){
            if (word==null){
                return 0;
            }
            int path=0;
            Node1 node=start;
            char[] chars= word.toCharArray();
            for (int i = 0; i <chars.length ; i++) {
                path= chars[i]-'a';
                node.pass++;
                if (node.next[path]==null){
                    return 0;
                }
                node=node.next[path];
            }
            return node.end;

        }
        //查询某个字符串是几个字符串的前缀
        public  static int countPrefix(String word){
            if (word==null){
                return 0;
            }
            int path=0;
            Node1 node=start;
            char[] chars = word.toCharArray();
            for (int i = 0; i <chars.length ; i++) {
                node.pass++;
                path = chars[i]-'a';
                if (node.next[path]==null){
                    return 0;
                }
                node=node.next[path];
            }
            return node.pass;

        }
        //删除一个字符串
        public static void deleteStr(String word){
            if (searchStrTimes(word)!=0){
                Node1 node= start;
                int path=0;
                char[] chars = word.toCharArray();
                for (int i = 0; i <chars.length ; i++) {
                    path=chars[i]-'a';

                    /**
                     * 若path-1==0,说明只存在一次，只需将此节点置为空，就删除了
                     * 还有一种情况，比如有两个"abc",则按顺序将p--，最后一个字符对应的节点e--
                     */
                    if (--node.next[path].pass==0){
                        node.next[path]=null;
                        return;
                    }
                    node=node.next[path];
                }
                node.end--;
            }

        }

    }
