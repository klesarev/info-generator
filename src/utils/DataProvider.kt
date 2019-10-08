package utils

interface DataProvider<T> {
    fun getData(file: T): String
}

interface WriteableDataProvider<T,V>: DataProvider<T> {
    fun writeData(file: T, content: V)
}