package com.fenlibao.pms.model.enums.publicize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.Optional;

/**
 * @author WangBoRan
 * @date 2019/1/9
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AticleType {
    /*行业新闻*/
    INDUSTRY_NEWS(1, "行业新闻"),
    /*媒体报道*/
    MEDIA_COVERAGE(2, "媒体报道"),
    /*公司动态*/
    COMPANY_DYNAMICS(3, "公司动态");

    private int value;

    private String message;

    public static Optional<AticleType> getAticleType(int value) {
        for (AticleType stats : values()) {
            if (value == stats.getValue()) {
                return Optional.of(stats);
            }
        }
        return Optional.empty();
    }

    public static String getMessage(int value) {
        Optional<AticleType> aticleType = AticleType.getAticleType(value);
        if (aticleType.isPresent()) {
            return aticleType.get().getMessage();
        }
        return Strings.EMPTY;
    }
}
