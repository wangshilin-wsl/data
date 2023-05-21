package teach.anothermedium;

public class StepCounter {
    /**
     * <p>A child is running up a staircase with {@code stepNumbers} steps. She can
     * hop either 1 or 2 steps at a time. So this method will count how many possible
     * ways the child can run up the stairs.</p>
     *
     * <p><b>Hint: </b>We can approach this problem from the top down. On the very last
     * hop, up to the n(th) step, the child could have done either a single or double
     * step hop. That is, the last move might have been a single step hop from step
     * {@code n-1} or a double step hop from step {@code n-2}. Then the total number of
     * ways of reaching the last step is therefore the sum of the number of ways of
     * reaching each of the last two steps.</p>
     *
     * @param stepNumbers The total number of steps of the stairs. This number should
     *                    be greater than or equal to 1 and less than or equal to 62.
     * @return The number of possible ways the child can run up the stairs.
     * @throws IllegalArgumentException the {@code stepNumbers} is out of range.
     */
    public static long countWays(int stepNumbers) {
        // TODO: Please implement the method.
        // <-start-
        if(stepNumbers>62||stepNumbers<1)
            throw new IllegalArgumentException();
        long[] result=new long[stepNumbers+1];
        result[1]=1;
        if(stepNumbers==1) return result[1];
        result[2]=2;
        if(stepNumbers==2) return result[2];
        for(int i=3;i<=stepNumbers;i++){
            result[i]=result[i-1]+result[i-2];
        }
        return result[stepNumbers];
        // --end->
    }

    // TODO: Please add additional helper method if you want.
    // <-start-
    public static void main(String[] args) {
        System.out.println(countWays(20));
    }
    // --end->
}
