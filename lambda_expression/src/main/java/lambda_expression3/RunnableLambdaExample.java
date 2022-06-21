package lambda_expression3;


class ThreadDemo implements  Runnable{
    @Override
    public void run(){
        System.out.println("run method called");
    }
}

public class RunnableLambdaExample {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();

//        Runnable runnable = () -> System.out.println("run method called using lambda....");
//        Thread threadLambda = new Thread(runnable);
//        threadLambda.start();

        Thread threadLambda = new Thread(()->System.out.println("run method called using lambda...."));
        threadLambda.start();



    }
}
