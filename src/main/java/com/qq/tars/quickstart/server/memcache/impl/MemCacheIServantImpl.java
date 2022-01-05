package com.qq.tars.quickstart.server.memcache.impl;

import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.common.support.Holder;
import com.qq.tars.common.util.Config;
import com.qq.tars.quickstart.client.testapp.HelloPrx;
import com.qq.tars.quickstart.server.memcache.MemCacheIServant;
import com.qq.tars.quickstart.server.memcache.Reponse;
import com.qq.tars.quickstart.server.memcache.Request;
import com.qq.tars.server.config.ConfigurationManager;
import com.qq.tars.server.core.Server;
import com.qq.tars.spring.annotation.RemoteConfigSource;
import com.qq.tars.spring.annotation.TarsClient;
import com.qq.tars.spring.annotation.TarsServant;
import com.qq.tars.support.config.ConfigHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@TarsServant("MemCacheObj")
public class MemCacheIServantImpl implements MemCacheIServant {

    @TarsClient("TestApp.HelloServer.HelloObj")
    HelloPrx helloPrx;


    @Autowired
    ConfigHelper configHelper;


//    @RemotePropertiesSource
//    private String ddd;


    @Override
    public int get(Request k, Holder<Reponse> v) {
        Holder<String> sRsp = new Holder<>();
        // configHelper.loadConfig("MemCache.conf");
        //application = conf.get("/tars/application/server<app>", "UNKNOWN");
        String str = "dddd";
        try {
            configHelper.loadConfig("MemCache.conf");
            System.out.println("++++" + System.getProperty("config"));
            String configPath = Server.getInstance().getServerConfig().getBasePath() + "/conf/";
            Path path = Paths.get(configPath);

//            File file = new File("/usr/local/app/tars/tarsnode/data/TestApp.MemCache/conf/");
//            for (String str2 : file.list()) {
//                System.out.println("FFFF="+str2);
//            }

            Config conf = Config.parseFile(configPath+"MemCache.conf");
            str = conf.get("/main/filterheaders");

            System.out.println("===>" + conf.get("/main<filterheaders>"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //communicatorConfig.get

        helloPrx.testHello("123", sRsp);
        v.value.message = "Response-->" + sRsp.value;
        v.value.responseCode = "001-->" + str;
        return 0;
    }

    @Override
    public int set(Request k, Reponse v) {
        return 0;
    }
}
