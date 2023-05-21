package jiedan.job6;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) throws ParseException, IOException {

        //open the file, read the contents, split data and save the data into an array
        double weeklyTotal = 0, weeklyAverage, total;
        String[] str;//list of data for a week
        File file = new File("C:\\Users\\wsl\\Desktop\\SalesData.txt");
        Scanner infile = new Scanner(file);
        double allSum=0;
        int i1=1;
        while (infile.hasNext()) {
            String data = infile.nextLine();
            str = data.split(",");
            //parse with Double.parseDouble()
            double sum=0;
            for(int i=0;i<str.length;i++){
                sum+=Double.parseDouble(str[i]);
            }
            allSum+=sum;
            System.out.println("第"+i1+"周总销售额为："+sum);
            System.out.println("第"+i1+++"周的平均日销售额为："+sum/str.length);
        }
        System.out.println();
        System.out.println("所有周的总销售额为："+allSum);
    }
}
