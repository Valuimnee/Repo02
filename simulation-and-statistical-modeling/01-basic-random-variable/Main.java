/**
 * @author CalapovaMD
 * @version 1.0, 9/4/2017
 */
public class Main {
    public static void main(String[] args) {
        long a0=261463909L;
        long c1=474379977;
        long M=2147483648L;
        int b=((Long)Long.max(c1, M-c1)).intValue();
        MultiplicationCongruentMethod mcm1=new MultiplicationCongruentMethod(a0, b, M);
        mcm1.run(1000);
        System.out.println("Multiplication congruent method:");
        printResults(mcm1);
        MomentsCoincidenceTest mcTest=new MomentsCoincidenceTest();
        CovariationTest cTest=new CovariationTest(30);
        TwoDimensionalUniformityTest uTest=new TwoDimensionalUniformityTest();
        mcTest.run(mcm1);
        cTest.run(mcm1);
        uTest.run(mcm1);
        System.out.println();

        long a02=234289925L;
        long c2=3097871;
        int b2=((Long)Long.max(c2, M-c2)).intValue();
        MultiplicationCongruentMethod mcm2=new MultiplicationCongruentMethod(a02, b2, M);
        mcm1.run(2000);
        mcm2.run(1000);
        int K=192;
        MacLarenMarsagliaMethod mmm=new MacLarenMarsagliaMethod(mcm1, mcm2, K);
        mmm.run(1000);
        System.out.println("MacLaren-Marsaglia method:");
        printResults(mmm);
        mcTest.run(mmm);
        cTest.run(mmm);
        uTest.run(mmm);
        System.out.println();

        System.out.println("D1 period: "+mcm1.getPeriod());
        System.out.println("D2 period: "+mcm2.getPeriod());
        System.out.println("MacLaren-Marsaglia method's period: "+mmm.getPeriod());
    }

    private static void printResults(BRVMethod method){
        try {
            System.out.println("1:    "+method.getAlpha(1));
            System.out.println("15:   "+method.getAlpha(15));
            System.out.println("100:  "+method.getAlpha(100));
            System.out.println("900:  "+method.getAlpha(900));
            System.out.println("1000: "+method.getAlpha(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
