package com.bp.controller;

import com.bp.Util.SignatureUtil;
import com.bp.po.*;
import com.bp.service.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins="*" )
@RestController
public class WeChatController {

	protected static final Logger logger = LoggerFactory.getLogger(WeChatController.class);

    @GetMapping(value = "/wechat")
    public String getSignature(SignatureReq sigReq) {
        String signature ="";
        try {
            signature = SignatureUtil.getSignature(sigReq.getUrl(),sigReq.getNoicestr(),sigReq.getTimestamp());
        } catch (Exception e) {
            logger.warn("get signature failed");
            e.printStackTrace();
        }
        return signature;
    }
}