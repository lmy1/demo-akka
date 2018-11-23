package com.anve.demo.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.anve.demo.akka.actor.SimpleActor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoAkkaApplicationTests {

    @Test
    public void contextLoads() {
        // 创建一个actor系统, 相当于一个工厂
        final ActorSystem actorSystem = ActorSystem.create("actor-system");

        // 创建一个actor引用, 名字叫simple-actor
        final ActorRef actorRef = actorSystem.actorOf(Props.create(SimpleActor.class), "simple-actor");

        // 发送消息, 第一个参数是消息内容, 第二个内容是发送者, actor并不在意发送者是谁, 所以不用发
        actorRef.tell("hello", ActorRef.noSender());

        actorRef.forward("hello", null);



        // 关闭actor系统
        actorSystem.shutdown();
    }

}
