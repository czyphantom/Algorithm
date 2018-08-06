/**
 * 题目：给定一个迭代器类的接口，接口包含两个方法：next()和hasNext()。设计并实现一个支持peek()操作的顶端迭代器，就是把原本应由next()方法返回的元素peek()出来。
 * 难度：Medium
 * 思路：利用一个缓存保存下一个元素
 */

class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer cache = null;

    public PeekingIterator(Iterator<Integer> iter) {
        iterator = iter;
    }

    public Integer peek() {
        if (cache == null) {
            cache = iterator.next();
        }
        return cache;
    }

    @Override
    public Integer next() {
        if (cache == null) {
            return iterator.next();
        }
        Integer temp = cache;
        cache = null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return cache != null || iterator.hasNext();
    }
}