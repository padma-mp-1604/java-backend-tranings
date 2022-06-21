package lambda_expression1;

interface  Colour{
    void paint();
}
public class LambdaExample1 {
    public static void main(String[] args) {

        Colour red =() -> System.out.println("this is paint method of red Class");
        red.paint();
        Colour blue= () ->System.out.println("this is paint method of blue Class");
        blue.paint();
        Colour green = () ->System.out.println("this is paint method of green Class");
        green.paint();

        Colour white =  () -> System.out.println("this is paint method of white class");


        System.out.println("-----------------");

        paint(red);
        paint(blue);
        paint(green);
        paint(white);

        System.out.println("------------------");

        paint(()-> System.out.println("this is paint method of red Class"));
        paint(()-> System.out.println("this is paint method of blue Class"));
        paint(()-> System.out.println("this is paint method of green Class"));


    }

    public static void paint(Colour colour){
        colour.paint();
    }
}
