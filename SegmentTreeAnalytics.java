public class SegmentTreeAnalytics {

    int tree[];

    SegmentTreeAnalytics(int n) {
        tree = new int[4 * n];
    }

    void build(int arr[], int node,
               int start, int end) {

        if (start == end) {
            tree[node] = arr[start];
        } else {

            int mid = (start + end) / 2;

            build(arr, 2 * node,
                    start, mid);

            build(arr, 2 * node + 1,
                    mid + 1, end);

            tree[node] =
                    tree[2 * node]
                            + tree[2 * node + 1];
        }
    }

    int query(int node, int start,
              int end, int l, int r) {

        if (r < start || l > end)
            return 0;

        if (l <= start && end <= r)
            return tree[node];

        int mid = (start + end) / 2;

        return query(2 * node,
                start, mid, l, r)
                +
                query(2 * node + 1,
                        mid + 1,
                        end, l, r);
    }

    public static void main(String[] args) {

        int sales[] = {
                1200,1500,1800,2100,1700,
                2500,2200,1900,2800,2600,
                2400,3000
        };

        SegmentTreeAnalytics st =
                new SegmentTreeAnalytics(
                        sales.length);

        st.build(sales, 1,
                0,
                sales.length - 1);

        System.out.println(
                "==========================================");
        System.out.println(
                " E-COMMERCE FLASH SALE ANALYTICS SYSTEM");
        System.out.println(
                "==========================================");

        System.out.println(
                "\nHourly Sales Data:");

        for (int i = 0; i < sales.length; i++) {

            System.out.println(
                    "Hour "
                            + (i + 1)
                            + " = ₹"
                            + sales[i]);
        }

        System.out.println(
                "\nSales from Hour 3 to Hour 8:");

        System.out.println(
                "Total Sales = ₹"
                        + st.query(
                        1,
                        0,
                        sales.length - 1,
                        2,
                        7));

        System.out.println(
                "\nSales from Hour 5 to Hour 12:");

        System.out.println(
                "Total Sales = ₹"
                        + st.query(
                        1,
                        0,
                        sales.length - 1,
                        4,
                        11));

        System.out.println(
                "\nAnalytics Status : ACTIVE");
    }
}