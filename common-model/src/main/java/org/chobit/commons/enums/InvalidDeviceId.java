package org.chobit.commons.enums;

/**
 * 无效设备ID枚举
 *
 * @author robin
 */
public enum InvalidDeviceId {

	/**
	 * 无效IDFA
	 */
	IDFA("00000000-0000-0000-0000-000000000000"),

	/**
	 * 无效IDFA1
	 */
	IDFA1("__IDFA__"),

	/**
	 * 无效IMEI
	 */
	IMEI("000000000000000"),

	/**
	 * 无效IMEI1
	 */
	IMEI1("__IMEI__"),

	/**
	 * 无效OAID
	 */
	OAID("00000000000000000000000000000000000000000000000000000000000000"),

	/**
	 * 无效OAID1
	 */
	OAID1("__OAID__"),

	/**
	 * 无效LJ_DEVICE_ID
	 */
	LJ_DEVICE_ID("0000000000000000"),

	/**
	 * 无效MAC
	 */
	MAC("00:00:00:00:00:00"),

	/**
	 * 无效未知ID
	 */
	UNKNOWN("00000000000000"),

	/**
	 * 空设备ID
	 */
	EMPTY1(""),

	/**
	 * 空设备ID
	 */
	EMPTY2(" "),

	/**
	 * 空设备ID
	 */
	EMPTY3("null"),

	/**
	 * 空设备ID
	 */
	EMPTY4("NULL"),
	;


	public final String value;

	InvalidDeviceId(String value) {
		this.value = value;
	}
}
