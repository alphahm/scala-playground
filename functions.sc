import scala.collection.mutable.ArrayBuffer

/*
  Remove all the negative numbers from an ArrayBuffer
  except for the first one
 */

var numbers = ArrayBuffer(1, -5, 9, 3, -2, 1, -3)

// Get all the negative numbers indices
val negatives = for (i <- 0 until numbers.length if numbers(i) < 0)
  yield i

// Drop the first index - drop(n) select all elements except the first n ones
val negativesToRemove = negatives.drop(1)

// Remove the negative numbers, need to do that in reverse order
// to keep the index
for (i <- negativesToRemove.reverse) numbers.remove(i)

numbers

// Even better use yield so that the original buffer is not mutated
def removeAllButFirstNegative(buf: ArrayBuffer[Int]) = {
  val indexesToRemove =
    (for (i <- 0 until buf.length if buf(i) < 0) yield i).drop(1)
    
  for (i <- indexesToRemove if !indexesToRemove.contains(i)) yield buf(i)
}

removeAllButFirstNegative(numbers)
