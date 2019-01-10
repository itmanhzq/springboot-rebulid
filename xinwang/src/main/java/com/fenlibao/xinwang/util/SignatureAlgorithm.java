package com.fenlibao.xinwang.util;

/**
 * @author Flynn
 */
public enum SignatureAlgorithm {

    /**
     * a
     */
    SHA_1_WITH_RSA("SHA1WithRSA");

    private String signAlgorithm;

    /**
     * a
     *
     * @param signAlgorithm
     */
    private SignatureAlgorithm(String signAlgorithm) {
        this.signAlgorithm = signAlgorithm;
    }

    public String getSignAlgorithm() {
        return signAlgorithm;
    }
}
