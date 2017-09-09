import java.util.Arrays;

/**
 * @author CalapovaMD
 * @version 1.0, 9/6/2017
 */
public class TwoDimensionalUniformityTest extends BRVTest {
    private static final double c=0.5;
    private int k;
    private double Xi2Table;
    private int M;
    private double[] r;
    private int[] m;
    private double[] p;

    TwoDimensionalUniformityTest(){
        k=10;
        Xi2Table=18.307;
        //k=30;
        //Xi2Table=43.773;
        MultiplicationCongruentMethod method=
                new MultiplicationCongruentMethod(65539,65539, 2147483648L);
        method.run(this.k);
        r=new double[k];
        for(int i=0;i<k;++i)
            try {
                r[i]=method.getAlpha(i+1)/2.0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        Arrays.sort(r);
        r[0]=0.;
        m=new int[k];
        p=new double[k];
        for(int i=1;i<k;++i)
            p[i-1]=Math.PI*(r[i]*r[i]-r[i-1]*r[i-1]);
        p[k-1]=1-Math.PI*r[k-1]*r[k-1];
    }
    public void run(BRVMethod method) {
        M=method.getN()/2;
        for(int i=0;i<k;++i)
            m[i]=0;
        double d;
        try {
            for(int i=1;i<=M;++i){
                d=Math.sqrt((method.getAlpha(2*i-1)-c)*(method.getAlpha(2*i-1)-c)
                        +(method.getAlpha(2*i)-c)*(method.getAlpha(2*i)-c));
                for(int j=k-1;j>0;)
                    if(d>=r[j]){
                        ++m[j];
                        j=0;
                    } else {
                        j--;
                        if(j==0)
                            ++m[0];
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        double Xi2=0.;
        double cur;
        for(int i=0;i<k;++i){
            cur=M*p[i];
            Xi2+=(m[i]-cur)*(m[i]-cur)/cur;
        }
        System.out.println("Two-dimensional uniformity test, k = "+k+":");
        if(Xi2<Xi2Table)
            System.out.println("Hypothesis H0 accepted.");
        else
            System.out.println("Hypothesis H1 accepted.");
    }
}
