public class _Test{
    public static void main(String[] srgs){
        Thread x=new Thread(){
          @Override
          public void run() {
              while(true){
                  System.out.println("ALive");
              }
          }  
        };
        x.setDaemon(true);
        x.start();
        try{
            Thread.currentThread().sleep(1000);        
        } catch(Exception e){

        }
        
    }
}