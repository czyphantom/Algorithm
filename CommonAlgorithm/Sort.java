/**
 * 各种排序算法
 */

public class Sort {

    /**
     * 插入排序，基本思想是将当前位置的数字插入到前面有序的序列中。
     * 平均复杂度O(n^2)，是稳定排序。
     */
    public void insertionSort(int[] a) {
        int len = a.length;
        for (int i = 1;i < len;i++) {
            int j;
            for (j = i-1, v = a[i];j>=0 && a[j]>v;j--) {
                a[j+1] = a[j];
            }
            a[j+1] = v;
        }
    }

    /**
     * 选择排序，基本思想是从i到n-1位置中选取最小的元素放到第i个位置
     * 平均复杂度O(n^2)，是不稳定排序
     */
    public void selectionSort(int[] a) {
        for (int i = 0; i < length; i++) {
            int index = i;
            for (int j = i+1; j < length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index == i) {
                continue;
            }
            else {
                int temp;
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 冒泡排序，基本思想是两两比较相邻元素，如果前者比后者大，则交换，一趟下来可得到一个元素的正确位置。
     * 平均复杂度O(n^2)，是稳定排序
     */
    public void bubleSort(int[] a) {
        boolean flag = false;
        for (int i = 0;i < a.length;i++) {
            for (int j = 0;j < a.length-i-1;j++) {
                if (a[j] > a[j+1]) {
                    int temp  = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }
            //如果一趟下来没发生交换，说明有序了，直接跳出循环
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 快速排序，基本思路是选取一个枢纽元，通过将数组分成左半部分小于枢纽元，右半部分大于枢纽元来缩小问题规模。
     * 平均时间复杂度O(nlogn)，空间复杂度栈的深度，是不稳定的排序
     */
    public void quickSort(int[] a, int begin, int end) {
        if (begin < end) {
            int partition = partition(a, begin, end);
            quickSort(a, begin, partition-1);
            quickSort(a, partition+1, end);
        }
    }

    private int partition(int[] a, int begin, int end) {
        int pivot = a[begin];
        while (begin < end) {
            while (begin<end && a[end]>pivot) {
                end--;
            }
            if (begin < end) {
                a[begin++] = a[end];
            }
            while (begin<end && a[begin]<pivot) {
                begin++;
            }
            if (begin < end) {
                a[end--] = a[begin];
            }
        }
        a[begin] = pivot;
        return begin;
    }


    /**
     * 三向切分快排
     * @param a
     * @param low
     * @param hi
     */
	public static void sort(int[] a,int low,int hi) {
		if (hi <= low) {
            return;
        }
		int lt = low,i = low+1,gt = hi;
		int v = a[low];
		while (i <= gt) {
			if (a[i] < v) {
                exch(a, lt++, i++);
            }
			else if (a[i] > v) {
                exch(a,gt--,i++);
            }
			else {
                i++;
            }
		}
		sort(a, low, lt-1);
		sort(a, gt+1, hi);
	}

	private static void exch(int[] a, int i, int j) {
		int ex = a[i];
		a[i] = a[j];
        a[j] = ex;
    }

    /**
     * 快速排序非递归
     */
    public static void quickSort2(int[] nums, int low, int high) {
        int pivot;
        if (low >= high) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            pivot = partition(nums, low, high);
            if (low < pivot - 1) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }

    /**
     * 堆排序，主要思想是构建一个大顶堆，然后将堆顶元素和最后一个元素互换，再对剩下的元素进行调整。
     * 平均时间复杂度O(nlogn)，是不稳定的排序
     */
    public void heapSort(int[] a) {
        int len = a.length;
        //从最后一个非叶节点开始构造大顶堆
        for (int i = len/2-1;i >= 0;i--) {
            heapAdjust(a, i, len);
        }
        //交换堆顶和最后一个元素，再调整堆
        for (int i = len-1;i > 0;i--) {
            tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            heapAdjust(a, 0, i);
        }
    }

    //非递归写法
    private void heapAdjust(int[] a, int i, int len) {
        int temp;
        for (temp = a[i];2*i+1 < len;i = child) {
            int child = i*2+1;
            //比较得到较大的子节点
            if (child < len-1 && a[child+1] > a[child]) {
                child++;
            }
            //如果子节点较大，交换父子节点
            if (temp < a[child]) {
                a[i] = a[child];
                a[child] = temp;
            } else {
                break;
            }
        }
    }

    //递归写法
    private void HeapAdjust(int arr[], int i, int length) {
	    int max = i;
	    int lchild = i * 2 + 1;
	    int rchild = i * 2 + 2;
	    if (lchild < length && arr[lchild] > arr[max]) {
            max = lchild;
        }
	    if (rchild < length && arr[rchild] > arr[max]) {
		    max = rchild;
	    }
	    if (max != i) {
		    int temp;
		    temp = arr[i];
		    arr[i] = arr[max];
		    arr[max] = temp;
		    // 递归
		    HeapAdjust(arr, max, length);
        }
    }

    /**
     * 归并排序，基本思想是将两个有序数组合并成一个，通过不断缩小数组的规模实现
     * 递归写法
     */
    public void mergeSort(int[] a, int begin, int end) {
        if (begin < end) {
            int mid = (begin+end)/2;
            mergeSort(a, begin, mid);
            mergeSort(a, mid+1, end);
            merge(a,begin, mid, end);
        }
    }

    private void merge(int[] a, int begin, int mid, int end) {
        int[] temp = new int[end-begin+1];
        int i = begin, j = mid + 1;
        int m = mid,   n = end;
        int k = 0;
    
        while (i <= m && j <= n) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
    
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
    
        for (i = 0; i < k; i++) {
            a[begin + i] = temp[i];
        }  
    }

    /**
     * 归并排序非递归
     */
    public static void mergeSort(int[] nums) {
        int len = 1;
        while (len <= nums.length) {
            for (int i = 0;i+len <= nums.length;i += len*2) {
                int low = i, mid = i+len-1, high = i+len*2-1;
                if (high > nums.length - 1) {
                    high = nums.length -1;
                }
                merge(nums, low, mid, high);
            }
            len *= 2;
        }
    }

    /**
     * 希尔排序，基本思想是将需要排序的序列划分成为若干个较小的子序列，对子序列进行插入排序，通过则插入排序能够使得原来序列成为基本有序。
     * 是不稳定的排序算法
     */
    public void shellSort(int[] a) {
        int d, i, j, temp;
        int n = a.length;
        for(d = n/2;d >= 1;d = d/2) {
            for(i = d; i < n;i++) {
                temp = a[i];
                for(j = i - d;(j >= 0) && (a[j] > temp);j = j-d) {
                    a[j + d] = a[j];
                }
            a[j + d] = temp;
            }
        }
    }

    public void bucketSort(int[] a) {
        List<Integer> bucket[] = new ArrayList[bucketSize];
        for(int i=0; i < a.length ; i++) {
            int temp = a[i]/10000;
            if(bucket[temp] == null) {
                bucket[temp] = new ArrayList<Integer>();
            }
            bucket[temp].add(a[i]);
        }
        //对桶内各个元素进行排序
        for(int j=0;j<bucketSize;j++) {
            intsertSort(bucket[j]);
            printList(bucket[j]);
        }
    }

    private void printList(List<Integer> list) {
        while(list.size()>0) {
            System.out.print(list.remove(0) +"\t");
        }
    }

    private void intsertSort(List<Integer> list) {
        Collections.sort(list);
    }
}