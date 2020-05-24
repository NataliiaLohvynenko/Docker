public class Test{
public static void main(String[] args){
 System.out.println("Received # is " + args[0]);
 int num = Integer.parseInt(args[0]);
  for(int i =0; i<= num; i++){
            System.out.println("Square of " + i + "is " +(i*i));
        }
}
}