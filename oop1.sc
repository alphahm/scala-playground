class Time(val hours: Int, val minutes: Int = 0) {

  if (!(hours >= 0 && hours <= 23) ||
  !(minutes >= 0 && minutes <= 59))
    throw new IllegalArgumentException

  def before(other: Time) = {
    hours < other.hours || hours == other.hours && minutes < other.minutes
  }

  override def toString = f"${hours}:${minutes}"
}

val time1 = new Time(10, 34)
val time2 = new Time(23, 54)
time2.before(time1)

/*
  Another implementation where we make use of the uniform
  access principle
 */
class AnotherTime(h: Int, m: Int) {
  private val minutesSinceMidnight = h * 60 + m

  // Uniform access principle
  def hours = minutesSinceMidnight / 60
  def minutes = minutesSinceMidnight % 60

  if (!(h >= 0 && h <= 23) ||
    !(m >= 0 && m <= 59)) {
    throw new IllegalArgumentException
  }

  def before(other: AnotherTime) = {
    minutesSinceMidnight < other.minutesSinceMidnight
  }
}

val time3 = new AnotherTime(5, 3)

/*
  Alternative implementation where:
  - minutes can be mutated
  - operator < is used in place of method before of other implementations
  - operator - is used for method to give the number of minutes between them
 */

class YetAnotherTime(val hours: Int, m: Int = 0) {

  if (!(hours >= 0 && hours <= 23) ||
    !(minutes >= 0 && minutes <= 59))
    throw new IllegalArgumentException

  private val minutesSinceMidnight = hours * 60 + _minutes

  private var _minutes: Int = m
  def minutes = _minutes
  def minutes_= (newValue: Int) {
    if (!(newValue >= 0 && newValue <= 59))
      throw new IllegalArgumentException
    _minutes = newValue
  }

  def <(other: YetAnotherTime): Boolean = {
    minutesSinceMidnight < other.minutesSinceMidnight
  }

  def -(other: YetAnotherTime): Int = {
    minutesSinceMidnight - other.minutesSinceMidnight
  }

  override def toString = f"${hours}:${minutes}"
}

/*
  Companion object used to instantiate YetAnotherTime without keyword new
 */
object YetAnotherTime {
  def apply(h: Int, m: Int) = new YetAnotherTime(h, m)
}

val time4 = new YetAnotherTime(2, 4)
// below is possible thanks to companion object
val time5 = YetAnotherTime(12, 50)

time4.minutes = 20
time4
// time4.minutes = 62 // throws an IllegalArgumentException
if (time4 < time5) println("Before!")
time5 - time4

