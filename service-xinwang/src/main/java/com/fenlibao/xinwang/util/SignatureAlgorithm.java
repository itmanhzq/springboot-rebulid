package com.fenlibao.xinwang.util;

/**
 * @author Flynn
 */
public enum SignatureAlgorithm {

    /**
     * RSAkey
     */
    SHA_1_WITH_RSA("SHA1WithRSA");

    private String signAlgorithm;

    SignatureAlgorithm(String signAlgorithm) {
        this.signAlgorithm = signAlgorithm;
    }

    public String getSignAlgorithm() {
        return signAlgorithm;
    }
}
