import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SampleOnlineData {

    /**
     * A brute force approach would be to store all the packets read so far. After reading in each packet, we apply Solution 6.11 on the facing page to compute a random subset of k packets. The space complexity is high—0(n), after n packets have been read. The time complexity is also high—0(nk), since each packet read is followed by a call to Solution 6.11 on the preceding page.
     *
     *  suppose we have read the first n packets, and have a random subset of k of them. When we read the (n + l)th packet, it should belong to the new subset with probability k/(n+1). If we choose one of the packets in the existing subset uniformly randomly to remove, the resulting collection will be a random subset of the n + 1 packets
     *
     *  As an example, suppose k - 2, and the packets are read in the order p,q,r,t,u,v. We keep the first two packets in the subset, which is {p,q}. We select the next packet, r, with probability 2/3. Suppose it is not selected. Then the subset after reading the first three packets is still {p,q}. We select the next packet, t, with probability 2/4. Suppose it is selected. Then we choose one of the packets in \p,q) uniformly, and replace it with t. Let q be the selected packet—now the subset is [p,t}. We select the next packet u with probability 2/5. Suppose it is selected. Then we choose one of the packets in {p,t) uniformly, and replace it with u. Let t be the selected packet—now the subset is {p,u\. We select the next packet v with probability 2/6. Suppose it is not selected. The random subset remains \p,u\.
    */

    public static List<Integer> runningSample(int k, List<Integer> sequence) {
        List<Integer> runningSample = new ArrayList<>(k);
        int i = 0;
        for (; i < sequence.size() && i < k; i++) {
            runningSample.add(sequence.get(i));
        }

        int cur = k;
        Random gen = new Random();
        while (i < sequence.size()) {
            Integer x = sequence.get(i++);
            cur++;
            // Generate a random number in [0, cur], and if this number is in
            // [0, k - 1], we replace that element from the sample with x.
            final int idxToReplace = gen.nextInt(cur);
            if (idxToReplace < k) {
                runningSample.set(idxToReplace, x);
            }
        }

        return runningSample;
    }
}
