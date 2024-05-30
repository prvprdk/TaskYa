import java.util.concurrent.TimeUnit;

public class Segments {


    static void nonIntersecting  (int [] x1, int [] x2 ){


        labe: for (int i = 0; i < x1.length; i++){

            for (int j = 0; j < x1.length; j++){
              if (i == j)  continue;
              if (x2[i] == x2[j]) continue labe;
              if (x1[i] > x1 [j] & x2[i] < x2 [j]) continue labe;
              if (x1[i] < x1 [j] & x2[j] < x2 [i]) continue labe;

            }
            System.out.printf("Отрезок  %d %d ни с кем не пересекается \n", x1[i], x2[i]);
        }




    }
    static void   intersecting (int [] x1, int [] x2 ){

       for (int i = 0; i < x1.length; i++){
           for (int j = 0; j < x2.length; j++){
               if (i == j) continue;
               if ((x1[j] > x1[i] && x2[j] < x2[i] ))
                   System.out.printf("Пересекающиеся отрезки %d %d и %d %d \n", x1[i], x2[i], x1[j], x2[j]);
           }
       }

    }

    public static void main(String[] args) {

        int [] x1 = {2,3,4,6,9};
        int [] x2 = {6,9,2,9,10};
        nonIntersecting(x1,x2);

    }
}
