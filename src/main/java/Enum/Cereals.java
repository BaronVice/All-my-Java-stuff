package Enum;

public enum Cereals {
    CAPTAIN_CRUNCH("Captain Crunch", 50, 2.90),
    FROOT_LOOPS("Froot loops", 60, 3.25),
    RESEES_PUFFS("Resees puffs", 100, 3.99),
    COCOA_PUFFS("Cocoa puffs", 75, 3.49);

    final String name;
    final Integer deliciousness;
    final Double price;

    Cereals(String name, Integer deliciousness, Double price){
        this.name = name;
        this.deliciousness = deliciousness;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("""
                    Name: %s
                    Deliciousness: %s
                    Price: %s
                    """, name, deliciousness, price);
    }
}
