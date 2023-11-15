package christmas.util;

public enum Batch {
    STAR("별", 5000, 10000),
    TREE("트리", 10000, 20000),
    SANTA("산타", 20000, Integer.MAX_VALUE-1);

    private final String batchName;
    private final int minDiscount;
    private final int maxDiscount;

    Batch(String batchName, int minDiscount, int maxDiscount) {
        this.batchName = batchName;
        this.minDiscount = minDiscount;
        this.maxDiscount = maxDiscount;
    }

    public boolean getCurrentBatch(int discount) {
        return minDiscount <= discount && discount < maxDiscount;
    }

    public String getBatchName() {
        return batchName;
    }
}

