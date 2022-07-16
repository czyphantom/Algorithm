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
}