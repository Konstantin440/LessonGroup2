package org.example.groupingByTask2;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class Account {
    private String login;
    private int balance;
    private boolean premium;



    public static void main(String[] args) {
        Account account1 = new Account("John", 10000, true);
        Account account2 = new Account("Alice", 5000, false);
        Account account3 = new Account("Michael", 4000, true);
        Account account4 = new Account("Emily", 16000, false);
        Account account5 = new Account("David", 5000, true);
        Account account6 = new Account("Olivia", 2000, false);
        Account account7 = new Account("Sophia", 5000, true);
        Account account8 = new Account("William", 8000, false);
        Account account9 = new Account("Daniel", 9000, true);
        Account account10 = new Account("Isabella", 6000, false);
        Account account11 = new Account("Sarah", -2000, true);
        Account account12 = new Account("Thomas", -500, false);
        Account account13 = new Account("Mia", -3500, true);

        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        accountList.add(account4);
        accountList.add(account5);
        accountList.add(account6);
        accountList.add(account7);
        accountList.add(account8);
        accountList.add(account9);
        accountList.add(account10);
        accountList.add(account11);
        accountList.add(account12);
        accountList.add(account13);

        //Получить мап где в качестве ключа будет boolean премиум аккаунт или нет а в качестве значения  лист юзеров
        Map<Boolean, List<Account>> accountsMap = accountList.stream()
                .collect(Collectors.groupingBy(Account::isPremium));

        //Вывести Мапу
        System.out.println(accountsMap);

        System.out.println();

        //После вывести баланс всех с премм аккаунтами
        Map<Integer, List <Account>> balancePremium = accountList.stream()
                .filter(Account::isPremium)
                .collect(Collectors.groupingBy(Account::getBalance));


        System.out.println(balancePremium);
        System.out.println();


        //  после удалить все аккаунты с отрицательным балансом если это не премимум аккаунт
        accountList.removeIf(account -> !account.isPremium() && account.getBalance() < 0);
        Map<Boolean, List<Account>> accountsWithoutNegativeBalance = accountList.stream()
                .collect(Collectors.groupingBy(Account::isPremium));


        System.out.println(accountsWithoutNegativeBalance);


    }

}
