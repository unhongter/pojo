

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.*;
import org.junit.Before;
import org.junit.Test;
import com.rabbitmq.client.AMQP.BasicProperties;
//import com.rabbitmq.client.ConnectionFactory;


public class Test2 {

    private Channel channel;

    @Before
    public void initChannel() throws IOException, TimeoutException {
        //创建连接工厂,连接中的属性赋值，
        ConnectionFactory factory=new ConnectionFactory();

        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("10.42.121.113");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        Connection conn = factory.newConnection();
//从长连接获取创建一个短连接信道
        channel=conn.createChannel();

    }
    @Test
    public void test1() throws Exception{
        //准备一个发送的消息字符串
        String msg="hello world";
        //声明一个使用的消息队列queue,如果在声明时
        //队列已经存在了,就直接使用,如果不存在才创建
        /*queue:String类型,队列的名称
         *durable:Boolean true表示持久化 false不持久化
         *exclusive:Boolean 是否专属,true表示专属 false不专属
         *如果设置专属,只有当前connection创建的连接客户端可以使用queue
         *autoDelete:Boolean 是否自动删除,true在所有消费端断开后自动删除队列
         *false不删除
         *arguments:Map<String,Object>定义当前队列的具体属性
         *例如,一个队列可放的对多消息数量等
         */
        channel.queueDeclare("simple01", false, false, false, null);
        //声明一个使用的交换机,这里使用默认的""名称的 AMQP default
        //将消息发送给交换机
        /*exchange:String 交换机名称
         *routingKey:String 路由key,由于我们使用的是默认交换机
         *路由key就是队列名称
         *props:BasicProperties,可以定义个消息的各种属性
         *例如可以设置消息超时时间,优先级,持久化
         *body:byte[] 消息本身
         */
        channel.basicPublish("", "simple01", null, msg.getBytes());
        System.out.println("123123");

    }

//    @Test
//    public void cusumer() throws IOException, InterruptedException {
//        //声明队列
//        channel.queueDeclare("simple01", false, false, false, null);
//        //创建一个消费端对象
//        QueueingConsumer cons=new QueueingConsumer(channel);
//        //将客户端代码的内存对象cons绑定到队列才能实现监听
//        /*queue 队列名称
//         *autoAck Boolean,是否自动反馈
//         *callback:消费端对象
//         */
//        channel.basicConsume("simple01", true, cons);
//        //死循环监听
//        while(true){
//            //从监听的队列获取的是一个客户端封装了所有消息对象
//            //数据的delivery对象,包含了消息的属性,头和消息本地
//            Delivery delivery = cons.nextDelivery();
//            //直接获取msg
//            System.out.println(new String(delivery.getBody()));
//            BasicProperties properties = delivery.getProperties();
//            System.out.println(properties.getBodySize());
//            System.out.println(properties.getPriority());
//        }

    }





