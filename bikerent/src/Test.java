
import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file=new File("C:\\");
        hh(file);
    }
    public static void hh(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                System.out.println(file1.getName());
                if(file1.isDirectory()){
                    hh(file1);
                }
            }
        }
    }
}
