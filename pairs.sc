"New York".partition(_.isUpper)

// Remove all negative numbers but the first one
val (neg, positive) = Array(1, 2, 3, -2, 4, -5, 9, -9).partition(_ < 0)
neg(0) +: positive

// zip method takes two collections of same length and zips them together
val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)

for (symbol <- pairs)
  print(symbol._1 * symbol._2)
