import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTaxIncome {

    // to check method taxIncomes()
    @Test
    void taxIncomes_test() {
        int tax1 = 1200;
        int actual = Main.taxIncomes(20000);
        Assertions.assertEquals(tax1, actual);
    }

    // to check method taxIncomesMinusExpenses()
    @Test
    void taxIncomesMinusExpenses_test() {
        int tax2 = 2250;
        int actual = Main.taxIncomesMinusExpenses(20000, 5000);
        Assertions.assertEquals(tax2, actual);
    }

    // to check method toSave()
    @Test
    void toSave_test() {
        int savings = 1050;
        int actual = Main.toSave(Main.taxIncomes(20000), Main.taxIncomesMinusExpenses(20000, 5000));
        Assertions.assertEquals(savings, actual);
    }

    // to add more incomes and count tax
    @Test
    void addIncome_test() {
        int add1 = 1000;
        int add2 = 3500;

        int incomes = 0;
        incomes += add1;
        incomes += add2;

        Assertions.assertEquals(4500, incomes);
        Assertions.assertEquals(270, Main.taxIncomes(incomes));
    }
}

