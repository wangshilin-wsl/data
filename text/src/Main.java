import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> list = new Main().buildArray(new int[]{1, 3}, 3);
        list.forEach(System.out::println);
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();

        int index = 1;
        for (int i = 0; i < target.length; ) {
            int tar = target[i];
            if(tar == index){
                list.add("Push");
                index++;
                i++;
            }else {
                while (index < tar){
                    list.add("Push");
                    list.add("Pop");
                    index++;
                }
            }
        }

        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void hh(Integer i) {
        System.out.println("aa");
    }

    public void hh1(Integer i) {
        System.out.println("aa");
    }

    public void hh2(Integer i) {
        System.out.println("aa");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.forEach(Main::hh);
    }

    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (hh(words[i], words[j]) && max < words[i].length() * words[j].length()) {
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }

    public boolean hh(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (b.contains(a.charAt(i) + "")) {
                return false;
            }
        }
        return true;
    }


    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;
        return res;

    }

    List<List<Integer>> res = new ArrayList<>();

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int last = level % 2 == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            //同一层级
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (level % 2 == 1) {
                    //奇数层级，都是偶数并且递减
                    if (temp.val % 2 == 1) {
                        return false;
                    }
                    if (temp.val >= last) {
                        return false;
                    }
                    last = temp.val;
                } else {
                    //偶数层级，都是奇数并且递增
                    if (temp.val % 2 == 0) {
                        return false;
                    }
                    if (temp.val <= last) {
                        return false;
                    }
                    last = temp.val;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            //层级加一
            level++;
        }
        return true;
    }



    public int[] countBits(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(Integer.bitCount(i));
        }
        return list.stream().mapToInt(value -> value.intValue()).toArray();
    }


    public int bitCount3(int x){

        int count = 0;

        while(x!=0){

            if(x<0){

                count++;

            }

            x = x<<1;

        }

        return count;

    }




    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char maxChar = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if(time > max){
                max = time;
                maxChar = keysPressed.charAt(i);
            }else if(time == max){
                maxChar = keysPressed.charAt(i) > maxChar ? keysPressed.charAt(i) : maxChar;
            }
        }
        return maxChar;
    }



    public int removePalindromeSub(String s) {
        return s.equals(new StringBuilder(s).reverse()) ? 1: 2;
    }

    public int getNext(int n){
       int temp =0;
       while(n != 0){
           temp += Math.pow((n%10),2);
           n /= 10;
       }
        return temp;
    }

    public boolean isHappy(int n) {
       int fast = getNext(n);
       int slow = n;
       while (fast != slow && slow != 1){
           slow = getNext(slow);
           fast = getNext(getNext(fast));
       }
       return slow ==1;
    }


    int m,n;
    boolean[][] flag;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numEnclaves(int[][] grid) {
        int ret = 0;
        m = grid.length;
        n = grid[0].length;
        flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            hh(grid,i,0);
            hh(grid,i,n - 1);
        }

        for (int j = 0; j < n; j++) {
            hh(grid,0,j);
            hh(grid,m - 1,j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !flag[i][j]){
                    ret++;
                }
            }
        }
        return ret;
    }

    public void hh(int[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= m || y >= n ||
                flag[x][y] || grid[x][y] == 0){
            return ;
        }
        flag[x][y] = true;
        for (int i = 0; i < dir.length; i++) {
            hh(grid,x + dir[i][0],y + dir[i][1]);
        }
    }


    public int maxNumberOfBalloons(String text) {
        int[] times = new int[5];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < text.length(); i++) {
            char temp = text.charAt(i);
            if(temp == 'b'){
              times[0]++;
            }else if(temp == 'a'){
                times[1]++;
            }else if(temp == 'l'){
                times[2]++;
            }else if(temp == 'o'){
                times[3]++;
            }else if(temp == 'n'){
                times[4]++;
            }
        }
        times[2] /= 2;
        times[3] /= 2;
        IntStream stream = Arrays.stream(times);


        return Arrays.stream(times).min().getAsInt();
    }



    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if(map.containsKey(temp) && Math.abs(i - map.get(temp)) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }


    public boolean isOneBitCharacter(int[] bits) {
       int i = 0;
       while(i < bits.length){
           if(i == bits.length -1){
               return true;
           }
           if(bits[i] == 1){
               i += 1;
           }
           i += 1;

       }
       return false;
    }

    public String complexNumberMultiply(String num1, String num2) {
        String[] split1 = num1.split("\\+|i");
        String[] split2 = num2.split("\\+|i");
        int shibu1 = Integer.parseInt(split1[0]);
        int xubu1 = Integer.parseInt(split1[1]);
        int shibu2 = Integer.parseInt(split2[0]);
        int xubu2 = Integer.parseInt(split2[1]);
        return String.format("%d+%di",shibu1*shibu2-xubu1*xubu2
        ,shibu1*xubu2+shibu2 * xubu1);

    }



    public int maximumDifference(int[] nums) {
        int max = -1;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i] -min;
            max = Math.max(temp > 0 ? temp:-1,max);
            min = Math.min(min,nums[i]);

        }
        return max;
    }


    public String tree2str(TreeNode root) {
        StringBuffer stringBuffer = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            stack.push(root);
            while(!stack.isEmpty()){

            }
        }
        return null;
    }


    public int calPoints(String[] ops) {
        if(ops.length == 0 || ops == null){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            String temp = ops[i];
            if("C".equals(temp)){
                list.remove(list.size() - 1);
            }else if("D".equals(temp)){
                list.add(list.get(list.size() - 1) * 2);
            }else if("+".equals(temp)){
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            }else {
                list.add(Integer.parseInt(temp));
            }
        }
        return list.stream().reduce(Integer::sum).get();
    }

    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if(letters[i] > target){
                return letters[i];
            }
        }
        return letters[letters.length - 1];
    }


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        hh(root1, list1);
        hh(root2, list2);
        List<Integer> list = new ArrayList<>();
        int i1 = 0,i2 = 0;
        while (true){
            if(i1 == list1.size()){
                list.addAll(list2.subList(i2, list2.size()));
                break;
            }
            if(i2 == list2.size()){
                list.addAll(list1.subList(i1, list1.size()));
                break;
            }

            boolean temp = list1.get(i1) >list2.get(i2);
            list.add(temp ? list2.get(i2++) : list1.get(i1++));
        }
        return list;
    }
    void hh(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        hh(root.left, list);
        list.add(root.val);
        hh(root.right, list);
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        boolean ret = true;
        for (int i = 0; i < ransomNote.length(); i++) {
            a[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            a[magazine.charAt(i) - 'a']--;
        }
        for (int i = 0; i < a.length; i++) {
            if(a[i] > 0){
                ret = false;
                break;
            }
        }
        return ret;
    }

    public double largestTriangleArea(int[][] points) {
        if(points.length < 3){
            return 0;
        }
        double max = Double.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    max = Math.max(max, getArea(points[i][0], points[j][0], points[k][0], points[i][1], points[j][1], points[k][1]));
                }

            }
        }

        return max;
    }

    double getArea(double x1, double x2, double x3, double y1, double y2, double y3){
        return (Math.abs(x1*y2+x2*y3 + x3* y1 - x1 * y3 - x2 * y1 - x3 * y2))/2;
    }
    public String removeOuterParentheses(String s) {
        if(s == null || "".equals(s.trim())){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if(')' == c){
                //遇到反括号，直接出栈
                left--;
            }

            if(left != 0){
                sb.append(c);
            }
            if('(' == c){
                //碰到正括号,入栈
                left++;
            }
        }
        return sb.toString();
    }



    public String validIPAddress(String queryIP) {
        String ipv4 = "((2(5[0-5]|[0-4]\\d))|(1([0-9][0-9]))|[1-9][0-9]?|[0-9])(.((2(5[0-5]|[0-4]\\d))|(1([0-9][0-9]))|[1-9][0-9]?|[0-9])){3}";
        String ipvv6 = "([0-9a-fA-F]{1,4})(:[0-9a-fA-F]{1,4}){7}";
        if(queryIP == null || "".equals(queryIP.trim())){
            return "Neither";
        }
        if(queryIP.matches(ipv4)){
            return "IPv4";
        }
        if(queryIP.matches(ipvv6)){
            return "IPv6";
        }
        return "Neither";
    }


    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        for (int num : nums) {
            if(temp.contains(num - k)){
                set.add(num - k);
            }
            if(temp.contains(k + num)){
                set.add(num);
            }
            temp.add(num);
        }
        return set.size();
    }






    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if(head ==  null){
            insert.next = insert;
            return insert;
        }
        Node temp = head;
        while(true){
            if(temp.val <= insertVal && temp.next.val >= insertVal){
                break;
            }
            if(temp.val > temp.next.val &&
                    (temp.val <= insertVal ||
                    insertVal <= temp.next.val)){
                break;
            }

            temp = temp.next;
            if(temp == head){
                break;
            }
        }
        insert.next = temp.next;
        temp.next = insert;
        return head;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        hh(root);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    int hh(TreeNode root){
        if(root == null){
            return 0;
        }
       int left = hh(root.left);
        int right = hh(root.right);
        int key = root.val + right + left;
        int temp = map.getOrDefault(key, 0) + 1;
        map.put(key, temp);
        if(max < temp){
            max = temp;
        }
        return key;
    }


    int mod = 1000000007;
    public int numPrimeArrangements(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if(hh(i)){
                num++;
            }
        }
        return (int)(hh1(num) * hh1(n - num) % mod);
    }
    boolean hh(int n){
        if(n == 1){
            return false;
        }
        for (int i = 2; i < n; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    long hh1(int n){
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret*=i;
            ret%= mod;
        }
        return ret;
    }

    char[] chars;
    public List<Integer> diffWaysToCompute(String expression) {
        chars = expression.toCharArray();
        return dfs(0, chars.length -1);
    }
    List<Integer> dfs(int l,int r){
        List<Integer> temp = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if(Character.isDigit(chars[i])){
                continue;
            }
            List<Integer> left = dfs(l, i - 1);
            List<Integer> right = dfs(i + 1, r);
            for (int i1 = 0; i1 < left.size(); i1++) {
                for (int i2 = 0; i2 < right.size(); i2++) {
                    if(chars[i] == '-'){
                        temp.add(left.get(i1) - right.get(i2));
                    }else if (chars[i] == '+'){
                        temp.add(left.get(i1) + right.get(i2));
                    }else {
                        temp.add(left.get(i1) * right.get(i2));
                    }
                }
            }
        }
        if(temp.isEmpty()){
            int res = 0;
            for (int i = l; i <= r; i++) {
                res = res * 10 + (chars[i] - '0');
            }
            temp.add(res);
        }

        return temp;
    }



    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Integer min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] <= min){
                if(arr[i + 1] - arr[i] < min){
                    min = arr[i + 1] - arr[i];
                    res.clear();
                }
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                res.add(list);
            }
        }
        return res;
    }




    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        final String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            String temp = split[i];
            for (int j = 0; j < temp.length(); j++) {
                final String substring = temp.substring(0, j + 1);
                if(set.contains(substring)){
                    split[i] = substring;
                    break;
                }
            }
        }
        return String.join(" ", split);
    }





    public int arrayNesting(int[] nums) {
        Integer max = Integer.MIN_VALUE;
        boolean[] temp = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i, k = 0;
            while(!temp[j]){
                temp[j] = true;
                k++;
                j = nums[j];
            }
            max = Math.max(max, k);
        }
        return max;
    }

    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        deque.add(root);
        int level=0;
        int res = -1;
        while(!deque.isEmpty()){
           int size = deque.size();
           int temp = 0;
           level++;
            for (int i = 0; i < size; i++) {
                final TreeNode node = deque.poll();
                temp += node.val;
                if(node.left != null){
                    deque.add(node.left);
                }
                if(node.right != null){
                    deque.add(node.right);
                }
            }
            if(max < temp){
                max = temp;
                res = level;
            }
        }
        return res;
    }

    List<List<Integer>> list = new ArrayList<>();
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 1);
        return max + 1;
    }
    public void dfs(TreeNode root, int level, int index){
        if(root == null){
            return;
        }
        if(list.size() <= level){
            list.add(new ArrayList<>());
            list.get(level).add(index);
        }
        int temp = index - list.get(level).get(0);
        if(temp > max){
            max = temp;
        }
        dfs(root.left, level + 1, 2 * index - 1);
        dfs(root.right, level + 1, 2 * index);
    }
}








