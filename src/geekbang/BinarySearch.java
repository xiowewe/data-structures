package geekbang;

/**
 * 二分查找 O(logn)：
 * 1、只能针对数组
 * 2、针对有序数据
 * 3、数据太小不适合，过大也不适合（由于数组存储，占用连续空间）
 *
 * @author xiongwenwen
 * @since 2022/4/11 5:14 下午
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,3,4,5,6,7,9,10,12,15,17,19,22,27,35,36,37,44,55,66};
        System.out.println(algorithm(array,9));

        System.out.println(algorithmRecursive(array, 9, 0, array.length - 1));

        System.out.println(square(10));
    }

    public static int algorithm(int[] array, int value){
        int low = 0;
        int high = array.length - 1;

        int time = 0;
        while (low <= high){
            time ++;
            //low + (high - low)/2
            int middle = low+((high-low)>>1);
            if(array[middle] == value){
                System.out.println("执行：" + time + "次");
                return middle;
            }else if(array[middle] < value){
                low = middle + 1;
            }else{
                high = middle - 1;
            }
        }
        return -1;
    }

    public static int algorithmRecursive(int[] array, int value, int low, int high) {
        if(high < low) return -1;
        int middle = low + ((high - low) >> 1);

        if (array[middle] == value) {
            return middle;
        } else if (array[middle] < value) {
            return algorithmRecursive(array, value, middle + 1, high);
        } else {
            return algorithmRecursive(array, value, low, middle - 1);
        }
    }

    public static double square(int target){
        double base = 0;
        int l = 0,r = 9;
        double step = 10;
        for (int i = 0;i < 7 ;i++){
            step *= 0.1;
            while (l <= r){
                int middle = l + (r - l)/2;
                if(Math.pow((base+middle*step),2) == target){
                    return middle;
                }
                if(Math.pow((base+middle*step),2) < target){
                    l = middle + 1;
                }
                if(Math.pow((base+middle*step),2) > target){
                    r = middle - 1;
                }
            }
            base += (r)*step;
            l = 0;
            r = 9;
        }
        return base;
    }
}
