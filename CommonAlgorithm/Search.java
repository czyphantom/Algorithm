public class Search {

    /**
     * 二分搜索
     * @param array 有序数组
     * @return 目标值的秩(任意一个即可)
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable> int binarySearch(T[] array, T target) {
        int begin = 0,end = array.length;
        while (begin <= end) {
            int mid = (end-begin)/2+begin;
            if (array[mid].compareTo(target) == 0) {
                return mid;
            } else if (array[mid].compareTo(target) < 0) {
                begin = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }


    /**
     * 二分搜索
     * @param array 有序数组
     * @return 目标值的秩(任意一个)
     */
    public static <T extends Comparable> int binarySearchVersionB(T[] array, T target) {
        int begin = 0, end = array.length;
        while (end - begin > 1) {
            int mid = (eng-begin)/2+begin;
            if (array[mid].compareTo(target) > 0) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        return target == array[begin] ? begin : -1;
    }

    /**
     * 二分搜索
     * @param array 有序数组
     * @return 目标值的秩(最大一个），如果查找不到返回失败位置
     */
    public static <T extends Comparable> int binarySearchVersionB(T[] array, T target) {
        int begin = 0, end = array.length;
        while (begin < end) {
            int mid = (eng-begin)/2+begin;
            if (array[mid].compareTo(target) > 0) {
                end = mid;
            } else {
                begin = mid+1;
            }
        }
        return begin--;
    }    
}