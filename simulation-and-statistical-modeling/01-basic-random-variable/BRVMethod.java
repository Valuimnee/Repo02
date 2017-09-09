/**
 * @author CalapovaMD
 * @version 1.0, 9/4/2017
 */
public abstract class BRVMethod {
    double[] alpha;
    int n;

    public abstract void run(int n);

    public double getAlpha(int i) throws Exception {
        if(i>0)
            return alpha[i-1];
        throw new Exception("Wrong index");
    }
    public int getN(){
        return n;
    }
    public double getMedian(){
        double m=0d;
        for(int i=0;i<n;i++)
            m+=alpha[i];
        m/=n;
        return m;
    }
    public double getDispersion(){
        double m=getMedian();
        double d =0d;
        for(int i=0;i<n;i++)
            d+=(alpha[i]-m)*(alpha[i]-m);
        d/=(n-1);
        return d;
    }

    public abstract long getPeriod();
}
