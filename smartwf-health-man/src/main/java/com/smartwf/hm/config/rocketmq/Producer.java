package com.smartwf.hm.config.rocketmq;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:生产者
 * @Date: 2018/8/9 14:52
 */

@Component
@Slf4j
public class Producer {

    /**
     * 生产者的组名
     */
    @Value("${rocketmq.producer.groupName}")
    private String groupName;

    /**
     * NameServer 地址
     */
    @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;

    private DefaultMQProducer producer;

    @PostConstruct
    public void defaultMQProducer() {

        //生产者的组名
        producer = new DefaultMQProducer(groupName);
        //指定NameServer地址，多个地址以 ; 隔开
        producer.setNamesrvAddr(namesrvAddr);
        producer.setVipChannelEnabled(true);
        producer.setDefaultTopicQueueNums(16);
        try {
            producer.start();
            log.info("-------->:producer启动了");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public String send(String topic, String tags, String body) throws InterruptedException, RemotingException, MQClientException, MQBrokerException, UnsupportedEncodingException {
    	StopWatch stop = new StopWatch();
        stop.start();
    	Message message = new Message(topic, tags, body.getBytes(RemotingHelper.DEFAULT_CHARSET));
        //message.setDelayTimeLevel(3);
    	//使用PTP模式
    	SendResult result = producer.send(message, new MessageQueueSelector() {
			@Override
			 public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {  
				Integer id = (Integer) arg;  
                int index = id % mqs.size();  
                return mqs.get(index);
			}
		}, 0);
    	log.info("发送响应：MsgId:{}，发送状态:{}", result.getMsgId(), result.getSendStatus());
        stop.stop();
    	return"{\"MsgId\":\"" + result.getMsgId() + "\"}";
    }
    
   

}