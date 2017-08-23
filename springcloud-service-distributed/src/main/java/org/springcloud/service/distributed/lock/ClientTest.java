package org.springcloud.service.distributed.lock;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientTest {

	@Autowired
	DistributedLockHandler distributedLockHandler;

	public  void dbTest(){
		 		Lock lock=new Lock("lockk","sssssssss");
				if(distributedLockHandler.tryLock(lock)){
				   // doSomething();
				    distributedLockHandler.releaseLock(lock);
				}

	}

}
