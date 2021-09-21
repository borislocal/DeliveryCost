public class Calculation {

    float calculateDeliveryCost(int kilometers, boolean isFragile,
                                Dimensions dimensions, WorkloadCoefficient workloadCoefficient) {
        float cost;

        cost = chargeByWorkload(workloadCoefficient) *
                (chargeByDistanceAndFragility(kilometers, isFragile) +
                        chargeByDimensions(dimensions));

        if (cost < 400) {
            cost = 400;
        }

        return Math.round(cost * 100.0) / 100.0f;
    }

    int chargeByDistanceAndFragility(int kilometers, boolean isFragile) {
        int distanceCost = chargeByDistance(kilometers);
        int fragilityCost = chargeByFragility(isFragile);

        if (kilometers > 30 & isFragile) {
            throw new IllegalArgumentException("fragile delivery could be sent to 30km maximum.");
        }

        if (kilometers <= 0) {
            throw new IllegalArgumentException(
                    "please set kilometers value greater than 0, we don`t have pickup option.");
        }

        return distanceCost + fragilityCost;
    }

    int chargeByFragility(boolean isFragile) {
        int fragilityCost = 0;
        if (isFragile) {
            fragilityCost += 300;
        }

        return fragilityCost;
    }

    int chargeByDistance(int kilometers) {
        int distanceCost = 0;
        if (kilometers > 0 & kilometers <= 2) {
            distanceCost = 50;
        } else if (kilometers > 2 & kilometers <= 10) {
            distanceCost = 100;
        } else if (kilometers > 10 & kilometers <= 30) {
            distanceCost = 200;
        } else if (kilometers > 30) {
            distanceCost = 300;
        }

        return distanceCost;
    }

    int chargeByDimensions(Dimensions dimensions) {
        int dimensionCost = 0;
        switch (dimensions) {
            case SMALL:
                dimensionCost = 100;
                break;
            case BIG:
                dimensionCost = 200;
                break;
        }

        return dimensionCost;
    }

    float chargeByWorkload(WorkloadCoefficient workloadCoefficient) {
        float resultCoefficient = 1;

        switch (workloadCoefficient) {
            case INCREASED:
                resultCoefficient = 1.2f;
                break;
            case HIGH:
                resultCoefficient = 1.4f;
                break;
            case VERY_HIGH:
                resultCoefficient = 1.6f;
                break;
            case OTHER:
                resultCoefficient = 1;
                break;
        }

        return resultCoefficient;
    }
}