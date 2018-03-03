package it.unimi.dsi.fastutil;

public final class HashCommon {
    protected HashCommon() {

    }
    /** Avalanches the bits of a long integer by applying the finalisation step of MurmurHash3.
     *
     * <p>This method implements the finalisation step of Austin Appleby's <a href="http://code.google.com/p/smhasher/">MurmurHash3</a>.
     * Its purpose is to avalanche the bits of the argument to within 0.25% bias.
     *
     * @param x a long integer.
     * @return a hash value with good avalanching properties.
     */
    public static long murmurHash3(long x) {
        x ^= x >>> 33;
        x *= 0xff51afd7ed558ccdL;
        x ^= x >>> 33;
        x *= 0xc4ceb9fe1a85ec53L;
        x ^= x >>> 33;
        return x;
    }
}
