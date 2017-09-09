/**
 * @author CalapovaMD
 * @version 1.0, 9/4/2017
 */
public class MacLarenMarsagliaMethod extends BRVMethod {
    private int K;
    private MultiplicationCongruentMethod D1;
    private MultiplicationCongruentMethod D2;
    private double[] V;

    MacLarenMarsagliaMethod(MultiplicationCongruentMethod d1, MultiplicationCongruentMethod d2, int k){
        D1=d1;
        D2=d2;
        K=k;
    }

    public void run(int n){
        this.n=n;
        alpha=new double[this.n];
        V = new double[K];
        for(int i=1; i<=K; i++)
            try {
                V[i-1]=D1.getAlpha(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        int s;
        for(int i=1; i<=this.n;i++)
             try {
                 s=(int)(D2.getAlpha(i)*K);
                 alpha[i-1]=V[s];
                 V[s]=D1.getAlpha(i+K);
             } catch (Exception e) {
                 e.printStackTrace();
             }
    }


    public long getPeriod() {
        double BInit;
        double CInit;
        V = new double[K];
        Long curPeriod=0L;
        double CCur;
        double BCur;
        for(int i=0; i<K; i++)
            V[i]=D1.next();
        BInit=D1.next();
        CInit=D2.next();
        V[(int)(CInit*K)]=BInit;
        ++curPeriod;
        while(true){
            CCur=D2.next();
            BCur=D1.next();
            if((CCur==CInit)&&(BCur==BInit)) {
                break;
            }else{
                ++curPeriod;
            }
            V[(int)(CCur*K)]=BCur;
        }
        return curPeriod;
    }
}
