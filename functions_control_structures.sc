def isVowel(ch: Char) = "aeiou".contains(ch)

def vowels(s: String) =
  for (ch <- s if isVowel(ch)) yield ch

vowels("Washington")

// Using recursion
def vowels3(s: String): String = {
  if (s.length == 0) ""
  else {
    val ch = s(0)
    val rest = vowels3(s.substring(1))
    if (isVowel(ch)) ch + rest else rest
  }
}

vowels3("Washington")
