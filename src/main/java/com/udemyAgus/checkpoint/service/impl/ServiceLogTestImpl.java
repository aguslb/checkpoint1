package com.udemyAgus.checkpoint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemyAgus.checkpoint.service.ServiceLogTest;

@Service("ServiceLogTest")
public class ServiceLogTestImpl implements ServiceLogTest {

	private static Log LOG = LogFactory.getLog(ServiceLogTestImpl.class);

	@Override
	public List<String> randomNumbers() {
		LOG.info("Obteniendo numeros random");
		List<String> retLits = new ArrayList<String>();
		int firstRandomNumber = (int) (Math.random() * 254) + 1;
		for (int i = 0; i < firstRandomNumber; i++) {
			retLits.add(String.valueOf((Math.random() * 1024) + 1));
		}
		retLits.add("---> Mensaje <---");
		return retLits;
	}

}
