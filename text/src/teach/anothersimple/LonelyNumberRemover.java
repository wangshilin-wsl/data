package teach.anothersimple;

public class LonelyNumberRemover {

    /**
     * <p>
     * We'll say that an element in an array is "alone" if there are values before and after it,
     * and those values are different from it. Return a version of the given array where every
     * instance of the given value which is alone is replaced by whichever value to its left or
     * right is larger.
     * </p>
     *
     * <p>This function will not change the original array.</p>
     *
     * <p>Examples:</p>
     * <ul>
     *     <li>{@code removeLonelyNumber([1, 2, 3], 2)} returns {@code [1, 3, 3]}</li>
     *     <li>{@code removeLonelyNumber(1, 2, 3, 2, 5, 2], 2)} returns {@code [1, 3, 3, 5, 5, 2]}</li>
     *     <li>{@code removeLonelyNumber([3, 4], 3)} returns {@code [3, 4]}</li>
     * </ul>
     *
     * @param numbers The given number array.
     * @param targetValue Then given value.
     * @return The processed array. Please note that the method returns {@code null} if given array
     *         is {@code null}.
     */
    public static int[] removeLonelyNumber(int[] numbers, int targetValue) {
        // TODO:
        // Please implement the method
        // <-start-
        if(numbers==null){
            return null;
        }
        int[] result=new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            if(i!=0&&i!=numbers.length-1&&numbers[i]==targetValue&&numbers[i-1]!=targetValue&&numbers[i+1]!=targetValue){
                result[i]=Integer.max(numbers[i-1],numbers[i+1]);
            }else {
                result[i]=numbers[i];
            }
        }
        return result;
        // --end->
    }

    // TODO:
    // You can add additional members if you want
    // <-start-
    public static void main(String[] args) {
        int[] numbers={1, 1, 1, 2};
        int[] ints = removeLonelyNumber(numbers, 1);
        for (int i : ints) {
            System.out.print(i+"  ");
        }
    }
    // --end-->
}
