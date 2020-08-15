val words = Array("Mary", "had", "a", "little", "lamb", "its", "fleece",
  "was", "white", "as", "snow", "and", "everywhere", "that", "Mary", "went",
  "the", "lamb", "was", "sure", "to", "go"
)

// Cluster the array by first letter
words.groupBy(_.substring(0, 1))
// HashMap(e -> Array(everywhere), s -> Array(snow, sure), t -> Array(that, the, to), f -> Array(fleece), a -> Array(a, as, and), M -> Array(Mary, Mary), i -> Array(its), h -> Array(had), w -> Array(was, white, went, was), g -> Array(go), l -> Array(little, lamb, lamb))

// Cluster the array by length
words.groupBy(_.length)
// HashMap(5 -> Array(white), 10 -> Array(everywhere), 1 -> Array(a), 6 -> Array(little, fleece), 2 -> Array(as, to, go), 3 -> Array(had, its, was, and, the, was), 4 -> Array(Mary, lamb, snow, that, Mary, went, lamb, sure))
