package org.chobit.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * IP操作工具类
 *
 * @author robin
 */
public final class IpKit {

	private static final Logger logger = LoggerFactory.getLogger(IpKit.class);


	/**
	 * 获取IP
	 *
	 * @return 当前应用IP
	 */
	public static String getIp() {
		String ip = "";
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface anInterface = interfaces.nextElement();
				Enumeration<InetAddress> inetAddresses = anInterface.getInetAddresses();
				while (inetAddresses.hasMoreElements()) {
					InetAddress inetAddress = inetAddresses.nextElement();
					if (!inetAddress.isLoopbackAddress()) {
						String inetIp = inetAddress.getHostAddress();
						//ipv6
						if (!inetIp.contains(":")) {
							ip = inetIp;
							break;
						}
					}
				}
			}
		} catch (Exception ex) {
			logger.error("Fail to get host ip address!", ex);
		}
		return ip;
	}


	public static String getLocalIp() {
		try{
			return InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			return "127.0.0.1";
		}
	}





	private IpKit() {
		throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
	}

}
