package com.wsl.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomRule extends AbstractLoadBalancerRule {
    //每个服务访问5次，换下一个服务（3个服务）
    //total=0，默认=0，如果=5，指向下一个服务结点
    //index=0，默认=0，如果total=5，index++,index>=3,index=0
    private int total = 0;//被调用次数
    private int currentIndex = 0;//当前是谁在提供服务
    public RandomRule() {
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }
                //获得活着的服务
                List<Server> upList = lb.getReachableServers();
                //获得全部服务
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

/*                //生成区间随机数
                int index = this.chooseRandomInt(serverCount);
                //从或者的服务中随机获取一个
                server = (Server)upList.get(index);*/
                //=====================================
                //从活着的服务中，获取一个服务
                if(total >= 5){
                    total = 0;
                    currentIndex++;
                    if(currentIndex >= upList.size()){
                        currentIndex=0;
                    }
                }
                server = upList.get(currentIndex);
                total++;
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
