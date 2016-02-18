package xyz.zrui.explore.common.dictionary;

public enum ErrorCode {
	
	FAILURE("110","失败"),
	SUCCESS("200","成功"),
	
	
	INSERT("3001","添加失败！"),
	UPDATE("3002","更新失败！"),
	DELETE("3003","删除失败");
	
	
	private ErrorCode(String key, String value) {
		this.key = key;
		this.value = value;
	}
	private String key;
	private String value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	

}
