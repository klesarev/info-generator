package utils

interface DataProvider<T> {
    /*file - variable name may be renamed in some classes, that realizes this interface method*/
    fun getData(file: T): String
}

interface WriteableDataProvider<T,V>: DataProvider<T> {
    fun writeData(file: T, content: V)
}