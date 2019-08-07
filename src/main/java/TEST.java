import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetSocketAddress;

public class TEST {

    private TransportClient client;
    @Before
    public void run(){
        client = new PreBuiltTransportClient(Settings.EMPTY);
        client.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("10.42.121.113", 9300)));
        client.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("10.42.1.180", 9300)));
        client.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("10.42.38.66", 9300)));
    }
    @Test
    public void indexManage() {
        //需要先获取索引的管理对象admin
        IndicesAdminClient admin = client.admin().indices();
        System.out.println(admin);

    }





}
