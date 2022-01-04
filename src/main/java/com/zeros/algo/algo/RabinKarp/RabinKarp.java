package com.zeros.algo.algo.RabinKarp;

public class RabinKarp {
    static final Integer prime_mod =  (int) 1e9 + 7;
    static final short prime_base = 257; //prime at least equal to 52 (26 * 2) (a-z A-Z)
    static Long hash(String str){
        Long h = 0L;
        for(int i = 0; i<str.length();i++){
            h = (h*prime_base + str.charAt(i)) % prime_mod;
        }
        return h;
    }
    static Integer subString(String source, String pat){
        if(pat.length() > source.length()) return -1;
        if(pat.isEmpty()) return 0;
        long h_p = hash(pat);
        long h_s = 0;
        long power = 1;
        //init last power
        for(int i = 0; i< pat.length();i++){
            power = (power * prime_base) % prime_mod;
        }
        for(int i = 0; i < source.length();i++){
            h_s = (h_s*prime_base + source.charAt(i)) % prime_mod;
            if(i >= pat.length()){
                h_s -= (power*source.charAt(i - pat.length())) % prime_mod;
                if(h_s < 0) h_s += prime_mod;
            }
            if(h_s == h_p){
                return i - (pat.length()-1);
            }
        }
        return -1;
    }

    public static void run(){
        String str_1 = "mississippi";
        String str_2 = "issip";
        System.out.println(subString(str_1,str_2));
    }
}
