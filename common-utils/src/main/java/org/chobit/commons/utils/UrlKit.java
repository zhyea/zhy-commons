package org.chobit.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.chobit.commons.constans.Symbol.QUESTION_MARK;
import static org.chobit.commons.utils.StrKit.isBlank;


/**
 * Url处理工具类
 *
 * @author robin
 */
public final class UrlKit {


	private static final Logger logger = LoggerFactory.getLogger(UrlKit.class);

	/**
	 * 解析url中的请求参数
	 *
	 * @param url 请求url
	 * @return url中的请求参数
	 */
	public static Map<String, String> parseQueryParams(String url) {
		GetReq pair = parse(url);
		if (null != pair) {
			return pair.getParams();
		}
		return null;
	}


	/**
	 * url解析，解析出请求地址和请求参数
	 *
	 * @param url 请求的url
	 * @return 请求地址和请求参数
	 */
	public static GetReq parse(String url) {
		try {
			if (isBlank(url)) {
				return null;
			}
			final int index = url.indexOf('?');
			if (url.length() <= index + 2) {
				return null;
			}
			if (index < 0) {
				return new GetReq(url);
			}

			return parse0(url, index);
		} catch (Exception e) {
			logger.error("Parse query params error, src url:[{}]", url, e);
		}
		return null;
	}


	private static GetReq parse0(String url, int index) {
		final String urlPath = url.substring(0, index);
		final String queryStr = url.substring(index + 1);

		final GetReq req = new GetReq(urlPath);
		final String[] arr = queryStr.split("&");
		for (String p : arr) {
			if (p.contains("=")) {
				final int idx = p.indexOf("=");
				if (idx == 0) {
					continue;
				}
				final String key = p.substring(0, idx);
				final String value = p.length() > idx + 1 ? p.substring(idx + 1) : "";
				req.addParam(key, value);
			} else {
				req.addParam(p, "");
			}
		}
		return req;
	}


	/**
	 * 对URL进行加密
	 *
	 * @param src 源路径
	 * @return 加密后的路径
	 */
	public static String encode(String src) {
		try {
			return URLEncoder.encode(src, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("url encode error, src:[{}]", src, e);
			return null;
		}
	}


	/**
	 * 对URL进行解密
	 *
	 * @param src 源路径
	 * @return 解密后的路径
	 */
	public static String decode(String src) {
		try {
			return URLDecoder.decode(src, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("url decode error, src:[{}]", src, e);
			return null;
		}
	}


	/**
	 * 构建Get请求query string
	 *
	 * @param url    请求url
	 * @param params 请求参数
	 * @return 修改后的请求路径
	 */
	public static String buildQueryStr(String url, Map<String, Object> params) {
		try {
			GetReq req = parse(url);
			if (null != req) {
				url = req.getUrl();
				Map<String, Object> tmp = new LinkedHashMap<>(8);
				tmp.putAll(req.getParams());
				tmp.putAll(params);
				params = tmp;
			}

			String paramStr = buildQueryStr(params, true);

			if (!url.endsWith(QUESTION_MARK)) {
				url = url + QUESTION_MARK;
			}

			return url + paramStr;
		} catch (Exception e) {
			logger.error("Building query string error. url:[{}], params:[{}]", url, params);
			throw e;
		}
	}


	/**
	 * 构建Get请求query string
	 *
	 * @param params 请求参数
	 * @return 修改后的请求路径
	 */
	public static String buildQueryStr(Map<String, Object> params) {
		return buildQueryStr(params, true);
	}


	/**
	 * 构建Get请求query string
	 *
	 * @param params       请求参数
	 * @param encodeParams 是否encode参数
	 * @return 修改后的请求路径
	 */
	public static String buildQueryStr(Map<String, Object> params, boolean encodeParams) {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			if (builder.length() > 0) {
				builder.append("&");
			}
			builder.append(entry.getKey())
					.append("=");
			if (encodeParams) {
				builder.append(encode(String.valueOf(entry.getValue())));
			} else {
				builder.append(entry.getValue());
			}
		}
		return builder.toString();
	}


	/**
	 * 构建Get请求query string
	 *
	 * @param req Get请求实例
	 * @return 修改后的请求路径
	 */
	public static String buildQueryStr(GetReq req) {
		String url = req.getUrl();
		Map<String, Object> params = new LinkedHashMap<>(8);
		params.putAll(req.getParams());
		return buildQueryStr(url, params);
	}

	/**
	 * 解析根域名
	 *
	 * @param url 请求路径
	 * @return 根域名
	 */
	public static String parseRoot(String url) {
		try {
			URL u = new URL(url);
			String protocol = u.getProtocol();
			String host = u.getHost();
			int port = u.getPort();
			return protocol + "://" + host + (port > 0 ? ":" + port : "");
		} catch (MalformedURLException e) {
			logger.error("parse root domain error. src url: {}", url, e);
			return null;
		}
	}

	private UrlKit() {
		throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
	}


	/**
	 * Get请求描述类
	 */
	public static class GetReq {

		private String url;

		private final Map<String, String> params = new LinkedHashMap<>();

		public GetReq() {
		}

		public GetReq(String url) {
			this.url = url;
		}

		public GetReq(String url, Map<String, String> params) {
			this.url = url;
			this.params.putAll(params);
		}

		public void addParam(String name, String value) {
			if (isBlank(name)) {
				throw new IllegalArgumentException("参数名不能为空");
			}
			if (null == value) {
				throw new IllegalArgumentException("参数值不能为空");
			}
			params.put(name, value);
		}

		public void addParams(Map<String, String> params) {
			this.params.putAll(params);
		}


		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public Map<String, String> getParams() {
			return params;
		}


		@Override
		public String toString() {
			return "GetReq{" +
					"url='" + url + '\'' +
					", params=" + params +
					'}';
		}
	}

}
