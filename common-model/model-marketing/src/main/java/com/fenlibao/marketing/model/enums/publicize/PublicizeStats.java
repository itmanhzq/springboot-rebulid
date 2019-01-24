package com.fenlibao.marketing.model.enums.publicize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.Optional;

/**
 * @author WangBoRan
 * @date 2018-12-27
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum PublicizeStats {
    /*已发布*/
    RELEASED(1, "已发布"),
    /*未发布*/
    UNRELEASED(2, "未发布"),
    /*预发布*/
    PRE_RELEASE(3, "预发布");

    private int value;

    private String message;

    public static Optional<PublicizeStats> getAticleStats(int value) {
        for (PublicizeStats stats : values()) {
            if (value == stats.getValue()) {
                return Optional.of(stats);
            }
        }
        return Optional.empty();
    }

    public static String getMessage(int value) {
        Optional<PublicizeStats> publicizeStats = PublicizeStats.getAticleStats(value);
        if (publicizeStats.isPresent()) {
            return publicizeStats.get().getMessage();
        }
        return Strings.EMPTY;
    }
}
