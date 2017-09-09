/**
 * @author CalapovaMD
 * @version 1.0, 9/4/2017
 */
public class MultiplicationCongruentMethod extends BRVMethod {
    private long Alpha0;
    private int B;
    private long M;
    private long alphaPrev;

    MultiplicationCongruentMethod(long alpha0, int b, long m){
        alphaPrev=alpha0;
        Alpha0=alpha0;
        B=b;
        M=m;
    }

    public void run(int n){
        this.n=n;
        alpha=new double[n];
        long alphaPrev=Alpha0;
        for(int i=0;i<this.n;i++){
            alphaPrev=(B*alphaPrev)%M;
            alpha[i]=(double)alphaPrev/M;
        }
    }
    public long getPeriod(){
        long period=0;
        double alphaInit;
        long alphaPrev=Alpha0;
        alphaPrev=(B*alphaPrev)%M;
        alphaInit=(double)alphaPrev/M;
        ++period;
        while(true){
            alphaPrev=(B*alphaPrev)%M;
            if(alphaInit==(double)alphaPrev/M)
                break;
            else ++period;
        }
        return period;
    }

    public double next(){
        alphaPrev=(B*alphaPrev)%M;
        return (double)alphaPrev/M;
    }
    public void skip(){
        alphaPrev=Alpha0;
    }
}
