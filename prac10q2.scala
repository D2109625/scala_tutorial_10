object SubRational {
  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val diff = y.sub(z)
    val result = x.sub(diff)

    println(s"Result of x - (y - z): $result")
  }
}

class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  // Greatest common divisor for reducing the fraction
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  // Simplified numerator and denominator
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  // Method to subtract two Rational numbers
  def sub(that: Rational): Rational = {
    new Rational(
      this.numer * that.denom - that.numer * this.denom,
      this.denom * that.denom
    )
  }

  // Override toString to print the rational number in a nice format
  override def toString: String = s"$numer/$denom"
}
