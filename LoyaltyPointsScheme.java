    public class LoyaltyPointsScheme {
        private int pointsPerDollar;
        private int pointsThreshold;

        public LoyaltyPointsScheme(int pointsPerDollar, int pointsThreshold) {
            this.pointsPerDollar = pointsPerDollar;
            this.pointsThreshold = pointsThreshold;
        }

        public int getPointsPerDollar() {
            return pointsPerDollar;
        }

        public int getPointsThreshold() {
            return pointsThreshold;
        }
    }

