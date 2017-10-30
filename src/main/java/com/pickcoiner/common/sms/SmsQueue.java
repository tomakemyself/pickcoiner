package com.pickcoiner.common.sms;

import java.util.concurrent.ArrayBlockingQueue;

import org.apache.commons.lang.StringUtils;

import freemarker.template.utility.NullArgumentException;

/**
 * 平台消息发送队列,单例模式
 * @author Dicky Yin
 * @date 2017-10-26
 */
public class SmsQueue {

	//一个由数组支持的有界阻塞队列。此队列按 FIFO（先进先出）原则对元素进行排序
	//队列最大长度为1000，如果队列满,往队列中再增加元素将导致阻塞
	private ArrayBlockingQueue<SMS> queue = new ArrayBlockingQueue<SMS>(1000);
	private static SmsQueue SMS_QUEUE = null;

	//禁止new对象
	private SmsQueue(){}
	
	
	/**
	 * 获取单例SendMsgDeque对象,
	 */
	public SmsQueue instance(){
		if(SMS_QUEUE == null) 
			SMS_QUEUE = new SmsQueue();
		return SMS_QUEUE;
	}
	
	/**
	 * 需要发送的信息加入队列当中
	 */
	public void  put(SMS sms) throws Exception{
		//如果sms为空或者，接收信息为空则拒绝添加进入队列
		if (sms==null || StringUtils.isBlank(sms.getReciever()))
			throw new NullArgumentException("待发送的信息有误"+sms.getReciever());
		queue.put(sms);
	}
	
	/**
	 * 获取并移除此队列的第一个SMS
	 */
	public SMS poll(){
		return queue.poll();
	}
	
	/**
	 * 获取但不移除此队列头SMS；如果此队列为空，则返回 null
	 */
	public SMS peek(){
		return queue.peek();
	}
	
	/**
	 * 从此队列中移除SMS（如果存在）
	 */
	public boolean remove(SMS sms){
		//如果sms为空或者，接收信息为空则拒绝添加进入队列
		if (sms == null)
			throw new NullArgumentException("移除的SMS对象不能为NUll:");
		return queue.remove(sms);
	}
	
	/**
	 * 获取队列剩余空间
	 */
	public int remainingCapacity(){
		return queue.remainingCapacity();
	}
	
	/**
	 * 队列长度
	 */
	public int size(){
		return queue.size();
	}
	
}
