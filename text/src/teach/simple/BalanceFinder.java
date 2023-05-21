package teach.simple;

public class BalanceFinder {
    /**
     * <p>
     * Given an array, return true if there is a place to split the array
     * so that the sum of the numbers on one side is equal to the sum of the
     * numbers on the other side.
     * </p>
     *
     * <p>Please note that the split position can be zero or beyond the last
     * element of the array. The sum of an empty array is considered as zero.
     * For example. The array {@code [1, 2, 3]} can be split into {@code []}
     * and {@code [1, 2, 3]}</p>
     *
     * <p>Examples:</p>
     *
     * <ul>
     *     <li>{@code isBalanced(new int[]{1, 1, 1, 2, 1})} returns {@code true}</li>
     *     <li>{@code isBalanced(new int[]{2, 1, 1, 2, 1})} returns {@code false}</li>
     *     <li>{@code isBalanced(new int[]{10, 10})} returns {@code true}</li>
     *     <li>{@code isBalanced(new int[]{0}} returns {@code true}</li>
     * </ul>
     *
     * @param numbers The given array.
     * @return {@code true} if the balanced place can be found. Or else, returns
     *   {@code false}. Please note that it will return {@code true} for empty
     *   array.
     * @throws IllegalArgumentException {@code numbers} is {@code null}.
     */
    public static boolean isBalanced(int[] numbers) {
        // TODO:
        // Please implement the method
        // <-start-
        if(numbers==null)
            throw new IllegalArgumentException();
        if(numbers.length==0)
            return true;
        if(numbers.length==1){
            if(numbers[0]==0)
                return true;
            else
                return false;
        }
        int left_sum=0,right_sum=0,i=-1,j=numbers.length;
        while(i<j-1) {
            if(left_sum>right_sum){
                j--;
                right_sum+=numbers[j];
            }else if(left_sum<right_sum) {
                i++;
                left_sum+=numbers[i];
            }else {
                j--;
                right_sum+=numbers[j];
            }
        }
        if(left_sum==right_sum)
            return true;
        else
            return false;
        // --end->
    }

    // TODO:
    // You can add additional members if you want
    // <-start-
    public static void main(String[] args) {
        System.out.println(isBalanced(new int[]{0}));
    }
    // --end-->
}
