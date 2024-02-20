package pojo.response;

public class Project {
	private AvatarUrls avatarUrls;
	private String entityId;
	private boolean isPrivate;
	private String uuid;
	private String expand;
	private boolean simplified;
	private String name;
	private String self;
	private String style;
	private String id;
	private String projectTypeKey;
	private String key;
	private Properties properties;

	public void setAvatarUrls(AvatarUrls avatarUrls){
		this.avatarUrls = avatarUrls;
	}

	public AvatarUrls getAvatarUrls(){
		return avatarUrls;
	}

	public void setEntityId(String entityId){
		this.entityId = entityId;
	}

	public String getEntityId(){
		return entityId;
	}

	public void setIsPrivate(boolean isPrivate){
		this.isPrivate = isPrivate;
	}

	public boolean isIsPrivate(){
		return isPrivate;
	}

	public void setUuid(String uuid){
		this.uuid = uuid;
	}

	public String getUuid(){
		return uuid;
	}

	public void setExpand(String expand){
		this.expand = expand;
	}

	public String getExpand(){
		return expand;
	}

	public void setSimplified(boolean simplified){
		this.simplified = simplified;
	}

	public boolean isSimplified(){
		return simplified;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSelf(String self){
		this.self = self;
	}

	public String getSelf(){
		return self;
	}

	public void setStyle(String style){
		this.style = style;
	}

	public String getStyle(){
		return style;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setProjectTypeKey(String projectTypeKey){
		this.projectTypeKey = projectTypeKey;
	}

	public String getProjectTypeKey(){
		return projectTypeKey;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	public void setProperties(Properties properties){
		this.properties = properties;
	}

	public Properties getProperties(){
		return properties;
	}
}
