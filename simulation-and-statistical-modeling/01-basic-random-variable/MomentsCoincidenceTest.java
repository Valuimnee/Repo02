/**
 * @author CalapovaMD
 * @version 1.0, 9/5/2017
 */
public class MomentsCoincidenceTest extends BRVTest {
    MomentsCoincidenceTest(){}

    public void run(BRVMethod method){
        System.out.println("Moment coincidence test:");
        double Xi1=method.getMedian()-0.5;
        double Xi2=method.getDispersion()-1.0/12;

        if(countC1(method.getN())*Math.abs(Xi1)<Delta)
            System.out.println("First moment satisfied the hypothesis H0.");
        else System.out.println("First moment satisfied the hypothesis H1.");
        if(countC2(method.getN())*Math.abs(Xi2)<Delta)
            System.out.println("Second moment satisfied the hypothesis H0.");
        else System.out.println("Second moment satisfied the hypothesis H1.");
    }

    private double countC1(int n){
        return Math.sqrt(12*n);
    }
    private double countC2(int n){
        return ((double)(n-1))/(n*Math.sqrt(0.0056/n+0.0028/n/n-0.0083/(n*n*n)));
    }
}
