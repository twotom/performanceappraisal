package cn.js.ccit.util;

public class CalcScoreUtil {
    private static int regularWorkScores[] ={0,100,90,80,50};
    private static int [][] keyWorkScores ={{0,0,0,0},{0,95,92,90},{0,88,84,80},{0,78,74,70}};
    private static int satisfactionScores[] ={0,90,80,70,50};
    private static double[] ratios ={0,1,0.95,0.9};
    public static double getRegularWorkScore(Integer choose){
        if (choose==null)
            return  0;

        return regularWorkScores[choose];
    }
    public static double getKeyWorkScore(Integer grade,Integer level,Integer charge){
        if (grade==null||level==null||charge==null)
            return  0;
        return keyWorkScores[grade][level]*ratios[charge];
    }
    public static double getSatisfactionScore(Integer choose){
        if (choose==null)
            return  0;
        return satisfactionScores[choose];
    }

}
