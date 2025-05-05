package binarysearch;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/fair-candy-swap/description/?envType=problem-list-v2&envId=binary-search
 */
public class FairCandySwap {

    public int[] fairCandySwap1(int[] aliceSizes, int[] bobSizes) {
        int sum1 = Arrays.stream(aliceSizes).sum();
        int sum2 = Arrays.stream(bobSizes).sum();
        int half = (sum1 + sum2) / 2;
        int[] swap = new int[2];
        for (int aliceSize : aliceSizes) {
            int i = half - (sum1 - aliceSize);
            int i1 = Arrays.stream(bobSizes).filter(v -> {
                return v == i;
            }).findAny().orElse(-1);
            if (i1 != -1) {
                swap[0] = aliceSize;
                swap[1] = i1;
                return swap;
            }
        }
        return null;
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sum1 = Arrays.stream(aliceSizes).sum();
        int sum2 = Arrays.stream(bobSizes).sum();
        int half = (sum1 + sum2) / 2;

        int[] swap = new int[2];
        for (int i = 0; i < aliceSizes.length; i++) {
            int aliceSize = aliceSizes[i];
            int i1 = half - (sum1 - aliceSize);
            int targetIndex = -1;
            for (int j = 0; j < bobSizes.length; j++) {
                if (bobSizes[j] == i1) {
                    targetIndex = j;
                    break;
                }
            }

            if (targetIndex != -1) {
                swap[0] = aliceSize;
                swap[1] = i1;
                return swap;
            }

        }
        return null;

    }
}
