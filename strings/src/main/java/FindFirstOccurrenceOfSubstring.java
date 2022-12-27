public class FindFirstOccurrenceOfSubstring {

    /**
     * A good string search algorithm is fundamental to the performance of many applica¬ tions. Several clever algorithms have been proposed for string search, each with its own trade-offs. As a result, there is no single perfect answer. If someone asks you this question in an interview, the best way to approach this problem would be to work through one good algorithm in detail and discuss at a high level other algorithms.
     *
     * Intuitively, the brute-force algorithm is slow because it advances through t one character at a time, and potentially does0(m) computation with each advance, where m is the length of s.
     * There are three linear time string matching algorithms: KMP, Boyer-Moore, and Rabin-Karp. Of these, Rabin-Karp is by far the simplest to understand and implement.
     *
     * The Rabin-Karp algorithm is very similar to the brute-force algorithm, but it does not require the second loop. Instead it uses the concept of a "fingerprint".
     *
     * Specifically, let m be the length of s. It computes hash codes of each substring whose length is m and these are the fingerprints. The key to efficiency is using an incremental hash function, such as a function with the property that the hash code of a string is an additive function of each individual character. (Such a hash function is sometimes referred to as a rolling hash.) For such a function, getting the hash code of a sliding window of characters is very fast for each shift.
     * For example, let the strings consist of letters from [A, C, G, T). Suppose t is "GACGCCA" and s is "CGC". Define the code for "A" to be 0, the code for "C" to be 1, etc. Let the hash function be the decimal number formed by the integer codes for the letters mod 31. The hash code of s is 121 mod 31 = 28. The hash code of the first three characters of t, "GAC", is 201 mod 31 = 15, so s cannot be the first three characters of t. Continuing, the next substring of t is "ACG", whose hash code can be computed from 15 by subtracting 200, then multiplying by 10, then adding 2 and finally taking mod 31. This yields 12, so there no match yet. We then reach "CGC" whose hash code, 28, is derived in a similar manner. We are not done yet—there may be a collision. We check explicitly if the substring matches s, which in this case it does.
     *
     * our matching process is actually to maintain a fixed-length window of length L = 10 sliding from left to right.
     *
     * So the key to optimization is whether we don't really generate substrings, but use some other forms of unique identities to represent substrings in the sliding window, and update them quickly during window sliding? that is in the help
     *
     * int L = 10;
     * // 集合中不要存储字符串了，而是存储字符串对应的哈希值
     * HashSet<Integer> seen;
     * leetcode 187 duplicate DNA
     * // 滑动窗口代码框架
     * CharWindow window;
     * int left = 0, right = 0;
     * while (right < s.size()) {
     *     // 扩大窗口，移入字符
     *     window.addRight(s[right]);
     *     right++;
     *
     *     // 当子串的长度达到要求
     *     if (right - left == L) {
     *         // 获取当前窗口内字符串的哈希值，时间 O(1)
     *         int windowHash = window.hash();
     *         // 根据哈希值判断是否曾经出现过相同的子串
     *         if (seen.contains(windowHash)) {
     *             // 当前窗口中的子串是重复出现的
     *             print("找到一个重复子串: ", window.toString());
     *         } else {
     *             // 当前窗口中的子串之前没有出现过，记下来
     *             seen.add(windowHash);
     *         }
     *
     *         // 缩小窗口，移出字符
     *         window.removeLeft();
     *         left++;
     *     }
     * }
     *
     *
     * 进一步，我们用一个 10 位数来标识一个长度为 10 的碱基字符序列，这需要 long 类型存储，int 存不下 10 位数。但你注意这个 10 位数中所有的数字只会局限于 0,1,2,3，是不是有些浪费？
     *
     * 换句话说，我们需要存储的其实只是一个四进制下的十位数（共包含 4^10 个数字），却用了十进制的十位数（可以包含 10^10 个数字）来保存，显然是有些浪费的。
     *
     * 那么借鉴上面的思路，我们不要每次都去一个字符一个字符地比较子串和模式串，而是维护一个滑动窗口，运用滑动哈希算法一边滑动一边计算窗口中字符串的哈希值，拿这个哈希值去和模式串的哈希值比较，这样就可以避免截取子串，从而把匹配算法降低为 O(N)，这就是 Rabin-Karp 指纹字符串查找算法的核心逻辑。
     *
     * 。那么一个长度为 L 的 ASCII 字符串，我们就可以等价理解成一个 L 位的 256 进制的数字，这个数字就可以唯一标识这个字符串，也就可以作为哈希值。
     *
     * // 文本串
     * String txt;
     * // 模式串
     * String pat;
     *
     *
     * // 需要寻找的子串长度为模式串 pat 的长度
     * int L = pat.length();
     * // 仅处理 ASCII 码字符串，可以理解为 256 进制的数字
     * int R = 256;
     * // 存储 R^(L - 1) 的结果
     * int RL = (int) Math.pow(R, L - 1);
     * // 维护滑动窗口中字符串的哈希值
     * int windowHash = 0;
     * // 计算模式串的哈希值
     * long patHash = 0;
     * for (int i = 0; i < pat.length(); i++) {
     *     patHash = R * patHash + pat.charAt(i);
     * }
     *
     * // 滑动窗口代码框架
     * int left = 0, right = 0;
     * while (right < txt.length()) {
     *     // 扩大窗口，移入字符（在最低位添加数字）
     *     windowHash = R * windowHash + txt[right];
     *     right++;
     *
     *     // 当子串的长度达到要求
     *     if (right - left == L) {
     *         // 根据哈希值判断窗口中的子串是否匹配模式串 pat
     *         if (patHash == windowHash) {
     *             // 找到模式串
     *             print("找到模式串，起始索引为", left);
     *             return left;
     *         }
     *
     *         // 缩小窗口，移出字符（删除最高位数字）
     *         windowHash = windowHash - txt[left] * RL;
     *         left++;
     *     }
     * }
     * // 没有找到模式串
     * return -1;
     *
     * 不过呢，这段代码实际运行的时候会有一个严重的问题，那就是整型溢出。
     *
     * 你想，上一道题给定的 DNA 序列字符串只包含 AGCT 四种字符，所以我们可以把 DNA 序列抽象成四进制的数字，即算法中 R = 4。相同位数下，四进制包含的数字数量是小于十进制包含的数字数量的。比方说 L = 10 时，4^10 = 1048576 < 10^8，即 10 位四进制数字用 8 位十进制数字就可以存下了。
     *
     * 但现在输入为 ASCII 码字符串，我们不得不把字符串抽象成 256 进制的数字，即算法中 R = 256。而相同位数下，256 进制包含的数字数量显然是远大于十进制包含的数字数量的。比如 L = 10 时，256^10 = 1.2 x 10^24 < 10 ^25，所以你需要一个 25 位的十进制数才能表示一个 10 位的 256 进制数。
     *
     * 无论一个数字多大，你让它除以 Q，余数一定会落在 [0, Q-1] 的范围内。所以我们可以设置一个 Q，用求模的方式让 windowHash 和 patHash 保持在 [0, Q-1] 之间，就可以有效避免整型溢出。
     *
     * 具体来说，对于一个字符串，我们不需要把完整的 256 进制数字存下来，而是对这个巨大的 256 进制数求 Q 的余数，然后把这个余数作为该字符串的哈希值即可。
     *
     * 好，整型溢出的问题倒是解决了，但新的问题又来了：求模之后的哈希值不能和原始字符串一一对应了，可能出现一对多的情况，即哈希冲突。
     *
     * 比方说 10 % 7 等于 3，而 17 % 7 也等于 3，所以如果你得到余数 3，你能确定原始数字就一定是 10 么？不能。
     *
     * 类似的，如果你发现 windowHash == patHash，你也不敢完全肯定窗口中的字符串一定就和模式串 pat 匹配，有可能它俩不匹配，但恰好求模算出来的哈希值一样，这就产生了是「哈希冲突」。
     *
     * 在我的 数据结构精品课 中哈希表的章节中用拉链法和线性探查法解决了哈希表的哈希冲突。对于 Rabin-Karp 算法来说，当发现 windowHash == patHash 时，使用暴力匹配算法检查一下窗口中的字符串和 pat 是否相同就可以避免哈希冲突了。因为希冲突出现的概率比较小，所以偶尔用一下暴力匹配算法是不影响总体的时间复杂度的。
     *
     * For the Rabin-Karp algorithm to run in linear time, we need a good hash function, to reduce the likelihood of collisions, which entail potentially time consuming string equality checks.
    */

    public static int findFirst(String t, String s) {
        int L = s.length();
        int R = 26; // here only focus on the letter
        long q = 123; //in case of overflow
        long RL = 1; //R ^ (L - 1)
        for (int i = 1; i < L; i++) {
            RL = (RL * R) % q; //in case of overflow
        }

        long sHash = 0;
        for (int i = 0; i < L; i++) {
            sHash = (sHash * R + s.charAt(i)) % q;
        }

        long windowHash = 0;

        int left = 0, right = 0;
        while (right < t.length()) {
            windowHash = (windowHash * R + t.charAt(right)) % q;
            right++;

            if (right - left == L) {
                if (windowHash == sHash) {
                    if (s.equals(t.substring(left, right))) {
                        return left;
                    }
                }
                //move out
                windowHash = windowHash - t.charAt(left) * RL;
                left++;
            }
        }

        return -1;
    }

    void help() {
        /* add a number at the least significant position */
        int number = 8264;
        // number 的进制
        int R = 10;
        // the number to add
        int appendVal = 3;
        number = R * number + appendVal;
        //now number = 82643

        /* delete a number at the most significant position */
        /*int number2 = 8264;

        int R = 10;

        int removeVal = 8;
        // 此时 number 的位数
        int L = 4;

        number2 = number2 - removeVal * R^(L-1);
        //now number is 264*/
    }

}
