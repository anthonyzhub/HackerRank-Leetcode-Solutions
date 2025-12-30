// https://leetcode.com/problems/simple-bank-system/
/*
Time Complexity: O(1) for all operations. No looping is done.

Space Complexity: O(n) where n = length of balance.
*/

class Bank {

    private long[] balance;
    private int numOfAccounts;

    public Bank(long[] balance) {
        this.balance = balance;
        this.numOfAccounts = balance.length;
    }

    private boolean doesAcctExist(int accountNumber) {
        return (accountNumber > 0 && accountNumber <= numOfAccounts);
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (!doesAcctExist(account1) || !doesAcctExist(account2)) {
            return false;
        }

        if (balance[account1 - 1] < money) {
            return false;
        }

        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (!doesAcctExist(account)) {
            return false;
        }

        balance[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (!doesAcctExist(account)) {
            return false;
        }

        if (balance[account - 1] < money) {
            return false;
        }

        balance[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
