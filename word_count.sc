import java.net.URL
import java.util.Scanner

/*
  Word count
  Alice in Wonderland
 */
val in =
  new Scanner(
    new URL(
      "https://www.gutenberg.org/files/11/11-0.txt")
      .openStream()
  )

// Mutable map
val mCount = scala.collection.mutable.Map[String, Int]()

while(in.hasNext) {
  val word = in.next()
  mCount(word) = mCount.getOrElse(word, 0) + 1
}

mCount("Rabbit")

// Immutable map
var count = Map[String, Int]()
while(in.hasNext) {
  val word = in.next()
  count += (word -> (count.getOrElse(word, 0) + 1))
}

mCount("Rabbit")
