package indi.Jake.team.service;
/**
 * 
* @Description	包含员工状态，提供主页面显示的toString方法和状态的全局变量
* @author Jack Email:wzy1048168235@163.com
* @version	v1.0
* @date 2021年1月20日下午10:33:59
*
 */
public class Status {
	private final String NAME;
	private Status(String name) {
		this.NAME = name;
	}
	public static final Status FREE = new Status("FREE");
	public static final Status VOCATION = new Status("VACATION");
	public static final Status BUSY = new Status("BUSY");
	public String getNAME() {
		return NAME;
	}
	@Override
	public String toString() {
		return NAME;
	}
}
