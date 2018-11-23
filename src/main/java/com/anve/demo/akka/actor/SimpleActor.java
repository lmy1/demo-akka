package com.anve.demo.akka.actor;

import akka.actor.UntypedActor;

/**
 * Created by ximeng 2018/11/20.
 */
public class SimpleActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {

        String msg = (String) o;
        System.out.println(msg);

        System.out.println("我是actor, 被调用了");
    }
}
