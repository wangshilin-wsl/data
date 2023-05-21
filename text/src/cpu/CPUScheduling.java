package cpu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
class Memory{//内存空间类，保存了100个页面
	Page[] mem=new Page[100];//

	public Memory() {//构造函数初始化内存的
		for(int i=0;i<100;i++){
			mem[i]=new Page(-1,10,false);
		}
	}
	public int doesItExist(int pro,int page){//0表示直接加入内存，1表示内存中有，2表示需要替换并不触发io,3替换要触发io
		for(int i=pro*4;i<pro*4+4;i++){//遍历该进程
			if(mem[i].ID==page){//该进程对应内存中有该页
				mem[i].ref=true;
				return 1;
			}
			if(mem[i].ID==-1){//该进程对应内存中还有空余，直接加入
				mem[i]=new Page(page,10,true);
				return 0;
			}
		}
		int index=-1;
		while(index==-1){//需要被替换的情况，找到被替换的下标
			for(int i=pro*4;i<pro*4+4;i++){
				if(!mem[i].ref){
					index=i;
					break;
				}else {
					mem[i].ref=false;
				}
			}
		}
		//进行替换
		if(mem[index].ID==2||mem[index].ID==5){//需要进行io
			mem[index].ID=page;
			mem[index].ref=true;
			return 3;
		}else {//不需要进行io
			mem[index].ref=true;
			mem[index].ID=page;
			return 2;
		}
	}
	public String display(){//返回内存状态的(字符串)
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=0;i<100;i++){
			stringBuilder.append(mem[i].ID+" ");
			if((i+1)%4==0){
				stringBuilder.append("||");
			}
		}
		stringBuilder.append("\n");
		return stringBuilder.toString();
	}
}
class Page{
	int ID;
	int time;
	boolean ref;

	public Page(int ID, int time, boolean ref) {
		this.ID = ID;
		this.time = time;
		this.ref = ref;
	}
}
class Process {
	int id;
	LinkedList<Page> page;//进程执行所需要的页
	int readyTime;//进程到达时间
	int times;//进程执行的次数，模拟cpu  1ms地执行，因为分级，所以得记录执行次数，用于分级

	public Process(int id, LinkedList<Page> page, int readyTime,int times) {
		this.id = id;
		this.page = page;
		this.readyTime = readyTime;
		this.times=times;
	}
}

public class CPUScheduling {
	public static void multiLevel_FB(List<Process> ready_q) {
		int t=0;//用于记录发生了多少次io
		Memory memory=new Memory();//内存对象
		StringBuilder stringBuilder=new StringBuilder();//用于存放每次内状态的
		Collections.sort(ready_q,(o1, o2) ->o2.readyTime-o1.readyTime);//对read_q进行排序，按到达时间的降序进行排序
		List<Process> first =new ArrayList<>();       // first level queue
		List<Process> second = new ArrayList<>();      // second level queue
		List<Process> third = new ArrayList<>();       // third level queue
		int global_time=0;//当前时间
		int currPro,currPage,start_time=0;//分别表示当前需要执行的进程id,页面id，开始的时间
		currPro=ready_q.get(13).id;//初始化为第一个执行进程的id
		currPage=ready_q.get(13).page.peek().ID;//初始化为第一个执行进程的第一个页面id
		System.out.println("process ID, page #, starting-time, leaving-time");
		while(true){//一个死循环用于模拟cpu的执行(以ms为单位)
			if(ready_q.size()>0&&ready_q.get(ready_q.size()-1).readyTime<=global_time){
				//每一次执行都将检查ready_q里面有没有准备好的进程，如果有就加入第一级调度
				first.add(0,ready_q.get(ready_q.size()-1));
				ready_q.remove(ready_q.size()-1);
			}
			//检查第一级调度里面有没有进行，如果有就执行
			if(first.size()>0){

				//用于判断上一次执行的进程id,页id和这次需要执行的是否一致，如果不一致就输出上一次的执行信息
				if(currPro!=first.get(first.size()-1).id||currPage!=first.get(first.size()-1).page.peek().ID){
					System.out.println("P"+(currPro+1)+",\t\t\tpage"+currPage+",\t\t"+start_time+"ms,\t\t"+global_time+"ms");
					//如果不一致，输出了之后，则更新当前进程id，页id，开始时间
					currPro=first.get(first.size()-1).id;
					currPage=first.get(first.size()-1).page.peek().ID;
					start_time=global_time;
				}
				//当前执行的页的时间-1
				first.get(first.size()-1).page.peek().time--;
				//执行次数+1
				first.get(first.size()-1).times++;
				//当该进程执行了8次，就相当于第一级调度运行完了，进入第二级调度
				if(first.get(first.size()-1).times==8){
					second.add(0,first.get(first.size()-1));
					first.remove(first.size()-1);
				}
				//判断当前页是否需要加入内存中
				int ret=memory.doesItExist(currPro,currPage);
				if(ret==0||ret==2||ret==3){
					stringBuilder.append(memory.display());
				}
				//发生了替换，并且需要io
				if(ret==3){
					t++;
					global_time+=30;
					//加入到就绪对列
					first.get(first.size()-1).times=0;
					ready_q.add(0,first.get(first.size()-1));
					first.remove(first.size()-1);
				}
			}else if(second.size()>0){//当这1ms第一级调度没有进程就执行第二级调度

				//判断页面是否执行完了，如果完了就将其从对列中移除
				if(second.get(second.size()-1).page.peek().time==0){
					second.get(second.size()-1).page.poll();
				}
				//用于判断上一次执行的进程id,页id和这次需要执行的是否一致，如果不一致就输出上一次的执行信息
				if(currPro!=second.get(second.size()-1).id||(!second.get(second.size()-1).page.isEmpty()&&currPage!=second.get(second.size()-1).page.peek().ID)){
					System.out.println("P"+(currPro+1)+",\t\t\tpage"+currPage+",\t\t"+start_time+"ms,\t\t"+global_time+"ms");
					//如果不一致，输出了之后，则更新当前进程id，页id，开始时间
					currPro=second.get(second.size()-1).id;
					currPage=second.get(second.size()-1).page.peek().ID;
					start_time=global_time;
				}
				//判断该进程是否执行完了
				if(second.get(second.size()-1).page.isEmpty()){
					second.remove(second.size()-1);
					global_time--;
				}else {
					second.get(second.size()-1).page.peek().time--;
					second.get(second.size()-1).times++;
					//判断第二级调度是否完了
					if(second.get(second.size()-1).times==24){
						third.add(0,second.get(second.size()-1));
						second.remove(second.size()-1);
					}
				}
				int ret=memory.doesItExist(currPro,currPage);
				if(ret==0||ret==2||ret==3){
					stringBuilder.append(memory.display());
				}
				if(ret==3){
					t++;
					global_time+=30;
					second.get(second.size()-1).times=0;
					ready_q.add(0,second.get(second.size()-1));
					second.remove(second.size()-1);
				}
			}else if(third.size()>0){
				//判断页面是否执行完了，如果完了就将其从对列中移除
				if(third.get(third.size()-1).page.peek().time==0){
					third.get(third.size()-1).page.poll();
				}
				//用于判断上一次执行的进程id,页id和这次需要执行的是否一致，如果不一致就输出上一次的执行信息
				if(currPro!=third.get(third.size()-1).id||(!third.get(third.size()-1).page.isEmpty()&&currPage!=third.get(third.size()-1).page.peek().ID)){
					System.out.println("P"+(currPro+1)+",\t\t\tpage"+currPage+",\t\t"+start_time+"ms,\t\t"+global_time+"ms");
					currPro=third.get(third.size()-1).id;
					currPage=third.get(third.size()-1).page.peek().ID;
					start_time=global_time;
				}
				if(third.get(third.size()-1).page.isEmpty()){
					third.remove(third.size()-1);
					global_time--;
				}else {
					third.get(third.size()-1).page.peek().time--;
				}
				int ret=memory.doesItExist(currPro,currPage);
				if(ret==0||ret==2||ret==3){
					stringBuilder.append(memory.display());
				}
				if(ret==3){
					t++;
					global_time+=30;
					third.get(third.size()-1).times=0;
					ready_q.add(0,third.get(third.size()-1));
					third.remove(third.size()-1);
				}
			}
			global_time++;
			if(ready_q.size()==0&&first.size()==0&&second.size()==0&&third.size()==0){
				System.out.println("P"+(currPro+1)+",\t\t\tpage"+currPage+",\t\t"+start_time+"ms,\t\t"+global_time+"ms");
				break;
			}
		}//while
		System.out.println(stringBuilder.toString());
		System.out.println(t);
	}

	public static void main(String args[]) throws IOException {
		List<Process> ready_q = new ArrayList<>();
		//读取数据文件
		BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\Users\\王世林\\Desktop\\processes.txt"));
		String temp=bufferedReader.readLine();
		int i=0;
		while(temp!=null){
			LinkedList<Page> page=new LinkedList<>();

			String[] split = temp.split(":")[1].split(",");
			for(int j=0;j<split.length;j++){
				if(!split[j].equals("")){
					page.add(new Page(Integer.parseInt(split[j]),10,false));
				}
			}
			Process process = new Process(i,page,i*20,0);
			i++;
			temp=bufferedReader.readLine();
			ready_q.add(process);
		}
		multiLevel_FB(ready_q);
	}
}