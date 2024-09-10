object AccountExample {
  def main(args: Array[String]): Unit = {
    val acc1 = new Account(1000)
    val acc2 = new Account(500)

    acc1.deposit(200)
    acc1.withdraw(100)
    acc1.transfer(300, acc2)

    println(s"Account 1 balance: ${acc1.balance}")
    println(s"Account 2 balance: ${acc2.balance}")
  }
}

class Account(private var bal: Double) {
  def balance: Double = bal

  def deposit(amount: Double): Unit = {
    bal += amount
  }

  def withdraw(amount: Double): Unit = {
    if (amount <= bal) bal -= amount
  }

  def transfer(amount: Double, to: Account): Unit = {
    if (amount <= bal) {
      this.withdraw(amount)
      to.deposit(amount)
    }
  }
}
