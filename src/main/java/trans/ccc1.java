package trans;

public class ccc1 {

    public static void main(String[] args) {
        x x=new x();
        if(Integer.parseInt(String.valueOf(x))==1&&Integer.parseInt(String.valueOf(x))==2&&Integer.parseInt(String.valueOf(x))==3){
            System.out.println("成功");
        }



    }
}
class x{
    public  int x1=1;


    @Override
    public String toString() {
        return String.valueOf(x1++);
    }


}
