package bishi2.job1;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().wordCount();
    }//统计文本中单词出现的个数
    public void wordCount() throws Exception{
        File file=new File("C:\\Users\\王世林\\Desktop\\war_and_peace.txt");
        Scanner sc=new Scanner(file);
        HashMap<String,Integer> hashMap=new HashMap<>();
        System.out.println("文章----------------------");
        while(sc.hasNextLine()){
            String line=sc.nextLine();
            String[] lineWords=line.split("\\s+");

            Set<String> wordSet=hashMap.keySet();
            for(int i=0;i<lineWords.length;i++){

                if(wordSet.contains(lineWords[i])){
                    Integer number=hashMap.get(lineWords[i]);
                    number++;
                    hashMap.put(lineWords[i],number);
                }else{
                    hashMap.put(lineWords[i],1);
                }
            }
        }

        System.out.println("统计单词------------------");
        Iterator<String> iterator=hashMap.keySet().iterator();
        int num=0;
        while(iterator.hasNext()){
            String word=iterator.next();
            num++;
            System.out.printf("单词:%-12s   出现次数：%d\n",word,hashMap.get(word));
        }
        System.out.println(num+"----");
        System.out.println(hashMap.containsKey(""));
    }
}