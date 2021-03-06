package io.hischoolboy.common;

import io.hischoolboy.captcha.CaptchaImgFont;
import io.hischoolboy.config.GlobalConfig;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class InitData {

    public static void start() {

        log.info("init data start");

        GlobalConfig.loadAllConfig();
        CaptchaImgFont.initImgFont();

        log.info("init data finish");

    }
}
