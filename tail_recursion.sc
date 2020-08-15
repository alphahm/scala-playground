def isSorted[A](
 as: Array[A],
 ordering: (A, A) => Boolean): Boolean = {
  
  @annotation.tailrec
  def go(n: Int): Boolean =
    if (n >= as.length - 1) true
    else if (!ordering(as(n), as(n + 1))) false
    else go(n + 1)
  
  go(0)
}

isSorted(Array(1, 3, 5, 7), (x: Int, y: Int) =>  x > y)
isSorted(Array(1, 3, 5, 7), (x: Int, y: Int) =>  x < y)

isSorted(Array("scala", "Exercises"), (x: String, y: String) => x.length < y.length)

