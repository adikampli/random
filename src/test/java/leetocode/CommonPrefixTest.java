package leetocode;

import leetcode.CommonPrefix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommonPrefixTest {

    @Test
    public void testCommmonPrefix() {
        Assertions.assertEquals("fl",
                CommonPrefix.longestCommonPrefix(new String[]{"flow", "flower", "flight"}));
        Assertions.assertEquals("flo",
                CommonPrefix.longestCommonPrefix(new String[]{"flow", "flower", "float"}));

    }
}
