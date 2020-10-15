package liby

class Uniterator<T>(private val items : Iterator<Iterator<T>>) : Iterator<T> {

    constructor (itA : Iterator<T>, itB : Iterator<T>) : this (listOf<Iterator<T>>(itA, itB).iterator())
    constructor (iterators : Collection<Iterator<T>>) : this (iterators.iterator())

    private var curIt: Iterator<T>? = null;


    override fun hasNext(): Boolean {
        var curIt = curIt;
        while (curIt == null || (!(curIt.hasNext()) && items.hasNext())) {
            this.curIt = items.next();
            curIt = this.curIt;
        }
        return curIt.hasNext()
    }

    override fun next(): T {
        val curIt = curIt ?: throw NoSuchElementException("No elements left");
        return curIt.next()
    }
}