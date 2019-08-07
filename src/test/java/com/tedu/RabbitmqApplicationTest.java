package com.tedu;

import com.tedu.Producer.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringRun.class)
public class RabbitmqApplicationTest {
    @Autowired
    private Producer producer;
    @Test
    public void testSend(){
        producer.send();
    }
}
