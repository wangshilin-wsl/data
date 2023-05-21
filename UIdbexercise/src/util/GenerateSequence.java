package util;

import java.text.SimpleDateFormat;
import java.util.Date;

//该类产生今天销售的商品流水号
public class GenerateSequence {
	
	public String generate(String lastSequence){
		String newSequence="";
		
		String today=new SimpleDateFormat("yyyyMMdd").format(new Date());
		
		int last=Integer.parseInt(lastSequence);  //转换为整形
		last=last+1;
		newSequence=String.valueOf(last);
		while(newSequence.length()<4){
			newSequence="0"+newSequence;
		}

		newSequence=today+newSequence;
		System.out.println("新的流水号为："+newSequence);
		
		return newSequence;		
		
	}

}
