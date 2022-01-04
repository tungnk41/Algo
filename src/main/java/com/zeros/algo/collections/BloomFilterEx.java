package com.zeros.algo.collections;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class BloomFilterEx {

    public static void run(){
        BloomFilter<String> filter = BloomFilter.create(
                Funnels.stringFunnel(Charset.defaultCharset()),
                500,
                0.01);

        filter.put("qwert");
        filter.put("asdfg");
        filter.put("zxcvb");

        System.out.println(filter.mightContain("qwert"));
        System.out.println(filter.mightContain("asdfg"));
        System.out.println(filter.mightContain("bvcxz"));

        System.out.println(filter.mightContain("nmklp"));
    }
}
