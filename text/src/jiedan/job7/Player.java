package jiedan.job7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Song{
    String name;
    String singer;

    public Song(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }
}
public class Player {
    List<Song> songList;

    public Player( List<Song> songList) {
        this.songList = songList;
    }
    public void add(Song song){
        songList.add(song);
    }
    public void remove(int i){
        if(i>=songList.size()){
            System.out.println("位于"+i+"的歌曲不存在！！！");
            return;
        }
        songList.remove(i);
    }
    public void moveUP(int i){
        if(i>=songList.size()){
            System.out.println("位于"+i+"的歌曲不存在！！！");
            return;
        }
        if(i==0) return;
        Collections.swap(songList,i-1,i);

    }
    public void moveDown(int i){
        if(i>=songList.size()){
            System.out.println("位于"+i+"的歌曲不存在！！！");
            return;
        }
        if(i==songList.size()-1) return;
        Collections.swap(songList,i,i+1);

    }
    public void play(int i){
        if(i>=songList.size()){
            System.out.println("位于"+i+"的歌曲不存在！！！");
            return;
        }
        System.out.println("当前播放歌曲的信息：");
        System.out.println("歌名："+songList.get(i).name+"  歌手："+songList.get(i).singer);
    }
    public void playAll(){
        System.out.println("所有歌曲信息：");
        for(int i=0;i<songList.size();i++)
        System.out.println("歌名："+songList.get(i).name+"  歌手："+songList.get(i).singer);
    }

    public static void main(String[] args) {
        List<Song> songs=new ArrayList<>();
        songs.add(new Song("左手指月","萨顶顶"));
        songs.add(new Song("起风了","买辣椒也要用劵"));
        songs.add(new Song("麻雀","李荣浩"));
        songs.add(new Song("愿得一人心","李行亮"));
        songs.add(new Song("手掌心","丁当"));
        Player player = new Player(songs);
        player.play(1);
        player.playAll();
        player.moveUP(1);
        System.out.println("将第二首歌曲上移后：");
        player.playAll();

        player.moveDown(1);
        System.out.println("将第二首歌曲下移后：");
        player.playAll();


        player.remove(1);
        System.out.println("移除第二首歌曲后：");
        player.playAll();
    }
}
