package geekbang;

/**
 * 二分查找变形问题：
 * 1、查找第一个等于指定值的元素
 * 2、查找最后一个等于指定值的元素
 * 3、查找第一个大于等于指定值的元素
 * 4、查找最后一个小于等于指定值的元素
 *
 * @author xiongwenwen
 * @since 2022/4/11 8:05 下午
 */
public class BinarySearchVariant {

    public static void main(String[] args) {
        int[] array = {1,3,4,5,6,7,7,7,12,15,15,22,22,22,35,36,36,44,44,66};
        System.out.println(algorithmOne(array,7));
        System.out.println(algorithmTwo(array,7));
        System.out.println(algorithmThree(array,7));
        System.out.println(algorithmFour(array,7));
    }

    /**
     * 1\查找第一个等于指定值的元素
     */
    public static int algorithmOne(int[] array, int value){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int middle = low+((high-low)>>1);
            if(array[middle] == value){
                if(middle == 0 || array[middle - 1] == value){
                    high = middle - 1;
                }else {
                    return middle;
                }
            }else if(array[middle] < value){
                low = middle + 1;
            }else{
                high = middle - 1;
            }
        }
        return -1;
    }


    /**
     * 2\查找最后一个等于指定值的元素
     */
    public static int algorithmTwo(int[] array, int value){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int middle = low+((high-low)>>1);
            if(array[middle] == value){
                //和方法一唯一的改动点
                if(middle == array.length - 1 || array[middle + 1] != value){
                    return middle;
                }else {
                    low = middle + 1;
                }
            }else if(array[middle] < value){
                low = middle + 1;
            }else{
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 3\查找第一个大于等于指定值的元素
     */
    public static int algorithmThree(int[] array, int value){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int middle = low+((high-low)>>1);
            if(array[middle] < value){
                low = middle + 1;
            }else{
                if(middle == 0 ||array[middle - 1] < value){
                    return middle;
                }else{
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 4\查找最后一个小于等于指定值的元素
     */
    public static int algorithmFour(int[] array, int value){
        int low = 0;
        int high = array.length - 1;
        while (low <= high){
            int middle = low + ((high -low) >> 2);
            if(array[middle] > value){
                high = middle - 1;
            }else{
                if(middle == array.length - 1 || array[middle + 1] > value){
                    return middle;
                }else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }
}
