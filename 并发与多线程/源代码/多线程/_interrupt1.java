public class _interrupt1{
    public static void main(String[] args){
        Thread x=new Thread(){        
            @Override
            public void run() {
                int i=0;
                while(!isInterrupted()&&i<=Integer.MAX_VALUE){
                    System.out.print(i+"->");
                    i++;
                }
            }
        };
        x.start();
        try{
            Thread.currentThread().sleep(100);
        } catch(Exception e){

        }
        x.interrupt();
    }
}