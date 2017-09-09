import java.util.ArrayList;

/**
 * @author CalapovaMD
 * @version 1.0, 9/5/2017
 */
public class CovariationTest extends BRVTest {
    private double component;
    private int t;

    CovariationTest(int t){
        this.t=t;
    }

    public void run(BRVMethod method){
        boolean H0=true;
        double coefficient=Delta/(12*Math.sqrt(method.getN()-1));
        component =method.getMedian();
        component *=method.getN()*component/(method.getN()-1);
        ArrayList<Integer> values=new ArrayList<>();
        if(Math.abs(getR(0, method)-1.0/12)>=Math.sqrt(2)*coefficient) {
            H0=false;
            values.add(0);
        }
        for(int j=1;j<=t;j++)
            if(Math.abs(getR(j, method))>=coefficient){
                values.add(j);
                H0=false;
            }
        System.out.println("Covariation test:");
        if(H0)
            System.out.println("Hypothesis H0 accepted.");
        else {
            System.out.println("Hypothesis H1 accepted on values:");
            for(Integer i: values)
                System.out.println(i);
        }
    }

    private double getR(int j, BRVMethod method){
        double rj=0;
        double number=method.getN()-j;
        for(int i=1;i<=number;i++)
            try {
                rj+=method.getAlpha(i)*method.getAlpha(i+j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        rj/=number-1;
        rj-=component;
        return rj;
    }
}
