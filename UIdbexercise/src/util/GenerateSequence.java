package util;

import java.text.SimpleDateFormat;
import java.util.Date;

//��������������۵���Ʒ��ˮ��
public class GenerateSequence {
	
	public String generate(String lastSequence){
		String newSequence="";
		
		String today=new SimpleDateFormat("yyyyMMdd").format(new Date());
		
		int last=Integer.parseInt(lastSequence);  //ת��Ϊ����
		last=last+1;
		newSequence=String.valueOf(last);
		while(newSequence.length()<4){
			newSequence="0"+newSequence;
		}

		newSequence=today+newSequence;
		System.out.println("�µ���ˮ��Ϊ��"+newSequence);
		
		return newSequence;		
		
	}

}
