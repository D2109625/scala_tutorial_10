object BankExample {
  def main(args: Array[String]): Unit = {
    val acc1 = new Account(1000)
    val acc2 = new Account(-200)
    val acc3 = new Account(300)
    val bank = new Bank(List(acc1, acc2, acc3))

    println(s"Accounts with negative balances: ${bank.negativeBalances}")
    println(s"Sum of all balances: ${bank.totalBalance}")
    println(s"Final balances after interest: ${bank.applyInterest}")
  }
}

class Account(var balance: Double) {
  def deposit(amount: Double): Unit = balance += amount
  def withdraw(amount: Double): Unit = if (amount <= balance) balance -= amount
}

class Bank(accounts: List[Account]) {
  def negativeBalances: List[Account] = accounts.filter(_.balance < 0)
  def totalBalance: Double = accounts.map(_.balance).sum
  def applyInterest: List[Double] = accounts.map { account =>
    if (account.balance > 0) account.deposit(account.balance * 0.05)
    else account.withdraw(account.balance.abs * 0.1)
    account.balance
  }
}
