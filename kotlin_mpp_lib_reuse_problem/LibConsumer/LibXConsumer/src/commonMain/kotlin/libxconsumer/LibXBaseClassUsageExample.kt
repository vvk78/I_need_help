package libxconsumer

import liby.Uniterator


class LibXBaseClassUsageExample : libx.LibXBaseClass("Xyz") {

    fun doSomething() {
        val uniterator = Uniterator(listOf(12L, 24L).iterator(), listOf(266L, 299L).iterator())
    }
}