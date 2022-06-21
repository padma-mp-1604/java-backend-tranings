package functional_interface1;

import java.util.function.Consumer;

class ConsumerImpl implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
public class CustomerDemo {

    public static void main(String[] args) {

        //traditional way
//        Consumer<String> consumer = new ConsumerImpl();
//        consumer.accept("Hello world");


        //lambdaExpression
        Consumer<String > consumer1 =(s)-> System.out.println(s);
        consumer1.accept("hello world");
    }

}
