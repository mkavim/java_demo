package com.xuxp.examples.base;

/**
 * 多态的使用
 */
public class Polymorphic {
    public static void main(String[] args) {
        Income[] incomes = new Income[]{
                new Income(100000),
                new Salary(100000),
                new StateCouncilSpecialAllowance(10000)
        };
        // 多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法
        for (Income income : incomes) {
            System.out.println(income.getTax());
        }
    }
}


class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1; // 税率10%
    }
}

class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}
