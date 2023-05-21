package jiedan.job8;

public class one {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    //分治法
   /* public int maxSubArray(int[] nums) {
        return maxSubArrayDivideWithBorder(nums, 0, nums.length-1);
    }
    private int maxSubArrayDivideWithBorder(int[] nums, int start, int end) {
        if (start == end) {
            // 只有一个元素，也就是递归的结束情况
            return nums[start];
        }

        // 计算中间值
        int center = (start + end) / 2;
        int leftMax = maxSubArrayDivideWithBorder(nums, start, center); // 计算左侧子序列最大值
        int rightMax = maxSubArrayDivideWithBorder(nums, center + 1, end); // 计算右侧子序列最大值

        // 下面计算横跨两个子序列的最大值

        // 计算包含左侧子序列最后一个元素的子序列最大值
        int leftCrossMax = Integer.MIN_VALUE; // 初始化一个值
        int leftCrossSum = 0;
        for (int i = center ; i >= start ; i --) {
            leftCrossSum += nums[i];
            leftCrossMax = Math.max(leftCrossSum, leftCrossMax);
        }

        // 计算包含右侧子序列最后一个元素的子序列最大值
        int rightCrossMax = nums[center+1];
        int rightCrossSum = 0;
        for (int i = center + 1; i <= end ; i ++) {
            rightCrossSum += nums[i];
            rightCrossMax = Math.max(rightCrossSum, rightCrossMax);
        }

        // 计算跨中心的子序列的最大值
        int crossMax = leftCrossMax + rightCrossMax;

        // 比较三者，返回最大值
        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }*/
    //动态规划
    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = nums[0];    // 全局最大值
        int subMax = nums[0];  // 前一个子组合的最大值
        for (int i = 1; i < nums.length; i++) {
            if (subMax > 0) {
                // 前一个子组合最大值大于0，正增益
                subMax = subMax + nums[i];
            } else {
                // 前一个子组合最大值小于0，抛弃前面的结果
                subMax = nums[i];
            }
            // 计算全局最大值
            max = Math.max(max, subMax);
        }

        return max;
    }
    //暴力法
   /* public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }*/
}
