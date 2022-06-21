package lambda_expression2;

interface Addable {
    int addition(int a, int b);
}

class Addition implements Addable {

    @Override
    public int addition(int a, int b) {
        return 0;
    }
}

public class LambdaExample2 {

    public static void main(String[] args) {

//        Addable add = (a,  b) -> (a + b);
//        int result =add.addition(20, 30);
//        System.out.println(result);


        Addable add = (int a, int b) ->
        {
            int c = (20 + 30);
            return c;
        };
    }
}
